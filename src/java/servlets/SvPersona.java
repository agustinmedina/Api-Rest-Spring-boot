package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;

@WebServlet(name = "SvPersona", urlPatterns = {"/SvPersona"})
public class SvPersona extends HttpServlet {
    //con lo abajo creamos una instancia a la controladora de logica
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Para traer de la base de datos la lista de personas 
        //que se pase de JSP en JSP o de Servelet en Servelet
        //usamos el metodo traer personas
        //lo que va a hacer es llamar a logica, la logica va llamar a la persistencia,la persistencia a la base de datos
        //la base de datos va a traernos todas las personas,  y nos guarda en la lista de personas
        
        
        //Entonces llega la solicitud GET se encarga de buscar en base de datos las personas, 
        //las guarda en una variable Lista personas las guarda en la sesion
        
        
        List <Persona> listaPersonas = control.traerPersonas();
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaPersonas",listaPersonas);
        
        //ahora vamos a redirigir a un nuevo JSP donde muestre todas las personas que tienen
        response.sendRedirect("verPersonas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //En la request de abajo recibo el nombre y otras cosas
        processRequest(request, response);
       
        //usa el name dni
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        /*
        System.out.println("dni: " + dni);
        System.out.println("nombre: " + nombre);
        System.out.println("apellido: " + apellido);
        System.out.println("telefono: " + telefono);
        */
        
        Persona pers = new Persona(0,dni,nombre,apellido,telefono);
        //con la instacia de new controladora se puede ejecutar lo de abajo
        //entonces tomamos los datos de JSP los agregamos a un objeto y llamamos a
        //la logica para crear a persona
        control.crearPersona(pers);
        
        //Y para que me redireccione al mismo formulario hacemos
        response.sendRedirect("index.jsp");
        //Con esto ya tenemos el metodo POST para nuestro JSP para el alta.
        //Ahora vamos a utilizar el GET.
         

       //la logica recibe a la persona la va a mandar a la persistencia,
        }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

