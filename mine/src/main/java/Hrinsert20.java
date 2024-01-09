

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Hrinsert20")
public class Hrinsert20 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static String id="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession hs=request.getSession(); 
		PrintWriter out1=response.getWriter();
			String role1=Hr20.role;
			String  fname=request.getParameter("fname");
			String  lname=request.getParameter("lname");
			String  phone=request.getParameter("phone");
			String  zip=request.getParameter("zip");
			String  dept=request.getParameter("dept");
			String  dob=request.getParameter("dob");
			String role=request.getParameter("role");
			String  id1=request.getParameter("id");
			String un=fname.substring(0,1)+lname;
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hhmm");
			LocalDateTime ldt=LocalDateTime.now();
			String dat=dtf.format(ldt);
			String pwd=Character.toUpperCase(fname.charAt(0))+fname.substring(1,4)+lname.charAt(lname.length()-1);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","M1racle@123");
				if(role1.equalsIgnoreCase("hr")) {
					PreparedStatement p=con.prepareStatement("insert Hr_data values(?,?,?,?,?,?,?,?,?,?,?)");
					p.setString(1,id1);
					p.setString(2,fname);
					p.setString(3,lname);
					p.setString(4,dept);
					p.setString(5,phone);
					p.setString(6,role);
					p.setString(7,dept);
					p.setString(8,dob);
					p.setString(9,un);
					p.setString(10,pwd);
					p.setString(11,"email");
					p.executeUpdate();
					out1.print("inserted");
				}
				else if(role1.equalsIgnoreCase("trainer")) {
					if(role.equalsIgnoreCase("hr")) {
					out1.print("cant insert values");
					out1.print("<h2 style='text-align:right'>"+ "hii"+hs.getAttribute("firstname")+"</h2>");
					RequestDispatcher rd=request.getRequestDispatcher("Option20.html");
					rd.include(request, response);
				}
					else
					{
				PreparedStatement p=con.prepareStatement("insert Hr_data values(?,?,?,?,?,?,?,?,?,?,?)");
				p.setString(1,id1);
				p.setString(2,fname);
				p.setString(3,lname);
				p.setString(4,dept);
				p.setString(5,phone);
				p.setString(6,role);
				p.setString(7,dept);
				p.setString(8,dob);
				p.setString(9,un);
				p.setString(10,pwd);
				p.setString(11,"email");
				p.executeUpdate();
				out1.print("inserted");
//				RequestDispatcher rd=request.getRequestDispatcher("Option20.html");
//				rd.include(request, response);
		
			}
				}
			}
//				else {
//					out1.print("cant insert values");
//				}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
	
	}
