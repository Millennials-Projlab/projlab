package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class MainFrame extends JFrame {
    public MainFrame() {
        setResizable(false);
        setTitle("Virologist without any hope\r\n\r\n");
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/main_icon.png"));
        setBounds(100, 100, 1100, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }


    
}
