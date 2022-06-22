package gfx;


public class AudioRessource extends Ressource {

	public AudioRessource(String name, gfxAudioClip animation) {
		this.setName(name);
		this.setValue(animation);
	}
		
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		super.setValue((gfxAudioClip)value);
	}

	@Override
	public gfxAudioClip getValue() {
		// TODO Auto-generated method stub
		return (gfxAudioClip) super.getValue();
	}
		
}
