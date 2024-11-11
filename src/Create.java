
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Create extends JFrame {
    
    private final JTextField fielNombre;
    private final JTextField fielApellidos;
    private final JTextField fielDocumento;
    private final JTextField fielFechaNacimiento;
    
    public Create() {
        setTitle("Ventana de Creación");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de la Información Personal");
        lblTitulo.setBounds(150, 10, 300, 30);
        add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombres:");
        lblNombre.setBounds(10, 50, 130, 30);
        add(lblNombre);

        fielNombre = new JTextField();
        // que el texto este centrado
        fielNombre.setHorizontalAlignment(JTextField.CENTER);
        fielNombre.setBounds(120, 50, 250, 30);
        add(fielNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(10, 100, 100, 30);
        add(lblApellidos);

        fielApellidos = new JTextField();
        fielApellidos.setHorizontalAlignment(JTextField.CENTER);
        fielApellidos.setBounds(120, 100, 250, 30);
        add(fielApellidos);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(10, 150, 100, 30);
        add(lblDocumento);

        fielDocumento = new JTextField();
        fielDocumento.setHorizontalAlignment(JTextField.CENTER);
        fielDocumento.setBounds(120, 150, 250, 30);
        add(fielDocumento);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setBounds(10, 200, 130, 30);
        add(lblFechaNacimiento);

        fielFechaNacimiento = new JTextField();
        fielFechaNacimiento.setHorizontalAlignment(JTextField.CENTER);
        fielFechaNacimiento.setBounds(150, 200, 150, 30);
        add(fielFechaNacimiento);

        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setBounds(10, 250, 100, 30);
        add(lblGenero);

        JRadioButton radioMasculino = new JRadioButton("Masculino");
        radioMasculino.setBounds(120, 250, 100, 30);
        add(radioMasculino);

        JRadioButton radioFemenino = new JRadioButton("Femenino");
        radioFemenino.setBounds(220, 250, 100, 30);
        add(radioFemenino);

        JButton continuarButton = new JButton("Continuar");
        continuarButton.setBounds(150, 300, 100, 40);
        add(continuarButton);
        
        continuarButton.addActionListener(e -> {
            String nombre = fielNombre.getText();
            String apellidos = fielApellidos.getText();
            String documento = fielDocumento.getText();
            String fechaNacimiento = fielFechaNacimiento.getText();

            dispose();

            Contacto contacto = new Contacto(nombre, apellidos, documento, fechaNacimiento);
            contacto.setVisible(true);
        });

        setVisible(false);          
    }
}
