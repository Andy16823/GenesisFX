package gfx.ui.items;

import gfx.ui.ListItem;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ImageItem extends ListItem {
	private Image image;
	private String text;
	private Label label;
	private ImageView imageView;
	
	public ImageItem(String name, String text, Image image) {
		super(name);
		this.image = image;
		this.text = text;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pane getItemLayout() {
		
		String cssBordering = "-fx-padding: 2.0;";
		
		// TODO Auto-generated method stub
		BorderPane itemLayout = new BorderPane();
		BorderPane imagePane = new BorderPane();
		imagePane.setStyle(cssBordering);
		imageView = new ImageView(this.image);	
		imageView.setStyle(cssBordering);
		imagePane.setCenter(imageView);
		itemLayout.setCenter(imagePane);
		
		label = new Label(this.text);
		label.setAlignment(Pos.CENTER);
		label.setStyle(cssBordering);
		itemLayout.setBottom(label);
		
		return itemLayout;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		this.label.setText(text);
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
}
