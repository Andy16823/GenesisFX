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
    
    public static double getDistance(Vector2 e1, Vector2 e2) {
    	double distX = e2.getX() - e1.getX();
        double distY = e2.getY() - e1.getY();

        return Math.sqrt((distX * distX) + (distY * distY));
    }
    
    public static double getDegrees(Vector2 e1, Vector2 e2) {
    	double elementX = e1.getX();
    	double elementY = e1.getY();
    	double refX = e2.getX();
    	double refY = e2.getY();
        float radians = (float) Math.atan2(refY - elementY, refX - elementX);
        float deg = (float) Math.toDegrees(radians);
        return deg;
    }

}
