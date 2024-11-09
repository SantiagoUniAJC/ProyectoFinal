import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Constructor de la ventana principal.
        setTitle("Proyecto Final - Programación II");
        setIconImage(new ImageIcon(getClass().getResource("/resources/images/logo.png")).getImage());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel titulo = new JLabel("Bienvenido al panel de ingreso del sistema");
        titulo.setText(titulo.getText().toUpperCase());
        titulo.setBounds(100, 30, 400, 30);
        add(titulo);

        JLabel create = new JLabel("Crear");
        create.setBounds(90, 250, 100, 30);
        add(create);

        JLabel createLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/images/create.png")));
        createLabel.setBounds(40, 100, 150, 150);
        add(createLabel);

        JLabel read = new JLabel("Leer");
        read.setBounds(230, 250, 100, 30);
        add(read);

        JLabel readLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/images/read.png")));
        readLabel.setBounds(170, 100, 150, 150);
        add(readLabel);

        JLabel update = new JLabel("Actualizar");
        update.setBounds(360, 250, 100, 30);
        add(update);

        JLabel updateLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/images/update.png")));
        updateLabel.setBounds(310, 100, 150, 150);
        add(updateLabel);

        JLabel deleteLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/images/delete.png")));
        deleteLabel.setBounds(430, 100, 150, 150);
        add(deleteLabel);

        JLabel delete = new JLabel("Eliminar");
        delete.setBounds(470, 250, 100, 30);
        add(delete);

        JLabel copy = new JLabel("© 2024 - Todos los derechos reservados");
        copy.setBounds(150, 300, 300, 30);
        add(copy);
        JLabel dev = new JLabel("Desarrollado por: Santiago Peña");
        dev.setBounds(160, 320, 300, 30);
        add(dev);

        // Agregar eventos a los labels
        createLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Código para abrir la ventana de creación
                Create create = new Create();
                create.setVisible(true);
            }
        });

        readLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Código para abrir la ventana de lectura
                Read read = new Read();
                read.setVisible(true);
            }
        });

        updateLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Código para abrir la ventana de actualización
                Update update = new Update();
                update.setVisible(true);
            }
        });

        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Código para abrir la ventana de eliminación
                Delete delete = new Delete();
                delete.setVisible(true);
            }
        });
    }
}
