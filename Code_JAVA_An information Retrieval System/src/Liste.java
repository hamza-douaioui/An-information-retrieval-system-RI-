/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class Liste represente une liste de Noeud{ Mot, Next } avec---> : Mot(mot,frequence)

public class Liste {

	private Noeud n;

	public Liste() {
		this.n = null;
	}

	public Liste(Noeud n) {
		this.n = n;
	}

	
	//methode permet d'jouter un nouvel neud a la fin de la liste
	public void ajouterNoed(String mot, int freq) {
		Noeud ajout = new Noeud(mot, freq);

		if (n == null)
			n = ajout;
		else {
			Noeud N = n;
			for (; N.getNext() != null; N = N.getNext())
				;

			N.setNext(ajout);
		}

	}


	public String toString() {
		return n + "";
	}

	public void afficherListe(Liste l) {

		System.out.print(l.n);

	}

	public Noeud getN() {
		return n;
	}

	public void setN(Noeud n) {
		this.n = n;
	}

}
