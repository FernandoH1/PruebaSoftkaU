package prueba.logica.controladores.impl;

import java.util.List;
import prueba.logica.controladores.CategoriaControlador;
import prueba.logica.entidades.Categoria;
import prueba.logica.servicios.CategoriaServicio;
import prueba.logica.servicios.impl.CategoriaServicioImpl;



public class CategoriaControladorImpl implements CategoriaControlador{
    
    private static CategoriaControladorImpl instance;

    public CategoriaControladorImpl() {
    }//Constructor por defecto

    //Obtener la instancia
    public CategoriaControladorImpl getInstance() {
        if (null == instance) {
            instance = new CategoriaControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private final CategoriaServicio categoriaServicio = new CategoriaServicioImpl().getInstance();

    @Override
    public void altaCategoria(String nombre) {
        categoriaServicio.altaCategoria(nombre);
    }

    @Override
    public List<Categoria> getCategoriaPorRonda(Long idRonda) {
        return categoriaServicio.getCategoriaPorRonda(idRonda);
    }

    @Override
    public List<Categoria> getTodasLasCategorias() {
        return categoriaServicio.getTodasLasCategorias();
    }

    @Override
    public void altaPregunta(String nombre, String categoria, Long nivel) {
        categoriaServicio.altaPregunta(nombre, categoria, nivel);
    }

    @Override
    public void altaOpcion(String descripcion, String idPregunta, boolean valido) {
        categoriaServicio.altaOpcion(descripcion, idPregunta, valido);
    }
    
}
