package com.example.demo.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class Project_service {
	@Autowired
	JdbcTemplate jt;
	String roleid="",emp_name="",phone="",email="",joiningdate="",project_id="",project_name="";
	public String select(Project p ) {
		String checkuser=p.getCheckuser();
		String checkpwd=p.getCheckpwd();
		String sql="select* from Employee where username=?"; 
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jt.queryForList(sql,checkuser);
		if(data.isEmpty()) {
			System.out.println("empty String");
			return "user name not matched";
		}

		else {
			String sqlp="select* from Employee where password=?";
			List<Map<String,Object>> datap=new ArrayList<Map<String,Object>>();
			datap=jt.queryForList(sqlp,checkpwd);
			System.out.println(datap+"here comih");
			if(datap.isEmpty()) {
				return "incorrect pwd";
			}
			if(!datap.isEmpty()) {
				String sqlr="select* from Employee where role='a'";
				List<Map<String,Object>> datar=new ArrayList<Map<String,Object>>();
				datar=jt.queryForList(sqlr);
			if(!datar.isEmpty()) {
				
			System.out.println("is not empty");
			String id=p.getId();
			String firstname=p.getFirstname();
			String lastname=p.getLastname();
			String dob=p.getDob();
			String zip=p.getZip();
			String phone=p.getPhone();
			String role=p.getRole();
			String username=firstname.charAt(0)+lastname+id;

			DateTimeFormatter d=DateTimeFormatter.ofPattern("HHmm");
			LocalDateTime ldt =LocalDateTime.now();
			String time=d.format(ldt);
			String password=""+firstname.charAt(0)+dob.charAt(0)+dob.charAt(1)+dob.charAt(3)+dob.charAt(4)+time;
			String email=firstname.charAt(0)+lastname+"@miraclesoft.com";
			String status =p.getStatus();
			String joindate=p.getJoindate();
			System.out.println("coming after sql 1");
			String sqlcheck="select* from roletable where role=? ";
			List<Map<String,Object>> datacheck=new ArrayList<Map<String,Object>>();
			datacheck=jt.queryForList(sqlcheck,role);
			for(Map map1:datacheck) {
				System.out.println(datacheck);
				roleid=""+map1.get("roleid");
				System.out.println("datacheck");
				System.out.println(roleid);
			}
			if(roleid==null || roleid.equals("")) {
				return "please insert role ";
			}
			else {
				String sqlcheckuser="select* from roletable where role=? ";
				List<Map<String,Object>> datacheckuser=new ArrayList<Map<String,Object>>();
				datacheck=jt.queryForList(sqlcheckuser,role);
				for(Map usermap:datacheckuser) {
					System.out.println("datacheckuser");
					System.out.println(datacheckuser);

					System.out.println(roleid);
				}
				String sql1="insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?)";
				jt.update(sql1,id,firstname,lastname,roleid,dob,zip,phone,username,password,email,joindate,status);


				return "inserted";
			}
		}
			}
		}
		return "not intrested";

	}
	public String projectinsert(Project p) {
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
	
	
	public String projectallocate(Project p) {
		String checkuser=p.getCheckuser();
		String checkpwd=p.getCheckpwd();
		String allsql="select * from Employee where username=? and password=? and role='p'";
		List<Map<String,Object>> alldata=new ArrayList<Map<String,Object>>();
		alldata=jt.queryForList(allsql,checkuser,checkpwd);
		if(alldata.isEmpty()) {
			System.out.println("empty String");
			return "credentials are invalid";
		}
		else {
			String  emp_id=p.getEmp_id();
			String projectsql="select * from project_details where project_manager=?";
			List<Map<String,Object>> projectdata=new ArrayList<Map<String,Object>>();
			projectdata=jt.queryForList(projectsql,checkuser);
			for(Map map:projectdata) {
				String project_id=""+map.get("project_id");
				String project_name=""+map.get("project_name");
				String assigned_by=(String)map.get("project_manager");
				DateTimeFormatter d=DateTimeFormatter.ofPattern("dd/MM/YYYY");
				LocalDateTime ldt1 =LocalDateTime.now();
				String date=d.format(ldt1);
				String assigned_date=date;
				String empsql="select * from Employee where id=? and status='b' and role='e'";
				List<Map<String,Object>> empsqldata=new ArrayList<Map<String,Object>>();
				empsqldata=jt.queryForList(empsql,emp_id);
				if(empsqldata.isEmpty()) {
					System.out.println("empty String");
					return "id or status or role doesn't matched";
				}
				else {
				for(Map mapemp:empsqldata) {
					String emp_name=""+mapemp.get("username");
					String phone=""+mapemp.get("phone");
					String email=""+mapemp.get("email");
					String joiningdate=""+mapemp.get("joining_date");
						String insert_emp_sql="insert into project_contact_details values(?,?,?,?,?,?,?,?,?) ";
						jt.update(insert_emp_sql,project_id,project_name,emp_id,emp_name,phone,email,joiningdate,
								assigned_date,assigned_by);
						String update_emp_sql="update Employee set status='a' where id="+emp_id+"";
						jt.update(update_emp_sql);
						return "assigned";
					}
				}
			}
			return "Not able to allocate project manager doesn't assigned";	
		}
	}
public String projectcopy(Project p) {
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
	

