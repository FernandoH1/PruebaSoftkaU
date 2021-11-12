package prueba.logica.controladores;

import java.util.List;
import prueba.logica.entidades.Categoria;

public interface CategoriaControlador {
    
    public void altaCategoria(String nombre);
    
    public List<Categoria> getTodasLasCategorias();
    
    public List<Categoria> getCategoriaPorRonda(Long idRonda);
    
    public void altaPregunta(String nombre,String categoria,Long nivel);
    
    public void altaOpcion(String descripcion,String idPregunta,boolean valido);
    
}
