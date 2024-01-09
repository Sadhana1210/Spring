

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertHr
 */
@WebServlet("/Hrinsert")
public class Hrinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out1=response.getWriter();
		String  fname=request.getParameter("fname");
		String  lname=request.getParameter("lname");
		String  dept=request.getParameter("dept");
		String  email=request.getParameter("email");
		String role=request.getParameter("role");
		int id1=Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			PreparedStatement p=con.prepareStatement("insert Emp values(?,?,?,?,?,?)");
			p.setInt(1,id1);
			p.setString(2,fname);
			p.setString(3,lname);
			p.setString(4,dept);
			p.setString(5,email);
			p.setString(6,role);
			p.executeUpdate();
			//out1.print("inserted");
	}
		catch(Exception e) {
			
		}

}
}
