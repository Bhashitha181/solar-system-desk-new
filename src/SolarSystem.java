import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SolarSystem extends JPanel {
    private final int SUN_RADIUS = 30; // Radius of the Sun

    private final String[] planetNames = {
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    };
    private final int[] planetRadii = {
            5, 10, 10, 7, 25, 22, 18, 17
    };
    private final int[] planetDistances = {
            50, 90, 130, 180, 260, 350, 450, 520
    };

    private double[] planetAngles = new double[planetNames.length];

    public SolarSystem() {
        setPreferredSize(new Dimension(800, 800));

        Timer timer = new Timer(20, e -> {
            for (int i = 0; i < planetAngles.length; i++) {
                planetAngles[i] += 0.005 * (i + 1); // Adjust speed for each planet
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw Sun
        g.setColor(Color.YELLOW);
        g.fillOval(centerX - SUN_RADIUS, centerY - SUN_RADIUS, 2 * SUN_RADIUS, 2 * SUN_RADIUS);

        for (int i = 0; i < planetNames.length; i++) {
            int orbitRadius = planetDistances[i];
            int planetRadius = planetRadii[i];
            double angle = planetAngles[i];

            int planetX = centerX + (int) (orbitRadius * Math.cos(angle));
            int planetY = centerY + (int) (orbitRadius * Math.sin(angle));

            // Set planet colors
            Color planetColor = getPlanetColor(planetNames[i]);
            g.setColor(planetColor);

            // Draw planet orbit
            g.setColor(Color.GRAY);
            ((Graphics2D) g).draw(new Ellipse2D.Double(centerX - orbitRadius, centerY - orbitRadius, 2 * orbitRadius, 2 * orbitRadius));

            // Draw planet
            g.fillOval(planetX - planetRadius, planetY - planetRadius, 2 * planetRadius, 2 * planetRadius);

            // Draw planet name
            g.setColor(Color.WHITE);
            g.drawString(planetNames[i], planetX + planetRadius, planetY);
        }
    }

    private Color getPlanetColor(String planetName) {
        switch (planetName) {
            case "Mercury":
                return Color.GRAY;
            case "Venus":
                return new Color(222, 184, 135); // Sandy Brown
            case "Earth":
                return Color.BLUE;
            case "Mars":
                return new Color(255, 69, 0); // Red-Orange
            case "Jupiter":
                return new Color(255, 165, 0); // Orange
            case "Saturn":
                return new Color(210, 180, 140); // Tan
            case "Uranus":
                return new Color(173, 216, 230); // Light Blue
            case "Neptune":
                return new Color(0, 0, 128); // Navy Blue
            default:
                return Color.WHITE;
        }
    }

}
