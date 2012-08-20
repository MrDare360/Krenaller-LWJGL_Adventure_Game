package uk.co.hotmail.toxiclogic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import static org.lwjgl.opengl.ARBTextureRectangle.*;
import static org.lwjgl.opengl.GL11.*;

public class RenderEngine {
	
	public static Krenaller krenallerInstance;
	public static int ingame = 1;
	public static int spritesheet;
	public static Map<String, Sprite> spriteMap = new HashMap<String, Sprite>();
	public static Sprite currentSprite;
	private static final String SPRITESHEET_IMAGE_LOCATION = "res/terrain.png";
    private static final String SPRITESHEET_XML_LOCATION = "res/terrain.xml";
	
	public RenderEngine() {
		
		setUpSpriteSheets();
		
	}
	
	public static void render(Krenaller krenaller, int width, int height) {
		
		if(ingame == 1) {
			renderMainMenu(krenaller, width, height);
		}else {
			renderIngame(krenaller, width, height);
		}
		
		

		
	}
	
	private static void renderIngame(Krenaller krenaller, int width, int height) {
		bindAndDraw("grass");
	}

	private static void renderMainMenu(Krenaller krenaller, int width, int height) {
		MainMenu.render(krenaller, width, height);
	}

	public static void setTexture(String texture) {
		
	}
	
	private static void setUpSpriteSheets() {
        spritesheet = ResourceManager.glLoadLinearPNG(SPRITESHEET_IMAGE_LOCATION);
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(new File(SPRITESHEET_XML_LOCATION));
            Element root = document.getRootElement();
            for (Object spriteObject : root.getChildren()) {
                Element spriteElement = (Element) spriteObject;
                String name = spriteElement.getAttributeValue("n");
                int x = spriteElement.getAttribute("x").getIntValue();
                int y = spriteElement.getAttribute("y").getIntValue();
                int w = spriteElement.getAttribute("w").getIntValue();
                int h = spriteElement.getAttribute("h").getIntValue();
                Sprite sprite = new Sprite(name, x, y, w, h);
                spriteMap.put(sprite.getName(), sprite);
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void bindAndDraw(String spriteName) {
		
		currentSprite = spriteMap.get(spriteName);
		
		glBindTexture(GL_TEXTURE_RECTANGLE_ARB, spritesheet);

        int x = currentSprite.getX();
        int y = currentSprite.getY();
        int x2 = currentSprite.getX() + currentSprite.getWidth();
        int y2 = currentSprite.getY() + currentSprite.getHeight();

        glBegin(GL_QUADS);
        	glTexCoord2f(x, y);
        	glVertex2f(-1, 1);
        	glTexCoord2f(x, y2);
        	glVertex2f(-1, -1);
        	glTexCoord2f(x2, y2);
        	glVertex2f(1, -1);
        	glTexCoord2f(x2, y);
        	glVertex2f(1, 1);
        glEnd();

        glBindTexture(GL_TEXTURE_RECTANGLE_ARB, 0);
		
	}
	
}
