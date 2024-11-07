import java.sql.*;

public class ConexionBBDD {
    
    public static void main(String[] args) {
        try {
            // Crear metodo de conexión a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ProyectoFinal?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Bogota", "root", "root");
            System.out.println("Conexión a la base de datos realizada con éxito");

            // Crear sentencia para realizar una consulta
            Statement sentencia = conexion.createStatement();

            // Realizar una consulta
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM usuarios");

            // Recorrer los resultados de la consulta
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nombre: " + resultado.getString("usuario"));
                // System.out.println("Apellido: " + resultado.getString("apellido"));
                // System.out.println("Edad: " + resultado.getInt("edad"));
                System.out.println("Correo: " + resultado.getString("email"));
                System.out.println("Contraseña: " + resultado.getString("contraseña"));
                // System.out.println("Rol: " + resultado.getString("rol"));
                // System.out.println("Fecha de creación: " + resultado.getString("fecha_creacion"));
                // System.out.println("Fecha de actualización: " + resultado.getString("fecha_actualizacion"));
                // System.out.println("Estado: " + resultado.getString("estado"));
                System.out.println("-------------------------------------------------");
            }

            // Cerrar la conexión a la base de datos
            conexion.close();
            
        } catch (Exception error) {
            System.out.println("Error en la conexión a la base de datos" + error);
        }
    }
}
