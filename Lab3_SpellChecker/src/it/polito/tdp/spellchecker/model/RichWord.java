package it.polito.tdp.spellchecker.model;

public class RichWord {
		
		private String parola;
		private boolean isCorretta;
		
		public RichWord(String parola) {
			super();
			this.parola = parola;
			this.isCorretta = false;
		}

		/**
		 * @return the parola
		 */
		public String getParola() {
			return parola;
		}

		/**
		 * @param parola the parola to set
		 */
		public void setParola(String parola) {
			this.parola = parola;
		}

		/**
		 * @return the isCorretta
		 */
		public boolean isCorretta() {
			return isCorretta;
		}

		/**
		 * @param isCorretta the isCorretta to set
		 */
		public void setCorretta(boolean isCorretta) {
			this.isCorretta = isCorretta;
		}

		@Override
		public String toString() {
			return parola+"\n";
		}
		
		
		
		




}
