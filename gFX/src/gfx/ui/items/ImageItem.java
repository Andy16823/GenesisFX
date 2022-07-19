package gfx.ui.items;

import gfx.math.Vector2;
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
	private Vector2 imageSize;
	private boolean renderText;
	
	public ImageItem(String name, String text, Image image) {
		super(name);
		this.image = image;
		this.text = text;
		this.imageSize = new Vector2(image.getWidth(), image.getHeight());
		this.renderText = true;
		// TODO Auto-generated constructor stub
	}
	
	public ImageItem(String name, String text, Vector2 imageSize, Image image) {
		super(name);
		this.image = image;
		this.text = text;
		this.imageSize = imageSize;
		this.renderText = true;
		// TODO Auto-generated constructor stub
	}
	
	public ImageItem(String name, String text, Vector2 imageSize, boolean renderText, Image image) {
		super(name);
		this.image = image;
		this.text = text;
		this.imageSize = imageSize;
		this.renderText = renderText;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pane getItemLayout() {
		
		String cssBordering = "-fx-padding: 2.0;";
		
		// TODO Auto-generated method stub
		BorderPane itemLayout = new BorderPane();
		itemLayout.getStyleClass().add("list-item-image-item");
		BorderPane imagePane = new BorderPane();
		imagePane.setStyle(cssBordering);
		imageView = new ImageView(this.image);	
		imageView.getStyleClass().add("list-item-image-item-iv");
		imageView.setFitWidth(this.imageSize.getX());
		imageView.setFitHeight(this.imageSize.getY());
		imageView.setStyle(cssBordering);
		imagePane.setCenter(imageView);
		itemLayout.setCenter(imagePane);
		
		label = new Label(this.text);
		label.getStyleClass().add("list-item-image-item-label");
		label.setAlignment(Pos.CENTER);
		label.setStyle(cssBordering);
		if(this.renderText) {
			itemLayout.setBottom(label);
		}
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
