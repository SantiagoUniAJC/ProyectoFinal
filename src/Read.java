
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Read extends JFrame {

    private final JTable tabla;

    public Read() {
        setTitle("Ventana de Consulta de Datos");
        setSize(620, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        String[] columnas = {"ID", "Nombre", "Apellidos", "Documento", "Fecha de Nacimiento", "Direccion", "Telefono", "Email", "Ciudad"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        tabla.setBounds(10, 10, 380, 250);
        add(tabla);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10, 10, 580, 450);
        add(scrollPane);

        mostrarDatos(modelo);        
    }

    private void mostrarDatos(DefaultTableModel modelo) {
        // Logica para mostrar los datos de la base de datos
        try {
            ConexionBBDD conexion = new ConexionBBDD();
            
            Statement statement = conexion.conexion().createStatement();
            
            String consultaSQL = "SELECT ID , nombre, apellidos, documento, fechaNacimiento, direccion, telefono, email, ciudad FROM clientes";

            ResultSet resultado = statement.executeQuery(consultaSQL);

            while (resultado.next()) {
                Object[] fila = new Object[9];
                for (int i = 0; i < 9; i++) {
                    fila[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
