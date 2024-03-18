import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EcouteurFocus implements FocusListener {
    public JTextField field;
    public String valeurDefaut;

    public EcouteurFocus(JTextField field) {
        this.field = field;
        this.valeurDefaut = field.getText();
    }

    @Override
    public void focusGained(FocusEvent e) {
        field.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().equals("")) {
            field.setText(valeurDefaut);
        }

    }
}




