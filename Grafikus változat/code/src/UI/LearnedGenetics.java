package UI;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;

public class LearnedGenetics extends JComboBox<String> {
    public LearnedGenetics() {
        super();
		setFocusable(false);
		setMaximumRowCount(4);
		setBackground(Color.WHITE);
	    setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 20));
		setBounds(10, 308, 260, 25);
    }
}
