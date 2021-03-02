package jackpot2021;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        SlotGraphique Slot = new SlotGraphique(1000);
        Slot.setLocationRelativeTo(null);
        Slot.setVisible(true);
        
        Joueur Jean = new Joueur("Jean", 100);
        Slot.setJoueur(Jean);
        Slot.crediter(40);

        Slot Machine = new Slot(1000);

        Joueur Joseph = new Joueur("Joseph", 100);
        Joseph.afficher();

        Joseph.prendreMachine(Machine);

        int sommeJouee = 50;

        Machine.crediter(sommeJouee);

        Scanner clavier = new Scanner(System.in);

        int mise = 0;

        do {
            System.out.print("Votre mise (0 pour arrêter de jouer) : ");
            mise = clavier.nextInt();
            Machine.miser(mise);
            Machine.spin();
        } while ((Machine.getCredits() < (sommeJouee + 20)) && (Machine.getCredits() > 0) && (mise > 0));

        if (Machine.getCredits() > 0) {

            System.out.println("Récupérez vos " + Machine.getCredits() + " crédits " + Joseph.getPrenom() + " !");
            Machine.encaisser();
        } else {
            System.out.println("Vous n'avez pas eu de chance " + Joseph.getPrenom() + ". Peut-être une prochaine fois !");
        }
    }
}
