package sravani;
import java.sql.*;
import java.util.Scanner;
import java.util.*;
public class Jdbc_bank {
	static void withdraw(int amt,int n, String name1,Connection con)throws Exception
	{
		if(n<amt)
		{
			amt=amt-n;
			PreparedStatement ps =con.prepareStatement("update bank set Amount=? where name=?");
			ps.setString(2,name1 );
			ps.setInt(1,amt);
			ps.executeUpdate();
			System.out.println("please collect your money");
		}
		else throw new MyException("Insufficient amount");
	}
	static void Deposit(int amt,int n,String name1,Connection c)throws Exception
	{
		if(n>100)
		{
		  amt=amt+n;
		  PreparedStatement ps =c.prepareStatement("update Baank set Amount=? where name=?");
		  ps.setString(2,name1);
		  ps.setInt(1,amt);
		  ps.executeUpdate();
		  System.out.println("Credited");
		}
		else 
			 throw new MyException("Less than 500 not possible");
	}
	static void transfer(int amt,int a,int t,String name,Connection con)throws Exception
	{
		if(t>100&&amt>t) {
			amt=amt-t;
			PreparedStatement ps2 =con.prepareStatement("update AtmBank set Amount = ? where name=?");
			ps2.setString(2, name);
			ps2.setInt(1,amt);
			ps2.executeUpdate();
			PreparedStatement ps = con.prepareStatement("select Amount from Bank where Acc_no=?");
			ps.setInt(1,a);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int s=rs.getInt(1);
			int amt1=t+s;
			PreparedStatement ps1=con.prepareStatement("update AtmBank set Amount =? where acc_no=?");
			ps1.setInt(1,amt1);
			ps1.setInt(2,a);
			ps1.executeUpdate();
			System.out.println("Amount transfered");
		}
		else
			throw new MyException("Insufficient amount or less amount");
	}
public static void main(String[] args)throws Exception{
	Scanner sc = new Scanner(System.in);
	System.out.println("enter password and account number");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");
	//String pass = sc.nextLine();
	//int Account = sc.nextInt();
	//PreparedStatement ps=con.prepareStatement("create table AtmBank (Accountid int,name VARCHAR(12),phNo int,password VARCHAR(12))");
    //ps.execute();
    //PreparedStatement ps1 =con.prepareStatement("insert into AtmBank values (5943,'sravani',8185,'s@123')");
    //ps1.executeUpdate();
    //PreparedStatement ps2 =con.prepareStatement("insert into AtmBank values (5944,'janu',9893,'j@123')");
    //ps2.executeUpdate();
    //PreparedStatement ps3 =con.prepareStatement("insert into AtmBank values (5945,'ramu',8185,'r@123')");
    //ps3.executeUpdate();
	//PreparedStatement ps4 =con.prepareStatement("insert into AtmBank values (5946,'siri',6330,'s1@123')");
    //ps4.executeUpdate();
    //PreparedStatement ps5 =con.prepareStatement("insert into AtmBank values (5947,'usha',6699,'u@123')");
    //ps5.executeUpdate();
	//PreparedStatement ps = con.prepareStatement("select *from AtmBank where Account=?");
	//ps.setInt(1,Account);
	//ResultSet rs = ps.executeQuery();
	PreparedStatement p = con.prepareStatement("select * from AtmBank where name=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	String name =sc.next();
	String pwd = sc. next();
	
	int cnt=0;
	
	p.setString(1,name);
	
	ResultSet rs = p.executeQuery();
	
	for(int i=0;i<2;i++)
	{
		//System.out.println("hii");
		while(rs.next())
		{
			//System.out.println("Hii");
			if(rs.getString(3).equals(pwd))
			{
				
				System.out.println("Enter your option\n 1.check Balence \n 2.withdraw \n 3.Deposite \n 4.Transfer \n 5.Exit");
				cnt++;
				break;
			}
			else
			{
			 System.out.println("Invalid");
			 name=sc.next();
			 pwd=sc.next();
			 p.setString(1,name);
			}
			
		}
	}
	rs.previous();
	if(cnt!=0)
	{
		int o = sc.nextInt();
		while(o!=5)
		{
			switch(o) {
			case 1:System.out.print(rs.getInt(4));
			break;
			case 2:System.out.print("Enter amount");
			int w=sc.nextInt();
			try
			{
				withdraw(rs.getInt(4),w,name,con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} break;
			case 3:System.out.println("Enter amount");
			int d = sc.nextInt();
			try
			{
				Deposit(rs.getInt(4),d,name,con);
			}catch (Exception e) {
				e.printStackTrace();
			}break;
			case 4:System.out.println("Enter amount details t transfer");
			System.out.println("Acc no");
			int a=sc.nextInt();
			System.out.println("Amount to be Transfered");
			int t=sc.nextInt();
			//int w1=rs.getInt(4);
			try
			{
				transfer(rs.getInt(4),a,t,name,con);
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			default:System.out.print("please enter valid option");
			}
			o=sc.nextInt();
			}
		System.out.print("Thank you");
		
	}
	else
	{
		System.out.print("Thank you");
	}
	
	}
}
