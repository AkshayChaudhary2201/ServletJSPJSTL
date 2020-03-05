package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
	
			String name=null;
			String address=null;
			String password=null;
			name=request.getParameter("name");
			address=request.getParameter("address");
			password=request.getParameter("password");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","adm@123");
				pstmt=con.prepareStatement("insert into login values(?,?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2, password);
				pstmt.setString(3, address);
				int i=pstmt.executeUpdate();
				//PrintWriter pw=response.getWriter();
				pstmt.close();
				con.close();
				if(i>0){
					response.sendRedirect("RegisterSuccess.html");
				}
				
				//pw.println("Successfully registered");
				//System.out.println("Data is in the database as below: ");
				//stmt=con.createStatement();
				//ResultSet rs=stmt.executeQuery("select * from login");
				//System.out.println("Name\tPassword\tAddress");
				//while(rs.next()){
					//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//}
			}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					pstmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		
		
		
	}

}








