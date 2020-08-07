public class Bateau {
    private Proprietaire proprietaire;
    private String nom;
    private String type;
    private int immatriculation;

    /**
     * 
     * @param proprietaire
     * @param nom
     * @param type
     * @param immatriculation
     */
    public Bateau(Proprietaire proprietaire, String nom, String type, int immatriculation) {
        this.proprietaire = proprietaire;
        this.nom = nom;
        this.type = type;
        this.immatriculation = immatriculation;
    }

    /**
     * 
     * @return
     */
    public Proprietaire getProprietaire() {
        return this.proprietaire;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "Propriétaire : " + this.proprietaire.toString() + "\nNom : " + this.nom + "\nType : " + this.type
                + "\nImmatriculation : " + this.immatriculation;
    }
}