package gfx.graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;

public class gfxImage extends WritableImage{
	private Canvas renderTarget;
	private GraphicsContext graphicsContex;
	
	public gfxImage(int arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		this.renderTarget = new Canvas(arg0, arg1);
		this.graphicsContex = renderTarget.getGraphicsContext2D();
	}
	
		
	public Canvas getRenderTarget() {
		return renderTarget;
	}



	public void setRenderTarget(Canvas renderTarget) {
		this.renderTarget = renderTarget;
	}



	public GraphicsContext getGraphicsContex() {
		return graphicsContex;
	}



	public void setGraphicsContex(GraphicsContext graphicsContex) {
		this.graphicsContex = graphicsContex;
	}



	public void flush() {
		renderTarget.snapshot(null, this);
	}
	
}
