package components;
import java.awt.*;


public class HeaderButton extends ShadowButton {

    final private Color shadowColor = new Color(39, 140, 74);
    protected String name;

    public HeaderButton(String name, String toolTip) {
        super(3);
        this.name = name;
        setText(name);
        setToolTipText(toolTip);
        setForeground(Color.BLACK);
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
