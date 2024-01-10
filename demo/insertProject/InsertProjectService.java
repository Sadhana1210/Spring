package com.example.demo.insertProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.insertEmp.InsertEmp;
@Service
public class InsertProjectService {
	@Autowired
	JdbcTemplate jt;
	public String projectinsert(ProjectInsert p) {
		String checkuser=p.getCheckuser();
		String checkpwd=p.getCheckpwd();
		String sql="select * from Employee where username=? and password=? and role='a'";
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jt.queryForList(sql,checkuser,checkpwd);
		if(data.isEmpty()) {
			System.out.println("empty String");
			return "Invalid credentials";
		}

		else {

			String project_name=p.getProject_name();
			String descrption=p.getDescrption();
			System.out.println(descrption);
			String project_start=p.getProject_start();
			String project_end=p.getProject_end();
			String project_manager=p.getProject_manager();
			System.out.println(project_manager);
			String project_hr=p.getProject_hr();
			String No_of_emp=p.getNo_of_emp();
			String assignedby=checkuser;
			String project_id=project_name+project_start;
			System.out.println("1befor manager check");
			String checkmanager="select * from Employee where username=? and role='p' and status='b' ";
			List<Map<String,Object>> checkmanagerdata=new ArrayList<Map<String,Object>>();
			checkmanagerdata=jt.queryForList(checkmanager,project_manager);
			System.out.println("2checkmanagerdata");
			System.out.println("3"+checkmanagerdata);
			if(checkmanagerdata.isEmpty()) {
				System.out.println("4 empty String man");
				return " allocated or user name of manager doesn't matched ";
			}
			System.out.println(" 6 befor hr check");
			String checkhr="select * from Employee where username=? and role='h' and status='b' ";
			List<Map<String,Object>> checkhrdata=new ArrayList<Map<String,Object>>();
			System.out.println(" 7 slect hr check");
			checkhrdata=jt.queryForList(checkhr,project_hr);
			System.out.println(" 8 checkhrdata");
			System.out.println("9"+checkhrdata);
			if(checkhrdata.isEmpty()) {
				System.out.println(" 10 empty String");
				return " allocated or user name of hr doesn't matched";
			}
			System.out.println(" 11 no check comin tothis");
			String project_insert_sql="insert into project_details values(?,?,?,?,?,?,?,?,?)";
			jt.update(project_insert_sql,project_id,project_name,descrption,project_start,project_end,project_manager,project_hr,No_of_emp,assignedby);
			String updatemanager="update Employee  set status='a' where username=?";
			jt.update(updatemanager,project_manager);
			String updatehr="update Employee  set status='a' where username=?";
			jt.update(updatehr,project_hr);

			return "inserted";
		}
	}
}
