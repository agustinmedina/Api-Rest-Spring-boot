package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //la logica recibe a la persona la va a mandar a la persistencia,
    //y la persistencia llama  al proceso JPA necesario para crear una nueva persona
public void crearPersona(Persona per){
    controlPersis.crearPersona(per);
}

//En eliminar es una pasarela vino aca la logica de Controladora.java y se lo pasa a persistencia
public void eliminarPersona(int id){
    controlPersis.eliminarPersona(id);
}

public void eliminarPersona(Persona pers){
    controlPersis.eliminarPersona(pers);
}

//Lo mismo pasa cuando queremos obtener pero en paso inverso va a llamar a controladora de persistencia 
//esta va a buscar en la base de datos nos va a devolver y nos la va mostrar en la interfas grafica a nuestro JSP.    
public List<Persona> traerPersonas (){
        return controlPersis.traerPersonas();
    }
}
