package UI;

import java.util.ArrayList;

import javax.swing.JPanel;

import main.Coordinate;
import main.Laboratory;
import main.Shelter;
import main.Warehouse;
import observers.Observer;
import subjects.*;

public class MapPanel extends JPanel implements Observer {
	private Map map;

	private Coordinate[] coordinates = {
		new Coordinate(45,20),
		new Coordinate(187,20),
		new Coordinate(329,20),
		new Coordinate(471,20),
		new Coordinate(613,20),
		new Coordinate(45,155),
		new Coordinate(187,155),
		new Coordinate(329,155),
		new Coordinate(471,155),
		new Coordinate(613,155),
		new Coordinate(45,290),
		new Coordinate(187,290),
		new Coordinate(329,290),
		new Coordinate(471,290),
		new Coordinate(613,290),
		new Coordinate(45,425),
		new Coordinate(187,425),
		new Coordinate(329,425),
		new Coordinate(471,425),
		new Coordinate(613,425),
		new Coordinate(45,560),
		new Coordinate(187,560),
		new Coordinate(329,560),
		new Coordinate(471,560),
		new Coordinate(613,560)
	};

    public MapPanel(Map map) {
        super();
		this.map = map;
		setOpaque(false);
		setBounds(299, 0, 795, 759);
		setBackground(null);
		setLayout(null);
    }

	public void update() {
		removeAll();
		ArrayList<Field> fields = map.getFields();
		for(int i = 0; i < fields.size(); i++) {
			FieldPanel field_panel;
			if(fields.get(i).isSame(new Laboratory(""))) {
				field_panel = new FieldPanel(coordinates[i], "field_lab_icon.png");
			}
			else if(fields.get(i).isSame(new Warehouse(""))) {
				field_panel = new FieldPanel(coordinates[i], "field_warehouse_icon.png");
			}
			else if(fields.get(i).isSame(new Shelter(""))) {
				field_panel = new FieldPanel(coordinates[i], "field_shelter_icon.png");
			}
			else {
				field_panel = new FieldPanel(coordinates[i], "");
			}
			
			add(field_panel);	
			}
		revalidate();
		repaint();
	}
}
