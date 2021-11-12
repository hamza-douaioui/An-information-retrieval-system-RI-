import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/*
 * Réalisé par : Hamza Douaioui
 * 
 * */

/*Classe de l interface graphique pour permettre à l utilisateur d interagir avec 
 * le systeme */
public class Interface extends JFrame implements ActionListener {

	// la declaration des composants de l interface
	JLabel Fichier;
	JTextField FichierFiled;
	JButton Indexer, AnnulerTout, EffacerConsole, Rechercher, Quitter;
	JTextArea zoneDoc, zoneTitre;
	ListeDoc Resul;
	
	Index i;
	Inverse orginalV;
	Action a;

	// Constricteur de l interface
	public Interface() {
		i = new Index();
		orginalV = new Inverse();
		a = new Action();
		Resul = new ListeDoc();
		
		// Initialisation des Composants
		Fichier = new JLabel("Fichier");
		FichierFiled = new JTextField(80);

		Indexer = new JButton("Indexer");
		AnnulerTout = new JButton("Annuler Tout");
		EffacerConsole = new JButton("Effacer Console");
		Rechercher = new JButton("Rechercher");
		Quitter = new JButton("Quitter");

		zoneDoc = new JTextArea();

		// configuration de la zone des documents
		zoneDoc.setBackground(Color.GRAY);
		zoneDoc.setColumns(10);
		zoneDoc.setLineWrap(true);
		zoneDoc.setForeground(Color.BLACK);
		zoneDoc.setFont(new Font("Serif", Font.PLAIN, 20));
		zoneDoc.setEditable(false);
		zoneDoc.setText(
				"Université Chouaïb Doukkali\nFac. Sciences, Dept. Informatique\nEl JADIDA\n\tMaster BIBDA: Information Retrieval\n\tTP (Devoir Indexation des documents)\n\tUn systeme de recherche d'information (engin de recherche) simplifié.");

		// configuration de la zone des titres
		zoneTitre = new JTextArea(20, 20);
		zoneTitre.setBackground(Color.GRAY);
		// zoneTitre.setEditable(false);
		zoneTitre.setForeground(Color.BLACK);
		zoneTitre.setFont(new Font("Serif", Font.PLAIN, 20));
		zoneTitre.setColumns(15);
		zoneTitre.setLineWrap(true);

		// Panel pour regrouper Jlabel: Fichier et JText field dans lequel on entre le
		// nom du fichier
		JPanel panelFichier = new JPanel(new FlowLayout());
		panelFichier.add(Fichier);
		panelFichier.add(FichierFiled);

		// panel pour les buttons
		JPanel panelButtons = new JPanel(new GridLayout(1, 5, 20, 20));
		panelButtons.add(Indexer);
		panelButtons.add(AnnulerTout);
		panelButtons.add(EffacerConsole);
		panelButtons.add(Rechercher);
		panelButtons.add(Quitter);

		// panel pour contient les composants du haut
		JPanel panelHaut = new JPanel(new GridLayout(2, 1, 20, 20));
		panelHaut.add(panelFichier);
		panelHaut.add(panelButtons);

		// Panel principale qui contients tou les JPanel
		JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
		mainPanel.add(panelHaut, BorderLayout.NORTH);
		mainPanel.add(zoneDoc, BorderLayout.CENTER);
		mainPanel.add(zoneTitre, BorderLayout.EAST);

		// just pour faire Border avec un titre "Devoir Indexation des documents"
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 5),
				"Devoir Indexation des documents", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Serif", Font.BOLD, 18), Color.BLUE));

		// add mainPanel to Container
		Container con = getContentPane();
		con.add(mainPanel);

		// configuration des ActionListener

		// Button Quiter
		Quitter.addActionListener(e -> {
			dispose();
		});

		// Button Annuler tout
		this.AnnulerTout.addActionListener(e -> {
			this.FichierFiled.setText("");
			this.zoneTitre.setText("");
			this.zoneDoc.setText("vous avez annule tout, vous devez indexer des documents a nouveau");
			this.a = new Action();
			this.i = new Index();
			this.orginalV = new Inverse();

		});

		// Button EffacerConsole
		EffacerConsole.addActionListener(e -> {
			this.zoneDoc.setText("");
			this.zoneTitre.setText("");
			this.FichierFiled.setText("");
		});

		// Button Indexer
		Indexer.addActionListener(e -> {

			String fileName = this.FichierFiled.getText();
			System.out.println(fileName);

			ArrayList<String> mots = new ArrayList<>();
			if (fileName.endsWith(".txt")) {

				try {
					StringBuffer strb = new StringBuffer();
					mots = i.EnsembleDeMotsContenus(fileName);

					String title = mots.get(0);
					strb.append("Document:\n");
					strb.append(title + "\n");
					zoneTitre.setText("-" + title);

					strb.append("Mots:\n");
					strb.append("[");
					for (int j = 1; j < mots.size() - 1; j++) {
						strb.append(mots.get(j) + ", ");
					}
					strb.append(mots.get(mots.size() - 1) + "]");
					zoneDoc.setText(strb.toString());

					ArrayList<String> toindex = mots;
					toindex.remove(0);

					Liste listemo = i.indextoList(toindex);
					// ld.ajouterNoed(fileName, listemo);
					// ld.afficherListe(ld);

					i.Setdocuments(title, listemo);
					TreeMap<String, Liste> Alldocs = i.getAllDocuments();
					Inverse v = new Inverse(Alldocs);
					orginalV.AllMots = v.AllMots;

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				this.zoneDoc.setText("Verifier le nom de votre document exemple du nom valid 'exemple.txt'");
				// System.out.println("Verifier le nom de votre document");
			}

		});

		// Button Rechercher
		Rechercher.addActionListener(e -> {
			String requeteString = this.FichierFiled.getText().trim();
			ArrayList<String> requeteArray = new ArrayList<>();
			String[] mots;
			mots = requeteString.split("\\s+");
			for (String str : mots) {
				requeteArray.add(str);
			}
			System.out.println("\n**********from recherche ***********\n");
			System.out.println(" requeteArray: " + requeteArray + "\n");
			System.out.println("Document inverse :");
			Set<Entry<String, ListeDoc>> maSet1 = orginalV.AllMots.entrySet();
			for (Entry<String, ListeDoc> entry : maSet1) {
				System.out.println(entry.getKey() + " :" + entry.getValue());
			}
			Resul = a.recherche(orginalV, requeteArray);
			this.zoneDoc.setText(Resul + "");
			this.zoneTitre.setText(requeteString);

		});

		// window setting dimension ......
		setTitle("TP Indexation");
		setSize(new Dimension(1000, 700));
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
