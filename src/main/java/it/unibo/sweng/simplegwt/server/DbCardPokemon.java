package it.unibo.sweng.simplegwt.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import it.unibo.sweng.simplegwt.shared.CardPokemon;
import it.unibo.sweng.simplegwt.shared.Utente;

public class DbCardPokemon extends RemoteServiceServlet{

		
		private static DB getDB() {
	         
				DB	db = DBMaker.fileDB(new File("dbCardPokemon")).closeOnJvmShutdown().make();
				return db;
			
		}
		
		
		
		public static String searchIllustrator(String illustrator) {
			DB db = getDB();
			BTreeMap<Integer, CardPokemon> cards = db.treeMap("PokemonMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();

			//ciclo per il controllo della mail nel db
			boolean find = false;
			for(Entry<Integer,CardPokemon> test : cards.entrySet()) {
				
				  if( test.getValue() !=null && test.getValue().getIllustrator()!=null)
				  {
					  if(test.getValue().getIllustrator().equalsIgnoreCase(illustrator))
					  {
						  find=true;
					  }
				  }
				
			}
			db.close();
			//se l'ho trovata ritorno l'utente che ha fatto l'accesso
			if(find){
				return "SI";
			}
			else
			{
				return "NO";
			}
			
		
		}
		
		
		//Ritorna catalogo
			
		public static ArrayList<CardPokemon> mostraCatalogoPokemon()
		{
			DB db = getDB();
			BTreeMap<Integer, CardPokemon> cards = db.treeMap("PokemonMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();

			ArrayList<CardPokemon> carte=new ArrayList<CardPokemon>();
			
			int i=1;
			while(i<cards.size()+1)
			{
				carte.add(cards.get(i+400));
				i++;
			}
			db.close();
			return carte;
			
		}
		
		
	


}
