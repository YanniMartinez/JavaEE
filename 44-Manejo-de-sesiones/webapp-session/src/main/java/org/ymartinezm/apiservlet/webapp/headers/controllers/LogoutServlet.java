package org.ymartinezm.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginService;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginServiceImp;
import org.ymartinezm.apiservlet.webapp.headers.services.LoginServiceSessionImp;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImp();
        Optional<String> username = auth.getUsername(req);

        if(username.isPresent()){ //Eliminando la cookie
            HttpSession session = req.getSession();
            session.invalidate();//Invalida toda la session de usuario
        }
        resp.sendRedirect(req.getContextPath() +"/login.html");
    }
}
