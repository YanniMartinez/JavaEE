package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    //Uniendo recursos de este servlet con otro o una JSP haciendo uso de Dispatcher forward


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //.forward lo que hace es unir la información entre peticiones
        //Une el request a este servlet con el request y response de otro servlet en este caso el de productos.html
        getServletContext().getRequestDispatcher("/productos.html").forward(req,resp);

    }
}
