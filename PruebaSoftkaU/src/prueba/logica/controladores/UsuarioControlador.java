package prueba.logica.controladores;

import java.util.List;
import prueba.logica.entidades.Usuario;

public interface UsuarioControlador {
    
    void altaUsuario(Usuario usuario); //Alta Usuario
    
    List<Usuario> getTodosLosUsuarios();
    
    public Usuario LoginUsuario(String Nickname, String Pass);

}
