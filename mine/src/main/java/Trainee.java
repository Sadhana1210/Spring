

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Trainee
 */
@WebServlet("/Trainee")
public class Trainee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("update");
		System.out.println("eeee"+fn);
		String fieldvalue=request.getParameter("fv");
		System.out.println("eeee"+fieldvalue);
		String id=Hr20.empid;
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			PreparedStatement p3s=c.prepareStatement("update Hr_data set "+fn+"=? where empid=?");
			p3s.setString(1, fieldvalue);
			p3s.setString(2, id);
			//System.out.println("eeee1upp");
			//int i=ps.executeUpdate();
			p3s.executeUpdate();
			System.out.println("eeee1upp mine");
//			if(i>0) {
//				out.print("<h2> Update successfully</h2>");
//			}
//			else {
//				out.print("<h2>  Not Updated</h2>");
//			}
			RequestDispatcher s=request.getRequestDispatcher("/Trainee1.html");
			s.include(request, response);
			out.print("Update successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}
