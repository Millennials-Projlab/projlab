package UI;

import javax.swing.JComboBox;

import main.Coordinate;

import java.awt.Color;
import java.awt.Font;

public class ItemComboBox extends JComboBox<String> {
    public ItemComboBox(String[] data, Coordinate coordinate) {
		super(data);
		setFocusable(false);
		setMaximumRowCount(4);
		setBackground(Color.WHITE);
	    setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 20));
		setBounds(coordinate.getX(), coordinate.getY(), 260, 25);
    }
}
