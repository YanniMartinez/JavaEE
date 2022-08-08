package org.ymartinezm.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Es necesario indicar el @WebServlet para indicarle a Java
 * que se trata de un Servlet y debemos mappearlo a una URL
 * Además es mandatorio heredar de HttpServlet.
 * Nunca sobreescribiremos el método Service() sino los que son
 * doGet(), doPut(),etc.
 * */
@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {

    
}
