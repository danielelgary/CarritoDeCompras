<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 04/10/2020
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrito De Compras</title>
</head>
<body>
    <h1>Carrito De Compras</h1>

    <!--
    //El action es la etiqueta que le dice al navegador quien va a manejar (manejador) del formulario
    //del lado del servidor, es decir, se le define en este caso el servlet que manejara los datos
    //adquiridos por el navegador
    -->
    <form action="CarritoServlet" name="Formulario1" method="post" id="Formulario1">

        Articulo a agregar: <input type="text" name="articulo">
        <br>
        <input type="submit" name="enviar" value="Enviar">



    </form>




</body>
</html>
