import java.io.IOException;
import java.io.*;
	import java.sql.*;
	import javax.servlet.*;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	@WebServlet("/Insert")
	public class Insert extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				PrintWriter pw = response.getWriter();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Details","root","M1racle@123");
				String  id = request.getParameter("id");
				String fname = request.getParameter("fname");
				String role = request.getParameter("role");
				String email = request.getParameter("email");
				String lname = request.getParameter("lname");
				String dept=request.getParameter("dept");
				pw.print(Loginhr.role);
				if(Loginhr.role.equals("hr")) {
					PreparedStatement ps = c.prepareStatement("insert into Emp values(?,?,?,?,?,?)");
					PreparedStatement p = c.prepareStatement("insert into roles values(?,?,?)");
					p.setString(1,id);
					p.setString(3,"M1racle@123");
					p.setString(2,role);
					p.executeUpdate();
					ps.setString(1,id);
					ps.setString(2,fname);
					ps.setString(3,lname);
					ps.setString(6,role);
					ps.setString(5,email);
					ps.setString(4, dept);
					ps.executeUpdate();
					RequestDispatcher rd = request.getRequestDispatcher("HR.html");
					rd.include(request, response);
					pw.print("HR Inserted Details Successfully");
				}
				else {
					if(role.equals("hr")) {
						pw.print("You Can't Enter the Hr Details");
					}
					else {
					PreparedStatement ps = c.prepareStatement("insert into employ values(?,?,?,?,?,?)");
					PreparedStatement p = c.prepareStatement("insert into roles values(?,?,?)");
					p.setString(1,id);
					p.setString(3,"M1racle@123");
					p.setString(2,role);
					p.executeUpdate();
					ps.setString(1,id);
					ps.setString(2,fname);
					ps.setString(3,lname);
					ps.setString(6,role);
					ps.setString(5,email);
					ps.setString(4,dept);
					ps.executeUpdate();
					RequestDispatcher rd = request.getRequestDispatcher("Trainer.html");
					rd.include(request, response);
					pw.print("Trainer Inserted Details Successfully");
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
