package it.unibo.sweng.simplegwt.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private String nome;
	private int Id;
	private ArrayList<Deck> deck;
	private ArrayList<Possesso> possessi;
	private ArrayList<Desiderio> desideri;
	
	public Utente()
	{
		
	}
	
	public Utente(String email, String password, String nome,int Id) {
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.Id=Id;
		this.possessi=new ArrayList<Possesso>();
		this.desideri=new ArrayList<Desiderio>();
		this.deck=new ArrayList<Deck>();
	}
	

	public String getEmail(){
		return this.email;		
	}
	
	public String getPw(){
		return this.password;
	}
	

	public String getNome(){
		return this.nome;		
	}
	
	public int getId(){
		return this.Id;		
	}
	
	public ArrayList<Deck> getDeck()
	{
		return this.deck;
	}
	
	public int setId(int Id){
		return this.Id=Id;		
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addDesiderio(Desiderio desiderio)
	{
		this.desideri.add(desiderio);
	}
	
	public void addPossesso(Possesso possesso)
	{
		this.possessi.add(possesso);
	}
	
	public void createDeck(Utente user, int idDeck, String tipo)
	{
		Deck d=new Deck(user, idDeck, tipo);
		this.deck.add(d);
	}
	
	public boolean addCardToDeck(Deck mazzo, Card carta)
	{
		//ciclo i deck e cerco quello con l'id specificato, poi gli aggiungo la carta 
		int i=0;
		while(i<this.deck.size())
		{
			if(this.deck.get(i).getId()==mazzo.getId())
			{
				int j=0;
				boolean trovata=false;
				while(j<this.deck.get(i).getCardList().size())
				{
					//se trovo una carta con l'id uguale a quello che voglio inserire pongo trovata=true
					if(this.deck.get(i).getCardList().get(j).getId()==carta.getId())
					{
						trovata=true;
					}
					j++;
				}
				
				//effettui questo inserimento solo se non c'è una carta uguale
				if(!trovata)
				{
				this.deck.get(i).addCardList(carta);
				return true;
				}
			}
			i++;
		}
		return false;
		
	}
	
	public void removeDeck(int idDeck)
	{
		int i=0;
		while(i<this.deck.size())
		{
			if(this.deck.get(i).getId()==idDeck)
			{
		        this.deck.remove(i);
			}
			i++;
		}
	}
	
	//Rimozione Desiderio (rimuovo il desiderio relativo alla carta con l'Id passato in input)
	public void removeDesiderio(int IdCard)
	{
		int i=0;
		while(i<this.desideri.size())
		{
			if(this.desideri.get(i).getCard().getId()==IdCard)
			{
				this.desideri.remove(i);
			}
			i++;
		}
	}
	
	//Rimozione possesso (rimuovo il possesso relativo alla carta con l'Id passato in input)
	public void removePossesso(int IdCard)
	{
		int i=0;
		while(i<this.possessi.size())
		{
			if(this.possessi.get(i).getPossessedCard().getId()==IdCard)
			{
				this.possessi.remove(i);
			}
			i++;
		}
	}
	
	public ArrayList<Desiderio> getDesideri()
	{
		return this.desideri;
	}
	
	public ArrayList<Possesso> getPossessi()
	{
		return this.possessi;
	}
}
