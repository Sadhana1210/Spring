package programs;
import java.util.Scanner;
public class Perfect {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum=0;
		for(int i=1;i<num;i++)
		{
			if(num%i==0) {
				sum=sum+1;
				
			}
			
		}
		if(sum==num) {
			System.out.println("perfect");
		}else {
			System.out.println("nt perfect");
		}
	}
}
