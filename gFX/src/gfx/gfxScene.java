package gfx;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Vector;

import gfx.math.Vector2;

public class gfxScene extends javafx.scene.Scene{
	private String name;
    private String tag;
    private Vector<Layer> layer;
    private Vector2 transform;
    private Image backgroundPlane;
    private Input input;
    private Group uiNode;
    private Group parent;
    
    public gfxScene(String name, Group parent) {
		super(parent);
		this.name = name;
		this.layer = new Vector<>();
		this.transform = new Vector2(0,0);
		this.input = new Input();
		this.resetInput();
		this.uiNode = new Group();
		parent.getChildren().add(uiNode);
		this.parent = parent;
	}
    
    public void init(Game game) {
    	for(Layer l : this.layer) {
    		l.init(game);
    	}
    }

    public void addLayer(Layer layer) {
        this.layer.add(layer);
    }

    public void renderScene(GraphicsContext g) {
    	g.getCanvas().setHeight(this.getHeight());
    	g.getCanvas().setWidth(this.getWidth());
    	if(this.backgroundPlane != null) {
    		g.drawImage(backgroundPlane, 0, 0, getWidth(), getHeight());
    	}
        for(Layer layer1 : this.layer) {
            if(layer1.isEnabled()) {
                layer1.renderLayer(g);
            }
        }
    }

    public void updateScene(RenderTarget renderTarget) {
        for(Layer layer1 : this.layer) {
            if(layer1.isEnabled()) {
                layer1.updateLayer(renderTarget);
            }
        }
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

    public Vector<Layer> getLayer() {
        return layer;
    }

    public void setLayer(Vector<Layer> layer) {
        this.layer = layer;
    }
    
    public Layer getLayer(String layername) {
    	for(Layer l : this.layer) {
    		if(l.getName().equals(layername)) {
    			return l;
    		}
    	}
    	return null;
    }
    
    public void addGameElment(String layername, GameElement element) {
    	Layer layerToInsert = this.getLayer(layername);
    	if(layerToInsert != null) {
    		layerToInsert.addGameElement(element);
    	}
    }
    
    public void transformScene(double x, double y)
    {
        this.transform.addX(x);
        this.transform.addY(y);

        for(Layer layer : this.layer) {
            layer.transformLayer(x, y);
        }
    }

    public void resetTransform() {
        this.transformScene(-this.transform.getX(), -this.transform.getY());
    }


	public Vector2 getTransform() {
		return transform;
	}


	public void setTransform(Vector2 transform) {
		this.transform = transform;
	}


	public Image getBackgroundPlane() {
		return backgroundPlane;
	}


	public void setBackgroundPlane(Image backgroundPlane) {
		this.backgroundPlane = backgroundPlane;
	}


	public Input getInput() {
		return input;
	}


	public void setInput(Input input) {
		this.input = input;
	}
    
	public void resetInput() {
		this.setOnKeyPressed(e -> {
			this.input.setInputKey(e.getCode().getCode());
		});
		this.setOnKeyReleased(e -> {
			this.input.removeInputKey(e.getCode().getCode());
		});
		this.setOnMouseClicked(e -> {
			this.input.setMouseX(e.getX());
			this.input.setMouseY(e.getY());
			this.input.setMouseButton(e.getButton());
		});
		this.setOnMouseMoved(e -> {
			this.input.setMouseX(e.getX());
			this.input.setMouseY(e.getY());
		});
	}

	public Group getUI() {
		return uiNode;
	}

	public void setUI(Group uiNode) {
		this.uiNode = uiNode;
	}

	public Group getUiNode() {
		return uiNode;
	}

	public void setUiNode(Group uiNode) {
		this.uiNode = uiNode;
	}

	public Group getParent() {
		return parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}
	
	public void addCanvas(Canvas canvas) {
		this.getParent().getChildren().add(canvas);
	}
		
}
