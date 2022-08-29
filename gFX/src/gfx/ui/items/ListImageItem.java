package gfx.ui.items;

import gfx.ui.ListItem;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class ListImageItem extends ListItem {
	private BorderPane _layout;

	public ListImageItem(String name, Image icon, String text) {
		super(name);
		// TODO Auto-generated constructor stub
		_layout = new BorderPane();
		_layout.getStyleClass().add("gfxListItem");
		_layout.setOnMouseClicked((event) -> {
			if(this.getItemBehavior() != null) {
				this.getItemBehavior().onClick(this);
			}
		});
		
		ImageView imageView = new ImageView(icon);
		imageView.setFitWidth(32);
		imageView.setFitHeight(32);
		_layout.setLeft(imageView);
		
		Label label = new Label(text);
		label.setTextAlignment(TextAlignment.LEFT);
		_layout.setCenter(label);
		_layout.setAlignment(label, Pos.CENTER_LEFT);
	}

	
	@Override
	public Pane getItemLayout() {
		// TODO Auto-generated method stub
		return _layout;
	}

}


