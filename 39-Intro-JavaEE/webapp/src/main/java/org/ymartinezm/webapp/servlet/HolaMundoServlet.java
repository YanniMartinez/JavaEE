package org.ymartinezm.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Es necesario indicar el @WebServlet para indicarle a Java
 * que se trata de un Servlet y debemos mappearlo a una URL
 * Además es mandatorio heredar de HttpServlet.
 * Nunca sobreescribiremos el método Service() sino los que son
 * doGet(), doPut(),etc.
 * */
@WebServlet("/hola")
public class HolaMundoServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        //Definiendo el tipo de contenido de la respuesta
         response.setContentType("text/html");
         PrintWriter out = response.getWriter(); //Instanciando PrintWriter

         //Imprimiendo en el cuerpo del response
         out.print("<!DOCTYPE html>");
         out.print("<html>");
         out.print("    <head>");
         out.print("        <meta charset=\"UFT-8\">");
         out.print("        <title>Hola mundo Servlet</title>");
         out.print("    </head>");
         out.print("    <body>");
         out.print("        <h1>Hola mundo Servlet</h1>");
         out.print("    </body>");
         out.print("</html>");

         //Cerrando el PrintWriter
         out.close();
    }
}
