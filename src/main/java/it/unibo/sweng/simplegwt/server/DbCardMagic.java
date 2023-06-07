package it.unibo.sweng.simplegwt.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.CardMagic;
import it.unibo.sweng.simplegwt.shared.CardPokemon;
import it.unibo.sweng.simplegwt.shared.Utente;

public class DbCardMagic extends RemoteServiceServlet{

	
	private static DB getDB() {
        
			DB	db = DBMaker.fileDB(new File("dbCardMagic")).closeOnJvmShutdown().make();
			return db;
		
	}
	
	
	//Ritorna catalogo
		
	public static ArrayList<CardMagic> mostraCatalogoMagic()
	{
		DB db = getDB();
		BTreeMap<Integer, CardMagic> cards = db.treeMap("MagicMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();

		ArrayList<CardMagic> carte=new ArrayList<CardMagic>();
		
		int i=0;
		while(i<cards.size())
		{
			carte.add(cards.get(i));
			i++;
		}
		db.close();
		return carte;
		
	}
	
	
	//Ottieni card da Id
	public static Card OttieniCartaMagic(int Id)
	{
		DB db = getDB();
		BTreeMap<Integer, CardMagic> cards = db.treeMap("MagicMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();

		
		for(Entry<Integer,CardMagic> test : cards.entrySet()) {
			if(test.getValue().getId()==Id) {
				db.close();
				return test.getValue();
			}
		}

		db.close();
		return null;
	}
	
	



}
