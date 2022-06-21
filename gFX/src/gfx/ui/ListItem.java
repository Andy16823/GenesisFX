package gfx.ui;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public abstract class ListItem {
	private String name;
	private String tag;
	
	
	public ListItem(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public abstract Pane getItemLayout();

}
