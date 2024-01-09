

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Option20")
public class Option20 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("valid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
	if(op.equals("insert")) 
	{
		RequestDispatcher rd=request.getRequestDispatcher("Hrinsert20.html");
		rd.forward(request, response);
	}
	else if(op.equals("update")) {
		RequestDispatcher rd=request.getRequestDispatcher("Hrupdate20.html");
		rd.forward(request, response);
	}
	else if(op.equals("delete")) {
		RequestDispatcher rd=request.getRequestDispatcher("delete20.html");
		rd.forward(request, response);
	}
	else if(op.equals("selectone")) {
		RequestDispatcher rd=request.getRequestDispatcher("Hrselect20.html");
		rd.forward(request, response);
	}
	else if(op.equals("selectAll")) {
		RequestDispatcher rd=request.getRequestDispatcher("Hrselect201");
		rd.forward(request, response);
	}
	else if(op.equals("Trainee")) {
		RequestDispatcher rd=request.getRequestDispatcher("Update201.html");
		rd.forward(request, response);
	}
	
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

}
