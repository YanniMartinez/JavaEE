package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    final static String USERNAME="admin";
    final static String PASSWORD="12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ( USERNAME.equals(username) && PASSWORD.equals(password)) {

            //Forma de declarar una nueva cookie (Formato clave:Valor)
            Cookie usernameCookie = new Cookie("username",username);

            //Manando cookie en el response para que sea interpretada por el navegador
            resp.addCookie(usernameCookie);

            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UFT-8\">");
                out.println("        <title>Login Correcto</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Login Correcto</h1>");
                out.println("        <h3> "+username+" Has iniciado sesión con Exito</h3>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else{
            //resp.setStatus(401);
            //Otra alternativa es:
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Lo sentimos, no está autorizado para ingresar a esta página");
        }
    }
}
