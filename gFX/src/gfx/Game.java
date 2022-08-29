package gfx;

import java.util.Vector;

import javafx.scene.Group;
import javafx.stage.Stage;

public class Game {
	private Stage stage;
	private Vector<gfxScene> scenes;
	private Group root;
	private RenderTarget renderTarget;
	private Timer timer;
	private boolean running;
	private gfxScene selectedScene;
	private GameCallbacks callbacks;
	private RessourceManager assets;
	private Storage storage;
	private boolean pause;
	
	public Game(RenderTarget renderTarget, int maxFps, GameCallbacks callbacks) {
		this.scenes = new Vector<>();
		this.renderTarget = renderTarget;
		this.timer = new gfx.Timer(maxFps, this);
		this.callbacks = callbacks;
		this.assets = new RessourceManager();
		this.root = new Group();
		this.root.getChildren().add(renderTarget);
		this.storage = new Storage(this);
		
	}
	
	public Game(int width, int height, int maxFps, Stage stage, GameCallbacks callbacks) {
		this.scenes = new Vector<>();
		this.renderTarget = new gfx.graphics.GraphicsContext2D(width, height);
		this.timer = new gfx.Timer(maxFps, this);
		this.callbacks = callbacks;
		this.assets = new RessourceManager();
		this.root = new Group();
		this.root.getChildren().add(renderTarget);
		this.storage = new Storage(this);
		this.stage = stage;
	}
	
	public void start() {
		this.running = true;
		if(callbacks != null) {
			this.callbacks.beforeStart(this);
		}
		for(var scene : this.scenes) {
			scene.init(this);
		}
		long timestamp = System.currentTimeMillis() / 1000;
		this.timer.setTimestamp(timestamp);
		this.timer.start();
	}
	
	public void update() {
		if(callbacks != null) {
			this.callbacks.onUpdate(this);
		}
		this.selectedScene.updateScene(this, renderTarget);
		this.storage.clearElements();
	}
	
	public void render() {
		if(callbacks != null) {
			this.callbacks.beforeRender(this);
		}
		this.renderTarget.render(this, selectedScene);
		if(callbacks != null) {
			this.callbacks.afterRender(this);
		}
	}
	
    public gfxScene getScene(String name) {
    	for(gfxScene scene : this.scenes) {
    		if(scene.getName().equals(name)) {
    			return scene;
    		}
    	}
    	return null;
    }
    
    public void loadScene(String name) {
    	this.selectedScene = this.getScene(name);
    	this.root = this.selectedScene.getParent();
    	this.root.getChildren().add(renderTarget);
    	this.selectedScene.recalculate();
    	this.stage.setScene(selectedScene);
    }
	
	public Vector<gfxScene> getScenes() {
		return scenes;
	}
	public void setScenes(Vector<gfxScene> scenes) {
		this.scenes = scenes;
	}
	public RenderTarget getRenderTarget() {
		return renderTarget;
	}
	public void setRenderTarget(RenderTarget renderTarget) {
		this.renderTarget = renderTarget;
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	public gfxScene getSelectedScene() {
		return selectedScene;
	}
	public void setSelectedScene(gfxScene selectedScene) {
		this.selectedScene = selectedScene;
	}
	public void addScene(gfxScene scene) {
		this.scenes.add(scene);
	}
	public void end() {
		if(callbacks != null) {
			this.callbacks.onEnd(this);
		}
		this.running = false;
	}

	public RessourceManager getAssets() {
		return assets;
	}

	public Group getRoot() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}

	public Storage getStorage() {
		return storage;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	public Stage getStage() {
		return this.stage;
	}
		
}
