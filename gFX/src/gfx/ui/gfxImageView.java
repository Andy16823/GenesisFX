package gfx.ui;

import java.awt.Color;

import gfx.math.Vector2;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

public class gfxImageView extends gfxControl{
	BorderPane layout;
	Label label;
	ImageView imageView;
	
	
	public gfxImageView(String name, Vector2 location, Vector2 size, Image image) {
		super(name);
		
		layout = new BorderPane();
		layout.setLayoutX(location.getX());
		layout.setLayoutY(location.getY());
		layout.setPrefWidth(size.getX());
		layout.setPrefHeight(size.getY());
		imageView = new ImageView(image);	
		layout.setCenter(imageView);
		
		label = new Label(name);
		label.setAlignment(Pos.CENTER);
		label.setPrefWidth(size.getX());
		layout.setBottom(label);
		
		this.addControl(layout);
		// TODO Auto-generated constructor stub
	}


	public BorderPane getLayout() {
		return layout;
	}


	public void setLayout(BorderPane layout) {
		this.layout = layout;
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
