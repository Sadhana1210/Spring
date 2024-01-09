package sravani;
import java.sql.*;
import java.util.Scanner;
public class Absolute {
public static void main(String[] args)throws Exception {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter absolute row");
	int i=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://loaclhost:3306/Test","root","M1racle@123");
	    PreparedStatement ps =con.prepareStatement("select *from details",ResultSet.TYPE_SCROLL_INSENSITIVE);
	    PreparedStatement ps1 =con.prepareStatement("select *from details",ResultSet.TYPE_FORWARD_ONLY);
	    ResultSet rs=ps1.executeQuery();
	    rs.absolute(i);
	    while(rs.next()) {
	    	   System.out.println(rs.getString(2));
	       }
	       

	}

}
