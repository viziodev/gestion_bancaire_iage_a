package services;

import java.util.ArrayList;

import models.Compte;

public class CompteService {

    private ArrayList<Compte> comptes=new ArrayList<>();

    public   ArrayList<Compte> listerCompte() {
        return comptes;
    }

    public void creerUnCompte(Compte compte){
        comptes.add(compte);
    }

    public Compte findCompteByNum(String numero){
       for (Compte compte : comptes) {
           if(compte.getNumCompte().compareTo(numero)==0){
               return compte;
           }
       }
          return null;
    }

}
