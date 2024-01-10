package com.example.demo.EmptaskList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.taskList.tasklist;
@RestController
public class EmptaskListcontroller {
	@Autowired
	EmptaskListService es;
	@PostMapping("emptaskinsert")
	public String emp(@RequestBody EmptaskList t) {
		return es.emptasksassign(t);
	}
}
