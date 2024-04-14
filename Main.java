import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque("Bibliothèque ");

        // Initialisation dde livres
        Livre livre1 = new Livre("Une si longue lettre", "Mariama Ba", 1954, "21", 5, "Roman");
        Livre livre2 = new Livre("Les Contes d'Amadou Coumba", "Birago Diop", 1960, "31", 3, "Roman");
        Livre livre3 = new Livre("Harry Potter ", "Rowling", 1997, "41", 8, "Jeunesse");
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);
        bibliotheque.ajouterLivre(livre3);

        // Initialisation pour les users
       // Utilisateur utilisateur1 = new Utilisateur("Adja", 12345, "membre");
        Utilisateur utilisateur2 = new Utilisateur("Fatou", 67890, "admin");
        //bibliotheque.inscrireUtilisateur(utilisateur1);
        bibliotheque.inscrireUtilisateur(utilisateur2);

        //ici on a voulu faire un menu en fonction de chaque utilisateur connecté car les cas d'utilisations different

        int choix;
        do {
            System.out.println("\n\n******************************************");
            System.out.println("*****         Bibliothèque Adja Aissatou Mané         *****");
            System.out.println("***********************************************************");
            System.out.println("1. Connexion");
            System.out.println("2. Afficher le catalogue");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Quitter");
            System.out.println("************************************************************");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1: // Connexion
                    seConnecter(bibliotheque, scanner);
                    break;
                case 2: // Afficher le catalogue
                    bibliotheque.afficherCatalogue();
                    break;
                case 3: // Rechercher un livre
                    System.out.print("Mot-clé de recherche : ");
                    String motCle = scanner.nextLine();
                    // Code pour la recherche de livres
                    break;
                case 4: // Quitter
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);

        scanner.close();
    }

    private static void seConnecter(Bibliotheque bibliotheque, Scanner scanner) {
        System.out.println("\n***** Connexion *****");
        System.out.print("Numéro d'identification : ");
        int numeroIdentification = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        // Ici on va rechercher et on va recuperern l'utilisateur qui correspond aux identifiants donnes lors de la connexion.
        Utilisateur utilisateur = bibliotheque.getUtilisateurs().stream()
                .filter(u -> u.getNumeroIdentification() == numeroIdentification && u.getNom().equals(motDePasse))
                .findFirst()
                .orElse(null);

        if (utilisateur != null) {
            System.out.println("Connexion réussie pour " + utilisateur.getNom() + ".");
            menuUtilisateurConnecte(bibliotheque, scanner, utilisateur);
        } else {
            System.out.println("Identifiants incorrects. Veuillez réessayer");
        }
    }

    private static void menuUtilisateurConnecte(Bibliotheque bibliotheque, Scanner scanner, Utilisateur utilisateur) {
        int choix;
        do {
            System.out.println("\n***** Menu Utilisateur *****");
            if (utilisateur.getRole().equals("membre")) {
                System.out.println("1. Consulter mes livres empruntés");
                System.out.println("2. Emprunter un livre");
                System.out.println("3. Retourner un livre");
                System.out.println("4. Déconnexion");
            } else if (utilisateur.getRole().equals("admin")) {
                System.out.println("1. Gérer les livres");
                System.out.println("   1. Ajouter un livre");
                System.out.println("   2. Retirer un livre");
                System.out.println("2. Gérer les utilisateurs");
                System.out.println("   1. Ajouter un utilisateur");
                System.out.println("   2. Afficher la liste des utilisateurs");
                System.out.println("3. Déconnexion");
            } else {
                System.out.println("Erreur : rôle utilisateur inconnu.");
                break;
            }
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1: // Consulter mes livres empruntés (réservé aux membres)
                    if (utilisateur.getRole().equals("membre")) {
                        utilisateur.consulterLivresEmpruntes();
                    } else {
                        System.out.println("Cette option n'est pas disponible pour votre rôle.");
                    }
                    break;
                case 2: // Emprunter un livre (réservé aux membres)
                    if (utilisateur.getRole().equals("membre")) {
                        System.out.print("ISBN du livre à emprunter : ");
                        String ISBN = scanner.nextLine();
                        Livre livre = bibliotheque.getCatalogue().get(ISBN);
                        if (livre != null) {
                            utilisateur.emprunterLivre(livre, bibliotheque);
                        } else {
                            System.out.println("Aucun livre trouvé avec l'ISBN '" + ISBN + "'.");
                        }
                    } else {
                        System.out.println("Cette option n'est pas disponible pour votre rôle.");
                    }
                    break;
                case 3: // Retourner un livre (réservé aux membres)
                    if (utilisateur.getRole().equals("membre")) {
                        System.out.print("ISBN du livre à retourner : ");
                        String ISBN = scanner.nextLine();
                        Livre livre = bibliotheque.getCatalogue().get(ISBN);
                        if (livre != null) {
                            utilisateur.retournerLivre(livre, bibliotheque);
                        } else {
                            System.out.println("Aucun livre trouvé avec l'ISBN '" + ISBN + "'.");
                        }
                    } else {
                        System.out.println("Cette option n'est pas disponible pour votre rôle.");
                    }
                    break;

                case 4: // Déconnexion
                    System.out.println("Déconnecté avec succès.");
                    break;
                case 11: // Gérer les livres (réservé aux administrateurs)
                    if (utilisateur.getRole().equals("admin")) {
                        int choixLivre;
                        do {
                            System.out.println("\n***** Gestion des Livres *****");
                            System.out.println("1. Ajouter un livre");
                            System.out.println("2. Retirer un livre");
                            System.out.println("3. Retour");
                            System.out.print("Votre choix : ");

                            choixLivre = scanner.nextInt();
                            scanner.nextLine();

                            switch (choixLivre) {
                                case 1:
                                    System.out.print("Titre du livre : ");
                                    String titre = scanner.nextLine();
                                    System.out.print("Auteur : ");
                                    String auteur = scanner.nextLine();
                                    System.out.print("Année de publication : ");
                                    int anneePublication = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("ISBN : ");
                                    String ISBN = scanner.nextLine();
                                    System.out.print("Nombre d'exemplaires : ");
                                    int nombreExemplaires = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Type de livre : ");
                                    String typeLivre = scanner.nextLine();
                                    Livre nouveauLivre = new Livre(titre, auteur, anneePublication, ISBN, nombreExemplaires, typeLivre);
                                    bibliotheque.ajouterLivre(nouveauLivre);
                                    break;
                                case 2:
                                    System.out.print("ISBN du livre à retirer : ");
                                    ISBN = scanner.nextLine();
                                    bibliotheque.retirerLivre(ISBN);
                                    break;
                                case 3: // Retour
                                    break;
                                default:
                                    System.out.println("Choix invalide. Veuillez réessayer.");
                            }
                        } while (choixLivre != 3);
                    } else {
                        System.out.println("Cette option n'est pas disponible pour votre rôle.");
                    }
                    break;
                case 21: // Ajouter un utilisateur (réservé aux administrateurs)
                    if (utilisateur.getRole().equals("admin")) {
                        System.out.print("Nom de l'utilisateur : ");
                        String nom = scanner.nextLine();
                        System.out.print("Numéro d'identification : ");
                        int numeroIdentification = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Rôle de l'utilisateur : ");
                        String role = scanner.nextLine();
                        Utilisateur nouveauUtilisateur = new Utilisateur(nom, numeroIdentification, role);
                        bibliotheque.inscrireUtilisateur(nouveauUtilisateur);
                    } else {
                        System.out.println("Cette option n'est pas disponible pour votre rôle.");
                    }
                    break;
                case 22:
                    bibliotheque.afficherUtilisateurs();
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 3);
    }
}
