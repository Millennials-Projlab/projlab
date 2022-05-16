package UI;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;

public class Equipments extends JComboBox<String> {
    public Equipments() {
        super();
		setMaximumRowCount(4);
	    setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 20));
		setFocusable(false);
		setBackground(Color.WHITE);
		setBounds(10, 394, 260, 25);
    }
}
