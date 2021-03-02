package jackpot2021;

public class Joueur {

    private String prenom;
    private int credits;

    private Slot machine;

    public Joueur(String prenom, int credits) {
        this.prenom = prenom;
        this.credits = credits;

        machine = null;
    }

    public void prendreMachine(Slot machine) {
        this.machine = machine;
        this.machine.setJoueur(this);
    }

    public String getPrenom() { return prenom; }
    public int getCredits() { return credits; }

    public void jouerCredits(int credits) {
        this.credits -= credits;
    }
    public void encaisserCredits(int credits) {
        this.credits += credits;
        afficher();
    }

    public void afficher() {
        System.out.println(prenom + " possède " + credits + " crédits en poche.");
    }
}
