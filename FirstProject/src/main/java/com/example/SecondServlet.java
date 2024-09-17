package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies();
        String username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
            }
        }

        if (username != null) {
            out.print("<!DOCTYPE html>");
            out.print("<html lang='en'>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<title>Welcome Page</title>");
            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f0f0f0; }");
            out.print(".container { text-align: center; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.print("button { padding: 10px 20px; font-size: 16px; margin-top: 20px; cursor: pointer; border: none; border-radius: 5px; background-color: #007bff; color: white; }");
            out.print("button:hover { background-color: #0056b3; }");
            out.print("</style>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div class='container'>");
            out.print("<h1>Welcome, " + username + "!</h1>");
            out.print("<p>We're glad to have you here.</p>");
            out.print("<form action='ThirdServlet' method='post'>");
            out.print("<button type='submit'>Logout</button>");
            out.print("</form>");
            out.print("</div>");
            out.print("</body>");
            out.print("</html>");
        } else {
            out.print("<h2>No user is logged in.</h2>");
            out.print("<a href='login.html'>Go to Login Page</a>");
        }
        
        out.close();
    }
}