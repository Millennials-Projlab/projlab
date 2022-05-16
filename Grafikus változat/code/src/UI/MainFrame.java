package UI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

import java.awt.Toolkit;
import observers.Observer;
import subjects.Game;

public class MainFrame extends JFrame implements Observer {
    public MainFrame() {
        setResizable(false);
        setTitle("A világtalan virológusok világa\r\n\r\n");
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/main_icon.png"));
        setBounds(100, 100, 1100, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }

    public void initialize() {
        ErrorTextArea error_textarea = new ErrorTextArea();
        add(error_textarea);

        PlayerSelectPanel player_selection_panel = new PlayerSelectPanel();
        getContentPane().add(player_selection_panel);

        VirologistPanelList virologist_panel_list = new VirologistPanelList();
        player_selection_panel.add(virologist_panel_list);

        VirologistPanelScrollPane virologist_panel_scrollpane = new VirologistPanelScrollPane(virologist_panel_list);

        VirologistPanel virologist_panel = new VirologistPanel();
        virologist_panel_list.add(virologist_panel);

        PlayerText txtPlayer = new PlayerText();
        virologist_panel.add(txtPlayer);

        VirologistIcon virologist_panel_virologist_icon = new VirologistIcon();
        virologist_panel.add(virologist_panel_virologist_icon);

        AminoText amino_text = new AminoText();
        virologist_panel.add(amino_text);

        NukleotidText nukleotid_text = new NukleotidText();
        virologist_panel.add(nukleotid_text);

        LearnedGenetics learned_genetics = new LearnedGenetics();
        virologist_panel.add(learned_genetics);

        Equipments equipments = new Equipments();
        virologist_panel.add(equipments);

        Agents agents = new Agents();
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

        virologist_panel_scrollpane.setViewportBorder(null);
		virologist_panel_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		virologist_panel_scrollpane.setBorder(null);
		virologist_panel_scrollpane.setBounds(0, 0, 300, 960);
		player_selection_panel.add(virologist_panel_scrollpane);

        MapPanel map_panel = new MapPanel(Game.getMap());
        getContentPane().add(map_panel);
        Game.getMap().attach(map_panel);
        //Game.getMap().attach(this);



        MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);

		JLabel map_label = new JLabel("");
		map_label.setFocusable(false);
		map_label.setIcon(new ImageIcon("images/map.png"));
		map_label.setBounds(299, 0, 795, 945);
		getContentPane().add(map_label);


        setVisible(true);
    }

    public void update() {
        //revalidate();
    }
}
