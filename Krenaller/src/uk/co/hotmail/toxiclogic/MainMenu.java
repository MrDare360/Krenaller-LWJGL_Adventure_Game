package uk.co.hotmail.toxiclogic;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class MainMenu {

	static boolean ingame = false;
	
	public static void render(Krenaller krenaller, int width, int height) {
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(100, 100);
			GL11.glVertex2f(100 + 100, 100);
			GL11.glVertex2f(100 + 100, 100 + 100);
			GL11.glVertex2f(100, 100 + 100);
		GL11.glEnd();
		
		if(Mouse.getX() >= 100 && Mouse.getX() <= 200) {
			if(Mouse.getY() >= 100 && Mouse.getY() <= 200) {
				if(Mouse.isButtonDown(0)) {
					ingame = true;
					RenderEngine.ingame = 2;
				}
			}
		}
		
	}
	
}
