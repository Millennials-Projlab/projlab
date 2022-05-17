package UI;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

public class NukleotidText extends JTextField {
    public NukleotidText(String text) {
		setText(text);
		setForeground(new Color(51, 0, 153));
	    setFont(new Font("SansSerif", Font.BOLD, 40));
		setFocusable(false);
		setEditable(false);
		setColumns(10);
		setBorder(null);
		setBackground(Color.WHITE);
		setBounds(209, 82, 37, 52);
    }
}
