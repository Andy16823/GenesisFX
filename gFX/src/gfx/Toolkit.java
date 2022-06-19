package gfx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Toolkit {
	
	public static void log(String value) {
		String date = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
		System.out.println("[" + date + "] : " + value);
	}
	
}
