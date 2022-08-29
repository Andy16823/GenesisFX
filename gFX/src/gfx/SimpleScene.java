package gfx;

import gfx.graphics.Camera;
import gfx.math.Vector2;
import javafx.scene.Group;

public class SimpleScene extends gfxScene {
	private Camera _cam;
	
	public SimpleScene(String name, Vector2 screenSize) {
		super(name, new Group());
		_cam = new Camera(Vector2.zero(), screenSize);
		_cam.setScene(this);
		// TODO Auto-generated constructor stub
	}
	
	public Camera getSceneCamera() {
		return _cam;
	}
	
}
