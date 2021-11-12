package prueba.logica.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {

    private ArrayList<Opcion> opciones;
    private String nombre;
    private Long id;

    public Pregunta(Long id,String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.opciones = new ArrayList<Opcion>();
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }
    
    public void cargarOpciones(List<Opcion> opciones) {
        for (int i = 0; i < opciones.size(); i++) {
            this.opciones.add(opciones.get(i));
        }
    }
    
    public boolean esCorrecta(String opcion){
     for(int i=0;i<opciones.size();i++){
         if(opciones.get(i).getNombre().equals(opcion)){
             return opciones.get(i).isEsCorrecto();
         }
     }
     return false;
    }
    
    public void addOpciones(Opcion opcion){
    opciones.add(opcion);
    }
}
