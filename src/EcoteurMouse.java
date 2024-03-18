import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class EcoteurMouse extends MouseAdapter{
    JLabel label;
    public EcoteurMouse(JLabel label) {
        this.label = label;
    }
    public void mouseEntered(MouseEvent evt) {
        label.setForeground(Color.red);
    }
    public void mouseExited(MouseEvent evt) {
        label.setForeground(Color.black);
    }
}
