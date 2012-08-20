package uk.co.hotmail.toxiclogic;

import org.lwjgl.LWJGLException;
import static org.lwjgl.opengl.ARBTextureRectangle.*;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

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
			
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			glEnable(GL_TEXTURE_RECTANGLE_ARB);
			glEnable(GL_CULL_FACE);
	        glCullFace(GL_BACK);
	        
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, 800, 0, 600, 1, -1);
			glMatrixMode(GL_MODELVIEW);
			
			new RenderEngine();
			
			while(!Display.isCloseRequested()) {
				glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
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
