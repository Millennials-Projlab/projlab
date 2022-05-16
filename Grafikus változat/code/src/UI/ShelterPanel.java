package UI;

import javax.swing.ImageIcon;

import main.Coordinate;
import subjects.Field;

public class ShelterPanel extends FieldPanel {
    public ShelterPanel(Coordinate coordinate, Field field) {
        super(coordinate, field);
		field_type_icon.setIcon(new ImageIcon("images/field_shelter_icon.png"));
    }
}
