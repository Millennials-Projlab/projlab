package UI;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class FieldPanel extends JPanel {
    public FieldPanel() {
        super();
		setOpaque(false);
		setFocusable(false);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(64, 64, 64), 4));
		setBounds(187, 155, 144, 134);
		setLayout(null);
    }
}
