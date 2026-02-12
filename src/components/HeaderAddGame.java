package components;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

public class HeaderAddGame extends HeaderButton {

    public HeaderAddGame(JFrame frame, IconPanel iconPanel) {
        super("🠋", "Add Game");

        setFont(new Font("Noto Sans", Font.PLAIN, 32));

        addActionListener(e -> {
            JDialog dialog = new JDialog(frame, "Input Form", true);
            dialog.setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 0, 5, 5));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JPanel row1 = new JPanel(new GridLayout(1, 2, 5, 5));
            JLabel gameNameLabel = new JLabel("Game Name (optional):");
            row1.add(gameNameLabel);
            JTextField gameName = new JTextField(20);
            row1.add(gameName);
            panel.add(row1);
            
            JPanel row2 = new JPanel(new GridLayout(1, 3, 5, 5));
            JLabel pathLabel = new JLabel("Path:");
            row2.add(pathLabel);
            JTextField path = new JTextField(20);
            row2.add(path);
            JButton browseButton = new JButton("Browse...");

            browseButton.addActionListener(ev -> {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    path.setText(filePath); 
                }
            });
            row2.add(browseButton);

            panel.add(row2);
            
            JButton submit = new JButton("Submit");
            submit.addActionListener(ev -> {
                String gameNameValue = gameName.getText();
                String pathValue = path.getText();

                File gameFolder = new File(System.getProperty("user.home"), "EmuHubGames");
                if (!gameFolder.exists()) {
                    boolean created = gameFolder.mkdirs();
                    if (!created) {
                        System.out.println("Failed to create folder: " + gameFolder.getAbsolutePath());
                        return;
                    }
                }

                
                try {
                    Path src = Paths.get(pathValue);
                    Path trgt = Paths.get(gameFolder.getAbsolutePath() + "/" + gameNameValue);

                    //change to .move, after testing
                    Files.copy(src, trgt, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(
                        null,                       
                        "An error occured! ensure your file paths are correct.",       
                        "Error",                    
                        JOptionPane.ERROR_MESSAGE   
                    );
                }

                iconPanel.refreshIcons();

                dialog.dispose();
            });
            
            panel.add(submit);
            
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true); // This blocks until closed!
        });
    }
}