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
import prueba.logica.entidades.Categoria;
import prueba.logica.entidades.Opcion;
import prueba.logica.entidades.Pregunta;
import prueba.logica.servicios.CategoriaServicio;
import prueba.persistencia.ConexionBD;

public class CategoriaServicioImpl implements CategoriaServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaCategoria = "INSERT INTO categoria (nombre) VALUES (?)";
    private final String categoriaRonda = "SELECT * FROM categoria WHERE ronda =";
    private final String todasLasCategorias = "SELECT * FROM categoria";
    private final String todasLasPreguntasPorCategoria = "SELECT * FROM pregunta WHERE Nivel = ? AND categoria = ?";
    private final String todasLasOpcionesPorPregunta = "SELECT `descripción`,`Valida` FROM `opciones` WHERE `idPregunta`= ?";
    private final String altaPregunta = "INSERT INTO `pregunta` (`id`, `Nombre`,`categoria`,`Nivel`) VALUES (NULL,?,?,?)";
    private final String altaOpcion = "INSERT INTO `opciones` (`id`, `descripción`, `idPregunta`, `Valida`) VALUES (NULL, ?,?,?)";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    //INSTANCIA DE LA CLASE
    private static CategoriaServicioImpl servicio;

    //OBTENER LA CONEXION A LA BASE DE DATOS
    private ConexionBD conexion = new ConexionBD();

    public CategoriaServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public CategoriaServicioImpl getInstance() {
        if (null == servicio) {
            servicio = new CategoriaServicioImpl();
        }
        return servicio;
    }

    //==================== AlTA DE CATEGORIA ===================//
    @Override
    public void altaCategoria(String nombre) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaCategoria);
            sentencia.setString(1, nombre);
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe una Categoria con el nombre [%s]", nombre));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }
    //==================== AlTA DE CATEGORIA ===================//

    //==================== OBTENER CATEGORIAS POR ID DE RONDA ============//
    @Override
    public List<Categoria> getCategoriaPorRonda(Long idRonda) {
        List<Categoria> categorias = getTodasLasCategorias();
        //System.out.println(categorias);
        for (int indexCategoria = 0; indexCategoria < categorias.size(); indexCategoria++) {
            List<Pregunta> preguntas = getTodasLasPreguntas(idRonda, categorias.get(indexCategoria).getNombre());
            //System.out.println(preguntas.get(0).getNombre());
            for (int indicePregunta = 0; indicePregunta < preguntas.size(); indicePregunta++) {
                List<Opcion> opciones = getTodasLasOpciones(preguntas.get(indicePregunta).getNombre());
                preguntas.get(indicePregunta).cargarOpciones(opciones);
            }
            categorias.get(indexCategoria).cargarPregunta(preguntas);
        }

        return categorias;
    }
    //==================== OBTENER CATEGORIAS POR ID DE RONDA ============//

    //================== OBTENER LA LISTA DE TODAS LAS CATEGORIAS ==============//
    @Override
    public List<Categoria> getTodasLasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasCategorias);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                categorias.add(categoriaMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return categorias;
    }
    //================== OBTENER LA LISTA DE TODAS LAS CATEGORIAS ==============//

    //======================= MAPPER CATEGORIA =========================//
    private Categoria categoriaMapper(ResultSet rs) throws SQLException {

        String nombre = rs.getString("Nombre");

        return new Categoria(nombre);
    }
    //======================= MAPPER CATEGORIA =========================//

    //================== OBTENER LA LISTA DE TODAS LAS Preguntas ==============//
    @Override
    public List<Pregunta> getTodasLasPreguntas(Long nivel, String categoria) {
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasPreguntasPorCategoria);
            sentencia.setLong(1, nivel);
            sentencia.setString(2, categoria);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                preguntas.add(preguntaMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return preguntas;
    }
    //================== OBTENER LA LISTA DE TODAS LAS CATEGORIAS ==============//

    //================== OBTENER LA LISTA DE TODAS LAS Preguntas ==============//
    @Override
    public List<Opcion> getTodasLasOpciones(String idPregunta) {
        List<Opcion> opciones = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasOpcionesPorPregunta);
            sentencia.setString(1, idPregunta);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                opciones.add(opcionesMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return opciones;
    }
    //================== OBTENER LA LISTA DE TODAS LAS CATEGORIAS ==============//

    //======================= MAPPER CATEGORIA =========================//
    private Pregunta preguntaMapper(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("Nombre");

        return new Pregunta(id, nombre);
    }
    //======================= MAPPER CATEGORIA =========================//

    //======================= MAPPER OPCION =========================//
    private Opcion opcionesMapper(ResultSet rs) throws SQLException {

        String nombre = rs.getString("descripción");
        Boolean valido = rs.getBoolean("Valida");

        return new Opcion(nombre, valido);
    }
    //======================= MAPPER CATEGORIA =========================//
    
    //==================== AlTA DE PREGUNTA ===================//
    @Override
    public void altaPregunta(String nombre,String categoria,Long nivel) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaPregunta);
            sentencia.setString(1, nombre);
            sentencia.setString(2, categoria);
            sentencia.setLong(3, nivel);
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe una Pregunta [%s]", nombre));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
    //==================== AlTA DE PREGUNTA ===================//
    
    //==================== AlTA DE PREGUNTA ===================//
    @Override
    public void altaOpcion(String descripcion,String idPregunta,boolean valido) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaOpcion);
            sentencia.setString(1, descripcion);
            sentencia.setString(2, idPregunta);
            sentencia.setBoolean(3, valido);
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe una Opcion [%s]", descripcion));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
    //==================== AlTA DE PREGUNTA ===================//
    
}
