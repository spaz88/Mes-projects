package jackpot2021;


public interface lSlot {
    public void setJoueur(Joueur j);
    public void crediter(int credits);
    public void miser(int mise);
    public void spin();
    public int calculerGains();
    public void encaisser();
    public int getCredits();
}
