package gfx.ui;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class gfxControl extends Group{
	private String name;
	private Pane layout;
	
	public gfxControl(String name) {
		this.name = name;
	}
		
	public void addControl(Node node) {
		this.getChildren().add(node);
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLayout(Pane layout) {
		this.layout = layout;
	}

	public abstract Pane getLayout();
		
}
