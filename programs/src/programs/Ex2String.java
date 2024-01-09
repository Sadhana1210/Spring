package Stringprograms;
import java.util.Scanner;
public class Ex2String{
   public static void main(String[] args) {
	   Scanner s = new Scanner(System.in);
	   System.out.println("Enter the string : ");
	   String str = s.nextLine();
	   int count =1;
	   for(int i=0;i<str.length();i++) {
		   if((str.charAt(i)==' ')) {
			   count++;
		   }
	   }
		System.out.println("Number of words in a string : "+count);
		int co=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=' ') {
				co++;
			}
		}
         System.out.println("Number of charecters in string : "+co);
	}

}
