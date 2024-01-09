

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
 * Servlet implementation class delete1
 */
@WebServlet("/delete1")
public class delete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");
			String fname=request.getParameter("nam");
			String s=request.getParameter("del");
			PreparedStatement p=con.prepareStatement("delete  from Insert1 where fname=?");
			p.setString(1, s);
			p.executeUpdate();
			con.close();
			PrintWriter pw=response.getWriter();
			pw.print("done");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
