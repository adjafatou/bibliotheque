import java.util.ArrayList;

public class Utilisateur {

    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
    private boolean cotisationAjour;
    private String role; // Attribut pour stocker le rôle de l'utilisateur

    public Utilisateur(String nom, int numeroIdentification, String role) {
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>(); // Initialisation de livresEmpruntes avec une nouvelle ArrayList
        this.role = role;
    }

    // Getters et setters pour tous les attributs, y compris le rôle

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(int numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public ArrayList<Livre> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes) {
        this.livresEmpruntes = livresEmpruntes;
    }

    public boolean isCotisationAjour() {
        return cotisationAjour;
    }

    public void setCotisationAjour(boolean cotisationAjour) {
        this.cotisationAjour = cotisationAjour;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Méthodes pour emprunter et retourner des livres, vérifier les livres empruntés et mettre à jour le statut de cotisation

    public void emprunterLivre(Livre livre, Bibliotheque bibliotheque) {
        // Méthode emprunterLivre
    }

    public void retournerLivre(Livre livre, Bibliotheque bibliotheque) {
        // Méthode retournerLivre
    }

    public void consulterLivresEmpruntes() {
        // Méthode consulterLivresEmpruntes
    }



    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", numeroIdentification=" + numeroIdentification +
                ", livresEmpruntes=" + livresEmpruntes +
                ", role='" + role + '\'' +
                '}';
    }
}
