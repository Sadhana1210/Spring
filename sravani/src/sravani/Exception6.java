package sravani
public class Exception6 {
      public static void main(String[] args){
		int a=10;
		int b=5;
		int c=5;
		try
		{
		    int x=a/(b-c);
			System.out.println("Division by zero");
		}
		finally
		{
	    int y=a/(b+c);
	    System.out.println(" y = "+y);
	    }
}
}
