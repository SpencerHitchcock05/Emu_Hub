package components;
import java.awt.*;


public class HeaderButton extends ShadowButton {

    protected String name;

    public HeaderButton(String name, String toolTip) {
        super(3);
        this.name = name;
        setText(name);
        setToolTipText(toolTip);
        setForeground(Color.BLACK);
    }
       
}
