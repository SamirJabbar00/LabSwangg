package it.unibo.sweng.simplegwt.server;

import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.CardMagic;
import it.unibo.sweng.simplegwt.shared.CardPokemon;
import it.unibo.sweng.simplegwt.shared.CardYugi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mapdb.DB;
import org.mapdb.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;



public class ListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context initialized.");
        System.out.println("Loading data from file");
        
      
        
        //se non è mai stato creato un dbCard allora lo creo e ci metto le carte lette dal Json
      
			//Lettura carte Magic
		   DB	db=DBMaker.fileDB(new File("/Users/giuseppecacciapuoti/eclipse-workspaces/simplegwt/dbCardMagic")).closeOnJvmShutdown().make();
		
			BTreeMap<Integer, CardMagic> map = db.treeMap("MagicMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
        
			try {
        	Gson gson=new GsonBuilder().setPrettyPrinting().create();
        	JsonReader jread=new JsonReader(new FileReader("/Users/giuseppecacciapuoti/eclipse-workspaces/simplegwt/src/main/java/it/unibo/sweng/simplegwt/server/magic.json"));
        	CardMagic[] cards=gson.fromJson(jread, CardMagic[].class);
        	
        	int i=0;
        	while(i<cards.length)
        	{
        		cards[i].setId(i);
        		map.put(cards[i].getId(), cards[i]);
        		
        		i++;
        	}
        	db.commit();
        	db.close();
        
        	//Lettura Carte YugiOh
        DB	db2 = DBMaker.fileDB(new File("/Users/giuseppecacciapuoti/eclipse-workspaces/simplegwt/dbCardYugi")).closeOnJvmShutdown().make();
        
        	
        	BTreeMap<Integer, CardYugi> map2 = db2.treeMap("YugiMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
        	
        	JsonReader jread2=new JsonReader(new FileReader("/Users/giuseppecacciapuoti/eclipse-workspaces/simplegwt/src/main/java/it/unibo/sweng/simplegwt/server/yugi.json"));
        	CardYugi[] cards2=gson.fromJson(jread2, CardYugi[].class);
        	
        	int j=0;
        	while(j<cards2.length)
        	{
        		cards2[j].setId(i);
        		map2.put(cards2[j].getId(), cards2[j]);
        		
        		
        		i++;
        		j++;
        		
        	}
        	db2.commit();
        	db2.close();
        	
        	//Lettura carte Pokemon
        DB	db3 = DBMaker.fileDB(new File("/Users/giuseppecacciapuoti/eclipse-workspaces/simplegwt/dbCardPokemon")).closeOnJvmShutdown().make();
    
        	BTreeMap<Integer, CardPokemon> map3 = db3.treeMap("PokemonMap", Serializer.INTEGER, Serializer.JAVA).createOrOpen();
        	
        	JsonReader jread3=new JsonReader(new FileReader("/Users/giuseppecacciapuoti/eclipse-workspaces/simplegwt/src/main/java/it/unibo/sweng/simplegwt/server/pokemon.json"));
        	CardPokemon[] cards3=gson.fromJson(jread3, CardPokemon[].class);
        	
        	int k=0;
        	while(k<cards3.length)
        	{
        		cards3[k].setId(i);
        		map3.put(cards3[k].getId(), cards3[k]);
        		
        		
        		i++;
        		k++;
        		
        	}
        	db3.commit();
    		db3.close();
    		
    		
    		
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
        	
        }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Content Destroyed");
    }
}