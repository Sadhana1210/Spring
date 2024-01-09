package mine;

import java.util.ArrayList;
import java.util.Iterator;


	class std{
		int i;
		String name;
		std(int id, String name1){
			i=id;
			name=name1;
			
		}
	}
	public class ObjArray {
public static void main(String[] args) {
	std s1= new std(1,"sai");
	std s2=new std(2,"sadh");
	
	ArrayList<std> a= new ArrayList();
	a.add(s2);
	a.add(s1);
	System.out.println(a);
	Iterator<std> it=a.iterator();
	while(it.hasNext()) {
	std s11=(std)it.next();
		System.out.println(s11.i+" "+s11.name);
	}
//	for(std ss:a) {
//		ss=(std)ss;
//		System.out.println(ss.i+" "+ss.name);
//
//	}
}
}
