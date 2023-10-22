import javax.swing.*;
import java.awt.*;

public class PlanetFrame extends JFrame {
    private PlanetInfoPanel infoPanel;
    private PlanetImagePanel imagePanel;

    public PlanetFrame(PlanetDetails planetDetails) {
        setTitle("Planet Information");
        setLayout(new BorderLayout());

        infoPanel = new PlanetInfoPanel(planetDetails.getName(), planetDetails.getOrbit(), planetDetails.getSummary(), "src/resources/audios/mars.mp3");
        imagePanel = new PlanetImagePanel(planetDetails.getCircleColor());

        add(infoPanel, BorderLayout.WEST);
        add(imagePanel, BorderLayout.CENTER);
        setSize(1000, 500);
        setVisible(true);
    }
}