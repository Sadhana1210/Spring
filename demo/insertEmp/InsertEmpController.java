package com.example.demo.insertEmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InsertEmpController {
	@Autowired
	InsertEmpService ts;
	@PostMapping("Empinsert")
	public String Insert(@RequestBody InsertEmp p) {
		return  ts.Insert(p);
	}
}
