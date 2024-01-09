

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hrupdate")
public class Hrupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=request.getParameter("val");
		String col1=request.getParameter("col");
		int sad=Integer.parseInt(request.getParameter("sad1"));
		
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			PreparedStatement p=c.prepareStatement("update Emp set("+col1+"=? where id=?");
			p.setString(1,val);
            p.setInt(2, sad);
            p.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
	}

}
