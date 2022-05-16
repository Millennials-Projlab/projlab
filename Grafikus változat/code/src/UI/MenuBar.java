package UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import subjects.Game;

import java.awt.Color;
import java.awt.Font;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        super();
        
        JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(new Color(51, 0, 153));
		mnNewMenu.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(mnNewMenu);

		class NewVirologistActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				NewVirologistDialog newVirologistDialog = new NewVirologistDialog();
			}
		}

		class StartActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Game.Start();
			}
		}

		class ExitActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}

		JMenuItem newVirologist = new JMenuItem("New Virologist");
		newVirologist.setForeground(new Color(51, 0, 153));
		newVirologist.setFont(new Font("SansSerif", Font.BOLD, 15));
		mnNewMenu.add(newVirologist);
		newVirologist.addActionListener(new NewVirologistActionListener());

		JMenuItem mntmNewMenuItem = new JMenuItem("Start");
		mntmNewMenuItem.setForeground(new Color(51, 0, 153));
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new StartActionListener());
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setForeground(new Color(51, 0, 153));
		mntmExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		mnNewMenu.add(mntmExit);
		mntmExit.addActionListener(new ExitActionListener());
    }
}
