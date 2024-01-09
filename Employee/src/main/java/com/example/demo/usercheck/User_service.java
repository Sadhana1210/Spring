package com.example.demo.usercheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class User_service {
	@Autowired 
	JdbcTemplate jt;
	public String username(User u) { 
		int count=0;
	int empid=u.getEmpid();
	String fname=u.getFname();
	String lname=u.getLname();
	String user=fname.charAt(0)+lname;
	
	String seequel="select * from user where user like'"+user+"%'";
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	data=jt.queryForList(seequel);
	if(data.size()>1) {
		user=user+(data.size());
	}
	
	
	
	
String sql="insert into user values(?,?,?,?)";
jt.update(sql,empid,fname,lname,user);
return"inserted";
}
}