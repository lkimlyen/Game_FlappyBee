package flappybee;

public class Bee {

    private int centerX = 96;
    private int centerY = 256;
    private boolean jumped = false;
    private int speedX = 0;
    private int speedY = 1;

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
