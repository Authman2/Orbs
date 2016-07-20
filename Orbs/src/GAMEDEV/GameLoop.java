package GAMEDEV;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.swing.JPanel;

/** 
 * Originally written by TheIndieDeveloper (https://www.youtube.com/user/InidDevo/about)
 */
public class GameLoop extends JPanel implements Runnable, Serializable  {
	private static final long serialVersionUID = 1L;
	
	
	private Thread thread;
	private boolean running;
	
	private int fps, tps;
	public static double currFPS = 120D;
	
	private int width, height;
	
	public Graphics2D graphics2D;
	private BufferedImage img;
	
	
	public GameLoop() {
		this.width = 0;
		this.height = 0;
		
		setPreferredSize(new Dimension(width,height));
		setFocusable(false);
		requestFocus();
	}
	public GameLoop(int w, int h) {
		this.width = w;
		this.height = h;
		
		setPreferredSize(new Dimension(width,height));
		setFocusable(false);
		requestFocus();
	}

	@Override
	public void addNotify() {
		super.addNotify();
		
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		init();
	
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / currFPS;
		int frames = 0;
		int ticks = 0;
		@SuppressWarnings("unused")
		long lastTimer = System.currentTimeMillis();
		double deltaTime = 0;
		
		while(running) {
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			
			while(deltaTime >= -1) {
				ticks++;
				update(deltaTime);
				deltaTime -= 1;
				shouldRender = true;
			}
			
			if(shouldRender == true) {
				frames++;
				draw(graphics2D);
			}
			
			try { Thread.sleep(2); } catch(InterruptedException e) { e.printStackTrace(); }
			
			if(System.currentTimeMillis() - lastTime >= 1000) {
				lastTime += 1000;
				tps = ticks;
				fps = frames;
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void init() {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics2D = (Graphics2D) img.getGraphics();
		running = true;
	}
	
	public void update(double deltaTime) {
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 640, 480);
		//g.clearRect(0,0,width,height);
	}
	
	public void clear() {
		Graphics2D g2 = (Graphics2D)getGraphics();
		if(img != null) {
			g2.drawImage(img,0,0,null);
		}
		g2.dispose();
	}
	
	public int getFPS() {
		return fps;
	}
	public int getTPS() {
		return tps;
	}
}