public class Livre {

    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;
    private int nombreExemplaires; // Nombre total d'exemplaires
    private int exemplairesDisponibles; // Nombre d'exemplaires disponibles
    private String typeLivre;

    public Livre(String titre, String auteur, int anneePublication, String ISBN, int nombreExemplaires, String typeLivre) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
        this.nombreExemplaires = nombreExemplaires;
        this.exemplairesDisponibles = nombreExemplaires; // Au début, tous les exemplaires sont disponibles
        this.typeLivre = typeLivre;
    }

    // Getters et setters pour tous les attributs

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }

    public int getExemplairesDisponibles() {
        return exemplairesDisponibles;
    }

    public void setExemplairesDisponibles(int exemplairesDisponibles) {
        this.exemplairesDisponibles = exemplairesDisponibles;
    }

    public String getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(String typeLivre) {
        this.typeLivre = typeLivre;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anneePublication=" + anneePublication +
                ", ISBN='" + ISBN + '\'' +
                ", nombreExemplaires=" + nombreExemplaires +
                ", exemplairesDisponibles=" + exemplairesDisponibles +
                ", typeLivre='" + typeLivre + '\'' +
                '}';
    }

    public void decrementerExemplairesDisponibles() {
        this.exemplairesDisponibles--;
    }

    public void incrementerExemplairesDisponibles() {
        this.exemplairesDisponibles++;
    }
}
