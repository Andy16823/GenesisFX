package gfx;

import gfx.graphics.Animation;

public class AnimationRessource extends Ressource {

	public AnimationRessource(String name, Animation animation) {
		this.setName(name);
		this.setValue(animation);
	}
		
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		super.setValue((Animation)value);
	}

	@Override
	public Animation getValue() {
		// TODO Auto-generated method stub
		return (Animation) super.getValue();
	}
	
}
