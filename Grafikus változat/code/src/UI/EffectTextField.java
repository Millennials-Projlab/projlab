package UI;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class EffectTextField extends JTextField {
    public EffectTextField(int x, int y, int width, int height) {
        super();
		setBackground(Color.WHITE);
		setBorder(null);
		setEditable(false);
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 15));
		setText("T1");
		setBounds(10, 196, 260, 20);
		setColumns(10);
    }
}
