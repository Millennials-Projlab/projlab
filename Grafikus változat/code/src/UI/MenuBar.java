package UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Font;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        super();
        
        JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(new Color(51, 0, 153));
		mnNewMenu.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Start");
		mntmNewMenuItem.setForeground(new Color(51, 0, 153));
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setForeground(new Color(51, 0, 153));
		mntmExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		mnNewMenu.add(mntmExit);
    }
}
