package UI;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class PlayerText extends JTextField {
    public PlayerText() {
        super();
        setBackground(Color.WHITE);
        setBorder(null);
        setFocusable(false);
        setEditable(false);
        setFont(new Font("SansSerif", Font.BOLD, 20));
        setForeground(new Color(204, 0, 102));
        setHorizontalAlignment(SwingConstants.CENTER);
        setText("Player1");
        setBounds(10, 11, 260, 39);
        setColumns(10);
    }
}
