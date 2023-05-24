package gfx;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Vector;

import gfx.graphics.Camera;
import gfx.math.Vector2;
import gfx.ui.gfxControl;

public class gfxScene extends javafx.scene.Scene{
	private Game game;
	private String name;
    private String tag;
    private Vector<Layer> layer;
    private Vector<gfxControl> uiElements;
    private Camera camera;
    private Vector2 transform;
    private Image backgroundPlane;
    private Input input;
    private Group uiNode;
    private Group parent;
    
    public gfxScene(String name, Group parent) {
		super(parent);
		this.name = name;
		this.layer = new Vector<>();
		this.uiElements = new Vector<>();
		this.transform = new Vector2(0,0);
		this.input = new Input();
		this.resetInput();
		this.uiNode = new Group();
		parent.getChildren().add(uiNode);
		this.parent = parent;
	}
    
    public gfxScene(String name) {
		super(new Group());
		this.name = name;
		this.layer = new Vector<>();
		this.uiElements = new Vector<>();
		this.transform = new Vector2(0,0);
		this.input = new Input();
		this.resetInput();
		this.uiNode = new Group();
		parent.getChildren().add(uiNode);
		this.parent = (Group) super.getRoot();
	}
    
    public void init(Game game) {
    	for(Layer l : this.layer) {
    		l.init(game);
    	}
    }

    public void addLayer(Layer layer) {
        this.layer.add(layer);
    }
    
    public void addLayer(String name) {
    	this.layer.add(new Layer(name));
    }
    
    public void recalculate() {
    	this.parent.getChildren().remove(uiNode);
    	this.parent.getChildren().add(uiNode);
    }

    public void renderScene(Game game, GraphicsContext g) {
    	g.getCanvas().setHeight(this.getHeight());
    	g.getCanvas().setWidth(this.getWidth());
    	if(this.backgroundPlane != null) {
    		g.drawImage(backgroundPlane, 0, 0, getWidth(), getHeight());
    	}
        for(Layer layer1 : this.layer) {
            if(layer1.isEnabled()) {
                layer1.renderLayer(game, g);
            }
        }
    }

    public void updateScene(Game game, RenderTarget renderTarget) {
    	if(!game.isPause()) {
            for(Layer layer1 : this.layer) {
                if(layer1.isEnabled()) {
                    layer1.updateLayer(game, renderTarget);
                }
            }
            for(gfxControl control : this.uiElements) {
            	control.onUpdate(game);
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
    
    public GameElement addGameElment(String layername, GameElement element) {
    	Layer layerToInsert = this.getLayer(layername);
    	if(layerToInsert != null) {
    		layerToInsert.addGameElement(element);
    		return element;
    	}
    	return null;
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

	public Camera getGfxCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
		this.camera.setScene(this);
	}
	
	public Camera createCamera(double width, double height) {
		this.camera = new Camera(0,0,width, height);
		this.camera.setScene(this);
		return camera;
	}
	
	public GameElement getElement(int layer, String name) {
		return this.layer.get(layer).getElement(name);
	}
	
	public GameElement getElement(String layer, String name) {
		return this.getLayer(layer).getElement(name);
	}
	
	public GameElement getElement(String element) {
		String[] query = element.split(".");
		return this.getElement(query[0], query[1]);
	}
	
	public boolean removeElement(GameElement element) {
		for(var layer : this.layer) {
			if(layer.getGameElements().contains(element)) {
				layer.getGameElements().remove(element);
				return true;
			}
		}
		return false;
	}
	
	public void addUIElement(gfxControl element) {
		this.uiElements.add(element);
		this.getUI().getChildren().add(element);
		element.setGame(game);
		element.setScene(this);
	}
	
	public gfxControl getUIElement(String name) {
		for(var element : this.uiElements) {
			if(element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}
	
	public void removeElement(gfxControl element) {
		this.getUI().getChildren().remove(element);
		this.uiElements.remove(element);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
		
}
