package UI;

import java.awt.Color;
import javax.swing.JPanel;

import main.Amino;
import main.Coordinate;
import main.IncorrectParameterException;
import main.Nukleotid;

import java.awt.GridLayout;
import java.awt.event.*;

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
	
			ItemComboBox learned_genetics = new ItemComboBox(virologist.getLearnedGenetics(), new Coordinate(10, 290));
			virologist_panel.add(learned_genetics);

			ItemComboBox agents = new ItemComboBox(virologist.getAgents(), new Coordinate(10, 360));
			virologist_panel.add(agents);
	
			ItemComboBox equipments = new ItemComboBox(virologist.getEquipmentList(), new Coordinate(10, 430));
			virologist_panel.add(equipments);
	
			InteractButton btnagent_generate = new InteractButton("Generate", 10, 308, 260, 39);
			btnagent_generate.addActionListener(new GenerateActionListener(virologist, learned_genetics));
			virologist_panel.add(btnagent_generate);
	
			InteractButton btnagent_attack = new InteractButton("Attack", 10, 383, 260, 39);
			if(virologist.getAgents().length>0) btnagent_attack.addActionListener(new AttackActionListener(virologist, virologist.getAgents()[agents.getSelectedIndex()]));
			virologist_panel.add(btnagent_attack);
	
			InteractButton btnagent_use = new InteractButton("Use", 10, 453, 260, 39);
			virologist_panel.add(btnagent_use);

			InteractButton btnagent_loot = new InteractButton("Loot", 10, 516, 260, 39);
			btnagent_loot.addActionListener(new LootActionListener(virologist));
			virologist_panel.add(btnagent_loot);
	
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

	class LootActionListener implements ActionListener {
		Virologist virologist;
		public LootActionListener(Virologist virologist) {
			this.virologist = virologist;
		}

		public void actionPerformed(ActionEvent e) {
			virologist.loot();
		}
	}


	class GenerateActionListener implements ActionListener {
		Virologist virologist;
		ItemComboBox genetic;
		public GenerateActionListener(Virologist virologist, ItemComboBox genetic) {
			this.virologist = virologist;
			this.genetic = genetic;
		}

		public void actionPerformed(ActionEvent e) {
			try {
				virologist.produceAgent(genetic.getSelectedItem().toString());
			} catch(IncorrectParameterException ex) {
				Game.errorMessage("ERROR: " + ex.getMessage());
			}
		}
	}
			

	class AttackActionListener implements ActionListener {
		Virologist virologist;
		Virologist target;
		String agent;
		public AttackActionListener(Virologist virologist,String agent){
			for(Virologist v: Game.getPlayers()){
				if(!v.getName().contentEquals(virologist.getName())&&virologist.getCurrentField()==v.getCurrentField()){
					this.virologist=virologist;
					this.target=v;
					this.agent=agent;
				}
			}
		}
		public void actionPerformed(ActionEvent e) {
			virologist.infect(target, agent);

		}
	}

}
