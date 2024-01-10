package com.example.demo.taskList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class tasklistService {
	@Autowired
	JdbcTemplate jt;
	public String addtasks(tasklist t) {
		try {
		String uname=t.getUname();
		System.out.println(uname);
		String pwd=t.getPwd();
		String sql="select * from Employee where username=? and password=? and role='p'";
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jt.queryForList(sql,uname,pwd);
		System.out.println(uname);
		System.out.println(pwd);
		System.out.println(data);
		if(data.isEmpty()) {
			return "invalid credentials";
		}
		else {
			String projectId=t.getProjectId();
			String taskname=t.getTaskname();
			String desc=t.getDesc();
			String duration=t.getDuration();
			DateTimeFormatter d=DateTimeFormatter.ofPattern("dd/MM/YYYY");
			LocalDateTime ldt1 =LocalDateTime.now();
			String date=d.format(ldt1);
			String taskId=taskname+date;
			String status="c";
			String assignedby=uname;
			String projectsql="select * from project_details where project_manager=? and project_id=?";
			List <Map<String,Object>> projectdata=new ArrayList<Map<String,Object>>();
			projectdata=jt.queryForList(projectsql,uname,projectId);
			System.out.println(projectId);
			if(projectdata.isEmpty()) {
				}
			else {
			String inserttask="insert into taskList values(?,?,?,?,?,?,?)";
			jt.update(inserttask,projectId,taskId,taskname,desc,duration,status,assignedby);
			return "task inserted";
		}
		}
		}
		catch(Exception e) {
			return   "exception ::::"+e.getMessage();
		}
		return "It's not your project ";
		
		}
public String updatetask(tasklist t) {
	String uname=t.getUname();
	String pwd=t.getPwd();
	String task_id=t.getTaskId();
	String desc=t.getDesc();
	String duration=t.getDuration();
	String sql="select * from Employee where username=? and password=? and role='p'";
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	data=jt.queryForList(sql,uname,pwd);
	if(!data.isEmpty()) {
		String tasksql="select * from taskList where assignedby=? and task_id=?";
		List<Map<String,Object>> taskdata=new ArrayList<Map<String,Object>>();
		taskdata=jt.queryForList(tasksql,uname,task_id);
		System.out.println(uname);
		System.out.println(task_id);
		System.out.println(taskdata+"hgljghg");
		if(!taskdata.isEmpty()) {
			String updatesql="update taskList set taskDescription=?, duration=? where task_id=?";
			jt.update(updatesql,desc,duration,task_id);
			System.out.println("else");
			return "updated";
		}
		
	return "Task is not there";

}
	return"invalid credentials";
}
public String deletetask(tasklist t) {
	String uname=t.getUname();
	String pwd=t.getPwd();
	String task_id=t.getTaskId();
	String desc=t.getDesc();
	String duration=t.getDuration();
	String sql="select * from Employee where username=? and password=? and role='p'";
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	data=jt.queryForList(sql,uname,pwd);
	if(!data.isEmpty()) {
		String tasksql="select * from taskList where assignedby=? and task_id=?";
		List<Map<String,Object>> taskdata=new ArrayList<Map<String,Object>>();
		taskdata=jt.queryForList(tasksql,uname,task_id);
		System.out.println(uname);
		System.out.println(task_id);
		System.out.println(taskdata+"hgljghg");
		if(!taskdata.isEmpty()) {
			String updatesql="delete from taskList where task_id=?";
			jt.update(updatesql,task_id);
			return "deleted";
}
		return "invalid taskid";
	}
	return "invalid credentials";
}
//}
public String taskSearch(tasklist t) {
	String s="";
	String uname=t.getUname();
	String pwd=t.getPwd();
	String sqlcheck="select * from Employee where username=? and password=?";
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	data=jt.queryForList(sqlcheck,uname,pwd);
	if(!data.isEmpty()) {
		String empid=t.getEmpId();
		String taskId=t.getTaskId();
		String duration=t.getDuration();
	String sql="select * from task where 3=1+2";
	System.out.println(sql);
	List<Map<String,Object>> data1=new ArrayList<Map<String,Object>>();
	data1=jt.queryForList(sql);
	if(empid!=null||taskId!=null||duration!=null) {
		s=s+" where ";
  if(empid!=null && taskId!=null && duration!=null) {
		s=s+ "  username like '"+empid+"%' and password like '"+taskId+"%' and email like '"+duration+"%' ;";
	}
 
		
	}
	return "selected";
}
	return sqlcheck;
}
}



