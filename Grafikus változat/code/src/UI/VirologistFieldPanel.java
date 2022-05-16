package UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.Coordinate;
import subjects.Game;
import subjects.Virologist;

import java.awt.Color;
import java.awt.event.*;

public class VirologistFieldPanel extends JPanel {
    Virologist virologist;
    JLabel field_type_icon;
	JButton field_select_button;

    public VirologistFieldPanel(Coordinate coordinate, Virologist virologist) {
        this.virologist = virologist;
		setOpaque(false);
		setFocusable(false);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(64, 64, 64), 4));
		setBounds(coordinate.getX(), coordinate.getY(), 144, 134);
		setLayout(null);

		field_type_icon = new JLabel("");
		field_type_icon.setIcon(new ImageIcon(""));
		field_type_icon.setBounds(10, 11, 124, 112);
        field_type_icon.setIcon(new ImageIcon("images/virologist_icon_field.png"));
		add(field_type_icon);

		field_select_button = new JButton("");
		field_select_button.setOpaque(false);
		field_select_button.setBorder(null);
		field_select_button.setFocusable(false);
		field_select_button.setBounds(10, 11, 124, 79);
		field_select_button.setBackground(null);
		add(field_select_button);
		
		field_select_button.addActionListener(new VirologistActionListener());
    }

    class VirologistActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            Game.selectedVirologist = virologist;
		}
	}
}
