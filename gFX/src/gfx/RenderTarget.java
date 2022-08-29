package gfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Vector;

public abstract class RenderTarget extends Canvas {

	
    public RenderTarget(double width, double height) {
    	super(width, height);
    }
    
    public abstract void render(Game game, gfx.gfxScene scene);
    public abstract void update();
}
