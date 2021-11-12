package prueba.logica.entidades;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String nombre;
    private ArrayList<Pregunta> preguntas;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.preguntas = new ArrayList<Pregunta>();
    }

    public void cargarPregunta(List<Pregunta> preguntas) {
        for (int i = 0; i < preguntas.size(); i++) {
            this.preguntas.add(preguntas.get(i));
        }
    }
    
    public Pregunta getRandomPregunta(){ 
        int posicion = (int) (Math.random()*preguntas.size());
        return preguntas.get(0);
    }

    public void addPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }
    
    @Override
    public String toString() {
        return String.format("%s", nombre);
    }
    
}
