package mine;

import java.util.ArrayList;

public class ListMethods {
public static void main(String[] args) {
ArrayList a=new ArrayList();
a.add("sadhana");
a.add("raj");
a.add("sai");
System.out.println(a);
a.remove(2);

//a.removeAll(a);
//a.clear();
System.out.println(a);
ArrayList a1=new ArrayList();
a1.add("kavya");
a1.add("pavi");
System.out.println(a1);
a1.removeAll(a);
System.out.println(a1);
}
}
