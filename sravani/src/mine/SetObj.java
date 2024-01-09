package mine;

import java.util.HashSet;

class Std{
	int id;
	String s;
	Std(int i,String name){
		id=i;
		s=name;
		
	}
}
public class SetObj {
public static void main(String[] args) {
	Std s1=new Std(1,"sai");
	Std s2=new Std(2,"sadh");
	Std s3=new Std(2,"sadh");
	HashSet<Std>hs=new HashSet();
	hs.add(s1);
	hs.add(s2);
	hs.add(s3);
	for(Std ss:hs) {
		ss=(Std)ss;
		System.out.println(ss.id+" "+ss.s);
	}

	
}
}
