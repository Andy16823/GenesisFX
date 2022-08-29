package gfx.ui;

import java.util.Vector;

import gfx.Game;
import gfx.math.Vector2;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class gfxToolbar extends gfxControl{
	private Vector<ListItem> listItems;
	private HBox layout;
	private int selectedItemIndex;

	public gfxToolbar(String name, Vector2 location) {
		super(name);
		this.listItems = new Vector<>();
		this.layout = new HBox(5);
		this.layout.setLayoutX(location.getX());
		this.layout.setLayoutY(location.getY());
		this.addControl(layout);
		// TODO Auto-generated constructor stub
	}
	
	public gfxToolbar(String name, Vector2 location, double spacing) {
		super(name);
		this.listItems = new Vector<>();
		this.layout = new HBox(spacing);
		this.layout.setLayoutX(location.getX());
		this.layout.setLayoutY(location.getY());
		this.addControl(layout);
		// TODO Auto-generated constructor stub
	}
	
	public void selectItem(int index) {
		this.selectedItemIndex = index;
		refreshItems();
	}
	
	public ListItem getSelectedItem() {
		return this.listItems.get(selectedItemIndex);
	}
	
	public void addItem(ListItem item) {
		this.listItems.add(item);		
		layout.getChildren().add(item.getItemLayout());
	}
	
	public void refreshItems() {
		layout.getChildren().clear();
		int i = 0;
		for(var item : this.listItems) {
			Pane itemLayout = item.getItemLayout();
			if(i == this.selectedItemIndex) {
				itemLayout.getStyleClass().add("selected-item");
			}
			else {
				if(itemLayout.getStyleClass().contains("selected-item")) {
					itemLayout.getStyleClass().remove("selected-item");
				}
			}
			layout.getChildren().add(itemLayout);
			i++;
		}
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

	@Override
	public void onUpdate(Game game) {
		// TODO Auto-generated method stub
		
	}
	
}
