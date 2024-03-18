import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TP0 extends JInternalFrame implements ActionListener {

    JButton btn_valid = new JButton("Valider");
    JButton btn_qte = new JButton("Quitter");
    //make me form for making cv of employees
    JTextField nom = new JTextField(10);
    JTextField prenom = new JTextField(10);
    JPanel jPan2 = new JPanel();

    TP0(){
        this.setClosable(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setTitle("Hello world!");
        this.setSize(480,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make me a form for making cv of employees with 2 inputs to read name and prenom

        //positioner de f
        this.setLayout(new BorderLayout(20,10));

        JLabel lb_titre = new JLabel("curriculum vitae");
        lb_titre.setForeground(Color.white);
        lb_titre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 34));
        lb_titre.setBackground(Color.green);
        lb_titre.setHorizontalAlignment(JLabel.CENTER);
        lb_titre.setOpaque(true);

        btn_valid = new JButton("Valider");
        btn_qte = new JButton("Quitter");

        this.add(lb_titre, BorderLayout.NORTH);

        JPanel jPan = new JPanel();

        //jPan.setPreferredSize(new Dimension(0,200));
        jPan.setOpaque(true);
        jPan.setBackground(Color.BLACK);
        jPan.add(btn_valid);
        jPan.add(btn_qte);

        this.add(jPan, BorderLayout.SOUTH);
        jPan2.setLayout(new GridLayout(2,2,10,10));
        jPan2.add(new JLabel("Nom"));
        jPan2.add(nom);
        jPan2.add(new JLabel("Prenom"));
        jPan2.add(prenom);


        this.add(jPan2, BorderLayout.CENTER);


        btn_qte.addActionListener(this);
        btn_valid.addActionListener(this);


        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_qte){
            System.exit(2);
        }else{
            File f = new File("cv.html");
            try {
                FileWriter fw = new FileWriter(f);
                fw.write("<head><title>CV</title></head>");
                fw.write("<style>body{display:flex;justify-content:center;align-items:center;flex-direction:column}</style>");
                fw.write("<h1>Les information</h1>");
                fw.write("<p>Nom: "+nom.getText()+"</p>");
                fw.write("<p>Prenom: "+prenom.getText()+"</p>");

                fw.close();
                Desktop.getDesktop().open(f);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(TP0.this, "Validé");
        }
    }
}
