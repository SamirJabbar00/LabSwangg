package it.unibo.sweng.simplegwt.server;

import java.io.File;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.RichiestaScambio;
import it.unibo.sweng.simplegwt.shared.Utente;

import java.util.ArrayList;

public class DbRichieste  extends RemoteServiceServlet{

	
	private static DB getDB() {
           
			DB	db = DBMaker.fileDB(new File("dbRichieste")).closeOnJvmShutdown().make();
			return db;
		
	} 
	
	public static String StampaRichiesta(int idRichiesta)
	{
		DB db = getDB();
		BTreeMap<Integer,RichiestaScambio> richieste;

		richieste = db.treeMap("RichiesteMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
		
		
		boolean find = false;
		for(Entry<Integer,RichiestaScambio> test : richieste.entrySet()) {
			if(test.getValue().getId()==idRichiesta) {
				find = true;
			}
		}
		
		
		if(find)
		{
			RichiestaScambio r=richieste.get(idRichiesta);
			db.close();
			return r.toString();
		}
		else
		{
			db.close();
			return "Non esiste una richiesta con quell'id.";
		}
		
		
		
	}
	
	public static String CreaRichiesta(Utente mittente, Utente destinatario, ArrayList<Card> carteRichieste, ArrayList<Card> carteProposte)
	{
		DB db = getDB();
		BTreeMap<Integer,RichiestaScambio> richieste;

		richieste = db.treeMap("RichiesteMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
		
		int id=0;
		for(Entry<Integer,RichiestaScambio> test : richieste.entrySet()) {
			if(test.getValue().getId()>id) {
				
				id=test.getValue().getId();
			}
		}
		
		
		RichiestaScambio r=new RichiestaScambio(mittente, destinatario, carteProposte, carteRichieste, id+1);
		
		richieste.put(id+1, r);
		
		
		db.commit();
		db.close();
		return "Richiesta inserita";
		
	}
	
	//Ritorno tutte le richieste ricevute da un utente (quelle che sono ancora in attesa)
	public static ArrayList<RichiestaScambio> RichiesteRicevute(Utente destinatario)
	{
		DB db = getDB();
		BTreeMap<Integer,RichiestaScambio> richieste;

		richieste = db.treeMap("RichiesteMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
		
		
		ArrayList<RichiestaScambio> r=new ArrayList<RichiestaScambio>();
		
		
		for(Entry<Integer,RichiestaScambio> test : richieste.entrySet()) {
			if(test.getValue().getDestinatario().getId()==destinatario.getId() && test.getValue().getEsito().equalsIgnoreCase("in attesa")) {
				r.add(test.getValue());
			}
		}
		
		db.close();
		return r;
		
	}
	
	
	//Ritorno tutte le richieste che un utente ha effettuato (quelle in attesa di risposta)
	public static ArrayList<RichiestaScambio> RichiesteInviate(Utente mittente)
	{
		DB db = getDB();
		BTreeMap<Integer,RichiestaScambio> richieste;

		richieste = db.treeMap("RichiesteMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
		
		
		ArrayList<RichiestaScambio> r=new ArrayList<RichiestaScambio>();
		
		
		for(Entry<Integer,RichiestaScambio> test : richieste.entrySet()) {
			if(test.getValue().getDestinatario().getId()==mittente.getId() && test.getValue().getEsito().equalsIgnoreCase("in attesa")) {
				r.add(test.getValue());
			}
		}
		
		db.close();
		return r;
		
	}
	
	//Metodo accettazione di una richiesta da parte di un utente
	
	public static String AccettaRichiesta(int idRichiesta)
	{
		DB db = getDB();
		BTreeMap<Integer,RichiestaScambio> richieste;

		richieste = db.treeMap("RichiesteMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
		
		boolean find = false;
		for(Entry<Integer,RichiestaScambio> test : richieste.entrySet()) {
			if(test.getValue().getId()==idRichiesta && test.getValue().getEsito().equalsIgnoreCase("in attesa")) {
				find = true;
			}
		}
		
		if(find)
		{
		RichiestaScambio r = richieste.get(idRichiesta);
		
		r.accettaRichiesta();
		
		richieste.remove(idRichiesta);
		
		richieste.put(idRichiesta, r);
		
		db.commit();
		db.close();
		return "Richiesta Accettata!";
		}
		else
		{
			db.close();
			return "Richiesta non accettabile.";
		}
		
	}
	
	
	//Metodo per rifiutare una richiesta
	public static String RifiutaRichiesta(int idRichiesta)
	{
		DB db = getDB();
		BTreeMap<Integer,RichiestaScambio> richieste;

		richieste = db.treeMap("RichiesteMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
		
		boolean find = false;
		for(Entry<Integer,RichiestaScambio> test : richieste.entrySet()) {
			if(test.getValue().getId()==idRichiesta && test.getValue().getEsito().equalsIgnoreCase("in attesa")) {
				find = true;
			}
		}
		
		if(find)
		{
		RichiestaScambio r = richieste.get(idRichiesta);
		
		r.rifiutaRichiesta();
		
		richieste.remove(idRichiesta);
		
		richieste.put(idRichiesta, r);
		
		db.commit();
		db.close();
		return "Richiesta rifiutata!";
		}
		else
		{
			db.close();
			return "Richiesta non rifiutabile.";
		}
		
	}
	

}
