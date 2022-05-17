package UI;

import java.awt.Color;
import javax.swing.JPanel;

import main.Amino;
import main.Coordinate;
import main.Nukleotid;

import java.awt.GridLayout;

import observers.Observer;
import subjects.Game;
import subjects.Virologist;

public class VirologistPanelList extends JPanel implements Observer {
    public VirologistPanelList() {
		super();
		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 1, 0, 3));
		setAutoscrolls(true);
    }

	public void update() {
		removeAll();
		for(Virologist virologist : Game.getPlayers()) {
			VirologistPanel virologist_panel = new VirologistPanel();
			add(virologist_panel);
	
			PlayerText txtPlayer = new PlayerText(virologist.getName());
			virologist_panel.add(txtPlayer);
	
			VirologistIcon virologist_panel_virologist_icon = new VirologistIcon();
			virologist_panel.add(virologist_panel_virologist_icon);
	
			AminoText amino_text = new AminoText(Integer.toString(virologist.countSubstance(new Amino())));
			virologist_panel.add(amino_text);
	
			NukleotidText nukleotid_text = new NukleotidText(Integer.toString(virologist.countSubstance(new Nukleotid())));
			virologist_panel.add(nukleotid_text);
	
			ItemComboBox learned_genetics = new ItemComboBox(virologist.getEquipments(), new Coordinate(10, 308));
			virologist_panel.add(learned_genetics);
	
			ItemComboBox equipments = new ItemComboBox(virologist.getEquipments(), new Coordinate(10, 394));
			virologist_panel.add(equipments);
	
			ItemComboBox agents = new ItemComboBox(virologist.getEquipments(), new Coordinate(10, 480));
			virologist_panel.add(agents);
	
			InteractButton btnagent_generate = new InteractButton("Generate", 10, 516, 260, 39);
			virologist_panel.add(btnagent_generate);
	
			InteractButton btnagent_attack = new InteractButton("Attack", 10, 430, 260, 39);
			virologist_panel.add(btnagent_attack);
	
			InteractButton btnagent_use = new InteractButton("Use", 10, 344, 260, 39);
			virologist_panel.add(btnagent_use);
	
			EffectTextField effect1 = new EffectTextField(10, 196, 260, 20);
			EffectTextField effect2 = new EffectTextField(10, 227, 260, 20);
			EffectTextField effect3 = new EffectTextField(10, 258, 260, 20);
			virologist_panel.add(effect1);
			virologist_panel.add(effect2);
			virologist_panel.add(effect3);
		}
		revalidate();
		repaint();
	}

}
