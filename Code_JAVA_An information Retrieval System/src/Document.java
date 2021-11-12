/*
 * Réalisé par : Hamza Douaioui
 * 
 * */



//class Document represente la structure String nom de document , et la frequence du mot frequence dans ce document 

public class Document {

	private String nom;
	private int freq;

	public Document(String nom, int freq) {
		this.nom = nom;
		this.freq = freq;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public String toString() {
		return "(" + nom + "," + freq + ")";
	}

}
