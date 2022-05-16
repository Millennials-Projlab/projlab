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
        Game.attach(virologist_panel_list);

        VirologistPanelScrollPane virologist_panel_scrollpane = new VirologistPanelScrollPane(virologist_panel_list);

        virologist_panel_scrollpane.setViewportBorder(null);
		virologist_panel_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		virologist_panel_scrollpane.setBorder(null);
		virologist_panel_scrollpane.setBounds(0, 0, 300, 960);
		player_selection_panel.add(virologist_panel_scrollpane);

        MapPanel map_panel = new MapPanel(Game.getMap());
        getContentPane().add(map_panel);
        Game.attach(map_panel);
        Game.getMap().attach(map_panel);

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
