package uk.co.hotmail.toxiclogic;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class MenuButton {

	/** Button positions **/
	public static Vector2f position = new Vector2f();
	/** Button width/height **/
	public static Vector2f dimensions = new Vector2f();
	/** Button Color **/
	public static Vector3f color;
	/** Button Text **/
	public static String text;
	/** Text Color **/
	public static Vector3f textColor;
	
	public MenuButton(int x, int y, int width, int height, Vector3f color, String text, Vector3f textColor) {
		position.x = x;
		position.y = y;
		
		dimensions.x = width;
		dimensions.y = height;
		MenuButton.color = color;
		MenuButton.text = text;
		MenuButton.textColor = textColor;
		
		drawButton();
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	public float getX() {
		return position.getX();
	}
	
	public float getY() {
		return position.getY();
	}
	
	public float getWidth() {
		return dimensions.getX();
	}
	
	public float getHeight() {
		return dimensions.getX();
	}
	
	public void drawButton() {
		GL11.glColor3f(color.x, color.y, color.z);
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(position.x, position.y);
			GL11.glVertex2f(position.x + dimensions.x, position.y);
			GL11.glVertex2f(position.x + dimensions.x, position.y + dimensions.y);
			GL11.glVertex2f(position.x, position.y + dimensions.y);
		GL11.glEnd();
	}
	
}
