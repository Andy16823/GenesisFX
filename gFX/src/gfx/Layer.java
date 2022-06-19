package gfx;

import javafx.scene.canvas.GraphicsContext;

import java.util.Vector;

import gfx.math.Vector2;

public class Layer {
    private String name;
    private String tag;
    private boolean enabled = true;
    private Vector<GameElement> gameElements;
    private Vector2 transform;

    public Layer(String name) {
        this.name = name;
        this.gameElements = new Vector<>();
        this.transform = new Vector2(0,0);
    }
    
    public void init(Game game) {
    	for(GameElement e : this.gameElements) {
    		e.init(game);
    	}
    }

    public void renderLayer(GraphicsContext g) {
       for(GameElement element : this.gameElements) {
           if(element.isEnabled()) {
               element.render(g);
           }
       }
    }

    public void updateLayer(RenderTarget renderTarget) {
        for(GameElement element : this.gameElements) {
            if(element.isEnabled()) {
                element.update(renderTarget);
            }
        }
    }
    
    public void transformLayer(double x, double y) {
        for(GameElement e : this.gameElements) {
        	e.getLocation().addX(x);
            e.getLocation().addY(y);
        }
    }

    public void addGameElement(GameElement element) {
        this.gameElements.add(element);
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Vector<GameElement> getGameElements() {
        return gameElements;
    }

    public void setGameElements(Vector<GameElement> gameElements) {
        this.gameElements = gameElements;
    }
}
