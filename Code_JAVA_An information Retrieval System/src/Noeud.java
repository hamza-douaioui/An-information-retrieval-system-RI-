/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class Noeud represente la structure Noeud qui contient Mot {mot,frequence} et next pour pointer sur l 'element suivant 
//afin qu'on puisse pointer sur l'elemnt suivant de la liste q'on va construire




public class Noeud {

	private Mot m;
	private Noeud next;

	
	//Constricteurs
	public Noeud(String mot, int freq) {
		this.m = new Mot(mot, freq);
		this.next = null;
	}

	public Noeud(Mot m) {
		this.m = m;
		this.next = null;
	}

	public Noeud(Mot m, Noeud next) {
		this.m = m;
		this.next = next;
	}

	public Mot getM() {
		return m;
	}

	public void setM(Mot m) {
		this.m = m;
	}

	public Noeud getNext() {
		return next;
	}

	public void setNext(Noeud next) {
		this.next = next;
	}

	public String toString() {
		return m + "--->" + next;
	}

}
