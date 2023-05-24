package gfx.ui;

import java.awt.Color;
import java.util.Vector;

import gfx.Game;
import gfx.math.Vector2;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import gfx.ui.contextmenuitems.*;

public class gfxContextmenu extends gfxControl{
	private BorderPane layout;
	private Vector2 location;
	private String title;
	private Vector<ContextmenuItem> items;
	
	private Label titleLabel;
	private VBox itemsArea;
	
	public gfxContextmenu(String name, String title, Vector2 location) {
		super(name);
		
		items = new Vector<>();
		this.location = location;
		this.title = title;
		
		layout = new BorderPane();
		layout.setStyle(""
				+ "-fx-background-color: #15181D;");
		
		layout.setLayoutX(location.getX());
		layout.setLayoutY(location.getY());
		
		Pane titlePane = new Pane();
		titleLabel = new Label(title);
		titleLabel.setStyle(""
				+ "-fx-text-fill: white;"
				+ "-fx-padding: 5px 5px 5px 5px;"
				+ "-fx-font-weight: bold;");
		
		titlePane.getChildren().add(titleLabel);
		layout.setTop(titlePane);
		
		itemsArea = new VBox();
		itemsArea.setPadding(new Insets(0));
		layout.setCenter(itemsArea);
		
		
		Pane closeItemPanel = new Pane();
		closeItemPanel.setOnMouseEntered(e -> {
			closeItemPanel.setStyle(""
					+ "-fx-background-color: #1E2D32;");
		});
		
		closeItemPanel.setOnMouseExited(e -> {
			closeItemPanel.setStyle(""
					+ "-fx-background-color: inherit;");
		});
		
		Label closeLabel = new Label("Close Menu");
		closeLabel.setStyle(""
				+ "-fx-text-fill: white;"
				+ "-fx-padding: 5px 5px 5px 5px;");
		closeLabel.setOnMouseClicked(e -> {
			this.setVisible(false);
		});
		
		closeItemPanel.getChildren().add(closeLabel);
		layout.setBottom(closeItemPanel);

		this.addControl(layout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pane getLayout() {
		// TODO Auto-generated method stub
		return layout;
	}

	@Override
	public void onUpdate(Game game) {
		// TODO Auto-generated method stub
		
	}

	public Vector2 getLocation() {
		return location;
	}

	public void setLocation(Vector2 location) {
		this.location = location;
		layout.setLayoutX(location.getX());
		layout.setLayoutY(location.getY());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.titleLabel.setText(title);
	}
	
	public void addItem(ContextmenuItem item) {
		this.items.add(item);
		item.setMenu(this);
		item.getLayout().setOnMouseClicked(e -> {
			item.getBehavior().onActivate(item);
		});
		refreshItems();
	}
	
	public void clearItems() {
		this.items.clear();
		this.itemsArea.getChildren().clear();
	}
	
	private void refreshItems() {
		this.itemsArea.getChildren().clear();
		for(ContextmenuItem item : this.items) {
			this.itemsArea.getChildren().add(item.getLayout());
		}
	}
	
}
