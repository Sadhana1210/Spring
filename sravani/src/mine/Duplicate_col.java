package mine;

import java.util.HashMap;
import java.util.Map;

public class Duplicate_col {
public static void main(String[] args) {
	int array [] = {1,2,3,4,90};
	Map <Integer,Integer> m=new HashMap<>();
	for(Integer i:array)
	{
		m.put(i, i);
	}

	System.out.println(m);

	 System.out.println("Duplicate elements in the array:");
     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
         if (entry.getValue() > 1) {
             System.out.println(entry.getKey());
         }

}
}
}
