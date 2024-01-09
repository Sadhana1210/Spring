package mine;
import java.util.*;
import java.util.HashSet;
import java.util.Iterator;

public class Abcd{

	public static void main(String[] args) {
		ArrayList h=new ArrayList();
		h.add("hii");
		h.add("hlo");
		h.add("hii");
		h.add("sadh");
		System.out.println(h);
		Iterator i=h.iterator();
		while(i.hasNext())
		{
		
			System.out.println(i.next());
		}
Set s=new HashSet(h);
ArrayList <String>a=new ArrayList(s);
System.out.println(s);
//System.out.println(a);
for(String i1:a) {
	System.out.println(i1);
}
	}
}



