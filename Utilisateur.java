import java.util.ArrayList;

public class Utilisateur {

    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
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

   
   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Méthodes pour emprunter et retourner des livres, vérifier les livres empruntés et mettre à jour le statut de cotisation

    public void emprunterLivre(Livre livre, Bibliotheque bibliotheque) {
        // Vérifier si le livre est disponible
        if (bibliotheque.verifierDisponibiliteLivre(livre)) {
            // Diminuer le nombre d'exemplaires disponibles dans la bibliothèque
            bibliotheque.decrementerExemplairesDisponibles(livre);

            // Ajouter le livre à la liste des livres empruntés par cet utilisateur
            livresEmpruntes.add(livre);

            System.out.println("Livre emprunté avec succès : " + livre.getTitre());
        } else {
            System.out.println("Désolé, ce livre n'est pas disponible pour l'emprunt.");
        }
    }

    public void retournerLivre(Livre livre, Bibliotheque bibliotheque) {
        // Vérifier si l'utilisateur a emprunté ce livre
        if (livresEmpruntes.contains(livre)) {
            // Augmenter le nombre d'exemplaires disponibles dans la bibliothèque
            bibliotheque.incrementerExemplairesDisponibles(livre);

            // Retirer le livre de la liste des livres empruntés par cet utilisateur
            livresEmpruntes.remove(livre);

            System.out.println("Livre retourné avec succès : " + livre.getTitre());
        } else {
            System.out.println("Vous n'avez pas emprunté ce livre, donc vous ne pouvez pas le retourner.");
        }
    }


    public void consulterLivresEmpruntes() {
        if (livresEmpruntes.isEmpty()) {
            System.out.println("Vous n'avez emprunté aucun livre.");
        } else {
            System.out.println("Livres empruntés par " + nom + ":");
            for (Livre livre : livresEmpruntes) {
                System.out.println(livre.getTitre() + " - " + livre.getAuteur());
            }
        }
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
