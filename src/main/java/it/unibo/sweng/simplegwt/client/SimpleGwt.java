package it.unibo.sweng.simplegwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class SimpleGwt implements EntryPoint{
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private TextBox TextBoxEmail = new TextBox();
	private TextBox TextBoxPassword = new TextBox();
	private Button addStockButton = new Button("Add");
	private Label testo = new Label();
	private Label testo2 = new Label();
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	
	public void onModuleLoad() {
		
		stocksFlexTable.setHTML(0, 0, "<h2>"+"Benvenuto Utente!"+"</h2>");
		stocksFlexTable.setText(1, 0, "");
		stocksFlexTable.setText(2, 0, "");
		stocksFlexTable.setText(3, 0, "");
		stocksFlexTable.setText(4, 0, "");
		
		testo.setText("Email:");
		testo2.setText("Password:");
		
		mainPanel.add(stocksFlexTable);
		mainPanel.add(testo);
	    mainPanel.add(TextBoxEmail);
	    mainPanel.add(testo2);
	    mainPanel.add(TextBoxPassword);
	    mainPanel.add(addStockButton);

	    
	    RootPanel.get("stockList").add(mainPanel);
	    
	    
	    addStockButton.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	          addStock();
	        }
	      });

	      // Listen for keyboard events in the input box.
	      TextBoxEmail.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	            addStock();
	          }
	        }
	      });
	    }

	    /**
	     * Add stock to FlexTable. Executed when the user clicks the addStockButton or
	     * presses enter in the newSymbolTextBox.
	     */
	    private void addStock() {
	 // Metodo per controllare che il contenuto della casella di testo della mail fosse tra 1 e 10 caratteri
	    	
	    	final String symbol = TextBoxEmail.getText().toUpperCase().trim();
	        TextBoxEmail.setFocus(true);

	        // Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
	        if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
	          Window.alert("'" + symbol + "' is not a valid symbol.");
	          TextBoxEmail.selectAll();
	          return;
	        }

	        TextBoxEmail.setText("");
	    }
}


