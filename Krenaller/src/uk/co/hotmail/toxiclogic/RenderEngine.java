package uk.co.hotmail.toxiclogic;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class RenderEngine {
	
	public static Krenaller krenallerInstance;
	public static int ingame = 1;
	private static SpriteSheet terrain;
	
	public RenderEngine() {
		
		
		
	}
	
	public static void render(Krenaller krenaller, int width, int height) {
		
		if(ingame == 1) {
			renderMainMenu(krenaller, width, height);
		}else {
			init();
			renderIngame(krenaller, width, height);
		}

		
	}
	
	public static void init() {
		try {
			terrain = ResourceManager.glLoadSpriteSheet("res/terrain.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void renderIngame(Krenaller krenaller, int width, int height) {
		
		Image s = terrain.getSubImage(1, 1);
		
		s.draw();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(100, 100);
			GL11.glVertex2f(100 + 100, 100);
			GL11.glVertex2f(100 + 100, 100 + 100);
			GL11.glVertex2f(100, 100 + 100);
		GL11.glEnd();
		
	}

	private static void renderMainMenu(Krenaller krenaller, int width, int height) {
		MainMenu.render(krenaller, width, height);
	}
	
	public static SpriteSheet geTerrainSpriteSheet() {
		return terrain;
	}
	
}
