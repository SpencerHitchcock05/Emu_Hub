package components;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class AppIcon extends JLayeredPane {

    final private int shadowOffset = 3;
    final private Color shadowColor = new Color(39, 140, 74);
    private String name;
    private String extension;
    private String emuPath;
    protected ShadowButton main;
    protected  JButton deleteButton;
        
    public AppIcon(String name, String extension, String emuPath) {
        this.name = name;
        this.extension = extension;
        this.emuPath = emuPath;

        main = new ShadowButton(4, false);
        main.setToolTipText(name);
        main.setText(name);
        main.setBounds(0,0,80,80);
        main.setBackground(Color.WHITE);
        main.setCursor(new Cursor(Cursor.HAND_CURSOR));
        main.setForeground(Color.BLACK);
        main.setVerticalAlignment(SwingConstants.BOTTOM);
        main.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(main, Integer.valueOf(0));

        String[] extensionList = extension.split("\\|");
        File icons = new File("resources/Console_Logos");
        String imgName = "";

        for (int i = 0; i < extensionList.length; i++) {
            final int index = i;
            String[] imgs = icons.list((d, fileName) -> fileName.toLowerCase().contains(extensionList[index].substring(1)));
            if (imgs.length > 0) {
                imgName = imgs[0];
                break;
            }
        }

        if (!imgName.isEmpty()) {
            ImageIcon icon = new ImageIcon(new File("resources/Console_Logos/" + imgName).getAbsolutePath());
            Image img = icon.getImage().getScaledInstance(
                60, 60 * icon.getIconHeight() / icon.getIconWidth(), Image.SCALE_SMOOTH
            );
            JLabel label = new JLabel(new ImageIcon(img));
            label.setBounds(8, 0, 60, 70);
            add(label, Integer.valueOf(1));
        } else if (!emuPath.isEmpty()) {                     
            File emuFile = new File(emuPath);

            if (emuFile.exists()) {
                Icon icon = FileSystemView.getFileSystemView().getSystemIcon(emuFile);
                
                if (icon != null) {
                    int iconWidth = icon.getIconWidth();
                    int iconHeight = icon.getIconHeight();

                    BufferedImage image = new BufferedImage(iconWidth, iconHeight, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g = image.createGraphics();
                    icon.paintIcon(null, g, 0, 0);
                    g.dispose();
                    Image img = image.getScaledInstance(
                        60, 60 * iconHeight / iconWidth, Image.SCALE_SMOOTH
                    );
                    JLabel label = new JLabel(new ImageIcon(img));
                    label.setBounds(8, 0, 60, 70);
                    add(label, Integer.valueOf(1));
                }
            }
        }

        deleteButton = new JButton("✕");
        deleteButton.setMargin(new Insets(0, 0, 0, 0));
        deleteButton.setFocusable(false);
        deleteButton.setOpaque(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBounds(48, 0, 25, 25);
        deleteButton.setBorder(BorderFactory.createEmptyBorder());
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.setRolloverEnabled(false);
        deleteButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        deleteButton.setForeground(Color.RED);

        deleteButton.addActionListener(e -> {

            File inputFile = new File("Emulators.csv");
            List<String> lines = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",", -1);

                    if (!(parts[0].equals(name) && parts[1].equals(extension) && parts[2].equals(emuPath))) {
                        lines.add(line);
                    }
                }
            } catch (IOException err) {
                err.printStackTrace();
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(inputFile))) {
                for (String l : lines) {
                    pw.println(l);
                }
            } catch (IOException err) {
                err.printStackTrace();
            }


            Container parent = this.getParent();
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        });

        
        setPreferredSize(new Dimension(80, 80));
        add(deleteButton, Integer.valueOf(2));
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Anti-aliasing (optional for smoother edges)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // ---- Draw shadow ----
        g2.setColor(shadowColor);
        g2.fillRect(shadowOffset, shadowOffset, w - 1 - shadowOffset, h - 1 - shadowOffset);

        // ---- Draw button background ----
        g2.setColor(getBackground());
        g2.fillRect(0, 0, w - 1 - shadowOffset, h - 1 - shadowOffset);

        g2.dispose();

        super.paintComponent(g);
    }
}