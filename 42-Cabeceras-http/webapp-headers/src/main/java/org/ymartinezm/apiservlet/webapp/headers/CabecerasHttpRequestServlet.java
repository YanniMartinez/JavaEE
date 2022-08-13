package org.ymartinezm.apiservlet.webapp.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        //Métodos para obtener información importante mediante los HTTP
        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");

        //Valor del cliente
        String ipCliente = req.getRemoteAddr();

        //Construyendo URL
        String url = scheme+"://"+host+contextPath+servletPath;
        String url2 = scheme+"://"+ip+":"+port+contextPath+servletPath;

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UFT-8\">");
            out.println("        <title>Cabeceras HTTP Request</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Cabeceras HTTP Request</h1>");
            out.println("    <ul>");
            out.println("    <li>Método HTTP: "+ metodoHttp+"</li>");
            out.println("    <li>Request URI: "+ requestUri+"</li>");
            out.println("    <li>Request URL: "+ requestUrl+"</li>");
            out.println("    <li>Context Path: "+ contextPath+"</li>");
            out.println("    <li>Servlet Path: "+ servletPath+"</li>");
            out.println("    <li>Dirección IP: "+ ip+"</li>");
            out.println("    <li>Dirección IPCliente: "+ ipCliente+"</li>");
            out.println("    <li>Puesto Local: "+ port+"</li>");
            out.println("    <li>Scheme: "+ scheme+"</li>");
            out.println("    <li>Host: "+ host+"</li>");
            out.println("    <li>URL1: "+ url+"</li>");
            out.println("    <li>URL2: "+ url2+"</li>");
            out.println("    </ul>");
            out.println("    </body>");

            out.println("</html>");
        }
    }
}
