package components;
import java.awt.*;
import javax.swing.*;


public class ShadowButton extends JButton {

    protected int shadowOffset;
    private boolean centered;
    final private Color shadowColor = new Color(39, 140, 74);

    public ShadowButton(int shadowOffset, boolean centered) {
        this.shadowOffset = shadowOffset;
        this.centered = centered;
        setPreferredSize(new Dimension(40, 40));
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(shadowOffset, shadowOffset, shadowOffset, shadowOffset));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public ShadowButton(int shadowOffset) {
        this(shadowOffset, true);
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Draw shadow
        g2.setColor(shadowColor);
        g2.fillRect(shadowOffset, shadowOffset, w - shadowOffset, h - shadowOffset);

        // Draw button background
        g2.setColor(getBackground());
        g2.fillRect(0, 0, w - shadowOffset, h - shadowOffset);

        // Draw text manually, centered ignoring shadow
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textX = (w - shadowOffset - fm.stringWidth(getText())) / 2;
        int textY = (h - shadowOffset - fm.getHeight()) / (centered? 2 : 1) + fm.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }
}
