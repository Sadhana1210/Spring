

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
import javax.servlet.http.HttpSession;
@WebServlet("/Hrdelete20")
public class Hrdelete20 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();
		response.setContentType("text/html");
		
		
		try {
			String rol=Hr20.role;
			String j="";
			if(rol.equalsIgnoreCase("trainer")) {
				j=" and role!='hr'";
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			PreparedStatement p=c.prepareStatement("delete from Hr_data where empid=?"+j);
			p.setString(1, id1);
			 int i=p.executeUpdate();
			 out.print("<h2 style='text-align:right'>"+ "hii"+hs.getAttribute("firstname")+"</h2>");
			 if(i>0) {
			out.print("<h2>deleted successfully</h2>");
		}
			 else {
				 out.print("<h2> not deleted </h2>");
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

}
