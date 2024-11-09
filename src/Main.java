import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ConexionBBDD conexion = new ConexionBBDD();
        Connection conexionBD = conexion.conexion();
        if (conexionBD != null) {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        }
    }
}
