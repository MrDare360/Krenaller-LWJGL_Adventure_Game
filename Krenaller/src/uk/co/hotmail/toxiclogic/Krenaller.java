package uk.co.hotmail.toxiclogic;

public class Krenaller implements Runnable{

	@Override
	public void run() {
		
	}
	
	public static void main(String[] args) {
		new Krenaller();
		
	}
	
	public Krenaller() {
		
		new GameWindow(this, 800, 600);
		
	}

	public Krenaller getKrenallerInstance() {
		return this;
	}
	
}
