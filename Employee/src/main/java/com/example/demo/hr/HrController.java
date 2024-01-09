package com.example.demo.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.task.Pojo;
import com.example.demo.task.TaskService;
@RestController
public class HrController {
@Autowired
HrService ts;
@PostMapping("insertHr")
public String slect (@RequestBody PojoHr pojo) {
	return  ts.select(pojo);
}
}
