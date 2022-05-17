package UI;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

public class AminoText extends JTextField {
    public AminoText(String text) {
		setBorder(null);
		setFocusable(false);
		setFont(new Font("SansSerif", Font.BOLD, 40));
		setForeground(new Color(204, 0, 102));
		setBackground(Color.WHITE);
		setEditable(false);
		setText(text);
		setBounds(41, 82, 37, 52);
		setColumns(10);
    }
}
