package UI;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class VirologistPanelList extends JPanel {
    public VirologistPanelList() {
		super();
		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 1, 0, 3));
		setAutoscrolls(true);
    }
}
