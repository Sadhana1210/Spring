package com.example.demo.taskList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tasklistController {
@Autowired
tasklistService ts;
@PostMapping("inserttask")
public String addtasks(@RequestBody tasklist t ) {
	return ts.addtasks(t);
}
@PostMapping("updatetask")
public String updatetask(@RequestBody tasklist t) {
	return ts.updatetask(t);
}
@PostMapping("deletetask")
public String deletetask(@RequestBody tasklist t) {
	return ts.deletetask(t);
}
@PostMapping("selecttask")
public String selecttask(@RequestBody tasklist t) {
	return ts.taskSearch(t);
}

}
