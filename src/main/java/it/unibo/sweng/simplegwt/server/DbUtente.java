package it.unibo.sweng.simplegwt.server;

import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.Deck;
import it.unibo.sweng.simplegwt.shared.Desiderio;
import it.unibo.sweng.simplegwt.shared.Possesso;
import it.unibo.sweng.simplegwt.shared.Utente;


import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;


//Nel db Utente si usa una BTreeMap dove ogni nodo è una coppia Stringa-Utente (la string aè la mail di quell'utente)

public class DbUtente extends RemoteServiceServlet{

	
	private static DB getDB() {
           
			DB	db = DBMaker.fileDB(new File("dbUtente")).closeOnJvmShutdown().make();
			return db;
		
	}
	
	//-----Registrazione utente-----------
	public static String registrazioneUtente(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String,Utente> Users;

		Users = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();
		//prima di inserire l'utente nel db controllo che la mail (che si trova in posizione 0 dell'arraylist) sia corretta
		boolean find = false;
		for(Entry<String,Utente> test : Users.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(dati.get(0))) {
				find = true;
			}
		}
		
		if(!find)
		{
			int id=Users.size()+1;

			//creo un nuovo utente passandogli email, password e nome
			Utente user = new Utente(dati.get(0),dati.get(1),dati.get(2),id);

			Users.put(user.getEmail(),user);
			
			db.commit();
			db.close();
			return "Registrazione completata";
		}
		else
			{
			
			db.commit();
			db.close();
			return "Errore";
			}
	}

	
	
	
	
	//--LOGIN Utente (si puo usare anche come metodo per la ricerca di un utente da ritornare)--------------
	public static Utente login(String email, String password) throws IllegalArgumentException{

		DB db = getDB();
		BTreeMap<String,Utente> Users = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();
		
		//ciclo per il controllo della mail nel db
		boolean find = false;
		for(Entry<String,Utente> test : Users.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(email)) {
				find = true;
			}
		}
		//se l'ho trovata ritorno l'utente che ha fatto l'accesso
		if(find){
			Utente user = Users.get(email);
			if(user.getPw().equals(password)) {
				db.close();
				return user;
				
			}else
				{
				db.close();
				return null;
				}
		}else {
			db.close();
			return null;
		}
	}

	//------Eliminazione utente---------------
	public static String deleteUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

		utenti.remove(email);
		db.commit();
		db.close();

		return "Successo";
	}

	
	//------Visualizzo info utente--------------
	public static String getInfoUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

		Utente user = Users.get(email);

		String all = "Email :" + user.getEmail() + "\nPassword : " + user.getPw() + "\nId : "+ user.getId()+ "\nNome : " + user.getNome() ;
		return all;
	}

	//-----Ottieni utente dalla mail------------
	public static Utente getUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();
		Utente user = Users.get(email);
		return user;

	}

		
	//-----Ritorna gli utenti---------------------
	public static ArrayList<Utente> getUtentiAll(){
		DB db = getDB();
		BTreeMap<String, Utente> Users = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();
		ArrayList<Utente> output = new ArrayList<Utente>();
		for(Entry<String,Utente> test : Users.entrySet()) {
			output.add(test.getValue());
		}
		
		return output;
	}
	
	
	//------Ritorna una stringa di tutte le entry del db----------
	public static String getDatabase() {
		DB db = getDB();
		String s = "";
		for(Entry<String,Object> test : db.getAll().entrySet()) {
			s += test.getValue().toString() + " | ";
		}

		return s;
	}

	//Modifica Utente passandogli la mail 
	//In posizione 0 della lista la nuova password, in posizione 1 il nuovo nome
	//La mail e l'id non sono modificabili. Se la posizione della lista è vuota vuol dire che quell'attributo non dev'essere modificato
	public static String modificaUtente(ArrayList<String> dati, String email) {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

		Utente utente = utenti.get(email);
		utenti.remove(email);
		if(dati.get(0).length()>=1)
		{
			utente.setPassword(dati.get(0));
		}
		
		if(dati.get(1).length()>=1)
		{
			utente.setNome(dati.get(2));
		}
		
		

		utenti.put(email, utente);
		db.commit();
		db.close();

		return "Successo";

	}
	
	
	
	
	
	
	
	
	
	//--------Inserisci Desiderio in arraylist specifico---------
	
    public static String InserisciDesiderio(Card card, int cond, String desc, String email)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	
		boolean find = false;
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(email)) {
				find = true;
			}
		}
		
		if(find)
		{
			Utente user_target=utenti.get(email);
			
			//controllo esistenza desiderio in arraylist
			
			Desiderio d=new Desiderio(card, cond, desc, user_target);
			
			int i=0;
			boolean trovato=false;
			while(i<user_target.getDesideri().size())
			{
				if(user_target.getDesideri().get(i).getCard().getId()==card.getId())
				{
					trovato=true;
				}
				i++;
			}
			
			if(!trovato)
			{
			utenti.remove(email);
	    	
	    	user_target.addDesiderio(d);
	    	
	    	utenti.put(user_target.getEmail(), user_target);
	    	
	    	db.commit();
	    	db.close();
	    	return "Desiderio inserito!";
			}
			else
			{
				db.close();
				return "Desiderio già espresso per quella carta.";
			}
		}
		else
		{
			db.close();
			return "Email non presente nel sistema.";
		}
		
    	
    }
	
	
	
   //------- Elimina Desiderio da arraylist specifico---------------
    //(passandogli anche la carta per la quale è riferito il desiderio)
	
    
    public static String EliminaDesiderio(String email, Card card)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	
		
		boolean find = false;
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(email)) {
				find = true;
			}
		}
		
		if(find)
		{
    	   Utente user_target=utenti.get(email);
    	   
    	   utenti.remove(email);
    	
    	   user_target.removeDesiderio(card.getId());
    	   
    	   utenti.put(user_target.getEmail(), user_target);
    	   
    	   db.commit();
    	   db.close();
    	   return "Desiderio rimosso";
		}
		else
		{
	    	db.close();
	    	return "Email non presente nel sistema";
		}
    	
    }
	
	
	//-------Inserisci Possesso da arraylist specifico--------
    
    public static String InserisciPossesso(Card card, int cond, String desc, String email)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	
		boolean find = false;
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(email)) {
				find = true;
			}
		}
		
		if(find)
		{
			Utente user_target=utenti.get(email);
			
			Possesso d=new Possesso(card, cond, desc, user_target);
			
			//controllo su inserimento
			
			int i=0;
			boolean trovato=false;
			while(i<user_target.getPossessi().size())
			{
				if(user_target.getPossessi().get(i).getPossessedCard().getId()==card.getId())
				{
					trovato=true;
				}
				i++;
			}
			
			if(!trovato)
			{
			utenti.remove(email);
	    	
	    	user_target.addPossesso(d);
	    	
	    	utenti.put(user_target.getEmail(), user_target);
	    	
	    	db.commit();
	    	db.close();
	    	return "Possesso inserito!";
			}
			else
			{
				db.close();
				return "Possesso già inserito per quella carta.";
			}
		}
		else
		{
			db.close();
			return "Email non presente nel sistema.";
		}
		
    	
    }
    
    //--------Rimozione Possesso da lista di possessi------------
    
    public static String EliminaPossesso(String email, Card card)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	
		
		boolean find = false;
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue().getEmail().equalsIgnoreCase(email)) {
				find = true;
			}
		}
		
		if(find)
		{
    	   Utente user_target=utenti.get(email);
    	   
    	   utenti.remove(email);
    	
    	   user_target.removePossesso(card.getId());
    	   
    	   utenti.put(user_target.getEmail(), user_target);
    	   
    	   db.commit();
    	   db.close();
    	   return "Possesso rimosso";
    	   
    	   //Controllo che la carta passata sia relativa ad un possesso ancora esistente
		}
		else
		{
	    	db.close();
	    	return "Email non presente nel sistema";
		}
    	
    }
    
    
    
	//-----------------Crea e Inserisci Deck nell'arraylist (per ora non faccio controlli sullo 
    //user inserito perchè in teoria è preso dall'interfaccia)
    
    
    public static String CreaDeck(Utente user, String deckType)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

		Utente user_target=utenti.get(user.getEmail());
		
		utenti.remove(user.getEmail());
		
		//politica assegnamento id al deck
		int i=0;
		while(i<user_target.getDeck().size())
		{
			if(i<user_target.getDeck().get(i).getId())
			{
				i=user_target.getDeck().get(i).getId();
			}
			i++;
		}
		
		user_target.createDeck(user, i+1, deckType);
		
		utenti.put(user_target.getEmail(), user_target);
		
		db.commit();
		db.close();
		return "Deck creato!";
    }
    
    
    //-------Inserisci carta in Deck esistente-------
    
    //Gli passo la mail dell'utente che possiede il deck, il mazzo e la carta da inserire in quel mazzo
    //Poi gli passo il tipo di carta inserita ("pokemon","yugi","magic") 
    
    public static String InserisciCard(Card carta, Deck mazzo, String email, String cardType)
    {
    	
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	Utente user_target=utenti.get(email);
    	
    	
    	if(mazzo.getType().equals(cardType))
    	{
    	utenti.remove(email);
    	
    	
    	if(user_target.addCardToDeck(mazzo, carta)) //in questo metodo avviene il controllo sulla carta
    	{
    	utenti.put(email, user_target);
    	
		db.commit();
		db.close();
    	return "Carta inserita nel Deck.";
    	}
    	else
    	{
    		db.close();
    		return "Carta già presente nel Deck corrente!";
    	}
    	}else
    	{
    		db.close();
        	return "Deck non compatibile con quella tipologia di carta.";
    	}
    }
    
    
    //-----Elimina Deck-----------------
    
    //se non dovesse funzionare gli si passa l'id del mazzo
    public static String EliminaDeck(Deck mazzo, String email)
    {
    	
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	Utente user_target=utenti.get(email);
    	
    	utenti.remove(email);
    	
    	user_target.removeDeck(mazzo.getId()); 
    	
    	utenti.put(email, user_target);
    	
		db.commit();
		db.close();
    	return "Deck rimosso.";
    }
    
    
	//--------------Mostra Carte che l'utente desidera--------------------------
    
    public static ArrayList<Card> CarteDesiderate(String email)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	Utente user_target=utenti.get(email);
    	
    	ArrayList<Card> carteDesiderate=new ArrayList<Card>();
    	
    	//riempio la lista di carte desiderate e poi lo ritorno
    	
    	int i=0;
    	while(i<user_target.getDesideri().size())
    	{
    		carteDesiderate.add(user_target.getDesideri().get(i).getCard());
    		i++;
    	}
    	
    	
    	db.close();
    	return carteDesiderate;
    }
    
    
	//------------------Mostra carte che possiede----------------------
    
    
    public static ArrayList<Card> CartePossedute(String email)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	Utente user_target=utenti.get(email);
    	
    	ArrayList<Card> cartePossedute=new ArrayList<Card>();
    	
    	//riempio la lista di carte possedute e poi lo ritorno
    	
    	int i=0;
    	while(i<user_target.getPossessi().size())
    	{
    		cartePossedute.add(user_target.getPossessi().get(i).getPossessedCard());
    		i++;
    	}
    	
    	
    	db.close();
    	return cartePossedute;
    }
    
    //--------------Mostra i Deck posseduti------------------
    public static ArrayList<Deck> DeckCreati(String email)
    {
    	DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

    	Utente user_target=utenti.get(email);
    	
    	ArrayList<Deck> deckCreati=new ArrayList<Deck>();
    	
    	//riempio la lista di carte possedute e poi lo ritorno
    	
    	int i=0;
    	while(i<user_target.getDeck().size())
    	{
    		deckCreati.add(user_target.getDeck().get(i));
    		i++;
    	}
    	
    	
    	db.close();
    	return deckCreati;
    }
    
    //TODO: Metodo che prende in input un Deck e stampa la lista di carte che compongono quel deck
    
    
	public static void tryUser() {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.treeMap("UtentiMap", Serializer.STRING, Serializer.JAVA).createOrOpen();

		Utente user = new Utente("ciao","ciao","ciao",1);
		utenti.put(user.getEmail(), user);
		db.commit();
		db.close();
	}
	
}
