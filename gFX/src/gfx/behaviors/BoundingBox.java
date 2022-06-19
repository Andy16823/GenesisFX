package gfx.behaviors;

import gfx.Game;
import gfx.GameBehavior;
import gfx.RenderTarget;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class BoundingBox extends GameBehavior {

	@Override
	public void onInit(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpdate(RenderTarget renderTarget) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeRender(GraphicsContext g) {
		// TODO Auto-generated method stub
		Paint oldPaint = g.getStroke();
		g.setStroke(Color.BLUE);
		g.strokeRect(this.getParent().getLocation().getX(), this.getParent().getLocation().getY(), this.getParent().getSize().getX(), this.getParent().getSize().getY());
		g.setStroke(oldPaint);
	}

	@Override
	public void afterRender(GraphicsContext g) {
		// TODO Auto-generated method stub

	}

}
