package gfx;

public interface GameCallbacks {
	public void beforeStart(Game game);
	public void onUpdate(Game game);
	public void beforeRender(Game game);
	public void afterRender(Game game);
	public void onEnd(Game game);
}
