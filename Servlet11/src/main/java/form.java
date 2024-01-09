 

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
import java.util.*;


/**
 * Servlet implementation class form
 */
@WebServlet("/form")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out1=response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			String role=request.getParameter("fname");
		    PreparedStatement p=con.prepareStatement("select*from roles where role=?");
			p.setString(1,role);
		
			ResultSet r=p.executeQuery();
				if(r.next()) {
					RequestDispatcher rd=request.getRequestDispatcher("subform");
					rd.forward(request, response);
				
			}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("NewFile.html");
					rd.include(request, response);
					out1.print("Invalid");
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}
