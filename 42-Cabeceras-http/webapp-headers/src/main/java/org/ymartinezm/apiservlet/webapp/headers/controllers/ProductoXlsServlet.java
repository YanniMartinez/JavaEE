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

@WebServlet({"/productos.xls","/productos.html"})
public class ProductoXlsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Creación de servicio basado en la implementación
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar(); //Obtenemos los productos

        resp.setContentType("text/html; charset=UTF-8");

        //Obteniendo la URL:
        String serverletPath = req.getServletPath();
        boolean esXls = serverletPath.endsWith(".xls"); //Verifica si tiene terminación .xls

        if(esXls){ //Definiendo para que se exporte a formato XLS
            resp.setContentType("application/vnd.ms-excel"); //Establece respuesta tipo Excel
            resp.setHeader("Context-Disposition","attachment;filename=productos.xls"); //Forzamos la descarga con ese nombre

        }

        try (PrintWriter out = resp.getWriter()) {

            if(!esXls) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("    <head>");
                out.print("        <meta charset=\"UFT-8\">");
                out.print("        <title>Listado de Productos</title>");
                out.print("    </head>");
                out.print("    <body>");
                out.print("        <h1>Listado de Productos</h1>");
                out.println("      <p>  <a href=\"" + req.getContextPath() + "/productos.xls" + "\"> Exportar a XLS </a> </p>");
            }

            out.print("        <table>");
            out.print("             <tr>");
            out.print("                 <th>Id</th>");
            out.print("                 <th>Nombre</th>");
            out.print("                 <th>Tipo</th>");
            out.print("                 <th>Precio</th>");
            out.print("             </tr>");

            //Iterando la lista de productos
            productos.forEach(p->{
                out.print("             <tr>");
                out.print("             <td>"+ p.getId() +"</td>");
                out.print("             <td>"+ p.getNombre() +"</td>");
                out.print("             <td>"+ p.getTipo() +"</td>");
                out.print("             <td>"+ p.getPrecio() +"</td>");
                out.print("             </tr>");
            });

            out.print("        </table>");

            if(!esXls) {
                out.print("    </body>");
                out.print("</html>");
            }
        }

    }
}
