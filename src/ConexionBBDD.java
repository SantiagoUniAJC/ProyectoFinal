import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBBDD {

    // crear metodo de conexión a la base de datos
    public Connection conexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ProyectoFinal?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Bogota", "root", "root");

            // JOptionPane.showMessageDialog(null, "Conexión a la base de datos realizada con éxito", "Conexión exitosa", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos " + error, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
}
