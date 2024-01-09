

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class select1
 */
@WebServlet("/select1")
public class select1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");
			PrintWriter pout=response.getWriter();
			PreparedStatement p=con.prepareStatement("select * from Insert1");
			ResultSet r=p.executeQuery();
			while(r.next()) {
				pout.print(r.getString(1)+r.getString(2));
			}
			con.close();
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	}


