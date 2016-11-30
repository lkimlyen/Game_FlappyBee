package Flappy_Bee;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener {
	private Bee bee;
	private Image image, character;
	private Graphics graphics;
private URL base;

	
	@Override
	public void init() {
		setSize(288, 512);
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(this);
		setVisible(true);
		Frame frame = (Frame)this.getParent().getParent();
		frame.setTitle("Flappy Bee");
		try {
			base = getDocumentBase();
		}catch(Exception e)
		{}
		character = getImage(base,"images/bee1.png");
		
		
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
		bee = new Bee();
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			graphics = image.getGraphics();
		}
		graphics.setColor(getBackground());
		graphics.fillRect(0, 0, getWidth(), getHeight());
		graphics.setColor(getForeground());
		paint(graphics);
		
		g.drawImage(image,0,0,this);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(character, bee.centerX - 20, bee.centerY-10,30,30,this);
		
	}
	public void run() {
		while (true) {
			bee.Update();
			repaint();
			try {
				Thread.sleep(17);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bee.jump();
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Stop Jump");
		}

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
