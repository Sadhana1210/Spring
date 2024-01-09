package com.example.demo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hr.PojoHr;



	@RestController
	public class Project_controller {
	@Autowired
	Project_service ts;
	@GetMapping("project")
	public String select (@RequestBody Project p) {
		return  ts.select(p);
	}
	@PostMapping("projectinsert")
	public String projectinsert(@RequestBody Project p) {
		return ts.projectinsert(p);
	}
	@PostMapping("projectallocate")
	public String projectallocate(@RequestBody Project p) {
		return ts.projectallocate(p);
	}
	@PostMapping("projectcopy")
		public String projectcopy(@RequestBody Project p) {
			return ts.projectcopy(p);
		}
	}
	

