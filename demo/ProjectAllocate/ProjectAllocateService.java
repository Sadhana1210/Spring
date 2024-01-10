package com.example.demo.ProjectAllocate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class ProjectAllocateService {
	@Autowired
	JdbcTemplate jt;
	public String projectallocate(ProjectAllocate p) {
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
}
