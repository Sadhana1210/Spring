package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestInsertController {
@Autowired
TestInsertService t;

@PostMapping("/test")
public String insert1(@RequestBody TestInsert p) {
	 return t.insert(p);
}
}
