package org.ymartinezm.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametroGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //Obteniendo el parametro que viene con ese nombre en la URL
        String saludo = req.getParameter("saludo");

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset=\"UFT-8\">");
        out.print("        <title>Parametro de la URL</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>Parametro de la URL</h1>");
        out.print("         <h2>El saludo enviado es: " + saludo + "</h2");
        out.print("    </body>");
        out.print("</html>");

        out.close();

    }
}
