
package sravani;
import java.sql.*;
import java.util.*;
class Insufficient extends Exception
{
	Insufficient (String str)
	{
		super(str);
	}
}

public class Bank {
	

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
		System.out.println("Enter user ");
		String check=sc.next();
		System.out.println("Enter password:");
	String pass=sc.next();
	PreparedStatement p2=c.prepareStatement("Select*from Details.Bank2_info");
	p2.execute();
//	PreparedStatement p3=c.prepareStatement("Select account_num,password where account_num=?");
	int count=0;
		while(count<3) {
			
		ResultSet r=p2.executeQuery();
		
		while(r.next()) {
			//r.next();
			String balance1=r.getString("balance");
		String password=r.getString("password");
		String account_number=r.getString("user_id");
			if(check.equals (account_number)&& pass.equals(password)) 
			{
				System.out.println("1.Balance 2.Withdraw 3.Deposit 4.Transfer 5.Exit");
			System.out.println("Enter operation number:");
				int op=sc.nextInt();
				if(op<6)
				{
					switch(op) {
					case 1:
						
						//System.out.println(balance1);
						//System.out.println(balance1);
					PreparedStatement p4=c.prepareStatement("select balance from Details.Bank2_info where user_id=?");
						p4.setString(1, check);
						p4.execute();
						ResultSet r1=p4.executeQuery();
						System.out.println(r.getString(4));	
						//
						String balance=r.getString(4);
						
						break;
					case 2:
						System.out.println("amount to withdraw");
	                       int m=sc.nextInt();
	                      int balance2=r.getInt(4);
							if(m<balance2)
							  {
								  balance2=balance2-m;
								  System.out.println(m+"deducted");
								  System.out.println("Current balance:"+balance2);
								  PreparedStatement ps=c.prepareStatement("update Details.Bank2_info set balance=? where user_id=?");
								   ps.setString(1, "balance2");
								   ps.setString(2, account_number);
								   ps.executeUpdate();
								   System.out.println("done");
							  }
							  else
							  {
								  throw new Insufficient("Insufficient amount");
							  }
							
						  // System.exit(0);
							break;
					case 3:
						System.out.println("money to draw");
						int n=sc.nextInt();
						int balance3=r.getInt(5);
						if(n<100)
						  {
							  throw new Insufficient("Insufficient");
						  }
						  else
						  {
							balance3=balance3+n;
							System.out.println(n+"credited");
						  }
					break;
					case 4:
						System.out.println("transfer");
					break;
					case 5:
						System.exit(0);
					}
				    }
			}
			else
			{
				if(count<3) {
				 System.out.println("invalid");
				 System.out.println("Enter account num");
				 check=sc.next();
				 System.out.println("Enter password:");
			    pass=sc.next();
			count++;
			System.out.println(count);
			}
			}
			
			}
			
				}
		
		
	
	}
}
