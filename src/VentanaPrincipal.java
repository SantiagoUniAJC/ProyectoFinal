import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Constructor de la ventana principal.
        setTitle("Proyecto Final - Programación II");
        setIconImage(new ImageIcon(getClass().getResource("/resources/images/logo.png")).getImage());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel titulo = new JLabel("Bienvenido al panel de ingreso al sistema");
        titulo.setText(titulo.getText().toUpperCase());
        titulo.setBounds(100, 50, 400, 30);
        add(titulo);

        // agregar una imagen para iniciar sesión & otra para registrarse al lado
        JLabel iniciarSesionImagen = new JLabel(new ImageIcon(getClass().getResource("/resources/images/inicio.png")));
        iniciarSesionImagen.setBounds(100, 100, 150, 150);
        add(iniciarSesionImagen);

        JLabel iniciarSesion = new JLabel("Iniciar Sesión");
        iniciarSesion.setBounds(130, 250, 100, 30);
        add(iniciarSesion);

        JLabel registrarseImagen = new JLabel(new ImageIcon(getClass().getResource("/resources/images/registro.png")));
        registrarseImagen.setBounds(300, 100, 150, 150);
        add(registrarseImagen);

        JLabel registrese = new JLabel("Registrarse");
        registrese.setBounds(330, 250, 100, 30);
        add(registrese);

        JLabel copy = new JLabel("© 2021 - Todos los derechos reservados");
        copy.setBounds(150, 300, 300, 30);
        add(copy);
        JLabel dev = new JLabel("Desarrollado por: Santiago Peña");
        dev.setBounds(160, 320, 300, 30);
        add(dev);


    }
}
