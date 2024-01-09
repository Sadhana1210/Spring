package com.example.demo.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestInsertService {
@Autowired
JdbcTemplate jt;
public String insert(TestInsert p) {
	String Id=p.getId();
	String Name=p.getName();
	String sql="insert into student values(?,?)";
	jt.update(sql,Id,Name);
	return "inserted";
}

}
