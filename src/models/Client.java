package models;

import java.util.ArrayList;

public class Client {

    private int id;
    private String nomComplet;
    private String telephone;
    //Attributs Navigationnels  
      //OneToMany
   // private  ArrayList<Compte> comptes=new ArrayList<>();

    //Methodes => Fonctions ou une Procedure
    /*

     * typeRetour  
     *   => Procedure  typeRetour=> void
     *   => Fonction   typeRetour=> !void
     * [public|private|protected] typeRetour nomMethode(){
     * 
     *    [return resultat]
     * }
     */

     //Constructeur(s)
     public Client(){
        
     }

   

     //Getters
     public int getId() {
        return id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getTelephone() {
        return telephone;
    }
     //Setters



    public void setId(int id) {
        this.id = id;
    }



    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }



    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

     //Metiers
     public String affiche(){
        return "Id :"+id
               +"\nNom et Prenom :"+nomComplet
               +"\nTelephone :"+telephone;
     }

     public boolean estEgal(Client client){
        return this.id==client.getId();
     }

}
