/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class ListeDoc represente une liste de NoeudDOC{ document, Next } avec---> : Document(nom,frequence)

public class ListeDoc {

	private NoeudDoc n;

	public ListeDoc() {
		this.n = null;
	}

	public ListeDoc(NoeudDoc d) {
		this.n = d;
	}

	

	//methode permet d'jouter un nouvel neudDOc a la fin de la liste
	public void ajouterNoeudDoc(String nom, int freq) {
		NoeudDoc ajout = new NoeudDoc(nom, freq);

		if (n == null)
			n = ajout;
		else {

			NoeudDoc N = n;
			for (; N.getNext() != null; N = N.getNext())
				;

			N.setNext(ajout);
		}

	}

	public String toString() {
		return n + "";
	}

	public NoeudDoc getNdoc() {
		return n;
	}

	public void setNdoc(NoeudDoc n) {
		this.n = n;
	}

	public void afficherListeDoc(ListeDoc l) {

		System.out.print(l.n);

	}

}
