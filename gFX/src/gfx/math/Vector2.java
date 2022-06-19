package gfx.math;

public class Vector2 {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
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

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }
    
    public static Vector2 zero() {
    	return new Vector2(0,0);
    }
    
    public Vector2 duplicate() {
    	return new Vector2(x, y);
    }

}
