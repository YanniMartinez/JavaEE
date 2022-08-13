package org.ymartinezm.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ymartinezm.apiservlet.webapp.headers.models.Producto;
import org.ymartinezm.apiservlet.webapp.headers.services.ProductoService;
import org.ymartinezm.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
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
}
