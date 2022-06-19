package gfx.graphics;

import javafx.scene.canvas.GraphicsContext;

public class GraphicsContext2D extends gfx.RenderTarget {

	public GraphicsContext2D(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(gfx.gfxScene scene) {
        GraphicsContext context = this.getGraphicsContext2D();
        context.clearRect(0, 0, this.getWidth(), this.getHeight());
        scene.renderScene(context);		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
