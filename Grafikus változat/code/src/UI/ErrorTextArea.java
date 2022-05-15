package UI;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class ErrorTextArea extends JTextArea {
    public ErrorTextArea() {
		setText("Error message");
	    setForeground(Color.RED);
	    setFont(new Font("SansSerif", Font.BOLD, 20));
		setEditable(false);
		setBackground(Color.WHITE);
		setBounds(310, 770, 774, 164);
		//frmVirologistWithoutAny.getContentPane().add(error_textarea);
    }
}
