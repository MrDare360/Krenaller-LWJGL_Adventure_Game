package uk.co.hotmail.toxiclogic;

import org.newdawn.slick.SpriteSheet;

public class ResourceManager {
	
	private static int width = 16;
	private static int height = 16;
	
	public static SpriteSheet glLoadSpriteSheet(String location) throws Exception{
        
		SpriteSheet spriteSheet = new SpriteSheet(location, width, height);
        
        return spriteSheet;
    }
	
}
