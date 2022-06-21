package gfx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
}
