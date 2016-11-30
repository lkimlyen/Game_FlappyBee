package Flappy_Bee;

public class Bee {
	public int centerX = 96;
    public int centerY = 256;
    public boolean jumped = false;
    public int speedX = 0;
    public int speedY = 1;

    public void Update() {
        if (speedX < 0) {
            centerX += speedX;
        } else if (speedX == 0) {
            System.out.println("Do not scroll the background");
        } else {
            if (centerX <= 100) {
                centerX += speedX;
            } else {
                System.out.println("Scroll Background Here");
            }
        }
        if (centerY + speedY >= 256) {
            centerY = 256;
        } else {
            centerY += speedY;
        }
        if (jumped == true) {
            speedY += 1;
            if (centerY + speedY >= 256) {
                centerY = 256;
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
            speedY = -15;
            jumped = true;
        }
    }
}
