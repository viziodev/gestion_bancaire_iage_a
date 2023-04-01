package services;

import models.Client;

public class ClientService {

    /*
     * Tabelaux sont des classes
     * 1-Declaration
     * int[] tab;
     * 2-Intanciation un Tableau
     *   => Taille de Reservation=> nbre de Cellules
     *   final int N=5
     *   tab=new int[N];
     */
     //Attributs
     public final int N=10;//Constantes
     private Client[] tabClients=new Client[N];
     private int nbreClient=0;

    public ClientService() {

    }

    public void ajouterUnClient(Client client){
       tabClients[nbreClient]=client;
       nbreClient++;
    }
    

    public Client[] listerLesClient() {
        return tabClients;
    }

    public Client   findClientByTelephone(String tel){
        for (int index = 0; index < nbreClient; index++) {
               if(tabClients[index].getTelephone()==tel){
                return tabClients[index];
               }
        }
        return null;
    }
   

    public int getNbreClient() {
        return nbreClient;
    }

    
    
}
