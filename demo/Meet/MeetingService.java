package com.example.demo.Meet;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
@Service
public class MeetingService {
	@Autowired
	JdbcTemplate jt;
	@Autowired
	JavaMailSender javaMailSender;

	String email="";
	@Transactional
	public String insert(Meeting m) {
		String message="";
		String rolemeet="";
		int count=0;
		String user=m.getUname();
		String pwd=m.getPwd();
		String checkuser="select * from Employee where username=? and password=? and status='a' ";
		List<Map<String,Object>>checkuserdata=new ArrayList<Map<String, Object>>();
		for(Map me:checkuserdata) {
			 rolemeet=(String)me.get("role");
		}
		checkuserdata=jt.queryForList(checkuser,user,pwd);

		if(!checkuserdata.isEmpty()) {
			String projectId=m.getProjectId();
			String meetName=m.getMeetName();
			int duration=m.getDuration();
			String descrption=m.getDesc();
			String starttime=m.getStarttime();
			DateTimeFormatter d=DateTimeFormatter.ofPattern("HH:mm" );
			LocalDateTime l=LocalDateTime.now();
			String time=d.format(l);
			if(starttime==null) {
				starttime=time;
			}
			LocalTime now=LocalTime.parse(starttime, d);
			LocalTime endtime=now.plusMinutes(duration);
			DateTimeFormatter d1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime l1=LocalDateTime.now();
			String date=d1.format(l1);
			System.out.println(date);
			String meetId=meetName+time;
			String status="c";
			String createdby=user;
			String contact=m.getContact();

			String sql="select * from project_contact_details where project_id=?";
			List<Map<String,Object>>sqlinfo=new ArrayList<>();
			sqlinfo=jt.queryForList(sql,projectId);
			if(sqlinfo.isEmpty()) {
				return"Invalid project id";
			}
			else {
				String [] employees =contact.split(",");
				for(String emp:employees) {
					String sql1="select * from project_contact_details where emp_id=? and project_id=?";
					List<Map<String,Object>> sqlinfo1=new ArrayList<>();
					sqlinfo1=jt.queryForList(sql1,emp,projectId);
					System.out.println("1"+sqlinfo1);
					if(sqlinfo1.isEmpty()) {
						message="employee not there";
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					}
					else {
					String sql2="select * from Employee where id=?";
					List<Map<String,Object>>sqlinfo2=new ArrayList<>();
					sqlinfo2=jt.queryForList(sql2,emp);
					for(Map role:sqlinfo2) {
						System.out.println(role);
						String emprole=(String)role.get("role");
						//email=(String)role.get("email");
						if(rolemeet.equals("e")&&emprole.equals("h")||emprole.equals("p") || emprole.equals("e")) {
							String sqlselect="select * from Details.Meet where MeetContactDetails=?";
							List<Map<String,Object>>selectdata=new ArrayList<>();
							selectdata=jt.queryForList(sqlselect,emp);
							System.out.println(selectdata);
							if(!selectdata.isEmpty()) {
								String timeset,timesetend;
								for(Map setime: selectdata) {
									 timeset=(String)setime.get("StartTime");
									 timesetend=(String)setime.get("EndTime");
									
								}
								System.out.println("hii");
								message="already allocated";
							}
							else {
								
							String setMeet="insert into Details.Meet values(?,?,?,?,?,?,?,?,?,?,?)";
							jt.update(setMeet,meetId,meetName,emp,projectId,starttime,endtime,duration,date,createdby,status,descrption);
							message="inserted";
							count++;
							if(count==employees.length) {
								mail(employees);
								message="mail sent";
							}
							else {
								

								message="contact details mis match";
							}							
						}
						}
						else {
							message="not inserted";
						}
					}


				}
				
			}

		
			}
		}
		else {
			message= "Invalid credentials";

		}
		

		return message;
}
	public  String mail ( String [] employees) {
		 SimpleMailMessage mailMessage  = new SimpleMailMessage();
		 
		 for(String id:employees) {
    String sqlquery="select * from Employee where id=?";
    List<Map<String,Object>> list=jt.queryForList(sqlquery,id);
    for(Map data:list) {
 
			 mailMessage.setFrom("ramusenki2001@gmail.com");
        mailMessage.setTo((String)data.get("email"));
        mailMessage.setText("this mail is regarding the project");
        mailMessage.setSubject("project task");
        javaMailSender.send(mailMessage);
		 }
		 }
        return "Mail Sent Successfully...";
	}
}
