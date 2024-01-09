

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hrtask12
 */
@WebServlet("/Hrtask12")
public class Hrtask12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out1=response.getWriter();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
		String pass=request.getParameter("pwd");
		int id=Integer.parseInt(request.getParameter("id"));
		PreparedStatement p=c.prepareStatement("select * from roles where id=? and pwd=?");
		p.setString(2,pass);
		p.setInt(1, id);
		ResultSet r=p.executeQuery();
		if(r.next()) {
			if(r.getString("role").equals("hr")) {
			RequestDispatcher rd=request.getRequestDispatcher("Option.html");
			rd.forward(request, response);
			
	}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("check.html");
			rd.include(request, response);
			out1.print("Invalid");
		}
		}
	}
	
	
	catch(Exception e) {
		e.printStackTrace();
	}
}
}

