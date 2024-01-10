package com.example.demo.insertEmp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
	@Service
	public class InsertEmpService {
				@Autowired
				JdbcTemplate jt;
				String roleid="";
				public String Insert(InsertEmp p ) {
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
							roleid=(String)map1.get("roleid");
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
}
