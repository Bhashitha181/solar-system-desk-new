import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton viewSolarSystemButton;
    private JButton mercuryButton;
    private JButton venusButton;
    private JButton earthButton;
    private JButton neptuneButton;
    private JButton saturnButton;
    private JButton uranusButton;
    private JButton marsButton;
    private JButton jupitorButton;
    private JPanel jp_main;

    public MainMenu(){
        setContentPane(jp_main);
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        viewSolarSystemButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Solar System Orbits");
                frame.getContentPane().add(new SolarSystem2());
                frame.pack();
                int screenWidth = 1280;
                int screenHeight = 720;
                frame.setSize(screenWidth, screenHeight);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        mercuryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.GRAY;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Mercury", "Orbit: 47 million km", "The First planet from the Sun. Mercury is the smallest planet in the solar system, and it is also the planet closest to the Sun, making it the most difficult of the planets to see with the unaided eye. Because its rising or setting is always within about two hours of the Sun's, Mercury is never observable when the sky is fully dark.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        venusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.YELLOW;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Venus", "Orbit: 67 million km", "Venus is the second planet from the Sun and is Earth's closest planetary neighbor. It's one of the four inner, terrestrial (or rocky) planets, and it's often called Earth's twin because it's similar in size and density. These are not identical twins, however – there are radical differences between the two worlds.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        earthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.BLUE;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Earth", "Orbit: 150 million km", "While Earth is only the fifth largest planet in the solar system, it is the only world in our solar system with liquid water on the surface. Just slightly larger than nearby Venus, Earth is the biggest of the four planets closest to the Sun, all of which are made of rock and metal.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        marsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.RED;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Mars", "Orbit: 230 million km", "It's red because of rusty iron in the ground. Like Earth, Mars has seasons, polar ice caps, volcanoes, canyons, and weather. It has a very thin atmosphere made of carbon dioxide, nitrogen, and argon. There are signs of ancient floods on Mars, but now water mostly exists in icy dirt and thin clouds.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        jupitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.orange;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Jupiter", "Orbit: 778 million km", "Jupiter is the fifth planet from our Sun and is, by far, the largest planet in the solar system – more than twice as massive as all the other planets combined. Jupiter's stripes and swirls are actually cold, windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        saturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.PINK;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Saturn", "Orbit: 1.4 billion km", "Saturn is the sixth planet from the Sun and the second-largest planet in our solar system. Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium. Saturn is not the only planet to have rings, but none are as spectacular or as complex as Saturn's. Saturn also has dozens of moons.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        uranusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.CYAN;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Uranus", "Orbit: 2.9 billion km", "The seventh planet from the Sun with the third largest diameter in our solar system, Uranus is very cold and windy. The ice giant is surrounded by 13 faint rings and 27 small moons as it rotates at a nearly 90-degree angle from the plane of its orbit.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });

        neptuneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color planetColor = Color.BLUE;
                PlanetDetails planetDetails = new PlanetDetails(
                        "Neptune", "Orbit: 4.5 billion km", "Neptune is very similar to Uranus. It's made of a thick soup of water, ammonia, and methane over an Earth-sized solid center. Its atmosphere is made of hydrogen, helium, and methane. The methane gives Neptune the same blue color as Uranus.", planetColor);

                PlanetFrame planetFrame = new PlanetFrame(planetDetails);
            }
        });
    }
}
