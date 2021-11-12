package prueba.logica.servicios;

import java.util.List;
import prueba.logica.entidades.Categoria;
import prueba.logica.entidades.Opcion;
import prueba.logica.entidades.Pregunta;

public interface CategoriaServicio {
    
    public void altaCategoria(String nombre);
    
    public List<Categoria> getTodasLasCategorias();
    
    public List<Pregunta> getTodasLasPreguntas(Long nivel, String categoria);
        
    public List<Categoria> getCategoriaPorRonda(Long idRonda); 
    
    public List<Opcion> getTodasLasOpciones(String idPregunta);
    
    public void altaPregunta(String nombre,String categoria,Long nivel);
    
    public void altaOpcion(String descripcion,String idPregunta,boolean valido);
}
