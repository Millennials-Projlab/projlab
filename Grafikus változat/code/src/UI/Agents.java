package UI;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;

public class Agents extends JComboBox<String> {
    public Agents() {
        super();
		setMaximumRowCount(4);
	    setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 20));
		setFocusable(false);
		setBackground(Color.WHITE);
		setBounds(10, 480, 260, 25);
    }
}
