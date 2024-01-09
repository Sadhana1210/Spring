package mine;
import java.util.*;

public class Demo {

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add(1);
		al.add(5);
		al.add("Hello");
		al.add(34.5);
		al.add(56);
		System.out.println(al);
		ArrayList a2=new ArrayList();
		a2.add(16);
		a2.add(78);
		System.out.println(a2);
		a2.set(0, "String");
		System.out.println(a2);
	al.add(a2);
	System.out.println(al);
	for(int j=0;j<a2.size();j++) {
		System.out.println((a2.get(j)));
	}
	
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
			
		}
//		ArrayList a2=new ArrayList();
//		a2.add(56);
//	al.add(a2);
//	for(int j=0;j<a2.size();j++) {
//		System.out.println((a2.get(j)));
//	}
	//System.out.println(a2);
//	ArrayList a3= new ArrayList();
////	a3=add(al+a2);
//	//a3=al+a2;
//	
//	System.out.println(a3);
//	
	}

}
