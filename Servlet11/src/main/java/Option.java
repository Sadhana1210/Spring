

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Option
 */
@WebServlet("/Option")
public class Option extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("valid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
	if(op.equals("insert")) 
	{
		RequestDispatcher rd=request.getRequestDispatcher("Hrinsert1.html");
		rd.forward(request, response);
	}
	else if(op.equals("update")) {
		RequestDispatcher rd=request.getRequestDispatcher("Hrupdate.html");
		rd.forward(request, response);
	}
	else if(op.equals("delete")) {
		RequestDispatcher rd=request.getRequestDispatcher("delete1.html");
		rd.forward(request, response);
	}
	else if(op.equals("select")) {
		RequestDispatcher rd=request.getRequestDispatcher("Hrselect.html");
		rd.forward(request, response);
	}
	else {
		
	}
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

}
