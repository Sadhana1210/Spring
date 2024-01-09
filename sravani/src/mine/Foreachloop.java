package mine;

import java.util.ArrayList;

public class Foreachloop {
public static void main(String args[] ) {
	ArrayList <Object>a=new ArrayList();
	a.add("sadh");
	a.add(1);
	a.add(12.4);
	System.out.println(a);
	a.forEach(a1 ->System.out.println(a1)) ;
}
}
