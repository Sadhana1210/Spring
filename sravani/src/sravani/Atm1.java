package sravani;
import java.util.*;
class MyException extends Exception
{
	MyException(String S)
	{
		super(S);
	}
}

public class Atm1 {
	static int amt =6000000;
	static void ChechBalence()
	    {
		
			System.out.print("your account holds "+amt);
		}
		static void withdraw(int n)throws Exception
		{
			if(n<amt)
			{
				amt=amt-n;
				System.out.println("atm");
				System.out.println("please collect ur amount");
			}
			else 
			{
				throw new MyException("Insufficient amount");
	
		    }
		static void Deposit(int n)throws Exception
		{
			if(n>500)
			{
				amt=amt+n;
				System.out.println(amt);
				System.out.println("creadited");
				
			}
			else
			{
				throw new MyException("less then 500 not possible");
			}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		String uname="sravs";
		String pwd="sr@123";
		System.out.println("Enter user name");
		String UName=s.next();
		System.out.println("Enter password");
		String PWD=s.next();
		int c=0;
		for(int i=0;i<2;i++)
		{
			if(UName.equals(UName)&&pwd.equals(PWD)) {
				System.out.println("Enter your option \n 1.Check Balence \n 2.withdraw \n 3. deposit \n 4.exit");
			    c++;
			    break;
			    
		}
		else
		{
			System.out.print("please enter valid user name or password");
			UName =s.next();
			PWD =s.next();
		}

	}
	if(c!=0)
	{
		int o=s.nextInt();
		while(o!=4)
		{
			switch(0)
			{
			case 1 :Cheak Balence();break;
			case 2 :System.out.print("Enter amount");
			int w=s.nextInt();
			try
				{
					withdraw(w);
					
				}catch (Exception e) {
					e.PrtintStackTrace();
				}
				break;
				case 3:System.out.print("Enter amount");
				int d=s.nextInt();
				try
				{
					Deposit(d);
					
				}catch(Exception e) 
				{
					e.printStackTrace();
					
				}
				break;
				default:System.out.print("please enter the valid option");
			}
			
			    o=s.nextInt();
			    }
			    System.out.print("Thank you");
	}
			    else
			    {
			    System.out.print("Thank you");
			    } 
	}
}
		
}
		       
	
	


