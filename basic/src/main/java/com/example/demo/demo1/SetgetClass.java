package com.example.demo.demo1;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class SetgetClass {
int a,b;

public int getA() {
	return a;
}

public void setA(int a) {
	this.a = a;
}

public int getB() {
	return b;
}

public void setB(int b) {
	this.b = b;
}
}
