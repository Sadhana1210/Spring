package mine;
import java.util.StringJoiner;
public class Constructer {
	public static void main(String[] args) {
	String s="sadhana"+"vabbili";
	
	
		        StringJoiner joiner = new StringJoiner("..."); // Delimiter is ", " here

//		        joiner.add("John");
//		        joiner.add("Doe");
//		        joiner.add("Jane");

//		        String result = joiner.toString();
System.out.println(s);
joiner.setEmptyValue("No names provided");

//
 StringJoiner joiner1=new StringJoiner(",,");
 joiner1.add("lucky");
		      joiner.add("123");  
		boolean sad=joiner.equals(joiner1);
		      System.out.println(joiner+"F");
		      System.out.println(joiner+"ghvg");
		    		  
		    		  System.out.println(joiner1.merge(joiner));
//		      System.out.println(sj);
		      int sjj=joiner.length();
		      System.out.println(sjj);
		      System.out.println(joiner.length());
	}
		
}
