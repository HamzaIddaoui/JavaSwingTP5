package ApplicationDessin;

import java.awt.*;
import java.awt.event.*;

public class Planche extends Frame implements ActionListener, MouseListener, MouseMotionListener {
    ZoneDessin zone_dessin;
    private MenuItem quitter;
    private Panel barreOutil_panel,couleurCB_panel,remplircouleur_panel;
    private CheckboxGroup couleursCB;
    private Checkbox noir,blanc,vert,bleu,remplir;
    private Choice choix;
    private Button valider;
    private Point Ptdepart,Ptfin;
    public Planche(String title) throws HeadlessException {
        super(title);
        this.setLayout(new BorderLayout());
        MenuBar bar = new MenuBar();
        setMenuBar(bar);
        Menu menu1 = new Menu("Menu");
        bar.add(menu1);
        this.quitter = new MenuItem("Quitter");
        quitter.addActionListener(this);
        menu1.add(quitter);
        this.zone_dessin = new ZoneDessin();
        this.zone_dessin.addMouseListener(this);
        this.zone_dessin.addMouseMotionListener(this);
        this.add(this.zone_dessin,BorderLayout.CENTER);

        /** Zone d'outils **/
        this.barreOutil_panel = new Panel();
        /** Choix Rectangle/Elipse **/
        this.choix = new Choice();
        this.choix.addItem("Rectangle");
        this.choix.addItem("Elipse");
        this.barreOutil_panel.setLayout(new FlowLayout());
        this.barreOutil_panel.add(this.choix);
        /** Fin de Choix Rectangle/Elipse **/
        /** Choix de la couleur **/
        this.couleursCB = new CheckboxGroup();
        this.noir = new Checkbox("Noir",this.couleursCB,true);
        this.blanc = new Checkbox("Blanc",this.couleursCB,false);
        this.vert = new Checkbox("Vert",this.couleursCB,false);
        this.bleu = new Checkbox("Bleu",this.couleursCB,false);
        this.couleurCB_panel = new Panel();
        this.couleurCB_panel.setLayout(new FlowLayout());
        this.couleurCB_panel.add(this.noir);
        this.couleurCB_panel.add(this.blanc);
        this.couleurCB_panel.add(this.vert);
        this.couleurCB_panel.add(this.bleu);
        this.barreOutil_panel.add(this.couleurCB_panel);
        /** Fin de Choix de la couleur **/
        /** Choix de Remplissage **/
        this.remplircouleur_panel = new Panel();
        this.remplircouleur_panel.setLayout(new FlowLayout());
        Label remplir_label = new Label("Voulez vous remplir ? ");
        this.remplir = new Checkbox("Oui",false);
        this.remplircouleur_panel.add(remplir_label);
        this.remplircouleur_panel.add(this.remplir);
        this.barreOutil_panel.add(this.remplircouleur_panel);
        /** Fin de Choix de Remplissage **/

        /** Fin de Zone d'outils **/

        this.add(this.barreOutil_panel,BorderLayout.SOUTH);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public boolean Estremplie(){
        return this.remplir.getState();
    }

    public Color Couleur() {
        switch (this.couleursCB.getSelectedCheckbox().getLabel()) {
            case "Blanc":
                return Color.white;
            case "Vert":
                return Color.green;
            case "Bleu":
                return Color.blue;
            default:
                return Color.BLACK;
        }
    }

    public String Forme(){
        return this.choix.getSelectedItem();
    }

    public Point Ptdepart(){
        return this.Ptdepart;
    }

    public Point PtFin() {
        return this.Ptfin;
    }


    public static void main(String[] args){
        Planche planche = new Planche("Planche");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.quitter) {
            System.out.println("Fin d'execution .... ");
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        this.Ptdepart = (Point)e.getPoint();
        /**
        this.zone_dessin.setPlanche(this);
        this.zone_dessin.repaint();
         **/
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        this.Ptfin = (Point)e.getPoint();
        this.zone_dessin.setPlanche(this);
        this.zone_dessin.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
