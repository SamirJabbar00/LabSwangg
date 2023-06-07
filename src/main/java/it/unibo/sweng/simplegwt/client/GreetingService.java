package it.unibo.sweng.simplegwt.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.CardMagic;
import it.unibo.sweng.simplegwt.shared.CardPokemon;
import it.unibo.sweng.simplegwt.shared.CardYugi;
import it.unibo.sweng.simplegwt.shared.Deck;
import it.unibo.sweng.simplegwt.shared.Desiderio;
import it.unibo.sweng.simplegwt.shared.RichiestaScambio;
import it.unibo.sweng.simplegwt.shared.Utente;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {


  String getDatabase() throws IllegalArgumentException;
  
  String registrazioneUtente(ArrayList<String> dati) throws IllegalArgumentException;
  
  String deleteUtente(String email) throws IllegalArgumentException;
  
  Utente login(String email, String password) throws IllegalArgumentException;
  
  String searchIllustrator(String illustrator) throws IllegalArgumentException;
  
  //Cataloghi Carte
  
  ArrayList<CardPokemon> mostraCatalogoPokemon() throws IllegalArgumentException;
  
  ArrayList<CardMagic> mostraCatalogoMagic() throws IllegalArgumentException;  
  
  Card OttieniCartaMagic(int Id) throws IllegalArgumentException;
  
  ArrayList<CardYugi> mostraCatalogoYugi() throws IllegalArgumentException;
  
  //Desideri
  
  String InserisciDesiderio(Card card, int cond, String desc,String email) throws IllegalArgumentException;
  
  String EliminaDesiderio(String email, Card card) throws IllegalArgumentException;
  
  ArrayList<Card> MostraCarteDesiderate(String email) throws IllegalArgumentException;
  
  //Possessi
  
  String EliminaPossesso(String email, Card card) throws IllegalArgumentException;
  
  ArrayList<Card> MostraCartePossedute(String email) throws IllegalArgumentException;
  
  String InserisciPossesso(Card card, int cond, String desc, String email) throws IllegalArgumentException;
  
  //Deck
  
  
  String CreaDeck(Utente user, String deckType) throws IllegalArgumentException;
  
  String EliminaDeck(Deck mazzo, String email) throws IllegalArgumentException;
  
  String InserisciCartaDeck(Card carta, Deck mazzo, String email, String cardType) throws IllegalArgumentException;
  
  ArrayList<Deck> StampaDeck(String email) throws IllegalArgumentException;
  
  //Richieste
  
  String MostraRichiesta(int Id) throws IllegalArgumentException;
  
  String AccettaRichiesta(int Id) throws IllegalArgumentException;
  
  String RifiutaRichiesta(int Id) throws IllegalArgumentException;
  
  String CreaRichiesta(Utente mittente, Utente destinatario, ArrayList<Card> carteRichieste, ArrayList<Card> carteProposte) throws IllegalArgumentException;
  
  ArrayList<RichiestaScambio> RichiesteRicevute(Utente destinatario) throws IllegalArgumentException;
  
  ArrayList<RichiestaScambio> RichiesteInviate(Utente mittente) throws IllegalArgumentException;
}


