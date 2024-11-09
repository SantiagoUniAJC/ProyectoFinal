
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Delete extends JFrame {
    
    public Delete() {
        setTitle("Ventana de Creación");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel create = new JLabel("Aqui estara el formulario para Eliminar");
        create.setBounds(190, 250, 100, 30);
        add(create);
    }
}
