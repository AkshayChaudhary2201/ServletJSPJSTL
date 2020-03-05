package com.cognizant;

import com.acc.utility.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		int flag=0;
			doGet(request,response);
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","adm@123");
				stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from login;");
				
				while(rs.next()){
					if(rs.getString(1).equals(name)&&rs.getString(2).equals(password)){
					flag=1;
					break;
					}
				}
						if(flag==1){
							RequestDispatcher rd=request.getRequestDispatcher("LoginSuccess.jsp");
							rd.forward(request, response);
							}
						
					else{
						RequestDispatcher rd=request.getRequestDispatcher("LoginFailure.jsp");
						rd.forward(request, response);
			
				}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}
