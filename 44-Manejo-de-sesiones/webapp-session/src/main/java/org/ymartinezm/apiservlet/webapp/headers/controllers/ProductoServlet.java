package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ymartinezm.apiservlet.webapp.headers.models.Producto;
import org.ymartinezm.apiservlet.webapp.headers.services.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Creación de servicio basado en la implementación
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar(); //Obtenemos los productos

        LoginService auth = new LoginServiceSessionImp();
        Optional<String> usernameOptional = auth.getUsername(req);


        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {


            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("    <head>");
            out.print("        <meta charset=\"UFT-8\">");
            out.print("        <title>Listado de Productos</title>");
            out.print("    </head>");
            out.print("    <body>");
            out.print("        <h1>Listado de Productos</h1>");

            if(usernameOptional.isPresent()){
                out.println("<div style='color:blue;'> Hola " + usernameOptional.get() +"</div>");
            }

            out.print("        <table>");
            out.print("             <tr>");
            out.print("                 <th>Id</th>");
            out.print("                 <th>Nombre</th>");
            if(usernameOptional.isPresent()) {
                out.print("                 <th>Tipo</th>");
            }
            out.print("                 <th>Precio</th>");
            out.print("             </tr>");

            //Iterando la lista de productos
            productos.forEach(p -> {
                out.print("             <tr>");
                out.print("             <td>" + p.getId() + "</td>");
                out.print("             <td>" + p.getNombre() + "</td>");
                out.print("             <td>" + p.getTipo() + "</td>");
                if(usernameOptional.isPresent()) {
                    out.print("             <td>" + p.getPrecio() + "</td>");
                }
                out.print("             </tr>");
            });

            out.print("        </table>");

        }

    }
}
