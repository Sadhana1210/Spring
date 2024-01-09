import java.sql.*;
import java.util.Scanner;
public class Like_concat {
	public static void main(String[] args)throws Exception{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("enter like values");
		String s= sc.nextLine();
		String s1=sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");
	    PreparedStatement ps1 =con.prepareStatement("select *from Test.Employee where firstname Like'%"+s+"'" +" or firstname Like'%"+s1+"'");
	    ResultSet rs=ps1.executeQuery();
	    while(rs.next())
	    System.out.println(rs.getInt(1)+ " "+rs.getString(2));
		
	}

}
