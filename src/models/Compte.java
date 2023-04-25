package models;

import java.util.ArrayList;

public class Compte {
    private int id;
    private String numCompte;
    private double solde;

    //Attributs Navigationnels => Issu des Relations
    //ManyToOne  (Getters et Setters)
    private Client client;

     private  ArrayList<Transaction> transactions=new ArrayList<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
         //Relation dans le sens Compte==>Client
         this.client = client;

    }

    public Compte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return    "ID :" + id 
               +  "  Numero Compte : " + numCompte 
               +  "  Solde : " + solde
               +  "  Client : " + client.getNomComplet()  ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numCompte == null) ? 0 : numCompte.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Compte other = (Compte) obj;
        if (numCompte == null) {
            if (other.numCompte != null)
                return false;
        } else if (!numCompte.equals(other.numCompte))
            return false;
        return true;
    }

    
}
