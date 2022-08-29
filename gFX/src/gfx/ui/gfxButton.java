package gfx.ui;

import gfx.Game;
import gfx.math.Vector2;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class gfxButton extends gfxControl {
	private BorderPane _layout;
	private Button _button;
	
	public gfxButton(String name, String text, Vector2 location, Vector2 size) {
		super(name);
		_layout = new BorderPane();
		_layout.setLayoutX(location.getX());
		_layout.setLayoutY(location.getY());
		
		_button = new Button(text);
		_button.setPrefSize(size.getX(), size.getY());
		_button.getStyleClass().add("gfxButton");
		_layout.setCenter(_button);
		
		this.addControl(_layout);
		// TODO Auto-generated constructor stub
	}
	
	public void setOnMouseClicked(MouseEvent handler) {
		_button.setOnMouseClicked((EventHandler<? super MouseEvent>) handler);
	}
	
	public Button getButton() {
		return _button;
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
