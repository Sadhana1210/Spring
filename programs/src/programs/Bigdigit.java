package programs;
import java.util.Scanner;
public class Bigdigit{
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int a,b,c;
	final int num = sc.nextInt();
    a = num/100;
	b = (num/10)%10;
	c = num%10;
       if(a>b){
	      if(a>c){
	        System.out.println(a);
	      } else{
	        System.out.println(c);
	      }
	    }

	}
}
	

