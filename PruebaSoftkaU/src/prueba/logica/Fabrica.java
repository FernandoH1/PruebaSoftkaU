package prueba.logica;

import prueba.logica.controladores.CategoriaControlador;
import prueba.logica.controladores.UsuarioControlador;
import prueba.logica.controladores.impl.CategoriaControladorImpl;
import prueba.logica.controladores.impl.UsuarioControladorImpl;

public class Fabrica {

    private static Fabrica instancia;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    //Obtener instancia de UsuarioControladorImpl
    public UsuarioControlador getUsuarioControladorImpl() {
        UsuarioControlador cont = new UsuarioControladorImpl();
        return cont;
    }
     
    public UsuarioControlador getUsuarioControlador() {
        return new UsuarioControladorImpl();
    }
    
    public CategoriaControlador getCategoriaImpl(){
        CategoriaControlador cont = new CategoriaControladorImpl();
        return cont;
    }
    
    public CategoriaControlador getCategoriaControlador() {
        return new CategoriaControladorImpl();
    }
}
