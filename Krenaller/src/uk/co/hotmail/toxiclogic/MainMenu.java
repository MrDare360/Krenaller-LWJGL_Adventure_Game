package uk.co.hotmail.toxiclogic;

import org.lwjgl.opengl.GL11;

public class MainMenu {

	public static void render(Krenaller krenaller, int width, int height) {
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(100, 100);
			GL11.glVertex2f(100 + 100, 100);
			GL11.glVertex2f(100 + 100, 100 + 100);
			GL11.glVertex2f(100, 100 + 100);
		GL11.glEnd();
		
	}
	
}
