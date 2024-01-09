package mine;

import java.util.ArrayList;
import java.util.Scanner;
class Duplicates_exception  extends Exception
{
	Duplicates_exception(String Message){
		super(Message);
	}

	
		 static void duplicates ()throws  Exception  
		{
			ArrayList a=new ArrayList() ;
			System.out.println("enter list ");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				int num=sc.nextInt();
				a.add(num);
				
			}
			
//				a.add(1);
//				a.add(2);
//				a.add(2);
//				a.add(4);
				//ArrayList a1=new ArrayList ();
				for(int i=0;i<a.size()-1;i++) 
				{
					for(int j=i+1;j<a.size();j++)
					{
						if(a.get(i)==a.get(j)) 
						{
							throw  new  Duplicates_exception("Exception raised");
						}
						
					}
			}
				System.out.println(a);
		}
		public class Diff_class_exception {
	public static void main(String[]args)  throws Exception{
		try {
			duplicates();
		}
	catch( Duplicates_exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}
	}





}
