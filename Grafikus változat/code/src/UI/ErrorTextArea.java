package UI;

import javax.swing.JTextArea;

import observers.Observer;
import subjects.Game;

import java.awt.Color;
import java.awt.Font;

public class ErrorTextArea extends JTextArea implements Observer {
    public ErrorTextArea() {
		setText("");
	    setForeground(Color.RED);
	    setFont(new Font("SansSerif", Font.BOLD, 20));
		setEditable(false);
		setBackground(Color.WHITE);
		setBounds(310, 770, 774, 164);
    }

	public void update() {
		removeAll();
		if(Game.getMessage().isError()) {
			setForeground(Color.RED);
		}
		else {
			setForeground(Color.BLACK);
		}
		setText(Game.getMessage().getMessage());

		revalidate();
		repaint();
	}
}
