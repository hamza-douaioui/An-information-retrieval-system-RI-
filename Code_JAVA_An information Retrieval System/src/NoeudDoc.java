/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class NoeudDoc represente une structure  qui contient la classe Document {nom,frequence} et next pour pointer sur l 'element suivant 
//afin qu'on puisse pointer sur l'elemnt suivant de la liste des documents frequence q'on va construire





public class NoeudDoc {

	private Document d;
	private NoeudDoc next;

	public NoeudDoc(String nom, int freq) {
		this.d = new Document(nom, freq);
		this.next = null;
	}

	public NoeudDoc(Document d, NoeudDoc next) {
		this.d = d;
		this.next = next;
	}

	public NoeudDoc(Document d) {
		this.d = d;
		this.next = null;
	}

	public Document getD() {
		return d;
	}

	public void setD(Document d) {
		this.d = d;
	}

	public NoeudDoc getNext() {
		return next;
	}

	public void setNext(NoeudDoc next) {
		this.next = next;
	}

	public String toString() {
		return d + "------>" + next;
	}

}
