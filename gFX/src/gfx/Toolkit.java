package gfx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import gfx.math.Vector2;

public class Toolkit {
	
	public static void log(String value) {
		String date = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
		System.out.println("[" + date + "] : " + value);
	}
	
	public static boolean isVisible(double x, double y, double width, double height, double sWidth, double sHeight) {
		if(x > 0 && y > 0 && x + width < sWidth && y + height < sHeight) {
			return true;
		}
		return false;
	}
	
	public static Vector<GameElement> getNearbyElements(Vector<GameElement> elementsToCheck, Vector2 location, double distance) {
		Vector<GameElement> nearbyElements = new Vector<>();
		for(GameElement element : elementsToCheck) {
			if(Vector2.getDistance(location, element.getCenterLocation()) <= distance) 
			{
				nearbyElements.add(element);
			}
		}
		return nearbyElements;
	}
	
}
