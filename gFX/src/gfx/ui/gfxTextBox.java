package gfx.ui;

import gfx.Game;
import gfx.math.Vector2;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class gfxTextBox extends gfxControl {
	private Pane _layout;
	private TextField _textBox;
	
	public gfxTextBox(String name, Vector2 location, Vector2 size) {
		super(name);
		// TODO Auto-generated constructor stub
		_layout = new Pane();
		_layout.setLayoutX(location.getX());
		_layout.setLayoutY(location.getY());
		
		_textBox = new TextField();
		_textBox.getStyleClass().add("gfx-textbox");
		_textBox.setPrefWidth(size.getX());
		_textBox.setPrefHeight(size.getY());
		_layout.getChildren().add(_textBox);
		this.addControl(_layout);
	}

	@Override
	public Pane getLayout() {
		// TODO Auto-generated method stub
		return _layout;
	}

	@Override
	public void onUpdate(Game game) {
		// TODO Auto-generated method stub

	}

}
