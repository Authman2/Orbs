package GAMEDEV;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.Serializable;

import javax.swing.JFrame;

/**
 *  Originally written by TheIndieDeveloper (https://www.youtube.com/user/InidDevo/about)
 */
public class GameWindow extends JFrame implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	
	boolean fse = false;
	int fsm = 0;
	GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public GameWindow(String titlex, int widthx, int heightx) {
		setTitle(titlex);
		setSize(widthx,heightx);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}


	@SuppressWarnings("unused")
	private void setfullscreen() {
		switch(fsm) { 
			case 0:
				System.out.println("No Fullscreen");
				setUndecorated(false);
				break;
			case 1:
				setUndecorated(true);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				break;
			case 2:
				setUndecorated(true);
				device.setFullScreenWindow(this);
		}
	}
	
	public void setFullscreen(int fsnm) {
		fse = true;
		if(fsm <= 2) {
			this.fsm = fsnm;
		} else {
			System.err.println("Error: " + fsnm + " is not supported.");
		}
	}

}