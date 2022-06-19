package gfx;

import java.io.File;
import java.net.URL;
import java.util.Vector;

import javafx.scene.image.Image;

public class RessourceManager {
	private Vector<Ressource> ressources;
	
	public RessourceManager() {
		this.ressources = new Vector<>();
	}
	
	public void addRessource(Ressource ressource) {
		this.ressources.add(ressource);
		Toolkit.log("ressouce " + ressource.getName() + " loaded");
	}
	
	public Ressource getRessource(String name) {
		for(Ressource res : this.ressources) {
			if(res.getName().equals(name)) {
				return res;
			}
		}
		return null;
	}
}
