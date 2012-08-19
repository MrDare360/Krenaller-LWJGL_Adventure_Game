package uk.co.hotmail.toxiclogic;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class FontManager {
	
	/** Font image **/
	private Texture fontImage;
	/** Text Positions And Spacing **/
	public static Vector2f positions = new Vector2f();
	public static int spacing = 20;
	
	public FontManager() {
		
		try {
			fontImage = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/font.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public int getCoordByCharacter(char c) {
        int i = 0;
       
        if(c >= 'a' && c <= 'z') {
                i = c - 'a' + 1;
        } else if(c >= 'A' && c <= 'Z') {
                i = c - 'A' + 1;
        } else {
                System.out.println("Character '" + c + "' Is not supported in the font manager!");
                i = 404;
        }

        return i;
}
	
	public void drawString(String text, int x, int y) {
		
		positions.x = x;
		positions.y = y;
		
		fontImage.bind();
		
		for(int i = 0; i < text.length(); i++) {
			if(getCoordByCharacter(text.charAt(i)) == 404) {
				return;
			} else {
				GL11.glBegin(GL11.GL_QUADS);
					GL11.glTexCoord2f(0, 0);
					GL11.glVertex2f(positions.x, positions.y);
					GL11.glTexCoord2f(1, 0);
					GL11.glVertex2f(positions.x + fontImage.getTextureWidth(), positions.y);
					GL11.glTexCoord2f(1, 1);
					GL11.glVertex2f(positions.x + fontImage.getTextureWidth(), positions.y + fontImage.getTextureHeight());
					GL11.glTexCoord2f(0, 1);
					GL11.glVertex2f(positions.x, positions.y + fontImage.getTextureHeight());
				GL11.glEnd();
			}
			
		}
		
	}
	
	
	
	
	
}
