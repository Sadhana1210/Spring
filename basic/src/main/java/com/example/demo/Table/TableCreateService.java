package com.example.demo.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableCreateService {
@Autowired
JdbcTemplate jt;
public String create(CreateTable c) {
	String s1=c.getName();
	System.out.println(s1);
	int s11=c.getCount();
	String sql11="insert into Shape4 values(?,?)";
	jt.update(sql11,s1,s11);
	
	return "insrted";
}
}
