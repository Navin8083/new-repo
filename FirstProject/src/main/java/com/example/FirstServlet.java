package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String validUsername = "Naveen";
        String validPassword = "12345";
        
        if (validUsername.equals(username) && validPassword.equals(password)) {
         //   out.print("Welcome " + username);

          
            Cookie ck = new Cookie("username", username);
            response.addCookie(ck);

           
            RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
            rd.forward(request, response);
        } else {
            response.sendRedirect("login.html");
        }
        
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");
    }
}