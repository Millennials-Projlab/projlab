package UI;

import javax.swing.ImageIcon;

import main.Coordinate;
import subjects.Field;

public class WarehousePanel extends FieldPanel {
    public WarehousePanel(Coordinate coordinate, Field field) {
        super(coordinate, field);
		field_type_icon.setIcon(new ImageIcon("images/field_warehouse_icon.png"));
    }
}
