package it.polito.tdp.spellchecker.model;


import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
public class Dictionary {
	
	private ArrayList<String> dizionario = new ArrayList<String>();
	
	public void loadDictionary (String lingua){
		try{
			FileReader fr = null;
			lingua=lingua.toLowerCase() ;
			if(lingua.compareTo("english")==0){
				fr = new FileReader("rsc/English.txt");
				}
			if(lingua.compareTo("italian")==0){
				fr = new FileReader("rsc/Italian.txt");
				}
			BufferedReader br = new BufferedReader (fr);
			String word;
			while((word = br.readLine())!=null){
				dizionario.add(word.toLowerCase().trim());
				}	
			br.close();
			} catch(IOException e){
				System.out.println("Errore nella lettura del file!");
			}
	}
	
	public ArrayList<RichWord> spellCheckText(List<String> inputTextList){
		ArrayList <RichWord> listaParole = new ArrayList <RichWord> ();
		RichWord word = null ;
		for(String s : inputTextList){
			word = new RichWord(s);
			if(dizionario.contains(s)){
				word.setCorretta(true);
				}
			listaParole.add(word);
		}
		return listaParole;
		
	}
	
//	public ArrayList<RichWord> spellCheckText2(List<String> inputTextList){
//		ArrayList <RichWord> listaParole = new ArrayList <RichWord> ();
//		RichWord word = null ;
//		for(String s : inputTextList){
//			word = new RichWord(s);
//			if(this.doRicerca(s)){
//				word.setCorretta(true);
//				listaParole.add(word);
//			}
//			

//}		
//		
//		
//		return null;
//		
//	}
	
}
