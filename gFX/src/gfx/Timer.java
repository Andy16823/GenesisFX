package gfx;

import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {
	private long maxFps;
    private Game game;
    private long timestamp;
    private int fps;
    private int stableFps;
    private long lastFrame;
    private long deltaTime;
    private long currentFrame;
    private long frameTime;

    public Timer(long maxFps, Game parent) {
        this.maxFps = maxFps;
        this.game = parent;
        this.timestamp = 0;
        this.fps = 0;
        this.stableFps = 0;
    }
    
    public int getFps() {
        return stableFps;
    }

    public long getDeltaTime() {
        return deltaTime;
    }

	@Override
	public void handle(long arg0) {
		// TODO Auto-generated method stub
        if(game.isRunning()) {
            this.frameTime = 1000 / maxFps;
            this.currentFrame = System.currentTimeMillis();
            long currentTime = currentFrame / 1000;

            if(this.currentFrame > this.lastFrame + this.frameTime) {
                if(currentTime >= timestamp + 1)
                {
                    this.stableFps = fps;
                    this.fps = 0;
                    this.timestamp = System.currentTimeMillis() / 1000;
                }
                else {
                    this.fps += 1;
                }

                this.game.update();
                this.game.render();
                this.deltaTime = currentFrame - lastFrame;
                this.lastFrame = currentFrame;
            }
        }
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getMaxFps() {
		return maxFps;
	}

	public void setMaxFps(long maxFps) {
		this.maxFps = maxFps;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getStableFps() {
		return stableFps;
	}

	public void setStableFps(int stableFps) {
		this.stableFps = stableFps;
	}

	public long getLastFrame() {
		return lastFrame;
	}

	public void setLastFrame(long lastFrame) {
		this.lastFrame = lastFrame;
	}

	public long getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(long currentFrame) {
		this.currentFrame = currentFrame;
	}

	public long getFrameTime() {
		return frameTime;
	}

	public void setFrameTime(long frameTime) {
		this.frameTime = frameTime;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public void setDeltaTime(long deltaTime) {
		this.deltaTime = deltaTime;
	}

}
