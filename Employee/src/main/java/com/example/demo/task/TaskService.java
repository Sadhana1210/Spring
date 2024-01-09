package com.example.demo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
@Autowired
JdbcTemplate jt;
public int insert(Pojo p) {
	int id=p.getId();
	String firstname=p.getFirstname();
	String lastname=p.getLastname();
	String dept=p.getDept();
	String role=p.getRole();
	String dob=p.getDob();
	String zip=p.getZip();
	String phone=p.getRole();
//	String username="user";
//	String password="pass";
//	String email="mail";
	String username=firstname.charAt(0)+lastname;
//	DateTimeFormatter d=DateTimeFormatter.ofPattern("HHmm");
	String password=""+firstname.charAt(0)+dob.charAt(0)+dob.charAt(1)+dob.charAt(3)+dob.charAt(4);
	String email=firstname.charAt(0)+lastname+"miraclesoft.com";
	String sql="insert into task values(?,?,?,?,?,?,?,?,?,?,?)";
	return jt.update(sql,id,firstname,lastname,dept,role,dob,zip,phone,username,password,email);
//	String sql1="update task set dept=? where id=?";
//	return jt.update(sql1,dept,id);
//	String sql2="delete from task where id=?";
//	return jt.update(sql2,id);
}

public int update (Pojo p) {
//	int id=p.getId();
//	String dept=p.getDept();
//	String fieldvalue=p.getFieldvalue();
//	String value=p.getValue();
//	String firstname=p.getFirstname();
String sql1="update task set dept='coll' where id=1";
//String s="delete from task where "+fieldvalue+"="+value+"";
return jt.update(sql1);
}
public int delete(Pojo p) {
//	int id=p.getId();
//	String firstname=p.getFirstname();
//	String lastname=p.getLastname();
//	String dept=p.getDept();
//	String role=p.getRole();
//	String dob=p.getDob();
//	String zip=p.getZip();
//	String phone=p.getRole();
	String fieldvalue=p.getFieldvalue();
	String value=p.getValue();
//	String password=""+firstname.charAt(0)+dob.charAt(0)+dob.charAt(1)+dob.charAt(3)+dob.charAt(4);
//	String email=firstname.charAt(0)+lastname+"miraclesoft.com";
//	String username=firstname.charAt(0)+lastname;
	String s="delete from task where "+fieldvalue+"="+value+"";
	return jt.update(s);
}
public List selectall() {
	String sql="select * from task";
List get=new ArrayList<>();
List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
Map mapdata;
data=jt.queryForList(sql);
for(Map m1:data) {
	mapdata=new HashMap<>();
	mapdata.put("id",m1.get("id"));
	mapdata.put("firstname",m1.get("firstname"));
	get.add(mapdata);
}
return get;
}
public List select(int id) {
	String sql="select* from task where id=?";
	List li=new ArrayList();
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	Map mapdata1;
	data=jt.queryForList(sql,id);
	return data;
	
}
public List selectLike(Pojo p) {
	String user=p.getUsernam();
	String password=p.getPassword();
	String email=p.getEmail();
	String sql="select * from task where username like'"+user+"%' and  password like'"+password+"%' and email like'"+email+"%'";
	
List get=new ArrayList<>();
List<Map<String,Object>> data1=new ArrayList<Map<String,Object>>();
data1=jt.queryForList(sql);
return data1;

}
public List selectrolike(Pojo p) {
	String s="";
	String username=p.getUsernam();
	String password=p.getPassword();
	String email=p.getEmail();
	System.out.println("here");
	if(username!=null||password!=null||email!=null) {
		s=s+" where ";
  if(email!=null && username!=null && password!=null) {
		s=s+ "  username like '"+username+"%' and password like '"+password+"%' and email like '"+email+"%' ;";
	}
  else if(password!=null && username!=null){
			s=s+ "  username like '"+username+"%' and password like '"+password+"%';";
		}
		else if(username!=null) {
			s=s+" username like '"+username+"%';";
			}
		
	}
	String sql="select * from task "+s;
	System.out.println(sql);
	List get=new ArrayList<>();
	List<Map<String,Object>> data1=new ArrayList<Map<String,Object>>();
	data1=jt.queryForList(sql);
	return data1;
}
}
