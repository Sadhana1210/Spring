

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
import javax.servlet.http.HttpSession;
@WebServlet("/Hr20")
public class Hr20 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   static String role="";
   static String empid="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(); 
		response.setContentType("text/html");
		PrintWriter out1=response.getWriter();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
				String pass=request.getParameter("pwd");
				String id=request.getParameter("id");
//				HttpSession hs=request.getSession(); 
				PreparedStatement pp=c.prepareStatement("select firstname from Hr_data where empid=?");
				pp.setString(1,id);
				ResultSet rp=pp.executeQuery();
				if(rp.next()) {
					hs.setAttribute("firstname", rp.getString("firstname"));
				}
				PreparedStatement p=c.prepareStatement("select * from Hr_data where empid=? and password=?");
				p.setString(2,pass);
				p.setString(1, id);
				ResultSet r=p.executeQuery();
				if(r.next()) {
					role=r.getString(6);
					empid=r.getString(1);
					
					if(role.equalsIgnoreCase("hr")||role.equalsIgnoreCase("trainer")) {
//						response.sendRedirect("Option20.html");
						out1.print("<h2 style='text-align:right'>"+ "hii"+hs.getAttribute("firstname")+"</h2>");
						RequestDispatcher rd=request.getRequestDispatcher("Option20.html");
						rd.include(request, response);
					
						
					
			}
				else if(role.equalsIgnoreCase("trainee")){
					RequestDispatcher rd=request.getRequestDispatcher("Trainee1.html");
					rd.forward(request, response);
//					out1.print("Invalid");
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("Hr20.html");
					rd.include(request, response);
					out1.print("Invalid");
				}
				}
			}
			
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
