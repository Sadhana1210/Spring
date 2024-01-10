package com.example.demo.insertProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insertEmp.InsertEmp;

@RestController
public class InsertProjectController {
@Autowired
InsertProjectService ip;
@PostMapping("Projectinsert")
public String Insert(@RequestBody ProjectInsert p) {
	return ip.projectinsert(p);
}
}

