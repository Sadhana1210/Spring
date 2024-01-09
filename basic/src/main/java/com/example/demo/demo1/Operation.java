package com.example.demo.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Operation {
@Autowired
Service1 s;

@PostMapping("addition456")
public String add1(@RequestParam int a,@RequestParam int b) {
String d="sub: "+s.sub(a,b)+" mul: "+s.mul(a, b)+" div: "+s.div(a, b)+" add: "+s.add(a, b);
//System.out.println(d);
	
 return d;
}
//@GetMapping("sub")
//public int sub(@RequestParam  int a,@RequestParam int b) {
//	int total=s.sub(a, b);
//	return total;
//	
//}
//@PostMapping("mul")
//public int mul(@RequestBody  SetgetClass b1) {
//	int total= s.mul(b1.getA(),b1.getB());
//	return total;
//}
//@GetMapping("div/{a}/{b}")
//public String div(@PathVariable int a,@PathVariable int b) {
//	String j="";
//	try {
//		 return j=j+s.div(a, b);
//	}
//	catch (Exception e) {
//		 return j=j+e;
//	}
//}
}
