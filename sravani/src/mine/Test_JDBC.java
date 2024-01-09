package mine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_JDBC {
	public static void main(String[] args) throws Exception{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:Mysql://localhost:3306/Test","root","M1racle@123");
//		PreparedStatement p1=c.prepareStatement("insert into Employee (id,firstname)values('100','sadama')");
//		p1.executeUpdate();
		
		Statement s=c.createStatement();
		s.addBatch("insert into Employee (id,firstname) values ('10002','saf')");
		s.addBatch("Select * from Employee where firstname like 's%' and email like 's%' and phone like '9%'");
	       long[] r=s.executeLargeBatch();
			for(long i :r)
			{
				System.out.println(i);
		
		}		
			do {
                try (ResultSet resultSet = s.getResultSet()) {
                   
                    while (resultSet.next()) {
                        
                    }
                }
            } while (s.getMoreResults() || s.getUpdateCount() != -1);

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
