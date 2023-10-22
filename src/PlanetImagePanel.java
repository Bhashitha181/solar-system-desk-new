import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlanetImagePanel extends JPanel {
    private Color circleColor;
    private JSlider scaleSlider;
    private JSlider shadingSlider;

    public PlanetImagePanel(Color circleColor) {
        this.circleColor = circleColor;

        setLayout(new BorderLayout());

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));

        scaleSlider = new JSlider(50, 200, 100);
        shadingSlider = new JSlider(0, 100, 0);

        JLabel scaleLabel = new JLabel("Scale");
        JLabel shadingLabel = new JLabel("Light Bounce");

        sliderPanel.add(scaleLabel);
        sliderPanel.add(scaleSlider);
        sliderPanel.add(shadingLabel);
        sliderPanel.add(shadingSlider);

        add(sliderPanel, BorderLayout.PAGE_END);

        scaleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                repaint();
            }
        });

        shadingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int circleDiameter = scaleSlider.getValue();
        int shadingValue = shadingSlider.getValue();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Calculate the radial gradient radius based on the shading slider value
        float gradientRadius = circleDiameter * (1.0f + (shadingValue - 50) / 100.0f);

        // Create the radial gradient for the simulated 3D effect
        RadialGradientPaint gradient = new RadialGradientPaint(
                centerX, centerY, gradientRadius,
                new float[]{0.0f, 1.0f},
                new Color[]{circleColor, circleColor.darker().darker()});

        // Fill the oval with the radial gradient
        g2d.setPaint(gradient);
        g2d.fillOval(centerX - circleDiameter / 2, centerY - circleDiameter / 2, circleDiameter, circleDiameter);
    }
}