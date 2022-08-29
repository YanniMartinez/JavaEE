package org.ymartinezm.apiservlet.webapp.headers.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImp implements LoginService{

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null){ //Si el usuario es diferente de nulo entonces:
            return Optional.of(username); //Retorna Optional de tipo String
        }
        return Optional.empty();
    }
}
