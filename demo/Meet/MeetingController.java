package com.example.demo.Meet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MeetingController {
@Autowired
MeetingService ms;
@PostMapping("meetinsert")
public String meeting(@RequestBody Meeting m) {
	 return ms.insert(m);
	
}
}
