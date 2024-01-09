import java.sql.*;
public class jdbc {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");
//       PreparedStatement ps=con.prepareStatement("create table details(id INTEGER,name VARCHAR(12))");
//       ps.execute();
       PreparedStatement ps=con.prepareStatement("insert into details values (1,'sravani') ");
//       PreparedStatement ps1=con.prepareStatement("update details set name = 'janu' where id=1");
       ps.executeUpdate();
       //ps1.executeUpdate();
       PreparedStatement ps2=con.prepareStatement("insert into details values (2,'sravani') ");
       ps2.executeUpdate();
       PreparedStatement ps3=con.prepareStatement("insert into details values (3,'lavanya') ");
       PreparedStatement ps4=con.prepareStatement("insert into details values (4,'syamu') ");
       PreparedStatement ps5=con.prepareStatement("insert into details values (5,'Hemu') ");
       ps3.executeUpdate();
       ps4.executeUpdate();
       ps5.executeUpdate();
//       ps1.executeUpdate();
       PreparedStatement ps6=con.prepareStatement("select *from details");
       ps6.executeQuery("select *from details");
       ResultSet rs1=ps6.executeQuery();
       while(rs1.next()) {
    	   System.out.println(rs1.getString(1)+rs1.getString(2));
       }
       
	}

}
