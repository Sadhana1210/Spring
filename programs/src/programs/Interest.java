package programs;
import java.util.Scanner;
public class Interest {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		System.out.println("enter the P & T & R :");
		float p = sc.nextFloat();
		float t = sc.nextFloat();
		float r = sc.nextFloat();
		float interest = p*t*r/100;
		System.out.println("Interest = "+interest);


	}

}
