package it.unibo.sweng.simplegwt.server;

import java.io.File;
import java.util.ArrayList;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import it.unibo.sweng.simplegwt.shared.CardMagic;
import it.unibo.sweng.simplegwt.shared.CardYugi;

public class DbCardYugi extends RemoteServiceServlet{

	
	private static DB getDB() {
          
			DB	db = DBMaker.fileDB(new File("dbCardYugi")).closeOnJvmShutdown().make();
			return db;
		
	}
	
	
	//Ritorna catalogo
		
	public static ArrayList<CardYugi> mostraCatalogoYugi()
	{
		DB db = getDB();
		BTreeMap<Integer, CardYugi> cards = db.treeMap("YugiMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();

		ArrayList<CardYugi> carte=new ArrayList<CardYugi>();
		
		int i=1;
		while(i<cards.size()+1)
		{
			carte.add(cards.get(i+200));
			i++;
		}
		db.close();
		return carte;
		
	}
	
	



}

