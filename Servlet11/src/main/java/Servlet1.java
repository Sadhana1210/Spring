

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;
import java.time.format.*;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","M1racle@123");
					String  fname=request.getParameter("fname");
					String  lname=request.getParameter("lname");
					String  phone=request.getParameter("phone");
					String  zip=request.getParameter("zipcode");
					String branch=request.getParameter("branch");
					String dept=request.getParameter("dept");
					String dob=request.getParameter("dob");
					String uname,email;
					 String pwd="";
					uname=fname.charAt(0)+lname+dob.charAt(1)+dob.charAt(1)+dob.charAt(3)+dob.charAt(4)+dob.charAt(8)+dob.charAt(9);
					email=fname.charAt(0)+lname+"@miraclesoft.com";
					int i=lname.length();
					DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HHmm");
					LocalDateTime now=LocalDateTime.now();
					String s1=dtf.format(now);
				pwd=pwd+Character.toUpperCase(fname.charAt(0))+fname.charAt(1)+fname.charAt(2)+fname.charAt(3)+lname.charAt(i-3)+lname.charAt(i-2)+lname.charAt(i-1)+s1;
					PreparedStatement p=con.prepareStatement("insert Insert1 values(?,?,?,?,?,?,?,?,?,?)");
					p.setString(1,fname);
					p.setString(2,lname);
					p.setString(3,phone);
					p.setString(4,zip);
					p.setString(5, branch);
					p.setString(6, dept);
					p.setString(7, dob);
					p.setString(8, uname);
					p.setString(9, email);
					p.setString(10, pwd);
					p.executeUpdate();
					con.close();
					PrintWriter pw=response.getWriter();
					pw.print("done");
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// doGet(request,response);
//	}
}
