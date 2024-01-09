package programs;
import java.util.Scanner;
public class Occurance11{
public static void main(String[] args){
		Scanner sc new Scanner(System.in);
		String a=" ";
		String b=" ";
		String c=" ";
		System.out.print("enter two words");
		a=sc.nextLine();
		b=sc.nextLine();
		for(int i=0;i<a.length();i++){
			char ch=a.charAt(i);
			if(b.indexOf(ch)!=-1){
				c=c+String.valueOf(ch);
			}
		}
		System.out.println("common letters are:"+c);
}


