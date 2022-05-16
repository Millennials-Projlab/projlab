package UI;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.Color;

public class VirologistPanel extends JPanel {
    public VirologistPanel() {
		super();
		setPreferredSize(new Dimension(283, 566));
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(51, 0, 153), 2, true));
	    setLayout(null);
    }
}
