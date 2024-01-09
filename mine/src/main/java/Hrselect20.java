

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Hrselect20")
public class Hrselect20 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		String id=request.getParameter("id");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
			PreparedStatement ps=c.prepareStatement("select * from Hr_data where empid=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				for(int i=1;i<=11;i++) {
				p.print(rs.getString(i)+" ");
			}
			}
	}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
