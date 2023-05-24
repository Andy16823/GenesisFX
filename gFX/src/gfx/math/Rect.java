package gfx.math;

public class Rect {
	private double x;
	private double y;
	private double width;
	private double height;
	
	public Rect() {
		
	}
	
	public Rect(double x, double y, double width, double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public Vector2 getTopLeft() {
		return new Vector2(x,y);
	}
	
	public Vector2 getTopRight() {
		return new Vector2(x + width,y);
	}
	
	public Vector2 getBottomRight() {
		return new Vector2(x + width,y + height);
	}
	
	public Vector2 getBottomLeft() {
		return new Vector2(x,y + height);
	}
	
	public boolean contains(Vector2 ref) {
		return this.contains(ref.getX(), ref.getY());
	}
	
	public boolean contains(Vector2[] ref) {
		for(var vec2 : ref) {
			if(this.contains(vec2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(double x, double y) {
		if(x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
			return true;
		}
		return false;
	}
	
	public boolean contains(double refX, double refY, double x, double y) {
		if(x > refX && x < refX + this.width && y > refY && y < refY + this.height) {
			return true;
		}
		return false;
	}
	
	public boolean intersects(Rect ref) {
		if(this.getX() > (ref.getWidth() + ref.getX()) || this.getY() + this.getHeight() < ref.getY() || ref.getX() > this.getWidth() + this.getX()	|| ref.getY() + ref.getHeight() < this.getY())
		{
			return false;
		}
		
		return true;
	}
	
	public void addX(double value) {
		this.x += value;
	}
	
	public void addY(double value) {
		this.y += value;
	}
	
	public void add(double valueX,double valueY) {
		this.x += valueX;
		this.y += valueY;
	}
	
	public Rect duplicate() {
		return new Rect(x,y,width, height);
	}
	
	
}
