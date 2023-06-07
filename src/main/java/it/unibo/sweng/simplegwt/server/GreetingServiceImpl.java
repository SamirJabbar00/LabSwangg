package it.unibo.sweng.simplegwt.server;

import it.unibo.sweng.simplegwt.client.GreetingService;
import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.CardMagic;
import it.unibo.sweng.simplegwt.shared.CardPokemon;
import it.unibo.sweng.simplegwt.shared.CardYugi;
import it.unibo.sweng.simplegwt.shared.Deck;
import it.unibo.sweng.simplegwt.shared.RichiestaScambio;
import it.unibo.sweng.simplegwt.shared.Utente;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import it.unibo.sweng.simplegwt.server.DbUtente;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

  
  @Override
	public String getDatabase() throws IllegalArgumentException {
	  
			return DbUtente.getDatabase();
	}
  
  
  public String deleteUtente(String email)
  {
	  
	return DbUtente.deleteUtente(email);
  }
  
  @Override
  public String registrazioneUtente(ArrayList<String> dati) {
		return DbUtente.registrazioneUtente(dati);
	}
  
  public Utente login(String email, String password)
  {
	  return DbUtente.login(email, password);
  }
  
  
  public String searchIllustrator(String illustrator)
  {
	  return DbCardPokemon.searchIllustrator(illustrator);
  }
  
  //Cataloghi carte
  
  public ArrayList<CardPokemon> mostraCatalogoPokemon()
  {
	  return DbCardPokemon.mostraCatalogoPokemon();
  }
  
  public ArrayList<CardMagic> mostraCatalogoMagic()
  {
	  return DbCardMagic.mostraCatalogoMagic();
  }
  
  public Card OttieniCartaMagic(int Id)
  {
	  return DbCardMagic.OttieniCartaMagic(Id);
  }
  
  public ArrayList<CardYugi> mostraCatalogoYugi()
  {
	  return DbCardYugi.mostraCatalogoYugi();
  }
  
  //Desideri
  
  public String InserisciDesiderio(Card card, int cond, String desc, String email)
  {
	  return DbUtente.InserisciDesiderio(card, cond, desc, email);
  }
  
  public String EliminaDesiderio(String email, Card card)
  {
	  return DbUtente.EliminaDesiderio(email, card);
  }
  
  public ArrayList<Card> MostraCarteDesiderate(String email)
  {
	  return DbUtente.CarteDesiderate(email);
  }
  
  //Possessi
  
  public String InserisciPossesso(Card card, int cond, String desc, String email)
  {
	  return DbUtente.InserisciPossesso(card, cond, desc, email);
  }
  
  public String EliminaPossesso(String email, Card card)
  {
	  return DbUtente.EliminaPossesso(email, card);
  }
  
  public ArrayList<Card> MostraCartePossedute(String email)
  {
	  return DbUtente.CartePossedute(email);
  }
  
  //Deck
  
  public String CreaDeck(Utente user, String deckType)
  {
	  return DbUtente.CreaDeck( user,  deckType);
  }
  
  public String EliminaDeck(Deck mazzo, String email)
  {
	  return DbUtente.EliminaDeck(mazzo, email);
  }
  
  public String InserisciCartaDeck(Card carta, Deck mazzo, String email, String cardType)
  {
	  return DbUtente.InserisciCard(carta, mazzo, email, cardType);
  }
  
  public ArrayList<Deck> StampaDeck(String email)
  {
	  return DbUtente.DeckCreati(email);
  }
  
  //Richieste
  
  public String MostraRichiesta(int id)
  {
	  return DbRichieste.StampaRichiesta(id);
  }
  
  public String AccettaRichiesta(int Id)
  {
	  return DbRichieste.AccettaRichiesta(Id);
  }
  
  public String RifiutaRichiesta(int Id)
  {
	  return DbRichieste.RifiutaRichiesta(Id);
  }
  
  public String CreaRichiesta(Utente mittente, Utente destinatario, ArrayList<Card> carteRichieste, ArrayList<Card> carteProposte)
  {
	  return DbRichieste.CreaRichiesta(mittente, destinatario, carteRichieste, carteProposte);
  }
  
  public ArrayList<RichiestaScambio> RichiesteRicevute(Utente destinatario)
  {
	  return DbRichieste.RichiesteRicevute(destinatario);
  }
  
  public ArrayList<RichiestaScambio> RichiesteInviate(Utente mittente)
  {
	  return DbRichieste.RichiesteInviate(mittente);
  }
  
  //test
  private GreetingService mock = null;

	public GreetingService getMock() {
		return mock;
	}
  
  public void setMock(GreetingService mock) {
		this.mock = mock;
	}
  
  public void tryUser() {
		DbUtente.tryUser();
	}
}
