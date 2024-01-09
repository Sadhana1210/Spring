package com.example.demo.demo1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmpInsertController {
@Autowired
EmpInsertService emp;
@PostMapping ("insert11")
public String insert(@RequestBody EmpInsertPojo e) {
	int op=emp.insert(e);
	if(op>0) {
		return "inserted";
	}
	else {
		return "not inserted";
	}
	
}
@PostMapping("inserttt")
public Map insert1(@RequestBody EmpInsertPojo em) {
 HashMap<String,String> h=new HashMap<String,String>();
	int op1=emp.insert1(em);
	if(op1>0) {
	  h.put("ok","inserted");
		}
	else {
		 h.put("not ok","not inserted");
	}
return h;
	}
}


