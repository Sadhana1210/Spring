package programs;
import java.util.Scanner;
public class Sumeven {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number :");
	int n = sc.nextInt();
	int sum=0;
	for(int i=2;i<=n;i++) {
		if(i%2==0) {
			sum=sum+i;
		}

	}
       System.out.println(sum);

}
}
