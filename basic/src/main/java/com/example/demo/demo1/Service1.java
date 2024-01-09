package com.example.demo.demo1;

import org.springframework.stereotype.Service;
@Service
public class Service1 {
	
public int add(int a, int b) {
	return a+b;
	
}
public int sub(int a, int b) {
	return a-b;
}
public int mul(int a, int b) {
	return a*b;
}
public int div(int a, int b) {
	return a/b;
}

}
