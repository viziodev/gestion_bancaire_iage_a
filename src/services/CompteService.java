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

}
