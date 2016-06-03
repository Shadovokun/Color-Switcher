package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

public class Accueil {
	
	int nbCouleurs=5;
	static int nbSets=8;
	JFrame fenetre;
	ArrayList<Color> selection=new ArrayList<>();
	ArrayList<Color> couleursAVerif=new ArrayList<>();
	int x, y;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<ArrayList<Color>> listeCouleurs=new ArrayList<>();
					ArrayList <Color> couleurs =new ArrayList<>();
					couleurs.add(Color.BLACK);
					couleurs.add(Color.BLUE);
					couleurs.add(Color.RED);
					couleurs.add(Color.GREEN);
					couleurs.add(Color.YELLOW);
					couleurs.add(Color.ORANGE);
					couleurs.add(Color.PINK);
					couleurs.add(Color.CYAN);
					couleurs.add(Color.MAGENTA);
					couleurs.add(Color.RED);
					ArrayList <Color> couleurs2 =new ArrayList<>();
					couleurs2.add(Color.PINK);
					couleurs2.add(Color.YELLOW);
					couleurs2.add(Color.CYAN);
					couleurs2.add(Color.RED);
					couleurs2.add(Color.BLUE);
					couleurs2.add(Color.ORANGE);
					couleurs2.add(Color.BLACK);
					couleurs2.add(Color.MAGENTA);
					couleurs2.add(Color.RED);
					couleurs2.add(Color.GREEN);
					listeCouleurs.add(couleurs2);
					for(int a=1; a<nbSets; a++) {
						listeCouleurs.add(couleurs);
					}
					Accueil frame = new Accueil(listeCouleurs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accueil(ArrayList<ArrayList<Color>> listeCouleurs) {
		//Création de la fenetre
		fenetre= new JFrame("COLOR SWITCHER");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(620,450));
		fenetre.setLocation(400,200);
		x=(int)(fenetre.getLocation().getX());
		y=(int)(fenetre.getLocation().getY());
		fenetre.setResizable(false);
		fenetre.addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent arg0) {}
			public void componentMoved(ComponentEvent arg0) {
				x=(int)(fenetre.getLocation().getX());
				y=(int)(fenetre.getLocation().getY());
			}
			public void componentResized(ComponentEvent arg0) {}
			public void componentShown(ComponentEvent arg0) {}
		});
		//Création onglets
		JTabbedPane onglets=new JTabbedPane(JTabbedPane.TOP);
		
		//Onglet1
		JPanel predef=new JPanel();
		predef.setLayout(new BorderLayout());
		JLabel titrePredef=new JLabel("Prédéfinis");
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

			//milieu
			JPanel panel3=new JPanel();
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
			JPanel[] setsJPanel=new JPanel[nbSets];
			for(int i=0; i<nbSets; i++) {
				panel3.add(new JPanel());
				
				JPanel p=new JPanel();
				p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
				
				JPanel couleur;
				JPanel set=new JPanel();
				set.setLayout(new BoxLayout(set, BoxLayout.Y_AXIS));
				int c=0;
				for(int j=0; j<10/2-nbCouleurs/2+nbCouleurs; j++) {
					if(j<10/2-nbCouleurs/2) {
						p.add(new JPanel());
					} else {
						couleur=new JPanel();
						couleur.setBackground(listeCouleurs.get(i).get(c));
						set.add(couleur);
						c++;
					}
				}
				p.add(set);
				setsJPanel[i]=set;
				for (int j=10/2-nbCouleurs/2+nbCouleurs; j<10 ; j++){
					p.add(new JPanel());
				}
				panel3.add(p);
			}
			//ajout des listeners
			for(int i=0; i<nbSets; i++) {
				setsJPanel[i].addMouseListener(new SelectionSet(i, setsJPanel));
			}			
			panel3.add(new JPanel());
			
			//haut
			JLabel labelNbCouleurs = new JLabel("Nombre de couleurs / set : ");
			panel1.add(labelNbCouleurs);
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
			comboBox.setSelectedIndex(2);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					nbCouleurs=Integer.parseInt((String) comboBox.getSelectedItem());
					panel3.removeAll();
					for(int i=0; i<nbSets; i++) {
						panel3.add(new JPanel());
						
						JPanel p=new JPanel();
						p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
						
						JPanel couleur;
						JPanel set=new JPanel();
						set.setLayout(new BoxLayout(set, BoxLayout.Y_AXIS));
						int c=0;
						for(int j=0; j<10/2-nbCouleurs/2+nbCouleurs; j++) {
							if(j<10/2-nbCouleurs/2) {
								p.add(new JPanel());
							} else {
								couleur=new JPanel();
								couleur.setBackground(listeCouleurs.get(i).get(c));
								set.add(couleur);
								c++;
							}
						}
						p.add(set);
						setsJPanel[i]=set;
						for (int j=10/2-nbCouleurs/2+nbCouleurs; j<10 ; j++){
							p.add(new JPanel());
						}
						panel3.add(p);
					}
					//ajout des listeners
					for(int i=0; i<nbSets; i++) {
						setsJPanel[i].addMouseListener(new SelectionSet(i, setsJPanel));
					}
					panel3.add(new JPanel());
					fenetre.pack();
				}
				
			});
			panel1.add(comboBox);
			
			//bas
			JPanel panel2=new JPanel();
			JButton btnValider1 = new JButton("✓");
			btnValider1.setFont(new Font("Dialog", Font.BOLD, 16));
			btnValider1.addActionListener(new ActionValider1(this));
			panel2.add(btnValider1);
		
		predef.add(panel1, BorderLayout.NORTH);
		predef.add(panel2, BorderLayout.SOUTH);
		predef.add(panel3, BorderLayout.CENTER);
		onglets.addTab("Prédéfinis", predef);
			
		
		//Onglet2
		JPanel creer=new JPanel();
		creer.setLayout(new BorderLayout());
		onglets.addTab("Créer", creer);
		JColorChooser colorChooser = new JColorChooser();
		JPanel panel4=new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		JPanel panel5=new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel labelNbSet = new JLabel("Nombre de couleurs du set : ");
		labelNbSet.setFont(new Font("Dialog", Font.BOLD, 16));
		panel5.add(labelNbSet);
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox2.setSelectedIndex(2);
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				nbCouleurs=Integer.parseInt((String) comboBox2.getSelectedItem());
			}
		});
		panel5.add(comboBox2);
		JPanel panel6=new JPanel();
		JButton btnValider2 = new JButton("✓");
		btnValider2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnValider2.addActionListener(new ActionValider2(this));
		panel6.add(btnValider2);
		panel4.add(panel5);
		panel4.add(panel6);
		creer.add(panel4, BorderLayout.SOUTH);
		creer.add(colorChooser);
		
		
		//Onglet3
		JPanel verifier=new JPanel();
		onglets.addTab("Vérifier", verifier);
		JColorChooser colorChooser2 = new JColorChooser();
		verifier.setLayout(new BorderLayout());
		verifier.add(colorChooser2);
		JPanel panel7=new JPanel();
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
		JButton validCouleur=new JButton("✓   Valider couleur");
		validCouleur.setFont(new Font("Dialog", Font.PLAIN, 16));
		JPanel panel8= new JPanel();
		panel8.add(validCouleur);
		panel7.add(panel8);
		//affichage des couleurs
		JPanel panelCouleurs=new JPanel();
		JPanel panelC;
		panelC=new JPanel();
		panelC.setPreferredSize(new Dimension(45,35));
		panelCouleurs.add(panelC);
		panel7.add(panelCouleurs);
		validCouleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(couleursAVerif.size()<10){
					couleursAVerif.add(colorChooser2.getColor());
					JPanel panelC;
					panelCouleurs.removeAll();
					for(int i=0; i<couleursAVerif.size(); i++) {
						panelC=new JPanel();
						//TODO Ajouter deselection d'une couleur
						panelC.setPreferredSize(new Dimension(45,35));
						panelC.setBackground(couleursAVerif.get(i));
						panelCouleurs.add(panelC);
					}
					fenetre.pack();
				}
			}
		});
		JButton validSet=new JButton("✓   Valider set");
		//TODO add listener pour envoyer sur la page des resultats de la verif (+ proposer un autre set?)
		validSet.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel7.add(validSet);
		verifier.add(panel7,BorderLayout.SOUTH);
		
		
		fenetre.setContentPane(onglets);
		fenetre.setVisible(true);
		fenetre.pack();
	}
	
	class SelectionSet extends MouseAdapter {
		int pointeur;
		JPanel[] sets;
		
		public SelectionSet(int pointeur, JPanel[] sets){
			this.pointeur=pointeur;
			this.sets=sets;
		}
		public void mouseClicked(MouseEvent arg0) {
			for(int n=0; n<sets.length; n++){
				sets[n].setBorder(BorderFactory.createEmptyBorder());
			}
			sets[pointeur].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			selection.clear();
			for(int a=0; a<sets[pointeur].getComponentCount(); a++) {
				selection.add(sets[pointeur].getComponent(a).getBackground());
			}
		}
	}

	class ActionValider1 implements ActionListener {
		Accueil a;
		public ActionValider1 (Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			if(selection.size()!=0){
				AffichageCouleurs AffichageCouleurs=new AffichageCouleurs(selection, a, x, y);
				a.fenetre.dispose();
			}
		}
	}
	
	class ActionValider2 implements ActionListener {
		Accueil a;
		public ActionValider2 (Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			//Generer un set et le mettre à la place de "selection" 
			//AffichageCouleurs AffichageCouleurs=new AffichageCouleurs(selection, a);
			//a.fenetre.dispose();
			System.out.println("Action du bouton non codée, nécessite l'algo :D");
		}
	}
	
}
