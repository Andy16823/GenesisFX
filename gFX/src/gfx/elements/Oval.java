package gfx.elements;

import gfx.Game;
import gfx.GameElement;
import gfx.RenderTarget;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Oval extends GameElement {
	private Paint fill;
	private Paint stroke;
	
	public Oval(String name, Vector2 location, Vector2 size, Paint fill) {
		super();
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.fill = fill;
	}
	
	public Oval(String name, Vector2 location, Vector2 size, Paint fill, Paint stroke) {
		super();
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.fill = fill;
		this.stroke = stroke;
	}
		
	@Override
	public void render(Game game, GraphicsContext g) {
		// TODO Auto-generated method stub
		
		if(this.fill != null) {
			Paint oldFill = g.getFill();
			g.setFill(fill);
			g.fillOval(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
			g.setFill(oldFill);
		}
		
		if(this.stroke != null) {
			Paint oldStroke = g.getStroke();
			g.setStroke(stroke);
			g.strokeOval(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
			g.setStroke(oldStroke);
		}
		
	}

	@Override
	public void update(Game game, RenderTarget target) {
		// TODO Auto-generated method stub

	}

}
