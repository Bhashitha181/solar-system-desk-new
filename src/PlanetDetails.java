import java.awt.Color;

public class PlanetDetails {
    private String name;
    private String orbit;
    private String summary;
    private Color circleColor;

    public PlanetDetails(String name, String orbit, String summary, Color circleColor) {
        this.name = name;
        this.orbit = orbit;
        this.summary = summary;
        this.circleColor = circleColor;
    }

    public String getName() {
        return name;
    }

    public String getOrbit() {
        return orbit;
    }

    public String getSummary() {
        return summary;
    }

    public Color getCircleColor() {
        return circleColor;
    }
}