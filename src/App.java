import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import models.Client;
import models.Compte;
import models.Transaction;
import models.Type;
import services.ClientService;
import services.CompteService;

public class App {
    public static void main(String[] args) throws Exception {
       int choix;
       Scanner scanner=new Scanner(System.in);
       //Creation du Service
       ClientService service=new ClientService();
       CompteService compteService=new CompteService();
     
       do {
            System.out.println("1-Ajouter un Client");
            System.out.println("2-Lister les Clients");
            System.out.println("3-Afficher un  par Telephone");
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
                    case 4:
                        //Creer un compte
                          scanner.nextLine();
                        //Saisit du Telephone
                            System.out.println("Entrer le Telephone");
                            tel=scanner.nextLine();
                        //Appel au Service
                           client =service.findClientByTelephone(tel);
                            if(client==null){
                                System.out.println("Le client n'existe pas");   
                            }else{
                                //Client existe 
                                //Creer Compte 
                                Compte compte =new Compte();
                                System.out.println("Entrer l'id du compte");
                                compte.setId(scanner.nextInt());
                                scanner.nextLine();
                                System.out.println("Entrer le numero  du compte");
                                compte.setNumCompte(scanner.nextLine());
                                System.out.println("Entrer le solde du compte");
                                compte.setSolde(scanner.nextDouble());
                                //Affectation du Client
                                  //Navigabilite Compte==> Client
                                   compte.setClient(client);
                                 //Navigabilite Client==> Compte
                                  client.addCompte(compte);
                                 compteService.creerUnCompte(compte);
                            }
                       break;

                    case 5:
                        //Lister les comptes
                        ArrayList<Compte> comptes= compteService.listerCompte();
                        for (Compte cpt : comptes) {
                            System.out.println(cpt);//System.out.println(cpt.toString());
                        }
                      break;
                  case 6:
                        //Lister les comptes
                           scanner.nextLine();
                          //Saisit du Telephone
                            System.out.println("Entrer le Telephone");
                            tel=scanner.nextLine();
                        //Appel au Service
                           client =service.findClientByTelephone(tel);
                            if(client==null){
                                System.out.println("Le client n'existe pas");   
                            }else{
                                //recuperer la liste de compte de ce client
                                    comptes= client.getComptes();
                                    for (Compte cpt : comptes) {
                                        System.out.println(cpt);//System.out.println(cpt.toString());
                                    }
                            }
                      
                       break;

                       case 7:
                       //Lister les comptes
                         scanner.nextLine();
                       //Saisit du Telephone
                         System.out.println("Entrer le numero du Compte");
                         String num=scanner.nextLine();
                        Compte cpt =compteService.findCompteByNum(num);
                        if(cpt==null){
                            System.out.println("Ce numero de Compte  n'existe pas");
                        }else{
                             Transaction transaction =new Transaction();
                            //Faire une Transaction
                            int typeTrans;
                            do{
                              System.out.println(" 0-Depot\n,1-Retrait\n,2-Virement ");
                              typeTrans=scanner.nextInt();
                            }while(typeTrans<0 || typeTrans>2);
                            
                            if(typeTrans==0){
                                transaction.setType(Type.Depot);
                            }else if(typeTrans==1){
                                transaction.setType(Type.Retrait);
                            }else{
                                transaction.setType(Type.Virement);
                            }
                              System.out.println("Entrer le montant de la Transaction");
                              transaction.setMontant(scanner.nextDouble());
                              //Recuperation de la Date du Jour
                              transaction.setDate(new Date());
                              //Compte => Transaction
                                cpt.addTransaction(transaction);
                              //Transaction => Compte 
                                transaction.setCompte(cpt); 
                        }
                       break;
                       case 8:
                       //Lister les comptes
                       scanner.nextLine();
                       //Saisit du Telephone
                         System.out.println("Entrer le numero du Compte");
                          num=scanner.nextLine();
                          cpt =compteService.findCompteByNum(num);
                        if(cpt==null){
                            System.out.println("Ce numero de Compte  n'existe pas");
                        }else{
                           ArrayList<Transaction> transactions=cpt.getTransactions();
                           for (Transaction t : transactions) {
                               System.out.println(t);
                           }
                        }
                       break;
                default:
                    break;
            }

       } while (choix!=9);
       


       scanner.close();
    }
}
