package gfx;

import javafx.scene.image.Image;

public class ImageRessource extends Ressource {
		
	public ImageRessource(String name, Image image) {
		this.setName(name);
		this.setValue(image);
	}
	
	public ImageRessource(String name) {
		this.setName(name);
		this.setValue(new Image(name));
	}
	
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		super.setValue((Image)value);
	}

	@Override
	public Image getValue() {
		// TODO Auto-generated method stub
		return (Image) super.getValue();
	}

}
