package prueba.logica.controladores.impl;

import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.InnovaModelException;
import static prueba.logica.Constantes.ALGORITMO;
import static prueba.logica.Hash.getHash;
import prueba.logica.controladores.UsuarioControlador;
import prueba.logica.entidades.Usuario;
import prueba.logica.servicios.UsuarioServicio;
import prueba.logica.servicios.impl.UsuarioServicioImpl;

public class UsuarioControladorImpl implements UsuarioControlador {

    private static UsuarioControladorImpl instance;

    public UsuarioControladorImpl() {
    }

    //Obtener la instancia
    public UsuarioControladorImpl getInstance() {
        if (null == instance) {
            instance = new UsuarioControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private final UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();

    //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        //=========== CAMBIA LA PASSWORD POR UNA HASH =============//

        String claveHash = getHash(usuario.getPass().getBytes(), ALGORITMO);
        usuario.setPass(claveHash);
        //=========== CAMBIA LA PASSWORD POR UNA HASH =============//
        usuarioServicio.altaUsuario(usuario); //Llama a servicio y muetsra
    }
    //=========================== Alta de usuario ============================//
    @Override
    public List<Usuario> getTodosLosUsuarios() {
        try {
            return usuarioServicio.getTodosLosUsuarios();
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }
//============================= LOGIN USUARIO=============================//
    @Override
    public Usuario LoginUsuario(String Nickname, String Pass) {
       try {
            return usuarioServicio.LoginUsuario(Nickname, Pass);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", e.getMessage()));
        } 
    }
 //============================= LOGIN USUARIO=============================//

    
    
    
}
