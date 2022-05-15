package projlab_graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ww {

	private JFrame frmVirologistWithoutAny;
	private JTextField txtPlayer;
	private JTextField amino_text;
	private JTextField nukleotid_text;
	private JTextField txtT;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ww window = new ww();
					window.frmVirologistWithoutAny.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ww() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVirologistWithoutAny = new JFrame();
		frmVirologistWithoutAny.setResizable(false);
		frmVirologistWithoutAny.setTitle("Virologist without any hope\r\n\r\n");
		frmVirologistWithoutAny.setIconImage(Toolkit.getDefaultToolkit().getImage("images/main_icon.png"));
		frmVirologistWithoutAny.setBounds(100, 100, 1100, 1100);
		frmVirologistWithoutAny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVirologistWithoutAny.getContentPane().setLayout(null);
		
		JTextArea error_textarea = new JTextArea();
		error_textarea.setText("Error message");
		error_textarea.setForeground(Color.RED);
		error_textarea.setFont(new Font("SansSerif", Font.BOLD, 20));
		error_textarea.setEditable(false);
		error_textarea.setBackground(Color.WHITE);
		error_textarea.setBounds(310, 770, 774, 164);
		frmVirologistWithoutAny.getContentPane().add(error_textarea);
		
		JPanel player_selection_panel = new JPanel();
		player_selection_panel.setBackground(Color.WHITE);
		player_selection_panel.setBounds(0, 0, 300, 971);
		frmVirologistWithoutAny.getContentPane().add(player_selection_panel);
		player_selection_panel.setLayout(null);
		
		JPanel virologist_panel_list = new JPanel();
		virologist_panel_list.setBackground(Color.WHITE);
		virologist_panel_list.setLayout(new GridLayout(0, 1, 0, 3));
		virologist_panel_list.setAutoscrolls(true);
		player_selection_panel.add(virologist_panel_list);
		
		JScrollPane virologist_panel_scrollpane = new JScrollPane(virologist_panel_list);
		
		JPanel virologist_panel = new JPanel();
		virologist_panel_list.add(virologist_panel);
		virologist_panel.setPreferredSize(new Dimension(283, 566));
		virologist_panel.setBackground(Color.WHITE);
		virologist_panel.setBorder(new LineBorder(new Color(51, 0, 153), 2, true));
		virologist_panel.setLayout(null);
		
		txtPlayer = new JTextField();
		txtPlayer.setBackground(Color.WHITE);
		txtPlayer.setBorder(null);
		txtPlayer.setFocusable(false);
		txtPlayer.setEditable(false);
		txtPlayer.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtPlayer.setForeground(new Color(204, 0, 102));
		txtPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer.setText("Player1");
		txtPlayer.setBounds(10, 11, 260, 39);
		virologist_panel.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		JLabel virologist_panel_virologist_icon = new JLabel("");
		virologist_panel_virologist_icon.setIcon(new ImageIcon("images/virologist_icon_field.png"));
		virologist_panel_virologist_icon.setBounds(75, 61, 124, 112);
		virologist_panel.add(virologist_panel_virologist_icon);
		
		amino_text = new JTextField();
		amino_text.setBorder(null);
		amino_text.setFocusable(false);
		amino_text.setFont(new Font("SansSerif", Font.BOLD, 40));
		amino_text.setForeground(new Color(204, 0, 102));
		amino_text.setBackground(Color.WHITE);
		amino_text.setEditable(false);
		amino_text.setText("5");
		amino_text.setBounds(41, 82, 37, 52);
		virologist_panel.add(amino_text);
		amino_text.setColumns(10);
		
		nukleotid_text = new JTextField();
		nukleotid_text.setText("5");
		nukleotid_text.setForeground(new Color(51, 0, 153));
		nukleotid_text.setFont(new Font("SansSerif", Font.BOLD, 40));
		nukleotid_text.setFocusable(false);
		nukleotid_text.setEditable(false);
		nukleotid_text.setColumns(10);
		nukleotid_text.setBorder(null);
		nukleotid_text.setBackground(Color.WHITE);
		nukleotid_text.setBounds(209, 82, 37, 52);
		virologist_panel.add(nukleotid_text);
		
		JComboBox learned_genetics = new JComboBox();
		learned_genetics.setFocusable(false);
		learned_genetics.setMaximumRowCount(4);
		learned_genetics.setBackground(Color.WHITE);
		learned_genetics.setForeground(new Color(51, 0, 153));
		learned_genetics.setFont(new Font("SansSerif", Font.BOLD, 20));
		learned_genetics.setBounds(10, 308, 260, 25);
		virologist_panel.add(learned_genetics);
		
		JComboBox equipments = new JComboBox();
		equipments.setMaximumRowCount(4);
		equipments.setForeground(new Color(51, 0, 153));
		equipments.setFont(new Font("SansSerif", Font.BOLD, 20));
		equipments.setFocusable(false);
		equipments.setBackground(Color.WHITE);
		equipments.setBounds(10, 394, 260, 25);
		virologist_panel.add(equipments);
		
		JComboBox agents = new JComboBox();
		agents.setMaximumRowCount(4);
		agents.setForeground(new Color(51, 0, 153));
		agents.setFont(new Font("SansSerif", Font.BOLD, 20));
		agents.setFocusable(false);
		agents.setBackground(Color.WHITE);
		agents.setBounds(10, 480, 260, 25);
		virologist_panel.add(agents);
		
		JButton btnagent_generate = new JButton("Generate");
		btnagent_generate.setBackground(Color.RED);
		btnagent_generate.setBorder(null);
		btnagent_generate.setFocusable(false);
		btnagent_generate.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnagent_generate.setForeground(Color.WHITE);
		btnagent_generate.setBounds(10, 516, 260, 39);
		virologist_panel.add(btnagent_generate);
		
		JButton btnagent_attack = new JButton("Attack");
		btnagent_attack.setForeground(Color.WHITE);
		btnagent_attack.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnagent_attack.setFocusable(false);
		btnagent_attack.setBorder(null);
		btnagent_attack.setBackground(Color.RED);
		btnagent_attack.setBounds(10, 430, 260, 39);
		virologist_panel.add(btnagent_attack);
		
		JButton btnagent_use = new JButton("Use");
		btnagent_use.setForeground(Color.WHITE);
		btnagent_use.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnagent_use.setFocusable(false);
		btnagent_use.setBorder(null);
		btnagent_use.setBackground(Color.RED);
		btnagent_use.setBounds(10, 344, 260, 39);
		virologist_panel.add(btnagent_use);
		
		txtT = new JTextField();
		txtT.setBackground(Color.WHITE);
		txtT.setBorder(null);
		txtT.setEditable(false);
		txtT.setHorizontalAlignment(SwingConstants.CENTER);
		txtT.setForeground(new Color(51, 0, 153));
		txtT.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtT.setText("T1");
		txtT.setBounds(10, 196, 260, 20);
		virologist_panel.add(txtT);
		txtT.setColumns(10);
		
		textField = new JTextField();
		textField.setText("T1");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(51, 0, 153));
		textField.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 227, 260, 20);
		virologist_panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("T1");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(51, 0, 153));
		textField_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(10, 258, 260, 20);
		virologist_panel.add(textField_1);
		
		JPanel virologist_panel_1 = new JPanel();
		virologist_panel_1.setLayout(null);
		virologist_panel_1.setPreferredSize(new Dimension(283, 566));
		virologist_panel_1.setBorder(new LineBorder(new Color(51, 0, 153), 2, true));
		virologist_panel_1.setBackground(Color.WHITE);
		virologist_panel_list.add(virologist_panel_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Player1");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(204, 0, 102));
		textField_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		textField_2.setFocusable(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(10, 11, 260, 39);
		virologist_panel_1.add(textField_2);
		
		JLabel virologist_panel_virologist_icon_1 = new JLabel("");
		virologist_panel_virologist_icon_1.setIcon(new ImageIcon("images/virologist_icon_field.png"));
		virologist_panel_virologist_icon_1.setBounds(75, 61, 124, 112);
		virologist_panel_1.add(virologist_panel_virologist_icon_1);
		
		textField_3 = new JTextField();
		textField_3.setText("5");
		textField_3.setForeground(new Color(204, 0, 102));
		textField_3.setFont(new Font("SansSerif", Font.BOLD, 40));
		textField_3.setFocusable(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(41, 82, 37, 52);
		virologist_panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("5");
		textField_4.setForeground(new Color(51, 0, 153));
		textField_4.setFont(new Font("SansSerif", Font.BOLD, 40));
		textField_4.setFocusable(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(209, 82, 37, 52);
		virologist_panel_1.add(textField_4);
		
		JComboBox learned_genetics_1 = new JComboBox();
		learned_genetics_1.setMaximumRowCount(4);
		learned_genetics_1.setForeground(new Color(51, 0, 153));
		learned_genetics_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		learned_genetics_1.setFocusable(false);
		learned_genetics_1.setBackground(Color.WHITE);
		learned_genetics_1.setBounds(10, 308, 260, 25);
		virologist_panel_1.add(learned_genetics_1);
		
		JComboBox equipments_1 = new JComboBox();
		equipments_1.setMaximumRowCount(4);
		equipments_1.setForeground(new Color(51, 0, 153));
		equipments_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		equipments_1.setFocusable(false);
		equipments_1.setBackground(Color.WHITE);
		equipments_1.setBounds(10, 394, 260, 25);
		virologist_panel_1.add(equipments_1);
		
		JComboBox agents_1 = new JComboBox();
		agents_1.setMaximumRowCount(4);
		agents_1.setForeground(new Color(51, 0, 153));
		agents_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		agents_1.setFocusable(false);
		agents_1.setBackground(Color.WHITE);
		agents_1.setBounds(10, 480, 260, 25);
		virologist_panel_1.add(agents_1);
		
		JButton btnagent_generate_1 = new JButton("Generate");
		btnagent_generate_1.setForeground(Color.WHITE);
		btnagent_generate_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnagent_generate_1.setFocusable(false);
		btnagent_generate_1.setBorder(null);
		btnagent_generate_1.setBackground(Color.RED);
		btnagent_generate_1.setBounds(10, 516, 260, 39);
		virologist_panel_1.add(btnagent_generate_1);
		
		JButton btnagent_attack_1 = new JButton("Attack");
		btnagent_attack_1.setForeground(Color.WHITE);
		btnagent_attack_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnagent_attack_1.setFocusable(false);
		btnagent_attack_1.setBorder(null);
		btnagent_attack_1.setBackground(Color.RED);
		btnagent_attack_1.setBounds(10, 430, 260, 39);
		virologist_panel_1.add(btnagent_attack_1);
		
		JButton btnagent_use_1 = new JButton("Use");
		btnagent_use_1.setForeground(Color.WHITE);
		btnagent_use_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnagent_use_1.setFocusable(false);
		btnagent_use_1.setBorder(null);
		btnagent_use_1.setBackground(Color.RED);
		btnagent_use_1.setBounds(10, 344, 260, 39);
		virologist_panel_1.add(btnagent_use_1);
		
		textField_5 = new JTextField();
		textField_5.setText("T1");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(new Color(51, 0, 153));
		textField_5.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(10, 196, 260, 20);
		virologist_panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("T1");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(new Color(51, 0, 153));
		textField_6.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(10, 227, 260, 20);
		virologist_panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("T1");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(new Color(51, 0, 153));
		textField_7.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(10, 258, 260, 20);
		virologist_panel_1.add(textField_7);
		virologist_panel_scrollpane.setViewportBorder(null);
		virologist_panel_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		virologist_panel_scrollpane.setBorder(null);
		virologist_panel_scrollpane.setBounds(0, 0, 300, 960);
		player_selection_panel.add(virologist_panel_scrollpane);
		
		JPanel map_panel = new JPanel();
		map_panel.setOpaque(false);
		map_panel.setBounds(299, 0, 795, 759);
		frmVirologistWithoutAny.getContentPane().add(map_panel);
		map_panel.setBackground(null);
		map_panel.setLayout(null);
		
		JPanel field_panel = new JPanel();
		field_panel.setOpaque(false);
		field_panel.setFocusable(false);
		field_panel.setBackground(Color.WHITE);
		field_panel.setBorder(new LineBorder(new Color(64, 64, 64), 4));
		field_panel.setBounds(187, 155, 144, 134);
		map_panel.add(field_panel);
		field_panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFocusable(false);
		comboBox.setMaximumRowCount(4);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(51, 0, 153));
		comboBox.setFont(new Font("SansSerif", Font.BOLD, 20));
		comboBox.setBounds(10, 101, 124, 22);
		field_panel.add(comboBox);
		
		JButton field_select_button = new JButton("");
		field_select_button.setOpaque(false);
		field_select_button.setBorder(null);
		field_select_button.setFocusable(false);
		field_select_button.setBounds(10, 11, 124, 79);
		field_select_button.setBackground(null);
		field_panel.add(field_select_button);
		
		JLabel field_virologist_icon = new JLabel("");
		field_virologist_icon.setBounds(10, 11, 124, 112);
		field_panel.add(field_virologist_icon);
		
		JLabel field_type_icon = new JLabel("");
		field_type_icon.setIcon(new ImageIcon("images/field_shelter_icon.png"));
		field_type_icon.setBounds(10, 11, 124, 112);
		field_panel.add(field_type_icon);
		
		JLabel map_label = new JLabel("");
		map_label.setFocusable(false);
		map_label.setIcon(new ImageIcon("images/map.png"));
		map_label.setBounds(299, 0, 795, 945);
		frmVirologistWithoutAny.getContentPane().add(map_label);
		
		JMenuBar menuBar = new JMenuBar();
		frmVirologistWithoutAny.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(new Color(51, 0, 153));
		mnNewMenu.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
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
