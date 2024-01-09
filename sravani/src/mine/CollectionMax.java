package mine;

import java.util.ArrayList;

public class CollectionMax {
public static void main(String[] args) {
	int max=0;
	ArrayList<Integer> a=new ArrayList();
	a.add(1);
	a.add(9);
	a.add(3);
	a.add(6);
	System.out.println(a);
	a.sort(null);
	System.out.println(a);
	for(Integer b:a) {
max=b;
	}
	System.out.println("max is"+max);

}
}
