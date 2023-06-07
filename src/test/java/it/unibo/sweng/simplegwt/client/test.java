package it.unibo.sweng.simplegwt.client;



import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

import it.unibo.sweng.simplegwt.server.GreetingServiceImpl;
import it.unibo.sweng.simplegwt.shared.Card;
import it.unibo.sweng.simplegwt.shared.CardPokemon;
import it.unibo.sweng.simplegwt.shared.Deck;
import it.unibo.sweng.simplegwt.shared.Utente;

public class test{

	static GreetingServiceImpl tryTest;
	
	@Before
	public void ready()
	{
		GreetingService i=mock(GreetingService.class);
		tryTest=new GreetingServiceImpl();
		tryTest.setMock(i);
		
	}
	
	
	/*@Test
	public void testRegistrazione()
	{
		ArrayList<String> utenti=new ArrayList<String>();
		utenti.add("pino");
		utenti.add("pino");
		utenti.add("pino");
		System.out.println(tryTest.registrazioneUtente(utenti));
	}
	
	@Test
	public void testStart() {
		tryTest.tryUser();
	}
	
	
	@Test
	public void testlogin()
	{
		System.out.println(tryTest.login("ciao", "ciao"));
	}
	
	
	@Test
	public void cercaIllustratore()
	{
		System.out.println(tryTest.searchIllustrator("Ken Sugimori"));
	}
	
	
	@Test
	public void mostraCatalogoPokemon()
	{
		int i=0;
		while(i<tryTest.mostraCatalogoPokemon().size())
		{
		     System.out.println(tryTest.mostraCatalogoPokemon().get(i).getName());
		     i++;
		}
	}
	
	@Test
	public void mostraCatalogoMagic()
	{
		int i=0;
		while(i<tryTest.mostraCatalogoMagic().size())
		{
		     System.out.println(tryTest.mostraCatalogoMagic().get(i).getName());
		     i++;
		}
	}
	
	@Test
	public void mostraCatalogoYugi()
	{
		int i=0;
		while(i<tryTest.mostraCatalogoYugi().size())
		{
		     System.out.println(tryTest.mostraCatalogoYugi().get(i).getName());
		     i++;
		}
	}
	
	
	
	//DESIDERI
	@Test
	public void InserisciDesiderio()
	{
		Card carta=tryTest.OttieniCartaMagic(50);
		Card carta2=tryTest.OttieniCartaMagic(51);
		
		System.out.println(tryTest.InserisciDesiderio(carta, 3, "Carta Forte", "ciao"));
		System.out.println(tryTest.InserisciDesiderio(carta2, 3, "Carta Forte", "ciao"));
	}
	
	
	@Test
	public void EliminaDesiderio()
	{
		System.out.println(tryTest.EliminaDesiderio("ciao",tryTest.OttieniCartaMagic(51) ));
	}
	
	
	@Test
	public void StampaDesideri()
	{
		System.out.println(tryTest.MostraCarteDesiderate("ciao"));
	}

	
	
	//POSSESSI
	@Test
	public void EliminaPossesso()
	{
		Card carta=tryTest.OttieniCartaMagic(51);
		System.out.println(tryTest.EliminaPossesso("ciao", carta));
	}
	
	
	@Test
	public void InserisciPossesso()
	{
		Card carta=tryTest.OttieniCartaMagic(50);
		System.out.println(tryTest.InserisciPossesso(carta, 2, "Bella", "ciao"));
	}
	
	@Test
	public void InserisciPossesso2()
	{
		Card carta=tryTest.OttieniCartaMagic(50);
		System.out.println(tryTest.InserisciPossesso(carta, 2, "Bella", "ciao"));
	}
	
	@Test
	public void StampaPossesso()
	{
		System.out.println(tryTest.MostraCartePossedute("ciao"));
	}
	
	
	@Test
	public void CreaDeck()
	{
		Utente u=tryTest.login("ciao", "ciao");
		System.out.println(tryTest.CreaDeck(u, "Pokemon"));
	}
	

	@Test
	public void CreaDeck2()
	{
		Utente u=tryTest.login("ciao", "ciao");
		System.out.println(tryTest.CreaDeck(u, "Pokemon"));
	}
	
	
	@Test
	public void EliminaDeck()
	{
		Deck d=tryTest.StampaDeck("ciao").get(1);
		System.out.println(tryTest.EliminaDeck(d, "ciao"));
	}
	
	@Test
	public void MostraDeck()
	{
		System.out.println(tryTest.StampaDeck("ciao"));
	}
	
	
	@Test
	public void CreaRichiesta()
	{
		Utente u1=tryTest.login("ciao", "ciao");
		Utente u2=tryTest.login("pino", "pino");
		
		ArrayList<Card> lista1=new ArrayList<Card>();
		ArrayList<Card> lista2=new ArrayList<Card>();
		
		System.out.println(tryTest.CreaRichiesta(u1, u2, lista1, lista2));
	}
	
	@Test
	public void StampaRichiesta()
	{
		System.out.println(tryTest.MostraRichiesta(1));
	}
	
	
	@Test
	public void AccettaRichiesta()
	{
		System.out.println(tryTest.AccettaRichiesta(1));
	}
	
	*/
	@Test
	public void RifiutaRichiesta()
	{
		System.out.println(tryTest.RifiutaRichiesta(1));
	}
	
}
