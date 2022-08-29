package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ymartinezm.apiservlet.webapp.headers.models.Producto;
import org.ymartinezm.apiservlet.webapp.headers.services.ProductoService;
import org.ymartinezm.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Creación de servicio basado en la implementación
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar(); //Obtenemos los productos

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

            out.print("        <table>");
            out.print("             <tr>");
            out.print("                 <th>Id</th>");
            out.print("                 <th>Nombre</th>");
            out.print("                 <th>Tipo</th>");
            out.print("                 <th>Precio</th>");
            out.print("             </tr>");

            //Iterando la lista de productos
            productos.forEach(p -> {
                out.print("             <tr>");
                out.print("             <td>" + p.getId() + "</td>");
                out.print("             <td>" + p.getNombre() + "</td>");
                out.print("             <td>" + p.getTipo() + "</td>");
                out.print("             <td>" + p.getPrecio() + "</td>");
                out.print("             </tr>");
            });

            out.print("        </table>");

        }

    }
}
