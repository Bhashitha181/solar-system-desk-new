import javax.swing.*;

public class PlanetPannel extends JFrame{
    private JPanel planet_pannel;
    private JLabel lbl_planet;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;

    public PlanetPannel(){
        setContentPane(planet_pannel);
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
