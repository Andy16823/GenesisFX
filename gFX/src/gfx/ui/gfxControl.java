package gfx.ui;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class gfxControl extends Group{
	private String name;
	private Pane layout;
	private long lastToggle;
	
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
	
	public void toggleVisibility() {
		long now = System.currentTimeMillis();
		if(now > lastToggle + 1000) {
			if(this.isVisible()) {
				this.setVisible(false);
			}
			else {
				this.setVisible(true);
			}
			this.lastToggle = now;
		}
	}

	public abstract Pane getLayout();
		
}
