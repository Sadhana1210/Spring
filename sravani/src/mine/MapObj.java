package mine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Joy{
	int i;
	String s;

Joy(int id,String st){
	i=id;
	s=st;
}
}
public class MapObj {
	public static void main(String[] args) {
		
	Joy j1=new Joy(1,"sai");
	Joy j2=new Joy(2,"sadh");
Map<Integer,Joy>m=new HashMap<Integer,Joy>();
System.out.println(m);
m.put(1, j2);
m.put(2, j2);
m.put(3, j1);
for(Map.Entry<Integer, Joy> entry:m.entrySet()) {
	
	
System.out.println(entry.getKey()+" "+entry.getValue().i+" "+entry.getValue().s);
	}
}
}
