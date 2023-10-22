import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SolarSystem2 extends JPanel {
    private ArrayList<Planet> planets;
    private Timer animationTimer;
    private JPanel planetDetailPanel;
    private int centerX, centerY;

    public SolarSystem2() {
        planets = new ArrayList<>();
        planetDetailPanel = new JPanel();
        planetDetailPanel.setPreferredSize(new Dimension(300, 300));
        // Create planets and add them to the list
        planets.add(new Planet("Mercury", Color.GRAY, 30, 10, 2, "/resources/earth.png"));
        planets.add(new Planet("Venus", Color.YELLOW, 60, 30, 1.5, "/resources/earth.png"));
        planets.add(new Planet("Earth", Color.BLUE, 100, 30, 1, "/resources/earth.png"));
        planets.add(new Planet("Mercury", Color.RED, 120, 25, 0.9, "/resources/earth.png"));
        planets.add(new Planet("Jupiter", Color.PINK, 200, 60, 0.8, "/resources/earth.png"));
        planets.add(new Planet("Saturn", Color.PINK, 250, 50, 0.7, "/resources/earth.png"));
        planets.add(new Planet("Uranus", Color.BLUE, 300, 40, 0.5, "/resources/earth.png"));
        planets.add(new Planet("Neptune", Color.BLUE, 400, 40, 0.3, "/resources/earth.png"));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickedX = e.getX();
                int clickedY = e.getY();

                System.out.println("Clicked");

//                System.out.println(clickedX+" || "+clickedY);

                for (Planet planet : planets) {
                    int planetX = centerX + planet.getX();
                    int planetY = centerY - planet.getY();
                    int planetSize = planet.getSize();

                    System.out.println(planet.getName()+" "+Math.pow(clickedX - planetX, 2) + Math.pow(clickedY - planetY, 2));
//                    openPlanetDetailPanel(planet);

                    if (Math.pow(clickedX - planetX, 2) + Math.pow(clickedY - planetY, 2) <= Math.pow(planetSize / 2, 2)) {
                        openPlanetDetailPanel(planet);
                    }
                }
            }
        });


        animationTimer = new Timer();
        animationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updatePlanetPositions();
                repaint();
            }
        }, 0, 30); // Update every 30 milliseconds
    }

    private void updatePlanetPositions() {
        for (Planet planet : planets) {
            planet.updatePosition();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g.setColor(Color.BLACK); // Set background color

        // Draw orbits
        for (Planet planet : planets) {
            int orbitRadius = planet.getOrbitRadius();
            g.drawOval(centerX - orbitRadius, centerY - orbitRadius, 2 * orbitRadius, 2 * orbitRadius);
        }

        int sunSize = 50;
        g.setColor(Color.YELLOW);
        g.fillOval(centerX - sunSize / 2, centerY - sunSize / 2, sunSize, sunSize);


        // Draw planets
        for (Planet planet : planets) {
            int x = centerX + planet.getX();
            int y = centerY - planet.getY();
            g.setColor(planet.getColor());
            g.fillOval(x - planet.getSize() / 2, y - planet.getSize() / 2, planet.getSize(), planet.getSize());
        }
    }
    private void openPlanetDetailPanel(Planet planet) {
        PlanetPannel planetPannel = new PlanetPannel();
        planetPannel.setVisible(true);
//        System.out.println("Jii");
//        planetDetailPanel.removeAll();
//
//        JLabel planetNameLabel = new JLabel(planet.getName());
//        JLabel planetImageLabel = new JLabel(new ImageIcon(planet.getImage()));
//
//        planetDetailPanel.add(planetNameLabel);
//        planetDetailPanel.add(planetImageLabel);
//
//        planetDetailPanel.revalidate();
//        planetDetailPanel.repaint();
    }
}
