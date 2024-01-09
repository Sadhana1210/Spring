

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
@WebServlet("/Loginhr")
public class Loginhr extends HttpServlet {
	static String role;
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {

				PrintWriter pw = response.getWriter();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Details","root","M1racle@123");
				String id = request.getParameter("id");
             	String password = request.getParameter("pass");
				PreparedStatement ps = c.prepareStatement("select * from roles where id=? and pwd=?");
				ps.setString(1,id);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					pw.print(rs.getString(2));
					  role=rs.getString(2);
//				if(rs.getString(1)==id && rs.getString(3).equals(password)) {
						if(role.equals("hr")) {
                           RequestDispatcher rd = request.getRequestDispatcher("HR.html");
							rd.forward(request, response);
						}
						else if(role.equals("trainer")) {
							RequestDispatcher rd = request.getRequestDispatcher("Trainer.html");
							rd.forward(request, response);	
						}
						else {
							RequestDispatcher rd = request.getRequestDispatcher("Trainee.html");
							rd.forward(request, response);
						}
						}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("/Loginr.html");
						rd.include(request, response);
						pw.print("Invalid");
					}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
