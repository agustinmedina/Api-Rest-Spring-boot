package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Persona;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
//vamos a llamar a Persona JPA controller en este caso solo tenemos unos pero puede haber varios
    
    PersonaJpaController persJPA = new PersonaJpaController();
    
    //los metodos CRUD tenemos aqui
    public void crearPersona(Persona per){
        //este llama a la controladora JPA y crea al objeto persona que estoy pasando aca per
        persJPA.create(per);
    }
     public void eliminarPersona(int id){
        try {
            //este llama a la controladora JPA y elimina al objeto persona que estoy pasando aca per
            persJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void eliminarPersona(Persona pers){
      
        try {
            persJPA.destroy(pers.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Persona> traerPersonas (){
        return persJPA.findPersonaEntities();
    }
}

    
    

