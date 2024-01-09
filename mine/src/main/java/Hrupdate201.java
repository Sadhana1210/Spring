

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
@WebServlet("/Hrupdate201")
public class Hrupdate201 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("update");
		String fieldvalue=request.getParameter("fv");
		String id=request.getParameter("id");
		PrintWriter p=response.getWriter();
				try {
					String rol=Hr20.role;
					String j="";
					if(rol.equalsIgnoreCase("trainer"))
					{
						j=" and role!='hr'";
					}
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			PreparedStatement ps=c.prepareStatement("update Hr_data set "+fn+"=? where empid=?"+j);
			ps.setString(1,fieldvalue);
            ps.setString(2,id);
            int i= ps.executeUpdate();
				if(i>0) {
					p.print("<h2> Updated successfully</h2>");
				}
				else{
					p.print("<h2>  not Updated</h2>");
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
	}
}