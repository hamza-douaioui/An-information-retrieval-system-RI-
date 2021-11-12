import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

//class Index permet de construire la structure index de Document
//pour chaque document on stocke tous les mots et leurs frequences en utilisant la structure de liste simplement chainée que j'ai cree,
//les documents sont aussi enchainé dans une treemap a la place d'une liste "j'ai pas cree une liste pour enchaine les documents
//car les choses sont devenues un peu compliquées pour moi Monsieur" 
public class Index {
	TreeMap<String, Liste> AllDocuments;

	public Index() {
		AllDocuments = new TreeMap<String, Liste>();
	}
	
	
	//methode pour analyser le fichier texte, et retourne ArrayList<String> qui contient l'ensemble de mots contennus dans le fichier
	// separé par espace , le premier element de cette Arraylist est le Titre du ficher.

	public ArrayList<String> EnsembleDeMotsContenus(String fileName) throws IOException {
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);

		ArrayList<String> allMots = new ArrayList<>();
		
		if (f.isFile() && f.canRead()) {
			Scanner myReader = new Scanner(f);
			String title = myReader.nextLine();
			allMots.add(title);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] mots;
				mots = data.split("\\s+");
				for (String str : mots) {
					// if(!allMots.contains(str)){
					allMots.add(str);

				}

				dis.close();
				fis.close();
			}
		} else {
			System.out.println("Probleme Error!!");
			dis.close();
			fis.close();

		}

		return allMots;
	}

	
	
	
	// methode permet d'ajouter les mots du fichier contennus dans ArrayList<String> dans la liste des mots frequences et
	//retourner la liste des mots et ses frequence 
	//on utilise TreeMap pour bien compter les frequences des mots ,avant d'ajouter les mots et ses frequence a la liste 
	
	public Liste indextoList(ArrayList<String> mots) {

		TreeMap<String, Integer> m = new TreeMap<>();
		for (String m0 : mots) {
			if (!m.containsKey(m0)) {
				m.put(m0, 1);
			} else {

				m.put(m0, m.get(m0) + 1);
			}

		}

		Liste l = new Liste();
		Set<Map.Entry<String, Integer>> maSet = m.entrySet();
		for (Entry<String, Integer> entry : maSet) {

			l.ajouterNoed(entry.getKey(), entry.getValue());
		}
		return l;
	}

	
	
	//methode permet de donné la structure Index de document 
	//chaque document est identifier par son titre et la liste des mot, frequence
	//on utulise Treemap (allDocument) pour regrouper tous les documents ----->et listes
	
	public void Setdocuments(String name, Liste l) {

		this.AllDocuments.put(name, l);
		System.out.println(this.AllDocuments.size());

		Set<Entry<String, Liste>> maSet = this.AllDocuments.entrySet();
		System.out.println("\n***********from index ******** \n");
		for (Entry<String, Liste> entry : maSet) {
			System.out.println(entry.getKey() + " :" + entry.getValue());

		}
	}
	
	
	
	

	public TreeMap<String, Liste> getAllDocuments() {
		return AllDocuments;
	}

	public void setAllDocuments(TreeMap<String, Liste> allDocuments) {
		AllDocuments = allDocuments;
	}

}
