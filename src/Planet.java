import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Planet {
    private String name;
    private Color color;
    private int orbitRadius;
    private int x, y;
    private int size;
    private double angle = 0;
    private double speed;
    private BufferedImage image;

    public Planet(String name, Color color, int orbitRadius, int size, double speed, String image) {
        this.name = name;
        this.color = color;
        this.orbitRadius = orbitRadius;
        this.size = size;
        this.x = (int) (orbitRadius * Math.cos(speed));
        this.y = (int) (orbitRadius * Math.sin(speed));
        this.speed = speed;
        this.image = loadImage(image);
    }

    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Color getColor() {
        return color;
    }

    public int getOrbitRadius() {
        return orbitRadius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void updatePosition() {
        angle += speed * 0.01; // Adjust the factor to control the speed
        x = (int) (orbitRadius * Math.cos(angle));
        y = (int) (orbitRadius * Math.sin(angle));
    }
}