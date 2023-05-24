package gfx.ui.contextmenuitems;

import gfx.ui.behavior.ContexmenuItemBehavior;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class BasicItem extends ContextmenuItem{
	private Pane layout;
	private Label textLabel;
	
	public BasicItem(String name, String text, ContexmenuItemBehavior behavior) {
		super(name, behavior);
		
		// TODO Auto-generated constructor stub
		layout = new Pane();
		textLabel = new Label(text);
		
		textLabel.setStyle(""
				+ "-fx-text-fill: white;"
				+ "-fx-padding: 5px 5px 5px 5px;");
		
		layout.getChildren().add(textLabel);
				
		layout.setOnMouseEntered(e -> {
			layout.setStyle(""
					+ "-fx-background-color: #1E2D32;");
		});
		
		layout.setOnMouseExited(e -> {
			layout.setStyle(""
					+ "-fx-background-color: inherit;");
		});
		
		this.setText(text);
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		super.setText(text);
		this.textLabel.setText(text);
	}

	@Override
	public Pane getLayout() {
		// TODO Auto-generated method stub
		return layout;
	}
	

}
