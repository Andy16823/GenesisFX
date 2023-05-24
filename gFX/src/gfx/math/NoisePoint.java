package gfx.math;

public class NoisePoint {
	private float x;
	private float y;
	private float value;
	
	
	public NoisePoint(float x, float y, float value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}


	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public float getValue() {
		return value;
	}


	public void setValue(float value) {
		this.value = value;
	}
}
