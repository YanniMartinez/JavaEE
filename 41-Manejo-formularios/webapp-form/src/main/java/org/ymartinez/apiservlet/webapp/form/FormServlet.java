package org.ymartinez.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        //Selecciones
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");

        String idioma = req.getParameter("idioma");
        boolean habilitar = req.getParameter("habilitar") != null
                && req.getParameter("habilitar").equals("on");

        String secreto = req.getParameter("secreto");

        //Declarando un map
        Map<String, String> errores = new HashMap<>();

        if (username == null || username.isBlank()) {
            errores.put("username", "El username es requerido");
        }
        if (password == null || password.isBlank()) {
            errores.put("password", "El password es requerido");
        }
        if (email == null || !email.contains("@")) {
            errores.put("email", "El username es requerido");
        }
        if (pais == null || pais.isBlank()) {
            errores.put("pais", "El país es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes", "Almenos debe seleccionar una opcion");
        }
        if (roles == null || roles.length == 0) {
            errores.put("roles", "Debe seleccionar almenos 1 rol");
        }
        if (idioma == null) {
            errores.put("idioma", "Seleccione un idioma");
        }

        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {

                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("    <head>");
                out.print("        <meta charset=\"UFT-8\">");
                out.print("        <title>Resultado Form</title>");
                out.print("    </head>");
                out.print("    <body>");
                out.print("        <h1>Resultado Form</h1>");
                out.print("        <ul>");


                out.print("             <li>Username" + username + "</li>");
                out.print("             <li>Password" + password + "</li>");
                out.print("             <li>Email" + email + "</li>");
                out.print("             <li>Email" + pais + "</li>");
                out.print("             <li>Lenguajes: <ul>");

                //Iterando el contenido
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("          <li>" + lenguaje + "</li>");
                });
                out.print("             </ul></li>");

                //Iterando el contenido
                out.print("             <li>Roles: <ul>");
                Arrays.asList(roles).forEach(role -> {
                    out.println("          <li>" + role + "</li>");
                });
                out.print("             </ul></li>");

                out.print("             <li>Idioma " + idioma + "</li>");
                out.print("             <li>Habilitar " + habilitar + "</li>");
                out.print("             <li>Secreto " + secreto + "</li>");
                out.print("        </ul>");
                out.print("    </body>");
                out.print("</html>");
            }
        } else {
                /*errores.forEach(error ->{
                    out.println("<li>" + error + "</li>");
                });
                out.println("<p><a href=\"/webapp-form/index.jsp\"> Volver</a> </p>");
                */

            //Estos atributos pueden mandarse entre JSP y servlets
            req.setAttribute("errores", errores); //Mandamos errores al atributo

            //Para redireccionar este JSP o vista debe estar dentro del request y usar el sig. elemento
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            //Reenombraremos el index para que acepte java
            //Forward redirecciona al JSP
        }

    }
}
