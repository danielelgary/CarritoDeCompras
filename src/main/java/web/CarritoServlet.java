package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Establecer el tipo de respuesta.
        resp.setContentType("text/html; charset=UTF-8");


        //Crear o recuperar el objeto HTTPSession
        //Crear si es la primera vez que se obtiene la sesion
        //Si ya existe, se recupera dicha sesion para usarla
        HttpSession sesion = req.getSession();

        // Recuperar una lista de articulos previos (si existe)
        // sino existe, se crea (sino existe sera nulo la primera vez la verificacion)
        // si contiene algun dato, quiere decir que se recupero la lista ya creada en la sesion y sera diferente de nulo
        // TENER EN CUENTA si no existe este atributo en la sesion, este se creara automaticamente
        List<String> articulosCarrito = (List<String>) sesion.getAttribute("articulos");

        //Verificar la lista de articulos
        // Existe?
        if (articulosCarrito == null){
            //Cuando no se ha anexado ningun articulo y la lista de articulos es nula
            //1. Inicializamos la lista de articulos
            articulosCarrito = new ArrayList<>();

            //2. Agregar la lista a la sesion para poder que la sesion vea los cambios
            // A la lista de la sesion (articulos) se le asigna la lista creada (articulosCarrito)
            sesion.setAttribute("articulos", articulosCarrito);

            //Luego de esto, ya la lista existe dentro de la sesion!

        }

        //Procesar el nuevo articulo que llegue del navegador
        String articuloNuevo = req.getParameter("articulo");

        //Revisar y agregar el articulo nuevo
        // Si NO es nulo y NO contiene el valor vacio (.trim quita espacios en blanco a la izq y der
        // Se compara con la cadena vacia para verificar que NO SEA UNA CADENA VACIA
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")){

            //Esto modificara la lista que se ha agregado a la sesion automaticamente
            //porque nos estamos refiriendo a una referencia del objeto como tal
            articulosCarrito.add(articuloNuevo);

        }

        //Mandamos a imprimir la lista de articulos
        try (PrintWriter out = resp.getWriter()) {
            out.println("<h1>Lista de Articulos: </h1>");
            //Iterar los articulos
            for (String articulo : articulosCarrito) {
                out.println("<li>" + articulo + "</li>");
            }

            //Link para regresar a la pagina del formulario

            out.println("<a href='/CarritoDeCompras-1.0'>Regresar al inicio </a>");
            //out.close();
        }


    }
}
