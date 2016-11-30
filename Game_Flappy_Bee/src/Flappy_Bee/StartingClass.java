package Flappy_Bee;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener,ActionListener {
	private Bee bee;
	private Image image, character, background, nennho;
	private Graphics graphics;
	private URL base;
	private static Background background1,background2;
	
	@Override
	public void init() {
		
		setSize(288, 512);
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(this);
		setVisible(true);
		
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Flappy Bee");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
		}
		character = getImage(base, "images/bee1.png");
		background = getImage(base,"images/nenngay.png");
		nennho = getImage(base,"images/bacthem.png");
	}

	@Override
	public void start() {
		background1 = new Background(0, 0);
		background2 = new Background(288, 0);
		
		bee = new Bee();
		
		Thread thread = new Thread(this);
		thread.start();
		
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

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, background1.getBgX(),background2.getBgY(),this);
		g.drawImage(background, background2.getBgX(),background2.getBgY(),this);

		g.drawImage(nennho,0,400,this);
		
		g.drawImage(character, bee.centerX - 20, bee.centerY - 10, 30, 30, this);

	}

	public static Background getBg1() {
		return background1;
		}

		public static Background getBg2() {
		return background2;
		}
	public void run() {
		while (true) {
			bee.Update();
			background1.update();
			background2.update();
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

	public void actionPerformed(ActionEvent e) {
		
	}
}
