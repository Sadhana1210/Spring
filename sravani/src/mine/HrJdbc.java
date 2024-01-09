package mine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HrJdbc {
  static void Hr( Scanner sc, Connection c) throws SQLException {
		PreparedStatement p=c.prepareStatement("insert roles values(?,?,?");
		String name=sc.nextLine();
		String role=sc.nextLine();
		int id=sc.nextInt();
		p.setString(2, name);
		p.setString(3, role);
		p.setInt(1, id);
		p.executeUpdate();
		}
  public static void main(String args[])  throws Exception{
		Scanner sc=new Scanner(System.in);
		String pass=sc.nextLine();
		int id=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root", "M1racle@123");
		PreparedStatement p1=c.prepareStatement("select * from roles where id=? and pwd=?");
		p1.setString(2,pass);
		p1.setInt(1,id);
		ResultSet r=p1.executeQuery();
		while(r.next()) {
			//System.out.println(r.getString("role"));
			if(r.getString("role").equals("hr")) {
				Hr(sc,c);
//			System.out.println("inser");
//			PreparedStatement p=c.prepareStatement("insert roles values(?,?,?)");
//			System.out.println("enter role");
//			String role1=sc.next();
//			System.out.println("enter pwd");
//		String pwd1=sc.next();
//			System.out.println("enter id");
//			int id1=sc.nextInt();
//			p.setString(3, pwd1);
//			p.setString(2, role1);
//			p.setInt(1, id1);
//			p.executeUpdate();
			}
			else {
				System.out.println("not able to insert");
			}
		}
		

  }}
