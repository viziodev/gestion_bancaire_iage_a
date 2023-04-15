import java.util.Scanner;

import models.Client;
import services.ClientService;

public class App {
    public static void main(String[] args) throws Exception {
       int choix;
       Scanner scanner=new Scanner(System.in);
       //Creation du Service
       ClientService service=new ClientService();
     
       do {
            System.out.println("1-Ajouter un Client");
            System.out.println("2-Lister les Clients");
            System.out.println("3-Afficher par Telephone");
            System.out.println("4-Creer Compte");
            System.out.println("5-Lister les Comptes");
            System.out.println("6-Lister les Comptes d'un Client");
            System.out.println("7-Faire Transaction");
            System.out.println("8-Lister les Transactions d'un Compte");
            System.out.println("9-Quitter");
            System.out.println("Faites un choix");
            choix=scanner.nextInt();
            switch (choix) {
                case 1:
                    Client client=new Client();
                    System.out.println("Entrer l'id");
                    client.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Entrer le Nom et le Prenom");
                    client.setNomComplet(scanner.nextLine());
                    System.out.println("Entrer le Telephone");
                    client.setTelephone(scanner.nextLine());
                    //Ajouter Client
                    service.ajouterUnClient(client);
                    
                    break;
            
                case 2:
                    Client[] clients =service.listerLesClient();
                    int nbreClient=service.getNbreClient();
                        for (int index = 0; index < nbreClient; index++) {
                            System.out.println(clients[index].affiche());
                        }
                    break;

                case 3:
                     scanner.nextLine();
                     
                    //Saisit du Telephone
                        System.out.println("Entrer le Telephone");
                        String tel=scanner.nextLine();
                    //Appel au Service
                       client =service.findClientByTelephone(tel);
                        if(client==null){
                            System.out.println("Le client n'existe pas");   
                        }else{
                            System.out.println(client.affiche()); 
                        }
                    break;

                default:
                    break;
            }

       } while (choix!=9);
       


       scanner.close();
    }
}
