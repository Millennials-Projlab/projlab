package UI;

import javax.swing.*;

import subjects.Game;

import java.awt.*;
import java.awt.event.*;

public class NewVirologistDialog extends JDialog {
    public NewVirologistDialog() {
        setSize(300, 400);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Virológus felvétele");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel("Név:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nameLabel);
        JTextField nameField = new JTextField(10);
        panel.add(nameField);

        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.addActionListener(new OkButtonActionListener(nameField));
        panel.add(okButton);

        add(panel);
        setVisible(true);
    }    
    
    class OkButtonActionListener implements ActionListener {
        private JTextField nameField;
        public OkButtonActionListener(JTextField nameField) {
            this.nameField = nameField;
        }

        public void actionPerformed(ActionEvent e) {
            Game.createVirologist(nameField.getText());
            dispose();
        }
    }
}
