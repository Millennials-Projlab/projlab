package UI;

import javax.swing.*;

import subjects.Virologist;

import java.awt.*;
import java.awt.event.*;

public class EndGameDialog extends JDialog{
    public EndGameDialog(Virologist virologist){
        setSize(300, 400);
        setLocation(400, 200);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("A játék befejeződött!");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel("A játékot "+ virologist.getName() +" nyerte.");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nameLabel);

        JButton ExitButton = new JButton("EXIT");
        ExitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ExitButton.addActionListener(new ExitButtonActionListener());
        panel.add(ExitButton);

        add(panel);
        setVisible(true);
    }
    
    class ExitButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
