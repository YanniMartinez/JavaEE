package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginService;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME="admin";
    final static String PASSWORD="12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImp();
        Optional<String> cookieOptional = auth.getUsername(req);

        if(cookieOptional.isPresent()){ //Si existe coookie no presenta login, sino contenido custom

            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UFT-8\">");
                out.println("        <title>Hola" + cookieOptional.get()+"</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola" + cookieOptional.get()+" ya has iniciado sesión anteriormente</h1>");
                out.println("    </body>");
                out.println("</html>");
            }

        }else { //No hay cookie PRESENTA login
            //Estableciendo el Dispatcher para propagar info entre la JSP y el servlet
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp); //Carga JSP
        }
    }

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
