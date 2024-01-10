package com.example.demo.copyProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insertProject.InsertProjectService;
import com.example.demo.insertProject.ProjectInsert;
@RestController
public class CopyProjectController {
	 @Autowired CopyProjectService copy;
	@PostMapping("CopyProject")
	public String Insert(@RequestBody CopyProject p) {
		return copy.projectcopy(p);
	}
	}


