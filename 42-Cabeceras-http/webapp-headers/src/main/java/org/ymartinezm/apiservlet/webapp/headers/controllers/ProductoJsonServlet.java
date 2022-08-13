package org.ymartinezm.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
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

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        //De la dependencia agregada convertimos esta lista a JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        //Con esto ahora nuestro Servlet puede trabajar como API REST
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }

    /**
     * Método para recibir un JSON dentro del body del Request
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream jsonStream = req.getInputStream(); //Recibiendo del InputStream
        ObjectMapper mapper = new ObjectMapper();
        //Convirtiendo JSON inputStream a un objeto (Producto.class)
        Producto producto = mapper.readValue(jsonStream, Producto.class); //Con esto ya tenemos el objeto y podemos usarlo

        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UFT-8\">");
            out.println("        <title>Detalle de producto desde JSON</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Detalle de producto desde JSON</h1>");
            out.println("        <ul>");
            out.println("           <li>Id: "+ producto.getId() +"</li>");
            out.println("           <li>Nombre: "+ producto.getNombre() +"</li>");
            out.println("           <li>Tipo: "+ producto.getTipo() +"</li>");
            out.println("           <li>Precio: "+ producto.getPrecio() +"</li>");
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");
        }

    }
}
