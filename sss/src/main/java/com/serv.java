package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.PrintWriter;
import DAO.* ;
/**
 * Servlet implementation class serv
 */
public class serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.getRequestDispatcher("/NewFile.jsp").forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		    String fullName = request.getParameter("fullName");
	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String phoneNumber = request.getParameter("phoneNumber");
	        String password = request.getParameter("password");
	        String confirmPassword = request.getParameter("confirmPassword");
	        String gender = request.getParameter("gender");
	        
	        
		
		
		if (!password.equals(confirmPassword)) {
         
			request.setAttribute("mssg", "mdp n'est pas valide") ;
        }
		
		if (fullName == null || fullName.isEmpty() || username == null || username.isEmpty()
                || email == null || email.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()
                || password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()
                || gender == null || gender.isEmpty()) {
           
           
            request.setAttribute("mssg", "Tous les champs sont obligatoires. Veuillez remplir tous les champs" ) ;
        }
		
	
		if (!phoneNumber.matches("\\d{10}")) {
				
			request.setAttribute("mssg", "numero n'est pas valide") ;
			
		}
		
	    if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
	    	request.setAttribute("mssg", "mail n'est pas valide") ;
		}
		
	    
	   agent a = new agent(fullName,username,email,phoneNumber,password,Integer.parseInt(gender)) ;
	    
	   agent_impl b = new agent_impl(DAOFactory.getInstance());
	   
	   try {
		b.create(a) ;
		
		 PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head><title>Registration Result</title></head>");
	        out.println("<body>");
	        out.println("<h1>Registration Successful!</h1>");
	        out.println("<p>Full Name: " + fullName + "</p>");
	        out.println("<p>Username: " + username + "</p>");
	        out.println("<p>Email: " + email + "</p>");
	        out.println("<p>Phone Number: " + phoneNumber + "</p>");
	        out.println("<p>Gender: " + gender + "</p>");
	        out.println("</body>");
	        out.println("</html>") ;
		
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	    
	    
	}

}
