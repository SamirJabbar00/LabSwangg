package it.unibo.sweng.simplegwt.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class RichiestaScambio implements Serializable{

	private int IdRichiesta;
	private Utente userMittente;
	private Utente userDestinatario;
	private ArrayList<Card> carteProposte;
	private ArrayList<Card> carteRichieste;
	private String esito; //"in attesa","accettata" o "rifiutata"
	
	
	public RichiestaScambio()
	{}
	
	public RichiestaScambio(Utente userMitt, Utente userDest, ArrayList<Card> carteProposte, ArrayList<Card> carteRichieste,int Id)
	{
		this.userMittente=userMitt;
		this.userDestinatario=userDest;
		this.carteProposte=carteProposte;
		this.carteRichieste=carteRichieste;
		this.IdRichiesta=Id;
		this.esito="in attesa";
	}
	
	public Utente getMittente()
	{
		return this.userMittente;
	}
	
	public Utente getDestinatario()
	{
		return this.userDestinatario;
	}
	
	public void accettaRichiesta()
	{
		this.esito="accettata";
	}
	
	public void rifiutaRichiesta()
	{
		this.esito="rifiutata";
	}
	
	public String getEsito()
	{
		return this.esito;
	}
	
	public int getId()
	{
		return this.IdRichiesta;
	}
	
	public ArrayList<Card> getCarteProposte()
	{
		return this.carteProposte;
	}
	
	public ArrayList<Card> getCarteRichieste()
	{
		return this.carteRichieste;
	}
	
}
