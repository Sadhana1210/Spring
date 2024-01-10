package com.example.demo.copyProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class CopyProjectService {
	@Autowired
	JdbcTemplate jt;
	public String projectcopy(CopyProject p) {
		String new_project_name=p.getNewproject_name();
		String projectId="";
		String checkuser=p.getCheckuser();
		String checkpwd=p.getCheckpwd();
		String sql="select * from Employee where username=? and password=? and role='a'";
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jt.queryForList(sql,checkuser,checkpwd);
		if(data.isEmpty()) {
		System.out.println("empty String");
		return "invalid credentials";
		}
		else {
		String project_copy_id=p.getProject_copy_id();
			String project_details="select * from project_details where project_id=?";
		List<Map<String,Object>> copydata= new ArrayList<Map<String,Object>>();
		copydata=jt.queryForList(project_details,project_copy_id);
		System.out.println(project_copy_id);
		if(copydata.isEmpty()) {
		return "invalid project id";
		}
		else {
		for(Map<String,Object> copiedproject_details:copydata) {
		String description=(String)copiedproject_details.get("descrption");
		String projectStart=(String)copiedproject_details.get("project_start");
		String projectEnd=(String)copiedproject_details.get("project_end");
		String projectManager=(String)copiedproject_details.get("project_manager");
		String projectHr=(String)copiedproject_details.get("project_hr");
		String noofemp=(String)copiedproject_details.get("no_of_emp");
		String assignedBy=checkuser;
		projectId=new_project_name+projectStart;
		System.out.println(new_project_name);
		String insertQuery="insert into project_details values(?,?,?,?,?,?,?,?,?)";
		jt.update(insertQuery,projectId,new_project_name,description,projectStart,projectEnd,projectManager,projectHr,noofemp,assignedBy);
		}
		String projectContact="select * from project_contact_details where project_id=?";
		List<Map<String,Object>> table=new ArrayList<Map<String,Object>>();
		table=jt.queryForList(projectContact,project_copy_id);
		System.out.println(project_copy_id);
		for(Map<String,Object> copiedproject:table) {
		String emp_id=(String)copiedproject.get("emp_id");
		String emp_name=(String)copiedproject.get("emp_name");
		String phone=(String)copiedproject.get("phone");
		String email=(String)copiedproject.get("email");
		String joining_date=(String)copiedproject.get("joining_date");
		String assigned_date=(String)copiedproject.get("assigned_date");
		String assigned_by=(String)copiedproject.get("assigned_by");
		String insertContactdetails="insert into project_contact_details values(?,?,?,?,?,?,?,?,?)";
		jt.update(insertContactdetails,projectId,new_project_name,emp_id,emp_name,phone,email,joining_date,assigned_date,assigned_by);
		}
		}
		}
		return "copied successfully";
		}}

