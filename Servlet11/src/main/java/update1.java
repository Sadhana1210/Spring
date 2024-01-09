

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update1
 */
@WebServlet("/update1")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");			
			String fname1=request.getParameter("fname");
			String field=request.getParameter("fieldname");
			String value=request.getParameter("fieldvalue");
			PreparedStatement p1=con.prepareStatement("update Insert1 set "+field+"=? where fname=? ");
			p1.setString(1, value);
			p1.setString(2, fname1);
		
			p1.executeUpdate();
			con.close();
//			PrintWriter pw=response.getWriter();
//			pw.print("done");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	}

