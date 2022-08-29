package gfx.ui.items;

import gfx.ui.ListItem;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DetailedListItem extends ListItem {
	private BorderPane _layout;
	
	public DetailedListItem(String name, Image icon, String text, String description) {
		super(name);
		
		_layout = new BorderPane();
		
		ImageView imageView = new ImageView(icon);
		imageView.setFitWidth(32);
		imageView.setFitHeight(32);
		_layout.setLeft(imageView);
		
		BorderPane contentPane = new BorderPane();
		Label headLabel = new Label(text);
		contentPane.setTop(headLabel);
		Label descriptionLabel = new Label(description);
		contentPane.setCenter(descriptionLabel);
		_layout.setCenter(contentPane);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pane getItemLayout() {
		// TODO Auto-generated method stub
		return _layout;
	}

}
