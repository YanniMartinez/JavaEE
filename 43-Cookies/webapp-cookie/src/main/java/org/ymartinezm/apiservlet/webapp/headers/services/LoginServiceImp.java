package org.ymartinezm.apiservlet.webapp.headers.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImp implements LoginService{


    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        //Obteniendo Cookies, Si es diferente de nulo obtenemos las cookies, en caso contrario arreglo vacio
        Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];

        //Busca la cookie, y declaramos un opcional porque podria o no devolver un valor Cookie
        return Arrays.stream(cookies)
                .filter(c -> "username".equals(c.getName()))
                .map(Cookie::getValue) //Mapea a string
                .findAny();
    }
}
