<!-- Agregando directiva para el contenido JSP ->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>

<!-- Etiquetas para insertar código JAVA <% %> se le conoce como SCRIPTLET-->
<%

    Map<String,String> errores = (Map<String,String>)request.getAttribute("errores");

%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formularios de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<h3>Formulario de usuarios</h3>

<%
    if(errores != null && errores.size()>0 ){
%>

    <ul class="alert alert-danger m-5">
        <% for(String error: errores.values()){%>
            <li> <%=error  %>  </li>
        <%}%>
    </ul>

<% } %>

<!-- Apuntando a nuestro Servlet-->
<div class="container px-5">
<form action="/webapp-form/form" method="post">
    <div class="row mb-3">
        <label for="username" class="col-form-label col-sm-2">Usuario</label>
        <div class="col-sm-6"><input type="text" name="username" id="username" class="form-content"></div>
        <%
            if( errores != null && errores.containsKey("username")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("username")+"</small>");
            }
        %>
    </div>

    <div class="row mb-3">
        <label for="password" class="col-form-label col-sm-2">Password</label>
        <div class="col-sm-6"><input type="password" name="password" id="password" class="form-content"></div>
        <%
            if( errores != null && errores.containsKey("password")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("password")+"</small>");
            }
        %>
    </div>

    <div class="row mb-3">
        <label for="email" class="col-form-label col-sm-2">Email</label>
        <div class="col-sm-6"><input type="text" name="email" id="email" class="form-content"></div>
        <%
            if( errores != null && errores.containsKey("email")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("email")+"</small>");
            }
        %>
    </div>


    <!-- Seleccion de una sola opción -->
    <div class="row mb-3">
        <lab for="pais" class="col-form-label col-sm-2"></lab>
        <div class="col-sm-6">
            <select name="pais" id="pais" class="form-select">País
                <option value="">-- Seleccionar --</option>
                <option value="ES">España</option>
                <option value="MX" selected>México</option>
                <option value="CL">Chile</option>
                <option value="AR">Argentina</option>
                <option value="PE">Perú</option>
                <option value="CO">Colombia</option>
                <option value="VE">Venezuela</option>
            </select>
        </div>
        <%
            if( errores != null && errores.containsKey("pais")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("pais")+"</small>");
            }
        %>
    </div>

    <!-- Selección multiple-->
    <div class="row mb-3">
        <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
        <div class="col-sm-6">
            <select name="lenguajes" id="lenguajes" multiple class="form-select">
                <option value="java" selected>Java</option>
                <option value="jakartaee">Jakarta EE</option>
                <option value="spring">Spring boot</option>
                <option value="js">Java Script</option>
                <option value="angular" selected>Angurlar</option>
                <option value="react">React</option>

            </select>
        </div>
        <%
            if( errores != null && errores.containsKey("lenguajes")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("lenguajes")+"</small>");
            }
        %>
    </div>

    <!-- Checkbox-->
    <div class="row mb-3">
        <label class="col-form-label col-sm-2">Roles</label>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input">
            <label class="form-check-label">Administrador</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="roles" value="ROLE_USER" checked class="form-check-input">
            <label class="form-check-label">Usuario</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input">
            <label class="form-check-label">Moderador</label>
        </div>
        <%
            if( errores != null && errores.containsKey("roles")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("roles")+"</small>");
            }
        %>
    </div>

    <!-- Radio -->
    <div class="row mb-3">
        <label class="col-form-label col-sm-2">Idiomas</label>
        <div class="form-check col-sm-2">
            <input type="radio" name="idioma" value="es" class="form-check-input">
            <label class="form-check-label">Español</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="radio" name="idioma" value="en" class="form-check-input">
            <label class="form-check-label">Ingles</label>
        </div>
        <div class="form-check col-sm-2">
            <input type="radio" name="idioma" value="en" class="form-check-input">
            <label class="form-check-label">Frances</label>
        </div>
        <%
            if( errores != null && errores.containsKey("idioma")){
                out.println("<small  class='alert alert-danger col-sm-4' style='color:red;'>"+errores.get("idioma")+"</small>");
            }
        %>
    </div>
    
    <!-- Checkbox-->
    <div  class="row mb-3">
        <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
        <div class="form-check col-sm-2">
            <input type="checkbox" name="habilitar" id="habilitar" class="form-check-input">
        </div>
    </div>
    

    <div class="row mb-3">
        <input type="submit" value="Enviar" class="btn btn-primary">
    </div>

    <!-- Hiden-->
    <input type="hidden" name="secreto" value="12345">
</form>
</div>
</body>
</html>