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
