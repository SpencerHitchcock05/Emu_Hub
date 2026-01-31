package components;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class HeaderAddEmu extends HeaderButton {

    public HeaderAddEmu(JFrame frame) {
        super(frame);

        addActionListener(e -> {
            JDialog dialog = new JDialog(frame, "Input Form", true);
            dialog.setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 0, 5, 5));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JPanel row1 = new JPanel(new GridLayout(1, 2, 5, 5));
            JLabel emulatorNameLabel = new JLabel("Emulator Name:");
            row1.add(emulatorNameLabel);
            JTextField emulatorName = new JTextField(20);
            row1.add(emulatorName);
            panel.add(row1);

            JPanel row2 = new JPanel(new GridLayout(1, 2, 5, 5));
            JLabel fileExtensionLabel = new JLabel("File Extension Name (ex: .nds):");
            row2.add(fileExtensionLabel);
            JTextField fileExtension = new JTextField(".xxx", 20);
            row2.add(fileExtension);
            panel.add(row2);

            JPanel row3 = new JPanel(new GridLayout(1, 3, 5, 5));
            JLabel pathLabel = new JLabel("Emluator Name:");
            row3.add(pathLabel);
            JTextField path = new JTextField(20);
            row3.add(path);
            JButton browseButton = new JButton("Browse...");

            browseButton.addActionListener(ev -> {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    path.setText(filePath); 
                }
            });
            row3.add(browseButton);

            panel.add(row3);
            
            JButton submit = new JButton("Submit");
            submit.addActionListener(ev -> {
                String emulatorNameValue = emulatorName.getText();
                String fileExtensionValue = fileExtension.getText();
                String pathValue = path.getText();

                try (PrintWriter pw = new PrintWriter(new FileWriter("Emulators.csv", true))) {

                    pw.println(String.join(",", new String[] {emulatorNameValue, fileExtensionValue, pathValue}));
                } catch (IOException err) {
                    err.printStackTrace();
                }

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