import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class Inverse  permet de construire la structure Fichier Inverse
// stocke pour chaque mot index une list de documents contenant ce mot avec ses frequence respectives

public class Inverse {

	TreeMap<String, ListeDoc> AllMots;

	public Inverse() {
		AllMots = new TreeMap<String, ListeDoc>();

	}

	
	
	//methode permet de donner le fichier inverse d'apres le fichier index(TreeMap) en utilisant la classe "ListDoc" qui represente 
	//la lsite des documents et la frequence
	
	
	public Inverse(TreeMap<String, Liste> allDoc) {
		System.out.println("\n*********From inverse ********* \n");

		AllMots = new TreeMap<String, ListeDoc>();
		Liste l = new Liste();

		Set<Entry<String, Liste>> maSet = allDoc.entrySet();
		for (Entry<String, Liste> entry : maSet) {
			l = entry.getValue();
			Noeud N = l.getN();
			for (; N != null; N = N.getNext()) {

				String docName = entry.getKey();
				String mot = N.getM().getMot();
				int freq = N.getM().getFreq();

				if (!AllMots.containsKey(mot)) {
					ListeDoc nld = new ListeDoc();

					// System.out.println(mot +" --->"+docName+" : "+freq);

					nld.ajouterNoeudDoc(docName, freq);

					AllMots.put(mot, nld);

				} else {

					ListeDoc copie = AllMots.get(mot);
					copie.ajouterNoeudDoc(docName, freq);

					AllMots.put(mot, copie);

				}

				// System.out.println("*********");
				// ld.afficherListeDoc(ld);

			}

			// System.out.println(entry.getKey() +" :"+l);

		}

		Set<Entry<String, ListeDoc>> maSet1 = AllMots.entrySet();
		for (Entry<String, ListeDoc> entry : maSet1) {
			System.out.println(entry.getKey() + " :" + entry.getValue());

		}
	}

	public TreeMap<String, ListeDoc> getAllMots() {
		return AllMots;
	}

	public void setAllMots(TreeMap<String, ListeDoc> allMots) {
		AllMots = allMots;
	}

}
