package UI;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class InteractButton extends JButton {
    public InteractButton(String text, int x, int y, int width, int height) {
        super(text);
		setForeground(Color.BLACK);
		setFont(new Font("SansSerif", Font.BOLD, 20));
		setFocusable(false);
		setBorder(null);
		setBackground(Color.RED);
		setBounds(x, y, width, height);
    }
}
