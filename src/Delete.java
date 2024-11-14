
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete extends JFrame {

    private final JTextField buscarRegistroText;
    private final JTextField nombreText;
    private final JTextField apellidoText;
    private final JTextField documentoText;
    private final JTextField telefonoText;
    private final JTextField emailText;
    private final JTextField ciudadText;
    
    public Delete() {
        setTitle("Ventana de Creación");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel create = new JLabel("Formulario para Eliminar Registros ");
        create.setBounds(100, 20, 300, 30);
        add(create);

        JLabel buscarRegistro = new JLabel("Buscar Registro");
        buscarRegistro.setBounds(50, 60, 100, 30);
        add(buscarRegistro);

        buscarRegistroText = new JTextField();
        buscarRegistroText.setBounds(150, 60, 70, 30);
        buscarRegistroText.setHorizontalAlignment(JTextField.CENTER);
        add(buscarRegistroText);

        JButton buscar = new JButton("Buscar");
        buscar.setBounds(250, 60, 100, 30);
        add(buscar);

        JLabel resultados = new JLabel("Resultados de la Búsqueda");
        resultados.setBounds(50, 100, 200, 30);
        add(resultados);

        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(50, 120, 100, 30);
        add(nombre);

        nombreText = new JTextField();
        nombreText.setBounds(50, 150, 80, 30);
        nombreText.setHorizontalAlignment(JTextField.CENTER);
        add(nombreText);

        JLabel apellidos = new JLabel("Apellidos");
        apellidos.setBounds(150, 120, 100, 30);
        add(apellidos);

        apellidoText = new JTextField();
        apellidoText.setBounds(150, 150, 80, 30);
        apellidoText.setHorizontalAlignment(JTextField.CENTER);
        add(apellidoText);

        JLabel documento = new JLabel("Documento");
        documento.setBounds(250, 120, 100, 30);
        add(documento);

        documentoText = new JTextField();
        documentoText.setBounds(250, 150, 80, 30);
        documentoText.setHorizontalAlignment(JTextField.CENTER);
        add(documentoText);

        JLabel telefono = new JLabel("Teléfono");
        telefono.setBounds(350, 120, 100, 30);
        add(telefono);

        telefonoText = new JTextField();
        telefonoText.setBounds(350, 150, 80, 30);
        telefonoText.setHorizontalAlignment(JTextField.CENTER);
        add(telefonoText);

        JLabel ciudad = new JLabel("Ciudad");
        ciudad.setBounds(450, 120, 100, 30);
        add(ciudad);

        ciudadText = new JTextField();
        ciudadText.setBounds(450, 150, 80, 30);
        ciudadText.setHorizontalAlignment(JTextField.CENTER);
        add(ciudadText);

        JLabel email = new JLabel("Email");
        email.setBounds(550, 120, 100, 30);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(550, 150, 80, 30);
        emailText.setHorizontalAlignment(JTextField.CENTER);
        add(emailText);

        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(50, 200, 100, 30);
        add(eliminar);

        buscar.addActionListener((ActionEvent e) -> {
            buscarRegistro();                
        });

        eliminar.addActionListener((ActionEvent e) -> {
            eliminarRegistro();
        });
    }

    private void buscarRegistro() {
        
        String id = buscarRegistroText.getText();
        
        try {
            ConexionBBDD conexion = new ConexionBBDD();
            
            Statement statement = conexion.conexion().createStatement();
            
            String buscarSQL = "SELECT * FROM clientes WHERE id = " + id;

            ResultSet resultado = statement.executeQuery(buscarSQL);

            if (resultado.next()) {
                nombreText.setText(resultado.getString("nombre"));
                apellidoText.setText(resultado.getString("apellidos"));
                documentoText.setText(resultado.getString("documento"));
                telefonoText.setText(resultado.getString("telefono"));
                emailText.setText(resultado.getString("email"));
                ciudadText.setText(resultado.getString("ciudad"));
            } else {
                System.out.println("No se encontró el registro");
            }
            
            statement.close();
            conexion.conexion().close();
            
        } catch (SQLException e) {
            System.out.println("Error al buscar el registro: " + e.getMessage());
        }
    }

    private void eliminarRegistro() {
        
        String id = buscarRegistroText.getText();
        
        try {
            ConexionBBDD conexion = new ConexionBBDD();
            
            Statement statement = conexion.conexion().createStatement();
            
            String eliminarSQL = "DELETE FROM clientes WHERE id = " + id;

            statement.executeUpdate(eliminarSQL);
            
            statement.close();
            conexion.conexion().close();
            dispose();
                       
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage());
        }
    }
}
