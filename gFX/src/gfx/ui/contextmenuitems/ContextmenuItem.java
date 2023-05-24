package gfx.ui.contextmenuitems;

import gfx.ui.gfxContextmenu;
import gfx.ui.behavior.ContexmenuItemBehavior;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;

public abstract class ContextmenuItem {
	private String name;
	private String text;
	private ContexmenuItemBehavior behavior;
	private gfxContextmenu menu;
	
	public ContextmenuItem(String name) {
		this.name = name;
	}
	
	public ContextmenuItem(String name, ContexmenuItemBehavior behavior) {
		this.name = name;
		this.behavior = behavior;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ContexmenuItemBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(ContexmenuItemBehavior behavior) {
		this.behavior = behavior;
	}

	public gfxContextmenu getMenu() {
		return menu;
	}

	public void setMenu(gfxContextmenu menu) {
		this.menu = menu;
	}


	public abstract Pane getLayout();
}
