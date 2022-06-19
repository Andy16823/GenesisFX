package gfx.elements;

import gfx.GameElement;
import gfx.RenderTarget;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Rectangle extends GameElement {
	private Paint fill;
	private Paint stroke;
	
	public Rectangle(String name, Vector2 location, Vector2 size, Paint fill) {
		super();
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.fill = fill;
	}
	
	public Rectangle(String name, Vector2 location, Vector2 size, Paint fill, Paint stroke) {
		super();
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.fill = fill;
		this.stroke = stroke;
	}

	@Override
	public void render(GraphicsContext g) {
		// TODO Auto-generated method stub
		
		if(this.fill != null) {
			Paint oldFill = g.getFill();
			g.setFill(fill);
			g.fillRect(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
			g.setFill(oldFill);
		}
		
		if(this.stroke != null) {
			Paint oldStroke = g.getStroke();
			g.setStroke(stroke);
			g.strokeRect(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
			g.setStroke(oldStroke);
		}

	}

	@Override
	public void update(RenderTarget target) {
		// TODO Auto-generated method stub

	}

	public Paint getFill() {
		return fill;
	}

	public void setFill(Paint paint) {
		this.fill = paint;
	}

	public Paint getStroke() {
		return stroke;
	}

	public void setStroke(Paint stroke) {
		this.stroke = stroke;
	}	
}
