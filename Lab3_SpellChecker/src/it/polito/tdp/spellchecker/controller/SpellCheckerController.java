
	package it.polito.tdp.spellchecker.controller;

	import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;

	public class SpellCheckerController {

		Dictionary dizionario;
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> cmbLingua;

	    @FXML
	    private TextArea txtParole;

	    @FXML
	    private Button btncheck;

	    @FXML
	    private TextArea txtRisultato;

	    @FXML
	    private Label txtErrori;

	    @FXML
	    private Button btnClear;

	    @FXML
	    private Label txtTempo;

	    @FXML
	    void doCheck(ActionEvent event) {
	    	Long t1 =System.nanoTime();
	    	String lingua = cmbLingua.getValue();
	    	dizionario.loadDictionary(lingua);
	    	String testo = txtParole.getText();
	    	testo.replaceAll("[ \\p{Punct}]", "");
	    	ArrayList<String> inputText = new ArrayList<String> ();
	    	
	    	String parole [] = testo.split(" ");
	    	for(String s : parole){
	    		inputText.add(s);
	    	}
	    	ArrayList<RichWord> risultato =  dizionario.spellCheckText(inputText);
	    	ArrayList<RichWord> errori = new ArrayList<RichWord> ();
	    	for(RichWord r : risultato){
	    		if(r.isCorretta()==false){
	    			errori.add(r);
	    		}
	    	}
	    	Long t2 =System.nanoTime();
	    		txtRisultato.setText(errori.toString());
	    		txtErrori.setVisible(true) ;
	    		txtTempo.setVisible(true) ;
	    		txtErrori.setText("Hai fatto"+ errori.size() +"errori");
	    		txtTempo.setText("spell check completato in secondi:"+(t2-t1)/1e9);


	    }

	    @FXML
	    void doClear(ActionEvent event) {
	    	txtRisultato.clear();
	    	txtParole.clear();
	    	txtErrori.setVisible(false);
    		txtTempo.setText("spell check completato in secondi:"+System.currentTimeMillis());


	    }

	    @FXML
	    void initialize() {
	        assert cmbLingua != null : "fx:id=\"cmbLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btncheck != null : "fx:id=\"btncheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";

	        cmbLingua.getItems().addAll("English", "Italian");
	        // per evitare che si crei una nullPointerException
	        if(cmbLingua.getItems().size()>0)
	        	cmbLingua.setValue(cmbLingua.getItems().get(0));

	    }
		public void setModel(Dictionary model2) {
			this.dizionario= model2;
			
		}

	}

	

