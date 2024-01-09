package com.example.demo.usercheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_controller {
	@Autowired
	User_service us;
@PostMapping("user")
public String select(@RequestBody User u) {
	 return us.username(u);
	
}

}
