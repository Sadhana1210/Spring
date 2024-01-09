package sravani;

import java.util.Scanner;

public class EXce {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		 System.out.println("Enter the String :");
		 String st = s.nextLine();
		 char ch =s.next().charAt(0);
		 for(int i=0;i<st.length();i++) {
			 if(st.charAt(i)==ch) {
				 continue;
			 }
			 else {
				 System.out.print(st.charAt(i));
			 }
		 }
		 
	}

}
