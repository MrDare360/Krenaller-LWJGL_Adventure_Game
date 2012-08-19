package uk.co.hotmail.toxiclogic;

import org.lwjgl.opengl.GL11;

public class RenderEngine {
	
	public static Krenaller krenallerInstance;
	public static int ingame = 1;
	
	public RenderEngine() {
		
		
		
	}
	
	public static void render(Krenaller krenaller, int width, int height) {
		
		switch(ingame) {
		
		case 1: renderMainMenu(krenaller, width, height);
			break;
		case 2: renderIngame(krenaller, width, height);
			break;
		
		}

		
	}
	
	private static void renderIngame(Krenaller krenaller, int width, int height) {
		
	}

	private static void renderMainMenu(Krenaller krenaller, int width, int height) {
		MainMenu.render(krenaller, width, height);
	}

	public static void setTexture(String texture) {
		
	}
	
}
