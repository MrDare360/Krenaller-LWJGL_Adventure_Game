package uk.co.hotmail.toxiclogic;

import org.lwjgl.opengl.GL11;

public class RenderEngine {
	
	public static Krenaller krenallerInstance;
	public static int ingame = 1;
	
	public RenderEngine() {
		
		
		
	}
	
	public static void render(Krenaller krenaller, int width, int height) {
		
		if(ingame == 1) {
			renderMainMenu(krenaller, width, height);
		}else {
			renderIngame(krenaller, width, height);
		}
		
		

		
	}
	
	private static void renderIngame(Krenaller krenaller, int width, int height) {
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(300, 300);
			GL11.glVertex2f(300 + 100, 300);
			GL11.glVertex2f(300 + 100, 300 + 100);
			GL11.glVertex2f(300, 300 + 100);
		GL11.glEnd();
	}

	private static void renderMainMenu(Krenaller krenaller, int width, int height) {
		MainMenu.render(krenaller, width, height);
	}

	public static void setTexture(String texture) {
		
	}
	
}
