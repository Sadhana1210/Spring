package demo;

import java.util.ArrayList;
import java.util.List;

public class Foreach222 {
	public static void main(String args[] ) {

	String s[]={"sadhana vabbf hdfhiuf","fsafgsgf"};
	for(String s1:s) {
		System.out.println(s1);
	}
	ArrayList <Object>a=new ArrayList();
	a.add("sadh");
	a.add(1);
	a.add(12.4);
	System.out.println(a);
	a.forEach(a2 ->System.out.println(a2)) ;
		
	
}
}
