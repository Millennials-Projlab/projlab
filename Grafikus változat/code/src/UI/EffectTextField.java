package UI;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import observers.Observer;
import subjects.Agent;

import java.awt.Color;
import java.awt.Font;

public class EffectTextField extends JTextField implements Observer {
	private Agent effect;
	private int y;

    public EffectTextField(int y, Agent effect) {
		this.effect = effect;
		this.y = y;
		effect.attach(this);
		setBackground(Color.WHITE);
		setBorder(null);
		setEditable(false);
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 15));
		setText(effect.toString() + "\t" + effect.getLivetime());
		setBounds(10, y, 260, 20);
		setColumns(10);
    }

	public void update() {
		removeAll();
		setBackground(Color.WHITE);
		setBorder(null);
		setEditable(false);
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(new Color(51, 0, 153));
		setFont(new Font("SansSerif", Font.BOLD, 15));
		setText(effect.toString() + "\t" + effect.getLivetime());
		setBounds(10, y, 260, 20);
		setColumns(10);
		revalidate();
		repaint();
	}
}
