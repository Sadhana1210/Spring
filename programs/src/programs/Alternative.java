package programs;
import java.util.*;
public class Alternative{
public static void main(String[] args){
	   int n=733;
	   int digit =n%10;
	   while(n!=0)
		   int current_digit=n%10;
	       n=n/10;
	       if(current_digit!=digit) 
	       {
		   System.out.println("no");
		   }
	       else 
	       {
		   System.out.pintln("yes");
	       }
	   }
	}
}