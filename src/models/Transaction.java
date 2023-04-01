package models;

import java.util.Date;

public class Transaction {
    private double montant;
    private Date  date;
    private Type type;
    
    public Transaction() {
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return  "Montant" + montant 
                + "Date " + date 
                + "Type " + type ;
    }

    
}
