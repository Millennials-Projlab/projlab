package UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.Coordinate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldPanel extends JPanel {
    public FieldPanel(Coordinate coordinate, String iconName) {
        super();
		setOpaque(false);
		setFocusable(false);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(64, 64, 64), 4));
		setBounds(coordinate.getX(), coordinate.getY(), 144, 134); // 187 155
		setLayout(null);

		JLabel field_type_icon = new JLabel("");
		field_type_icon.setIcon(new ImageIcon("images/" + iconName));
		field_type_icon.setBounds(10, 11, 124, 112);
		add(field_type_icon);

		JButton field_select_button = new JButton("");
		field_select_button.setOpaque(false);
		field_select_button.setBorder(null);
		field_select_button.setFocusable(false);
		field_select_button.setBounds(10, 11, 124, 79);
		field_select_button.setBackground(null);
		add(field_select_button);

		field_select_button.addActionListener(new ClickActionListener());
    }

	class ClickActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("click");
		}
	}
}
