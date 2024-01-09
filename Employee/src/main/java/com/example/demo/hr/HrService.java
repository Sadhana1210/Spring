package com.example.demo.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HrService {
@Autowired
JdbcTemplate jt;
String roleid="";
	public String select(PojoHr pojo ) {
		String checkuser=pojo.getCheckuser();
		String checkpwd=pojo.getCheckpwd();
		String sql="select* from Employee where (username=? and password=?) and (role='h'|| role='a') ";
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jt.queryForList(sql,checkuser,checkpwd);
		System.out.println(data);
		if(data.isEmpty()) {
			System.out.println("empty String");
			return "user name or password or role doesn't matched";
		}

		else {
			System.out.println("is not empty");
			String id=pojo.getId();
	String firstname=pojo.getFirstname();
	String lastname=pojo.getLastname();
	String dob=pojo.getDob();
	String zip=pojo.getZip();
	String phone=pojo.getPhone();
	String role=pojo.getRole();
	String username=firstname.charAt(0)+lastname;
	String password=""+firstname.charAt(0)+dob.charAt(0)+dob.charAt(1)+dob.charAt(3)+dob.charAt(4);
	String email=firstname.charAt(0)+lastname+"miraclesoft.com";
	String joindate=pojo.getJoindate();
	String status=pojo.getStatus();
	 System.out.println("coming after sql 1");
	String sqlcheck="select* from roletable where role=? ";
	List<Map<String,Object>> datacheck=new ArrayList<Map<String,Object>>();
	datacheck=jt.queryForList(sqlcheck,role);
	for(Map map1:datacheck) {
		System.out.println(datacheck);
		roleid=(String)map1.get("roleid");
	}
	if(roleid==null || roleid.equals("")) {
		return "please insert role ";
	}
	else {
	
	String sql1="insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?)";
	 jt.update(sql1,id,firstname,lastname,roleid,dob,zip,phone,username,password,email,joindate,status);
	
	
		return "inserted";
		}
	}}
		}
