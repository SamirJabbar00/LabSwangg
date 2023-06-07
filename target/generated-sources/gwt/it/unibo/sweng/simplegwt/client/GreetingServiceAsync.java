package it.unibo.sweng.simplegwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#getDatabase
     */
    void getDatabase( AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#registrazioneUtente
     */
    void registrazioneUtente( java.util.ArrayList<java.lang.String> dati, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#deleteUtente
     */
    void deleteUtente( java.lang.String email, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#login
     */
    void login( java.lang.String email, java.lang.String password, AsyncCallback<it.unibo.sweng.simplegwt.shared.Utente> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#searchIllustrator
     */
    void searchIllustrator( java.lang.String illustrator, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#mostraCatalogoPokemon
     */
    void mostraCatalogoPokemon( AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.CardPokemon>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#mostraCatalogoMagic
     */
    void mostraCatalogoMagic( AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.CardMagic>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#OttieniCartaMagic
     */
    void OttieniCartaMagic( int Id, AsyncCallback<it.unibo.sweng.simplegwt.shared.Card> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#mostraCatalogoYugi
     */
    void mostraCatalogoYugi( AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.CardYugi>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#InserisciDesiderio
     */
    void InserisciDesiderio( it.unibo.sweng.simplegwt.shared.Card card, int cond, java.lang.String desc, java.lang.String email, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#EliminaDesiderio
     */
    void EliminaDesiderio( java.lang.String email, it.unibo.sweng.simplegwt.shared.Card card, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#MostraCarteDesiderate
     */
    void MostraCarteDesiderate( java.lang.String email, AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.Card>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#EliminaPossesso
     */
    void EliminaPossesso( java.lang.String email, it.unibo.sweng.simplegwt.shared.Card card, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#MostraCartePossedute
     */
    void MostraCartePossedute( java.lang.String email, AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.Card>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#InserisciPossesso
     */
    void InserisciPossesso( it.unibo.sweng.simplegwt.shared.Card card, int cond, java.lang.String desc, java.lang.String email, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#CreaDeck
     */
    void CreaDeck( it.unibo.sweng.simplegwt.shared.Utente user, java.lang.String deckType, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#EliminaDeck
     */
    void EliminaDeck( it.unibo.sweng.simplegwt.shared.Deck mazzo, java.lang.String email, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#InserisciCartaDeck
     */
    void InserisciCartaDeck( it.unibo.sweng.simplegwt.shared.Card carta, it.unibo.sweng.simplegwt.shared.Deck mazzo, java.lang.String email, java.lang.String cardType, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#StampaDeck
     */
    void StampaDeck( java.lang.String email, AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.Deck>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#MostraRichiesta
     */
    void MostraRichiesta( int Id, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#AccettaRichiesta
     */
    void AccettaRichiesta( int Id, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#RifiutaRichiesta
     */
    void RifiutaRichiesta( int Id, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#CreaRichiesta
     */
    void CreaRichiesta( it.unibo.sweng.simplegwt.shared.Utente mittente, it.unibo.sweng.simplegwt.shared.Utente destinatario, java.util.ArrayList<it.unibo.sweng.simplegwt.shared.Card> carteRichieste, java.util.ArrayList<it.unibo.sweng.simplegwt.shared.Card> carteProposte, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#RichiesteRicevute
     */
    void RichiesteRicevute( it.unibo.sweng.simplegwt.shared.Utente destinatario, AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.RichiestaScambio>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see it.unibo.sweng.simplegwt.client.GreetingService#RichiesteInviate
     */
    void RichiesteInviate( it.unibo.sweng.simplegwt.shared.Utente mittente, AsyncCallback<java.util.ArrayList<it.unibo.sweng.simplegwt.shared.RichiestaScambio>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GreetingServiceAsync instance;

        public static final GreetingServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GreetingServiceAsync) GWT.create( GreetingService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
