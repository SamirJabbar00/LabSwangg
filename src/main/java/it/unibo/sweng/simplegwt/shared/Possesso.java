package it.unibo.sweng.simplegwt.shared;

import java.io.Serializable;

public class Possesso implements Serializable{

	    private Card possessedCard;  //Carta associata al possesso
	    private int conditions;  //condizioni della carte (da 1 a 5)
	    private String possessedCardDescription;  //Descrizione della carta posseduta
	    private Utente userOfPossession;  //Utente che possiede quella carta
	    
	    public Possesso(Card possessedCard, int conditions, String possessedCardDescription, Utente userOfPossession) {
	        this.possessedCard = possessedCard;
	        this.conditions = conditions;
	        this.possessedCardDescription = possessedCardDescription;
	        this.userOfPossession = userOfPossession;
	    }
	    
	    // metodi getter e setter
	    
	    public Card getPossessedCard() {
	        return possessedCard;
	    }
	    
	    public void setPossessedCard(Card possessedCard) {
	        this.possessedCard = possessedCard;
	    }
	    
	    public int getConditions() {
	        return conditions;
	    }
	    
	    public void setConditions(int conditions) {
	        this.conditions = conditions;
	    }
	    
	    public String getPossessedCardDescription() {
	        return possessedCardDescription;
	    }
	    
	    public void setPossessedCardDescription(String possessedCardDescription) {
	        this.possessedCardDescription = possessedCardDescription;
	    }
	    
	    public Utente getUserOfPossession() {
	        return userOfPossession;
	    }
	    
	    public void setUserOfPossession(Utente userOfPossession) {
	        this.userOfPossession = userOfPossession;
	    }
	
}
