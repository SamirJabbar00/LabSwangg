package it.unibo.sweng.simplegwt.shared;
import java.io.Serializable;
import java.util.ArrayList;
public class Deck implements Serializable{

	    private Utente userOwner; //Utente che ha creato quel deck
	    private ArrayList<Card> cardList; //Lista di carte che fanno parte del deck
	    private String tipo; //tipo di carta "pokemon", "yugi" o "magic"
	    private int Id;

	    
	    
	    public Deck(Utente userOwner, int Id, String tipo) {
	        this.userOwner = userOwner;
	        this.cardList = new ArrayList<Card>();
	        this.Id=Id;
	        this.tipo=tipo;
	    }

	    // getters and setters
	    public Utente getUserProperty() {
	        return userOwner;
	    }
	    
	    public String getType()
	    {
	    	return this.tipo;
	    }

	    public void setUserOwner(Utente userOwner) {
	        this.userOwner = userOwner;
	    }

	    public ArrayList<Card> getCardList() {
	        return cardList;
	    }

	    public void switchCardList(ArrayList<Card> cardList) {
	        this.cardList = cardList;
	    }
	    
	    public void addCardList(Card carta) {
	        this.cardList.add(carta);
	        }
	    
	    public void removeCardList(Card carta) {
	        this.cardList.remove(carta); //rimuove la prima occorrenza della carta (assicurarsi non ci siano due carte uguali nel deck)
	    }
	    
	    public int getId()
	    {
	    	return this.Id;
	    }

}
