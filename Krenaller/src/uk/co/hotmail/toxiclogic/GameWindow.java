package uk.co.hotmail.toxiclogic;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GameWindow {

	/** Krenaller Instance **/
	public static Krenaller krenallerInstance;
	static int width;
	static int height;
	
	public GameWindow(Krenaller krenaller, int width, int height) {
		
		krenallerInstance = krenaller;
		GameWindow.width = width;
		GameWindow.height = height;
		
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Krenaller");
			Display.setResizable(false);
			Display.create();
			
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 0, 600, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			
			while(!Display.isCloseRequested()) {
				//Render
				
				RenderEngine.render(krenallerInstance, width, height);
				
				Display.update();
				Display.sync(100);
			}
			
			Display.destroy();
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
