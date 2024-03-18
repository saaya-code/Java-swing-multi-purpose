import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Principale extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menuTP;
    JMenuItem menuItemTp1;
    JMenuItem menuItemTp2;
    JDesktopPane desktop;
    Principale(){
        menuBar = new JMenuBar();
        this.setTitle("TP Java");
        this.setSize(1000,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktop = new JDesktopPane();
        this.add(desktop);

        menuTP = new JMenu("TPS");

        menuItemTp1 = new JMenuItem("TP1");
        menuItemTp2 = new JMenuItem("TP2");

        menuTP.add(menuItemTp1);
        menuTP.add(menuItemTp2);

        menuBar.add(menuTP);

        this.setJMenuBar(menuBar);
        this.setVisible(true);

        // listenners
        menuItemTp1.addActionListener(this);
        menuItemTp2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menuItemTp2){
            CreationProfil creationProfil = new CreationProfil();
            desktop.add(creationProfil);
        }else{
            TP0 tp0 = new TP0();
            desktop.add(tp0);
        }
    }
}


