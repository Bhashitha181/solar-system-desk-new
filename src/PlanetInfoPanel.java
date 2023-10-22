import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

public class PlanetInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel orbitLabel;
    private JTextArea summaryArea;
    private JButton playButton;
    private JButton pauseButton;
    private JSlider audioSlider;

    private AdvancedPlayer audioPlayer; // JLayer's AdvancedPlayer

    public PlanetInfoPanel(String name, String orbit, String summary, String audioFilePath) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical layout
        setBorder(BorderFactory.createTitledBorder("Planet Information"));

        // Create a nested panel for the labels, align them to the left corner
        JPanel labelsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        orbitLabel = new JLabel(orbit);
        labelsPanel.add(nameLabel);
        labelsPanel.add(orbitLabel);

        summaryArea = new JTextArea(summary);

        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        summaryArea.setEditable(false);
        summaryArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(Box.createRigidArea(new Dimension(0, 2)));
        add(labelsPanel); // Add the labels panel
        add(new JScrollPane(summaryArea));

        // Create a panel for the audio controller
        JPanel audioPanel = new JPanel();
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        audioSlider = new JSlider();

        audioPlayer = loadAudioPlayer(audioFilePath);

        playButton.addActionListener(e -> playAudio());
        pauseButton.addActionListener(e -> pauseAudio());

        audioPanel.add(playButton);
        audioPanel.add(pauseButton);
        audioPanel.add(audioSlider);

        add(audioPanel);
    }

    private AdvancedPlayer loadAudioPlayer(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            return new AdvancedPlayer(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void playAudio() {
        if (audioPlayer != null) {
            new Thread(() -> {
                try {
                    audioPlayer.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void pauseAudio() {
        if (audioPlayer != null) {
            audioPlayer.close();
        }
    }
}
