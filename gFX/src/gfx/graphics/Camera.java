package gfx.graphics;

import gfx.GameElement;
import gfx.gfxScene;
import gfx.math.Vector2;
import javafx.scene.Scene;

public class Camera {
    private double x;
    private double y;
    private double width;
    private double height;
    private gfxScene scene;

    public Camera(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Camera(Vector2 location, Vector2 size)
    {
        this.x = location.getX();
        this.y = location.getY();
        this.width = size.getX();
        this.height = size.getY();
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

    public void setViewport(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setViewport(Vector2 location)
    {
        this.x = location.getX();
        this.y = location.getY();
    }

    public void setResolution(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public void changeResolution(double width, double height)
    {
        this.width = width;
        this.height = height;
        this.lookAtViewport();
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

    public void setY(double y) {
        this.y = y;
    }

    public gfxScene getScene() {
        return scene;
    }

    public void setScene(gfxScene scene) {
        this.scene = scene;
    }

    public void transfromCamera(int x, int y) {
        if(this.scene != null) {
            this.x += x;
            this.y += y;

            this.scene.resetTransform();
            this.scene.transformScene(-this.x +(this.width / 2), -this.y + (this.height / 2));
        }
    }

    public void activateCamera() {
        if(this.scene != null) {
            this.scene.resetTransform();
            this.scene.transformScene(-this.x +(this.width / 2), -this.y + (this.height / 2));
        }
    }

    public void lookAtViewport() {
        if(this.scene != null) {
            this.scene.resetTransform();
            this.scene.transformScene(-this.x +(this.width / 2), -this.y + (this.height / 2));
        }
    }

    public void snapToGameElement(GameElement element)
    {
        this.setX(element.getCenterLocation().getX() - scene.getTransform().getX());
        this.setY(element.getCenterLocation().getY() - scene.getTransform().getY());
        this.lookAtViewport();
    }
}
