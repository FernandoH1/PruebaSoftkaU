package prueba.logica.servicios;

import java.util.List;
import prueba.logica.entidades.Usuario;

public interface UsuarioServicio {

    public List<Usuario> getTodosLosUsuarios();
    
     void altaUsuario(Usuario usuario);
     
     public Usuario LoginUsuario(String Nickname, String Pass);

}
