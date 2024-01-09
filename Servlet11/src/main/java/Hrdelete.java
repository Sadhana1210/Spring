

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Hrdelete")
public class Hrdelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
		int id2=Integer.parseInt(request.getParameter("id"));
		PreparedStatement p=c.prepareStatement("delete from Emp where id=?");
		p.setInt(1, id2);
		p.executeUpdate();
		System.out.println("done");
	}
	catch(Exception e) {
		
	}
	}

	

}
