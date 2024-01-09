package com.example.demo.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class EmpInsertService {
@Autowired
JdbcTemplate connect;
@Autowired
NamedParameterJdbcTemplate con;

public int insert(EmpInsertPojo e) {
	
	int id=e.getId();
	String role=e.getRole();
	String pwd=e.getPwd();
	String sql="insert into Emp1 values(?,?,?)";
	return connect.update(sql,id,role,pwd);
}
public int insert1(EmpInsertPojo em) {
	MapSqlParameterSource m=new MapSqlParameterSource().addValue("id", em.getId())
.addValue("role", em.getRole()).addValue ("pwd",em.getPwd());
	String sql="insert into Emp1 values(:id,:role,:pwd)";
	return con.update(sql,m);
}
}
