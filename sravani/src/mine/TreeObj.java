package mine;

import java.util.Set;
import java.util.TreeSet;

import java.util.*;    
class Book1 implements Comparable<Book1> {    
int id;    
String n; 
public Book1(int id, String n) {    
    this.id = id;
    this.n=n;
}   

public int compareTo(Book1 b) {   
	    if(id>b.id){    
	        return 1;    
	    }else if(id<b.id){    
	        return -1;    
	    }else{    
	    return 0;    
	    }    
}
}    
public class TreeObj{    
public static void main(String[] args) {    
    //Creating map of Books    
    Set<Book1> map=new TreeSet<Book1>();    
    //Creating Books    
    Book1 b1=new Book1(111,"Let us C");    
    Book1 b2=new Book1(102,"Data Communications & Networking");    
    Book1 b3=new Book1(103,"Operating System");    
    //Adding Books to map   
    map.add(b1);  
    map.add(b2);  
    map.add(b3);  
//      System.out.println(map);  
//    for(Book1 b:map) {
      Iterator i= map.iterator();
      while(i.hasNext()) {
    	 Book1 b11  =(Book1)i.next();
    	System.out.println(b11.id+" "+b11.n);
    }
}    
}    
