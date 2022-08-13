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
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");

        //El Filter lo que hace es buscar si se encontró el elemento, además recordemos que devuelve un opcional
        //En resumen, busca, por cada elemento obten el filtro y verifica si contienene el nombre que queremos, si si entonces devuelvelo
        Optional<Producto> encontrado = service.listar().stream().filter(p -> p.getNombre().contains(nombre)).findFirst();

        if(encontrado.isPresent()){ //Si lo encontró

            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UFT-8\">");
                out.println("        <title>Producto Encontrado</title>");
                out.println("        <title>Producto Encontrado</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Producto Encontrado</h1>");
                out.println("        <h3>Producto Encontrado" + encontrado.get().getNombre() +
                        " El precio es $"+ encontrado.get().getPrecio()+"</h1>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else{
            //resp.sendError(404);
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Lo sentimos, no se encontró el producto: " + nombre);
        }
    }
}
