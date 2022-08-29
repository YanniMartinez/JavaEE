package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginService;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginServiceImp;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginServiceSessionImp;

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
        LoginService auth = new LoginServiceSessionImp();
        Optional<String> usernameOptional = auth.getUsername(req);

        if(usernameOptional.isPresent()){ //Si existe coookie no presenta login, sino contenido custom

            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UFT-8\">");
                out.println("        <title>Hola" + usernameOptional.get()+"</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + usernameOptional.get()+" has iniciado sesión anteriormente</h1>");
                out.println("<p><a href='" + req.getContextPath() +"/index.html'>Volver  </a>  </div>");
                out.println("<p><a href='" + req.getContextPath() +"/logout'>Cerrar session  </a>  </div>");
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

            HttpSession session = req.getSession();
            session.setAttribute("username",username);

            resp.sendRedirect(req.getContextPath()+"/login.html");

        }else{
            //resp.setStatus(401);
            //Otra alternativa es:
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Lo sentimos, no está autorizado para ingresar a esta página");
        }
    }
}
