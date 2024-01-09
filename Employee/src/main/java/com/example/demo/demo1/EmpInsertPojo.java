package com.example.demo.demo1;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class EmpInsertPojo {
int id;
String role;
String pwd;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
}
