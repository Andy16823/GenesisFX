package gfx.ui;

import java.util.Vector;

import gfx.Game;
import gfx.math.Vector2;
import gfx.ui.behavior.gfxListItemBehavior;
import gfx.ui.behavior.gfxListViewBehavior;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class gfxListView extends gfxControl {
	private Pane _layout;
	private ScrollPane _scrollArea;
	private VBox _content;
	private Vector<ListItem> _items;
	private gfxListViewBehavior _listener;
	private ListItem _selectedItem;
	
	public gfxListView(String name, Vector2 location, Vector2 size) {
		super(name);
		_items = new Vector<>();
				
		_layout = new Pane();
		_layout.setLayoutX(location.getX());
		_layout.setLayoutY(location.getY());
		_layout.getStyleClass().add("gfxListView");
		
		
		_scrollArea = new ScrollPane();
		_scrollArea.setPrefSize(size.getX(), size.getY());
		_scrollArea.getStyleClass().add("gfxListView-scroll-area");
		_scrollArea.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		_layout.getChildren().add(_scrollArea);
		
		
		_content = new VBox();
		_content.getStyleClass().add("gfxListView-content-area");
		_content.setPrefWidth(size.getX());
		_scrollArea.setContent(_content);
		
		this.addControl(_layout);
		// TODO Auto-generated constructor stub
	}

	public void addItem(ListItem item) {
		_items.add(item);
		item.setItemBehavior(new gfxListItemBehavior() {
			@Override
			public void onClick(ListItem item) {
				// TODO Auto-generated method stub
				gfxListView.this.selectItem(item);
			}
		});
		refresh();
	}
	
	public void setListViewBehavior(gfxListViewBehavior event) {
		_listener = event;
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
	
	private void refresh() {
		_content.getChildren().clear();
		for(var item : _items) {
			_content.getChildren().add(item.getItemLayout());
		}
	}
	
	private void selectItem(ListItem item) {
		_selectedItem = item;
		for(var i : _items) {
			i.getItemLayout().getStyleClass().remove("gfxListItem-selected");
		}
		_selectedItem.getItemLayout().getStyleClass().add("gfxListItem-selected");
		
		if(this._listener != null) {
			_listener.onItemChanged(this, item);
		}
	}
	
}
