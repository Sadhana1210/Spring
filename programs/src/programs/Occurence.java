package programs;

public class Occurence {

	public static void main(String[] args) {
		int n=898989999,count=0;
		int d=4;
		while(n>0)
		{
			int rem=n%10;
			if(rem==d)
				count++;
			n=n/10;
		}
        System.out.println(count);
	}

}
