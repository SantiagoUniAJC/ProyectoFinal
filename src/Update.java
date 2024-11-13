
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Update extends JFrame {

    private final JTextField buscarRegistroText;
    private final JTextField nombreText;
    private final JTextField apellidoText;
    private final JTextField documentoText;
    private final JTextField fechanacimientoText;
    private final JTextField direccionText;
    private final JTextField telefonoText;
    private final JTextField emailText;
    private final JTextField ciudadText;
            
    public Update() {
        setTitle("Ventana de Edición de Registros");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel create = new JLabel("Formulario para Actualizar Registros");
        create.setBounds(50, 20, 300, 30);
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
        nombre.setBounds(50, 140, 100, 30);        
        add(nombre);

        nombreText = new JTextField();
        nombreText.setBounds(150, 140, 200, 30);
        nombreText.setHorizontalAlignment(JTextField.CENTER);
        add(nombreText);

        JLabel apellidos = new JLabel("Apellidos");
        apellidos.setBounds(50, 180, 100, 30);
        add(apellidos);

        apellidoText = new JTextField();
        apellidoText.setBounds(150, 180, 200, 30);
        apellidoText.setHorizontalAlignment(JTextField.CENTER);
        add(apellidoText);

        JLabel documento = new JLabel("Documento");
        documento.setBounds(50, 220, 100, 30);
        add(documento);

        documentoText = new JTextField();
        documentoText.setBounds(150, 220, 200, 30);
        documentoText.setHorizontalAlignment(JTextField.CENTER);
        add(documentoText);

        JLabel fechanacimiento = new JLabel("Fecha de Nacimiento");
        fechanacimiento.setBounds(50, 260, 100, 30);
        add(fechanacimiento);

        fechanacimientoText = new JTextField();
        fechanacimientoText.setBounds(150, 260, 200, 30);
        fechanacimientoText.setHorizontalAlignment(JTextField.CENTER);
        add(fechanacimientoText);

        JLabel direccion = new JLabel("Dirección");
        direccion.setBounds(50, 300, 100, 30);
        add(direccion);

        direccionText = new JTextField();
        direccionText.setBounds(150, 300, 200, 30);
        direccionText.setHorizontalAlignment(JTextField.CENTER);
        add(direccionText);

        JLabel telefono = new JLabel("Teléfono");
        telefono.setBounds(50, 340, 100, 30);
        add(telefono);

        telefonoText = new JTextField();
        telefonoText.setBounds(150, 340, 200, 30);
        telefonoText.setHorizontalAlignment(JTextField.CENTER);
        add(telefonoText);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 380, 100, 30);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(150, 380, 200, 30);
        emailText.setHorizontalAlignment(JTextField.CENTER);
        add(emailText);

        JLabel ciudad = new JLabel("Ciudad");
        ciudad.setBounds(50, 420, 100, 30);
        add(ciudad);

        ciudadText = new JTextField();
        ciudadText.setBounds(150, 420, 200, 30);
        ciudadText.setHorizontalAlignment(JTextField.CENTER);
        add(ciudadText);

        JButton actualizar = new JButton("Actualizar");
        actualizar.setBounds(150, 460, 100, 30);
        add(actualizar);

        buscar.addActionListener((ActionEvent e) -> {
            buscarRegistro();                
        });

        actualizar.addActionListener((ActionEvent e) -> {
            actualizarRegistro();
        });
                
        setVisible(true);           
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
                fechanacimientoText.setText(resultado.getString("fechanacimiento"));
                direccionText.setText(resultado.getString("direccion"));
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

    private void actualizarRegistro() {
        
        String id = buscarRegistroText.getText();
        String nombre = nombreText.getText();
        String apellidos = apellidoText.getText();
        String documento = documentoText.getText();
        String fechanacimiento = fechanacimientoText.getText();
        String direccion = direccionText.getText();
        String telefono = telefonoText.getText();
        String email = emailText.getText();
        String ciudad = ciudadText.getText();
        
        try {
            ConexionBBDD conexion = new ConexionBBDD();
            
            Statement statement = conexion.conexion().createStatement();
            
            String actualizarSQL = "UPDATE clientes SET nombre = '" + nombre + "', apellidos = '" + apellidos + "', documento = '" + documento + "', fechanacimiento = '" + fechanacimiento + "', direccion = '" + direccion + "', telefono = '" + telefono + "', email = '" + email + "', ciudad = '" + ciudad + "' WHERE id = " + id;
            
            statement.executeUpdate(actualizarSQL);
            
            statement.close();
            conexion.conexion().close();
            
            System.out.println("Registro actualizado correctamente");
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        }
    }
}
