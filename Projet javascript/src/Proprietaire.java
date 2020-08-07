import java.util.Date;

public class Proprietaire {
    private String nom;
    private String prenom;
    private String adresse;
    private Date date;

    /**
     * 
     * @param nom
     * @param prenom
     */
    public Proprietaire(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * 
     * @param nom
     * @param prenom
     * @param adresse
     * @param date
     */
    public Proprietaire(String nom, String prenom, String adresse, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.adresse = adresse;
    }

    /**
     * 
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * 
     * @return
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * 
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 
     */
    public String toString() {
        return "Nom : " + this.nom + "\nPrenom : " + this.prenom + "\nAdresse : " + this.adresse + "\nDate : "
                + this.date;
    }
}