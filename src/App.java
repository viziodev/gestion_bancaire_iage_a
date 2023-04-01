import java.util.Scanner;

import models.Client;

public class App {
    public static void main(String[] args) throws Exception {
       int choix;
       Scanner scanner=new Scanner(System.in);

       do {
            System.out.println("1-Ajouter un Client");
            System.out.println("2-Lister les Clients");
            System.out.println("3-Afficher par Telephone");
            System.out.println("4-Quitter");
            System.out.println("Faites un choix");
            choix=scanner.nextInt();
            switch (choix) {
                case 1:
                    Client client=new Client();
                    System.out.println("Entrer l'id");
                    client.setId(scanner.nextInt());
                    System.out.println("Entrer le Nom et le Prenom");
                    client.setNomComplet(scanner.nextLine());
                    System.out.println("Entrer le Telephone");
                    client.setTelephone(scanner.nextLine());
                    
                    break;
            
                case 2:
                    
                    break;
                default:
                    break;
            }

       } while (choix!=4);
       


       scanner.close();
    }
}
