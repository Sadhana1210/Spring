package mine;

import java.util.LinkedHashSet;

class Std1{
	int i;
	String s;
	Std1(int i,String s){
		this.i=i;
		this.s=s;
	}
}
public class LinkedHashSetObj {
	public static void main(String[] args) {
		
	
Std1 s1=new Std1(1,"sai");
Std1 s2=new Std1(1,"sai");
Std1 s3=new Std1(1,"sai");
LinkedHashSet <Std1>lh=new LinkedHashSet();
lh.add(s3);
lh.add(s1);
lh.add(s1);
for(Std1 ss:lh) {
	System.out.println(ss.i+" "+ss.s);
}
}
}
