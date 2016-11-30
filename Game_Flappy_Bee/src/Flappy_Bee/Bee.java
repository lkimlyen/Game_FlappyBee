package Flappy_Bee;

public class Bee {
	public final int GROUND = 256;
	public final int MOVESPEED = 5;
	
	public int centerX = 96;
	public int centerY = GROUND;
	public boolean jumped = false;
	public boolean gameOver,started;
	
	public int speedX = 0;
	public int speedY = 1;
	public static Background background1 = StartingClass.getBg1();
	public static Background background2 = StartingClass.getBg2();

	public void Update() {
		if (speedX < 0) {
			centerX += speedX;
		} else if (speedX == 0) {
		background1.setSpeedX(0);
		background2.setSpeedX(0);
		} else {
			if (centerX <= 100) {
				centerX += speedX;
			} else {
				background1.setSpeedX(-MOVESPEED);
				background2.setSpeedX(-MOVESPEED);
			}
		}
		if (centerY + speedY >= GROUND) {
			centerY = GROUND;
		} else {
			centerY += speedY;
		}
		if (jumped == true) {
			speedY += 1;
			if (centerY + speedY >= GROUND) {
				centerY = GROUND;
				speedY = 0;
				jumped = false;
			}
		}
		if (centerX + speedX <= 20) {
			centerX = 21;
		}
	}

	public void stop() {
		speedX = 0;
	}

	public void jump() {
		if (jumped == false) {
			speedY = -10;
			jumped = true;
		}
	}
	public int getCenterX() {
		return centerX;
		
	}
	public int getCenterY() {
		return centerY;
		
	}
	public boolean isJumped() {
		return jumped;
		
	}
	public int getSpeedX() {
		return speedX;
		
	}
	public int getSpeedY() {
		return speedY;
		
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	public void setJumped(boolean jumped) {
		this.jumped = jumped;
		
	}
	
}
