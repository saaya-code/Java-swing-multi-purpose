import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
// import a class from the package TP0 LOCATED IN C:\Users\boual\IdeaProjects\TP0\src\MaFenetre

public class CreationProfil extends JInternalFrame {
    JPanel inputs;
    public JLabel nom;
    public JLabel prenom;
    public JLabel pseudo;
    JButton valider;
    public JTextField nomInput;
    public JTextField prenomInput;
    public JTextField pseudoInput;
    JSplitPane jsp;
    JLabel help;
    DefaultListModel<String> model;
    JList jl;
    JTabbedPane jtp;
    ArrayList<TabForm> modelTab;
    CreationProfil(){
        this.setTitle("Creation de profile");
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modelTab = new ArrayList<TabForm>();
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);

        jsp = new JSplitPane();
        inputs = new JPanel();
        nom = new JLabel("Nom");
        prenom = new JLabel("Prenom");
        pseudo = new JLabel("Pseudo");
        valider = new JButton("Valider");
        nomInput = new JTextField(5);
        prenomInput = new JTextField(5);
        pseudoInput = new JTextField(5);
        nomInput.setText("Nom");
        prenomInput.setText("Prenom");
        pseudoInput.setText("Pseudo");
        help = new JLabel("Help");
        model = new DefaultListModel<String>();
        jl = new JList();
        jl.setModel(model);
        jtp = new JTabbedPane();
        jsp.setDividerLocation(150);
        jsp.setLeftComponent(jl);
        jsp.setRightComponent(jtp);

        inputs.add(nom);
        inputs.add(nomInput);
        inputs.add(prenom);
        inputs.add(prenomInput);
        inputs.add(pseudo);
        inputs.add(pseudoInput);
        inputs.add(valider);



        this.add(inputs, BorderLayout.NORTH);
        this.add(jsp, BorderLayout.CENTER);
        this.add(help, BorderLayout.SOUTH);


        this.setVisible(true);

        // events
        valider.addActionListener((ActionEvent ae)->{
            String pseudo = pseudoInput.getText();
            for(TabForm tf : modelTab){
                if(tf.p.getPseudo().equals(pseudo)){
                    return;
                }
            }
            model.addElement(pseudoInput.getText());
            modelTab.add(new TabForm(nomInput.getText(),prenomInput.getText(),pseudoInput.getText()));
        });

        nom.addMouseListener(new EcoteurMouse(this.nom));
        prenom.addMouseListener(new EcoteurMouse(this.prenom));
        pseudo.addMouseListener(new EcoteurMouse(this.pseudo));


        nomInput.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                help.setText("Saisir votre nom");
            }
            public void mouseExited(MouseEvent evt) {
                help.setText("Help");
            }
        });
        prenomInput.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                help.setText("Saisir votre prenom");
            }
            public void mouseExited(MouseEvent evt) {
                help.setText("Help");
            }
        });
        pseudoInput.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                help.setText("Saisir votre pseudo");
            }
            public void mouseExited(MouseEvent evt) {
                help.setText("Help");
            }
        });



        nomInput.addFocusListener(new EcouteurFocus(this.nomInput));
        prenomInput.addFocusListener(new EcouteurFocus(this.prenomInput));
        pseudoInput.addFocusListener(new EcouteurFocus(this.pseudoInput));


        jl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    String pseudoCourant = list.getSelectedValue().toString();
                    for(TabForm tf : modelTab){
                        if(tf.p.getPseudo().equals(pseudoCourant)){
                            jtp.addTab(pseudoCourant, tf.f);
                            //navigate to that tab
                            for(int i = 0; i < jtp.getTabCount(); i++) {
                                if (jtp.getTitleAt(i).equals(pseudoCourant)) {
                                    jtp.setSelectedIndex(i);
                                }
                            }
                            return;
                        }
                    }


                } else if (evt.getButton()==MouseEvent.BUTTON3) {

                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem supprimer = new JMenuItem("Supprimer");
                    JMenuItem modifier = new JMenuItem("Modifier");
                    JMenuItem supprimerTout = new JMenuItem("Supprimer tout");
                    popupMenu.add(modifier);
                    popupMenu.add(supprimer);
                    popupMenu.add(supprimerTout);
                    // events
                    supprimer.addActionListener((e)->{
                        String pseudoCourant = list.getSelectedValue().toString();
                        for(int i = 0; i < modelTab.size(); i++){
                            if (modelTab.get(i).p.getPseudo().equals(pseudoCourant)) {
                                modelTab.remove(modelTab.get(i));
                                model.removeElement(pseudoCourant);
                                for(int j = 0; j < jtp.getTabCount(); j++) {
                                    if (jtp.getTitleAt(j).equals(pseudoCourant)) {
                                        jtp.remove(j);
                                    }
                                }
                            }
                        }
                    });
                    supprimerTout.addActionListener((e) ->{
                        modelTab.clear();
                        model.removeAllElements();
                        jtp.removeAll();
                    });
                    modifier.addActionListener((e)->{
                        String pseudoCourant = list.getSelectedValue().toString();
                        String nouveauNom = JOptionPane.showInputDialog(CreationProfil.this, "Donner un nouveau nom.","Edition");
                        String nouveauPrenom = JOptionPane.showInputDialog(CreationProfil.this, "Donner un nouveau prénom.","Edition");
                        for(TabForm tf: modelTab){
                            if(tf.p.getPseudo().equals(pseudoCourant)){
                                tf.p.setNom(nouveauNom);
                                tf.p.setPrenom(nouveauPrenom);
                            }
                           return;
                        }
                    });

                    popupMenu.show(list, evt.getX(), evt.getY());
                }
            }
        });

    }

}
