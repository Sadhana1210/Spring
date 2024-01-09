package com.example.demo.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableCreateController {
@Autowired
TableCreateService ts;
@GetMapping("table")
public String create(@RequestBody CreateTable t ) {
	return ts.create(t);
	
}
}
