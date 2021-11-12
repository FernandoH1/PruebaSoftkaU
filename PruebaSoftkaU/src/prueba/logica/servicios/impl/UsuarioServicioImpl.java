package prueba.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.InnovaModelException;
import prueba.logica.entidades.Usuario;
import prueba.logica.servicios.UsuarioServicio;
import prueba.persistencia.ConexionBD;

public class UsuarioServicioImpl implements UsuarioServicio {

//====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String todosLosUsuarios = "SELECT * FROM usuario";
    private final String nuevoUsuario = "INSERT INTO usuario (Nombre, Apellido, Nickname, Password, Tipo) VALUES (?, ?, ?, ?, ?)";
    private final String LoginUsuarios = "SELECT * FROM usuario U WHERE U.Nickname = ? AND U.Password = ?";
    
//====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private static UsuarioServicioImpl servicioUsuario;

    private ConexionBD conexion = new ConexionBD(); //OBTENER LA CONEXION A LA BASE DE DATOS

    public UsuarioServicioImpl() {
    }

//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public UsuarioServicioImpl getInstance() {
        if (null == servicioUsuario) {
            servicioUsuario = new UsuarioServicioImpl();
        }
        return servicioUsuario;
    }
//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

//================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    @Override
    public List<Usuario> getTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosUsuarios);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                usuarios.add(usuarioMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return usuarios;
    }
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    
        //============================= ALTA Usuario =============================//
    @Override
    public void altaUsuario(Usuario usuario) {

        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoUsuario);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setString(3, usuario.getNickname());
            sentencia.setString(4, usuario.getPass());
            sentencia.setString(5, usuario.getTipo());
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un usuario con el nickname [%s]", usuario.getNickname()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    //============================= ALTA USUARIO=============================//
    
    //========================= DEVUELVE EL JUGADOR =======================//
    private Usuario usuarioMapper(ResultSet rs) throws SQLException {
        return new Usuario(rs.getLong("id"),rs.getString("Nombre"), rs.getString("Apellido"),rs.getString("Nickname"), rs.getString("Password"), rs.getString("Tipo"));
    }
    
    //============================= LOGIN USUARIO=============================//
    public Usuario LoginUsuario(String Nickname, String Pass) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(LoginUsuarios);
            sentencia.setString(1, Nickname);
            sentencia.setString(2, Pass);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                if (rs.getString("tipo").equals("jugador")) {
                    return usuarioMapper(rs);
                }
            }
            throw new NoSuchElementException(String.format("Usuario no encontrado", Nickname));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
}
//============================= LOGIN USUARIO=============================//

