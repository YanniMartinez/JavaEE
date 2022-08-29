package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginService;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginServiceImp;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImp();
        Optional<String> username = auth.getUsername(req);

        if(username.isPresent()){ //Eliminando la cookie
            Cookie usernameCookie = new Cookie("username","");
            usernameCookie.setMaxAge(0); //Estableciendo vida de 0
            resp.addCookie(usernameCookie);
        }
        resp.sendRedirect(req.getContextPath() +"/login.html");
    }
}
