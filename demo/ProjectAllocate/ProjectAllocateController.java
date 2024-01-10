package com.example.demo.ProjectAllocate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insertEmp.InsertEmp;
@RestController
public class ProjectAllocateController {
@Autowired
ProjectAllocateService allocateEmp;
@PostMapping("AllocateEmp")
public String Insert(@RequestBody ProjectAllocate p) {
	return  allocateEmp.projectallocate(p);
}
}
