import javax.swing.*;
import java.awt.*;

public class Formulaire extends JPanel {
    Profile p;
    public Formulaire(Profile p){
        this.p = p;
        this.setLayout(new BorderLayout());
        JLabel lb_titre = new JLabel("Bienvenue "+ p.nom + " " + p.prenom);
        lb_titre.setForeground(Color.white);
        lb_titre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 34));
        lb_titre.setBackground(Color.green);
        lb_titre.setHorizontalAlignment(JLabel.CENTER);
        lb_titre.setOpaque(true);

        this.add(lb_titre, BorderLayout.NORTH);

        this.setVisible(true);

    }
}
