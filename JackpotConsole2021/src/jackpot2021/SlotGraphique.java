package jackpot2021;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SlotGraphique extends JFrame implements lSlot {

    private int banque;
    private int credits;
    private int mise;
    private int rouleaux[];
    private JPanel banquePanel;
    private JLabel lblBanque;
    private JPanel rouleauxPanel;
    private JLabel lblRouleaux[];
    private JPanel joueurPanel;
    private JLabel lblCreditsJoueur;
    private JLabel lblDerniereMise;
    private JLabel lblGains;
    private JPanel misePanel;
    private JTextField txtMise;
    private JButton btnMiser;
    private JButton btnJouer;
    private JPanel caissePanel;
    private JButton btnEncaisser;

    private Joueur joueur;
    
    private int temp = 0;

    public SlotGraphique(int banque) {
        this.banque = banque;
        rouleaux = new int[3];
        credits = 0;
        mise = 0;
        joueur = null;

        //initialisation graphique
        setTitle("Jackpot !");
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(480, 640));
        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Layout principal de la fenetre
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        initialiserInterface();
    }

    private void initialiserInterface() {
        /**
         * * Panneau Banque **
         */
        banquePanel = new JPanel();
        banquePanel.setLayout(new FlowLayout());

        // On ajoute le panneau "BANQUE" à la fenetre
        this.add(banquePanel);

        // Ensuite le label lblBanque pour afficher ce que contient la machine :
        lblBanque = new JLabel("Banque : " + Integer.toString(this.banque) + " credits");

        // On ajuste les propriétés d'affichage
        lblBanque.setHorizontalAlignment(JLabel.CENTER);

        // Enfin, on ajoute le label au panneau "BANQUE"
        banquePanel.add(lblBanque);

        /**
         * * Panneau "ROULEAUX" **
         */
        rouleauxPanel = new JPanel();
        rouleauxPanel.setLayout(new FlowLayout());

        // On ajoute le panneau "ROULEAUX" àla fenêtre
        this.add(rouleauxPanel);

        // Ensuite les 3 chiffres des rouleaux :
        lblRouleaux = new JLabel[3];

        int min = 1;
        int max = 4;

        for (int i = 0; i < 3; i++) {

            // On créé un JLabel pour chacun des chiffres
            lblRouleaux[i] = new JLabel("7");
            // On personnalise son rendu esthétique
            lblRouleaux[i].setOpaque(true);
            lblRouleaux[i].setBackground(Color.white);
            lblRouleaux[i].setFont(new Font("MV Boli", 1, 72));
            lblRouleaux[i].setHorizontalAlignment(JLabel.CENTER);
            lblRouleaux[i].setPreferredSize(new Dimension(140, 200));
            // Enfin, on ajoute le chiffre au panneau "ROULEAUX"
            rouleauxPanel.add(lblRouleaux[i]);

        }
        /**
         * * Panneau "JOUEUR" ****
         */
        joueurPanel = new JPanel();
        joueurPanel.setLayout(new GridLayout(1, 3));

        // On ajoute le panneau "JOUEUR" à la fenêtre
        this.add(joueurPanel);

        // Ensuite on initialise et personnalise les labels :
        lblCreditsJoueur = new JLabel("Crédits joueur : - ");
        lblDerniereMise = new JLabel("Denière mise : - ");
        lblGains = new JLabel("Gains : - ");

        lblCreditsJoueur.setHorizontalAlignment(JLabel.CENTER);
        lblDerniereMise.setHorizontalAlignment(JLabel.CENTER);
        lblGains.setHorizontalAlignment(JLabel.CENTER);

        // Enfin, on ajoute les labels au panneau "JOUEUR"
        joueurPanel.add(lblCreditsJoueur);
        joueurPanel.add(lblDerniereMise);
        joueurPanel.add(lblGains);

        /**
         * * Panneau "MISE" ****
         */
        misePanel = new JPanel();
        misePanel.setLayout(new FlowLayout());

        // On ajoute le panneau "MISE" à la fenêtre
        this.add(misePanel);

        // Ensuite on initialise et personnalise les composants 
        txtMise = new JTextField();
        btnMiser = new JButton("Miser");
        btnJouer = new JButton("Jouer");

        txtMise.setPreferredSize(new Dimension(100, 26));
        btnJouer.setPreferredSize(new Dimension(150, 26));

        // Enfin, on ajoute les composants au panneau
        misePanel.add(new JLabel("Votre mise : ")); // Vous comprenez cette ligne ?
        misePanel.add(txtMise);
        misePanel.add(btnMiser);
        misePanel.add(new JLabel(" ")); // Pour éviter de gérer les marges (pas idéal)
        misePanel.add(btnJouer);

        /**
         * * Panneau "CAISSE" ****
         */
        caissePanel = new JPanel();
        caissePanel.setLayout(new FlowLayout());

        // On ajoute le panneau "CAISSE" à la fenêtre
        this.add(caissePanel);

        // Ensuite on initialise et personnalise le bouton :
        btnEncaisser = new JButton("ENCAISSER");
        btnEncaisser.setPreferredSize(new Dimension(250, 50));

        // Enfin, on ajoute les composants au panneau
        caissePanel.add(btnEncaisser);

        btnMiser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                mise = Integer.parseInt(txtMise.getText());
                lblDerniereMise.setText("Mise : " + Integer.toString(mise));
                
                banque += mise;
                credits -= mise;
                lblCreditsJoueur.setText("Crédits joueur : " + Integer.toString(credits));
                lblBanque.setText("Banque : "+ Integer.toString(banque)+ " credits");
                
            }
        });
        btnJouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                genererRouleaux();
                
                for(int i=0; i<3; i++)
                {
                    lblRouleaux[i].setText(Integer.toString(rouleaux[i]));
                }
                
                lblGains.setText("Gains :  " + Integer.toString(calculerGains()));
                
                if (calculerGains() > 0){
                   credits += calculerGains();
                   lblCreditsJoueur.setText("Crédits joueur : " + Integer.toString(credits));
                }
                mise = 0;
                lblDerniereMise.setText("Mise : " + Integer.toString(mise));
            }

        });
        btnEncaisser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                encaisser();
                lblCreditsJoueur.setText("Crédits joueur : " + Integer.toString(credits));
                banque -= credits;
                lblBanque.setText("Banque : "+ Integer.toString(banque)+ " credits");
                
            }
        });

    }

    public void setJoueur(Joueur J) {
        joueur = J;
        lblCreditsJoueur.setText("Crédits joueur : 0");
    }

    public void crediter(int credits) {
        if ((joueur != null) && (credits <= joueur.getCredits())) {

            this.credits += credits;
            this.joueur.jouerCredits(credits);

            lblCreditsJoueur.setText("Crédits joueur : " + Integer.toString(credits));
        }

    }

    public void miser(int mise) {
        if (mise > credits) {
            System.out.println("XXX Vous n'avez pas les crédits suffisants pour miser cette somme. XXX");
            return;
        }

    }

    public void spin() {
        if (mise == 0) {
            return;
        }

        genererRouleaux();

        int gains = calculerGains();

        banque += mise;
        mise = 0;

        if (gains > 0) {

            banque -= gains;
            credits += gains;
        }
    }

    public void genererRouleaux() {
        int min = 0;
        int max = 10;

        for (int i = 0; i < 3; i++) {
            rouleaux[i] = (int) (Math.random() * (max - min)) + min;

        }
    }

    public int calculerGains() {
        int gains = 0;
        
        if ((rouleaux[0] == rouleaux[1]) && (rouleaux[0] == rouleaux[2])) {
            gains = 3 * mise; // Les 3 chiffres sont identiques !

        } else if ((rouleaux[0] == rouleaux[1]) || (rouleaux[0] == rouleaux[2]) || (rouleaux[1] == rouleaux[2])) {
            gains = mise; // 2 chiffres sont identiques !
        }
        
        return gains;
    }

    public void encaisser() {
        
            this.credits += temp;
            credits = 0;
    }

    public int getCredits() {
        return credits;
    }
}
