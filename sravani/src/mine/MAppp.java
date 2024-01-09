package mine;

import java.util.LinkedHashMap;
import java.util.Map;
	class Sadh{
		int a;
		String name;
		Sadh(int a, String name)
		{
			this.a=a;
			this.name=name;
		}
		
	}
	public class MAppp {
		
	public static void main(String[] args) {
	Sadh s=new Sadh(1,"sadhana");
	Sadh s1=new Sadh(2,"sai");
		Map<Integer,Integer> m= new LinkedHashMap<>();
		m.put(1, 12);
		m.put(2,45);
		m.put(3,34);
//		m.put( 4,s);
//		m.put(5, s1);
		System.out.println(m);
		
		
	}
	}

