package gfx.ui;

import java.util.Vector;

import gfx.math.Vector2;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class gfxToolbar extends gfxControl{
	private Vector<ListItem> listItems;
	private HBox layout;
	
	public gfxToolbar(String name, Vector2 location) {
		super(name);
		this.listItems = new Vector<>();
		
		this.layout = new HBox(5);
		this.layout.setLayoutX(location.getX());
		this.layout.setLayoutY(location.getY());
		
		this.addControl(layout);
		// TODO Auto-generated constructor stub
	}
	
	public void addItem(ListItem item) {
		this.listItems.add(item);		
		layout.getChildren().add(item.getItemLayout());
	}

	public Vector<ListItem> getListItems() {
		return listItems;
	}

	public void setListItems(Vector<ListItem> listItems) {
		this.listItems = listItems;
	}

	public HBox getLayout() {
		return layout;
	}

	public void setLayout(HBox layout) {
		this.layout = layout;
	}
	
}
