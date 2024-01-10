package com.example.demo.EmptaskList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
	@Service
	public class EmptaskListService {
			@Autowired
			JdbcTemplate jt;
		public String emptasksassign(EmptaskList t) {
			String uname=t.getUname();
			System.out.println(uname);
			String pwd=t.getPwd();
			String sql="select * from Employee where username=? and password=? and role='p'";
			List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
			data=jt.queryForList(sql,uname,pwd);
			if(data.isEmpty()) {
				return "invalid credentials";
			}
			else {
				String projectId="";
				String statdate=t.getStartdate();
				String taskid=t.getTaskId();
		        String empid=t.getEmpId();
		        String checksql="select * from taskList where task_id=?";
		        List<Map<String,Object>> datacheck=new ArrayList<Map<String,Object>>();
		    	datacheck=jt.queryForList(checksql,taskid);
		    	System.out.println(datacheck);
		    	if(!datacheck.isEmpty()) {
		    		System.out.println(datacheck+"fgfd");
		    		for(Map map1:datacheck) {
		    		projectId=(String)map1.get("project_id");
		    		
				String duration=t.getDuration();
				DateTimeFormatter d=DateTimeFormatter.ofPattern("dd/MM/YYYY");
				LocalDateTime ldt1 =LocalDateTime.now();
				String enddate=d.format(ldt1);
				String status="a";
				String projectsql="select * from project_details where project_manager=? and project_id=?";
				List <Map<String,Object>> projectdata=new ArrayList<Map<String,Object>>();
				projectdata=jt.queryForList(projectsql,uname,projectId);
				System.out.println(projectdata);
				if(projectdata.isEmpty()) {
					return"No project";
				}
				else {
					String searchemp="select* from project_contact_details where emp_id=? and assigned_by=?";
					List<Map<String,Object>>datasearch=new ArrayList<Map<String,Object>>();
					datasearch=jt.queryForList(searchemp,empid,uname);
					System.out.println(datasearch);
					if(datasearch.isEmpty()) {
						System.out.println(datasearch+"adf");
					return "employee not assigned";
					}
					else {
						String checkassign="select * from EmpTaskList where emp_id=? and project_id=?";
						List<Map<String,Object>>dataassign=new ArrayList<Map<String,Object>>();
						dataassign=jt.queryForList(checkassign,empid,projectId);
						if(dataassign.isEmpty()) {
							
							String insertEmp="insert into EmpTaskList values(?,?,?,?,?,?,?)";
							jt.update(insertEmp,empid,projectId,taskid,statdate,enddate,status,uname);
							String updatelist="update taskList set status='a' where task_id=?";
							jt.update(updatelist,taskid);
							return " inserted";
							
						}
						else
						{
							return"already employee assigned to the project";
			}
				}
			}
			}
			}
		    	else {
		    		return"no task ";
		    	}
//			}
//			catch(Exception e) {
//				return   "exception ::::"+e.getMessage();
//			}
			return "Task is not there";
			
		}
		}
	}


