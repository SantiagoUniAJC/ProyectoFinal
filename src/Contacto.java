import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Contacto extends JFrame {

    private final JTextField fieldDireccion;
    private final JTextField fielTelefono;
    private final JTextField fielEmail;
    private final JTextField fielCiudad;
    private final String nombre;
    private final String apellidos;
    private final String documento;
    private final String fechaNacimiento;

    public Contacto( String nombre, String apellidos, String documento, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;

        setTitle("Ventana de Creación de Contacto");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de la Información de Contacto");
        lblTitulo.setBounds(150, 10, 300, 30);
        add(lblTitulo);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(10, 50, 130, 30);
        add(lblDireccion);

        fieldDireccion = new JTextField();
        fieldDireccion.setHorizontalAlignment(JTextField.CENTER);
        fieldDireccion.setBounds(120, 50, 250, 30);
        add(fieldDireccion);

        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(10, 100, 100, 30);
        add(lblTelefono);

        fielTelefono = new JTextField();
        fielTelefono.setHorizontalAlignment(JTextField.CENTER);
        fielTelefono.setBounds(120, 100, 250, 30);
        add(fielTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 150, 100, 30);
        add(lblEmail);

        fielEmail = new JTextField();
        fielEmail.setHorizontalAlignment(JTextField.CENTER);
        fielEmail.setBounds(120, 150, 250, 30);
        add(fielEmail);

        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setBounds(10, 200, 130, 30);
        add(lblCiudad);

        fielCiudad = new JTextField();
        fielCiudad.setHorizontalAlignment(JTextField.CENTER);
        fielCiudad.setBounds(120, 200, 250, 30);
        add(fielCiudad);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBounds(150, 300, 100, 40);
        add(guardarButton);

        guardarButton.addActionListener(e -> guardarRegistro());

    }  

    private void guardarRegistro() {
        
        // logica para guardar el registro en la base de datos
        try {
            ConexionBBDD conexion = new ConexionBBDD();
            
            Statement statement = conexion.conexion().createStatement();
            
            String insertarSQL = "INSERT INTO clientes (nombre, apellidos, documento, fechaNacimiento, direccion, telefono, email, ciudad) VALUES ('" + nombre + "', '" + apellidos + "', '" + documento + "', '" + fechaNacimiento + "', '" + fieldDireccion.getText() + "', '" + fielTelefono.getText() + "', '" + fielEmail.getText() + "', '" + fielCiudad.getText() + "')";

            statement.executeUpdate(insertarSQL);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro " + e, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        
                
        


        JOptionPane.showMessageDialog(null, "Registro guardado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

        dispose();

        Read read = new Read();
        read.setVisible(true);
    }

}
