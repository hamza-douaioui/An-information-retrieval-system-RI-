/*
 * Réalisé par : Hamza Douaioui
 * 
 * */



//class Mot represente la structure String mot , et son frequence ; Mot {mot,frequence} 


public class Mot {

	private String mot;
	private int freq;

	public Mot(String mot, int freq) {
		this.mot = mot;
		this.freq = freq;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public String toString() {
		return "(" + mot + "," + freq + ")";
	}

}
