package gfx.ui;

import gfx.math.Vector2;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class gfxImageButton extends gfxControl{
	private Image normalImage;
	private Image hoverImage;
	private Pane layout;
	private ImageView imageView;
	
	public gfxImageButton(String name, Vector2 location, Vector2 size, Image image) {
		super(name);
		this.normalImage = image;
		this.hoverImage = image;
		this.setCursor(Cursor.HAND);
		this.layout = new Pane();
		this.layout.setLayoutX(location.getX());
		this.layout.setLayoutY(location.getY());
		this.layout.setPrefSize(size.getX(), size.getY());
		this.imageView = new ImageView(image);
		this.imageView.setFitWidth(size.getX());
		this.imageView.setFitHeight(size.getY());
		this.layout.getChildren().add(imageView);
		this.getChildren().add(layout);
		this.imageView.setOnMouseEntered((event) -> {
			this.imageView.setImage(hoverImage);
		});
		this.imageView.setOnMouseExited((event) -> {
			this.imageView.setImage(normalImage);
		});
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pane getLayout() {
		// TODO Auto-generated method stub
		return layout;
	}

	public void setOnClick(EventHandler<? super MouseEvent> event) {
		this.imageView.setOnMouseClicked(event);
	}

	public Image getNormalImage() {
		return normalImage;
	}

	public void setNormalImage(Image normalImage) {
		this.normalImage = normalImage;
	}

	public Image getHoverImage() {
		return hoverImage;
	}

	public void setHoverImage(Image hoverImage) {
		this.hoverImage = hoverImage;
	}
	
}
