import javax.swing.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Solar System Orbits");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(new SolarSystem());
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
            MainMenu mainMenu = new MainMenu();
        });
    }
}