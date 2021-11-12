import java.util.ArrayList;
/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class Action contient la mehtode rechrche, prend comme argument le fichier inverse et la requete
//renvoie une liste de document resultat
public class Action {
	public ListeDoc recherche(Inverse v, ArrayList<String> requete) {
		System.out.println("From rechreche");
		ListeDoc resultat = new ListeDoc();
		ListeDoc resultatF = new ListeDoc();
		ListeDoc resultatTMP = new ListeDoc();

		resultat = v.AllMots.get(requete.get(0));
		System.out.println("\n\n\n\nresultat initila :" + resultat);

		if (requete.size() > 1) {

			ArrayList<String> documentnom = new ArrayList<String>();
			for (int i = 1; i < requete.size(); i++) {
				resultatTMP = v.AllMots.get(requete.get(i));

				System.out.println("resultat TMP :" + resultatTMP);

				// On combine la list resultat initial avec list resulatt tmp

				// Si un document existe dans la liste résulat et dans la liste
				// de documents du mot
				// Alors incrementer la frequence du document dans la liste de resulat
				// par la freaquence de list de document

				NoeudDoc N = resultatTMP.getNdoc();

				NoeudDoc R = resultat.getNdoc();

				for (; N != null; N = N.getNext()) {

					// System.out.println(N.getD().getNom());
					documentnom.add(N.getD().getNom());

					for (; R != null; R = R.getNext()) {
						if (N.getD().getNom().equals(R.getD().getNom())) {
							System.out.println("kaytsawa");

							System.out.println(R.getD().getNom() + ": " + R.getD().getFreq());

							R.getD().setFreq(R.getD().getFreq() + N.getD().getFreq());
						}
					}
				}
				System.out.println("documentnom :" + documentnom);
				System.out.println("resultat final :" + resultat);
			}
			NoeudDoc R1 = resultat.getNdoc();
			for (; R1 != null; R1 = R1.getNext()) {
				if (documentnom.contains(R1.getD().getNom())) {
					resultatF.ajouterNoeudDoc(R1.getD().getNom(), R1.getD().getFreq());

					// System.out.println("R.getD().getNom() :"+R1.getD().getNom());
				}
			}
			return resultatF;
		} else {
			return resultat;
		}

	}

}
