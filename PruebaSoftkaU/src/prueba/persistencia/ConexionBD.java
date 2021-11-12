package prueba.persistencia;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import prueba.exeptions.BaseDeDatosException;

public class ConexionBD {
    
    private static Connection conexion;
    private static Properties prop = new Properties();
    
    static {
        Properties properties = new Properties();
        properties.setProperty("DB_URL", "jdbc:mysql://localhost/pruebadiagnostica");
        properties.setProperty("USER", "root");
        properties.setProperty("PASS", "");
        prop = properties;
    }
    
    public ConexionBD() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");

                conexion = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"), prop.getProperty("PASS"));
                 
                System.err.println("Conexion exitosa a la DB");
            }
        } catch (CommunicationsException e) {
            throw new BaseDeDatosException(String.format("Error al conectar a la DB [%s]", e.getMessage()));
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new BaseDeDatosException(e.getMessage());
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
}
    

