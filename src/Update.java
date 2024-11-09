
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Update extends JFrame {
    
    public Update() {
        setTitle("Ventana de Creación");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel create = new JLabel("Aqui estara el formulario para Actualizar");
        create.setBounds(190, 250, 100, 30);
        add(create);
    }
}
