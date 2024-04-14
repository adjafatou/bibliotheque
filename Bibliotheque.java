import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque {

    private String nom;
    private Map<String, Livre> catalogue; // Map pour le stock de livre
    private List<Utilisateur> utilisateurs; //La liste des utilisateurs

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.catalogue = new HashMap<>();
        this.utilisateurs = new ArrayList<>();
    }

    // Getters pour  nom, catalogue,  utilisateurs

    public String getNom() {
        return nom;
    }

    public Map<String, Livre> getCatalogue() {
        return catalogue;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    // Ajouter un livre dans mecatalogue
    public void ajouterLivre(Livre livre) {
        if (!catalogue.containsKey(livre.getISBN())) {
            catalogue.put(livre.getISBN(), livre);
            System.out.println("Livre ajouté au catalogue avec succès.");
        } else {
            System.out.println("Un livre avec l'ISBN " + livre.getISBN() + " existe déjà.");
        }
    }
//afficher la liste des utilisaturs en fait pour que  l'admi puisse les gerer
    public void afficherUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur inscrit.");
        } else {
            System.out.println("Liste des utilisateurs inscrits:");
            for (Utilisateur utilisateur : utilisateurs) {
                System.out.println(utilisateur);
            }
        }
    }
    // Retirer le livres du catalogue
    public void retirerLivre(String ISBN) {
        if (catalogue.containsKey(ISBN)) {
            catalogue.remove(ISBN);
            System.out.println("Livre avec l'ISBN " + ISBN + " retiré du catalogue.");
        } else {
            System.out.println("Aucun livre avec l'ISBN " + ISBN + " n'a été trouvé.");
        }
    }

    // On va verifier si un livre est dispo
    public boolean verifierDisponibiliteLivre(Livre livre) {
        return livre.getExemplairesDisponibles() > 0;
    }

    // Ca c'est pour diminuer les exemplaires en fait vu qu'on doit gerer la disponibilité
    public void decrementerExemplairesDisponibles(Livre livre) {
        livre.decrementerExemplairesDisponibles();
    }

    // on incremente
    public void incrementerExemplairesDisponibles(Livre livre) {
        livre.incrementerExemplairesDisponibles();
    }

    // On va inscrie uun nouvel urilisateur car l'administrateur a le pouvoir d'ajouter les utilisateurs
    public void inscrireUtilisateur(Utilisateur utilisateur) {
        if (!utilisateurs.contains(utilisateur)) {
            utilisateurs.add(utilisateur);
            System.out.println("Utilisateur " + utilisateur.getNom() + " inscrit avec succès.");
        } else {
            System.out.println("Un utilisateur avec le numéro d'identification " + utilisateur.getNumeroIdentification() + " existe déjà.");
        }
    }

    //recher un livre par titre auteur issbn
    public List<Livre> rechercherLivre(String motCle) {
        List<Livre> resultats = new ArrayList<>();
        for (Livre livre : catalogue.values()) {
            if (livre.getTitre().toLowerCase().contains(motCle.toLowerCase()) ||
                    livre.getAuteur().toLowerCase().contains(motCle.toLowerCase())) {
                resultats.add(livre);
            }
        }
        return resultats;
    }

    // afficher les livres en tant qu'admin
    public void afficherCatalogue() {
        if (catalogue.isEmpty()) {
            System.out.println("Le catalogue est vide.");
        } else {
            System.out.println("Liste des livres du catalogue:");
            for (Livre livre : catalogue.values()) {
                System.out.println(livre);
            }
        }
    }
}
