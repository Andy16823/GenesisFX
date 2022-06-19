package gfx;

import java.util.Vector;

import javafx.scene.input.MouseButton;

public class Input {
    private double MouseX;
    private double MouseY;
    private boolean MouseInput;
    private MouseButton mouseButton;
    private Vector<Integer> keysDown;

    public Input() {
        this.keysDown = new Vector<>();
    }
    
    public boolean isIsInput() {
        if(this.keysDown.isEmpty()) {
        	return false;
        }
        else {
        	return true;
        }
    }

    public void setInputKey(int InputKey) {
        if(!this.keysDown.contains(InputKey)) {
            this.keysDown.add(InputKey);
        }
    }

    public void removeInputKey(int Key) {
        if(this.keysDown.contains(Key)) {
            this.keysDown.remove(Integer.valueOf(Key));
        }
    }

    public boolean isKeyDown(int key) {
        return this.keysDown.contains(key);
    }
    
    public boolean isKeyDown(int key, boolean clearInput) {
    	boolean isKeyDown = this.keysDown.contains(key);
    	if(clearInput) {
    		this.removeInputKey(key);
    	}
        return isKeyDown;
    }
    
    public void setMouseCord(double x, double y) {
    	this.MouseX = x;
    	this.MouseY = y;
    }
    
    public double getMouseX() {
        return MouseX;
    }

    public void setMouseX(double MouseX) {
        this.MouseX = MouseX;
    }

    public double getMouseY() {
        return MouseY;
    }

    public void setMouseY(double MouseY) {
        this.MouseY = MouseY;
    }

    public boolean isMouseInput() {
        return MouseInput;
    }

    public void setMouseInput(boolean MouseInput) {
        this.MouseInput = MouseInput;
    }

    
    public MouseButton getMouseButton() {
    	MouseButton button = this.mouseButton;
    	this.mouseButton = null;
		return button;
	}
    
    public void clearMouseButton() {
    	this.mouseButton = null;
    }

	public void setMouseButton(MouseButton mouseButton) {
		this.mouseButton = mouseButton;
	}

	public void clearInput() {
        this.MouseX = 0;
        this.MouseY = 0;
        this.mouseButton = null;
        this.MouseInput = false;
    }
}
