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

public class gfxLabel extends gfxControl{
	BorderPane layout;
	Label label;
	
	
	public gfxLabel(String name, Vector2 location, Vector2 size, String text) {
		super(name);
		this.layout = new BorderPane();
		label = new Label(text);
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
	
	public void setText(String text) {
		this.label.setText(text);
	}
	
	public String getText() {
		return this.label.getText();
	}
	
}
