package gfx.ui;

import gfx.ui.behavior.gfxListItemBehavior;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public abstract class ListItem {
	private String name;
	private String tag;
	private gfxListItemBehavior behavior;
	
	
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
	
	public void setItemBehavior(gfxListItemBehavior behavior) {
		this.behavior = behavior;
	}
	
	public gfxListItemBehavior getItemBehavior() {
		return this.behavior;
	}
	
	public abstract Pane getItemLayout();

}
