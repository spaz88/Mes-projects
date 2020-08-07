public class PortDePlaisance {
    private Bateau[] bateaux;
    private int nbBateaux;

    /**
     * 
     * @param max
     */
    public PortDePlaisance(int max) {
        bateaux = new Bateau[max];
        this.nbBateaux = 0;
    }

    /**
     * 
     */
    public PortDePlaisance() {
        bateaux = new Bateau[100];
        this.nbBateaux = 0;
    }

    /**
     * 
     * @return
     */
    public boolean isFull() {
        return this.nbBateaux == bateaux.length;
    }

    /**
     * 
     * @param bateau
     */
    public void ajouter(Bateau bateau) {
        this.bateaux[nbBateaux] = bateau;
        this.nbBateaux++;
    }

    /**
     * 
     * @param i
     * @return
     */
    public Bateau retirer(int i) {
        Bateau bateau = this.bateaux[i];
        for (int cpt = ++i; cpt < this.nbBateaux; cpt++) {
            bateaux[i--] = bateaux[i];
        }
        this.nbBateaux--;
        return bateau;
    }

    /**
     * 
     */
    public String toString() {
        String string = "";
        for (int cpt = 0; cpt < this.nbBateaux; cpt++) {
            string += "Bateau : " + this.bateaux[cpt].toString();
        }
        return string;
    }
}