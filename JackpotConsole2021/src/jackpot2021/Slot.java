package jackpot2021;

public class Slot {

    private int banque;
    private int credits;
    private int mise;
    private int rouleaux[];

    private Joueur joueur;

    public Slot(int banque) {
        this.banque = banque;

        rouleaux = new int[3];

        credits = 0;
        mise = 0;

        joueur = null;
    }

    public void setJoueur(Joueur J) {
        this.joueur = J;
    }

    public void crediter(int credits) {

        if (joueur == null) {
            System.out.println("Aucun joueur n'est sur la machine..");
        } else if (credits > joueur.getCredits()) {
            System.out.println("Le joueur n'a pas cette somme en poche..");
        } else {
            this.credits += credits;
            this.joueur.jouerCredits(credits);
            System.out.println(joueur.getPrenom() + " a crédité la machine de " + credits + " crédits.");
            System.out.println("Il lui reste " + joueur.getCredits() + " crédits en poche.");
        }
    }

    public void miser(int mise) {
        
        if (mise > credits) {
            System.out.println("XXX Vous n'avez pas les crédits suffisants pour miser cette somme. XXX");
            return;
        }
        
        this.mise += mise;
        this.credits -= mise;
    }

    public void spin() // Jouer ! fait tourner les rouleaux
    {
        if (mise == 0) {
            System.out.println("Vous devez misez au moins 1 crédit.");
            return;
        }

        genererRouleaux();

        int gains = calculerGains();

        banque += mise;
        mise = 0;

        if (gains > 0) {

            System.out.println("<<<<< VOUS AVEZ GAGNE " + gains + "€ >>>>>");

            banque -= gains;
            credits += gains;
        }

        afficher();
    }

    private void genererRouleaux() {

        int min = 1;
        int max = 4;

        for (int i = 0; i < 3; i++) {
            rouleaux[i] = (int) (Math.random() * (max - min)) + min;
        }

        System.out.println("+---+---+---+");
        System.out.println("+ " + rouleaux[0] + " + " + rouleaux[1] + " + " + rouleaux[2] + " +");
        System.out.println("+---+---+---+");
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

    public void afficher() {
        System.out.println("La machine contient " + banque + " crédit(s) en banque..");
        System.out.println("Vous avez " + credits + " crédit(s) dans la machine..\n");
    }

    public void encaisser() {

        if (joueur == null) {
            System.out.println("Le joueur est parti..");
        } else {
            joueur.encaisserCredits(credits);

            credits = 0;
            joueur = null;
        }
    }

    public int getCredits() {
        return credits;
    }
}
