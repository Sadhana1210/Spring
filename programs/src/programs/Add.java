package programs;

public class Add {

	public static void main(String[] args) {
		int digit=23456;
		int lastdigit;
		
		lastdigit=digit%10;
		while(digit>10) {
			digit=digit/10;
		}
		int sum=digit+lastdigit;
		System.out.println("sum of first and last digit :"+sum);
	}

}
