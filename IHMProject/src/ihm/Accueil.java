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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

public class Accueil {
	
	int nbCouleurs1=4;
	static int nbSets=8;
	JFrame fenetre;
	ArrayList<Color> selection=new ArrayList<>();
	ArrayList<Color> couleursAVerif=new ArrayList<>();
	int x, y;
	JColorChooser colorChooser, colorChooser2;
	ColorSetCreator csc=new ColorSetCreator();
	
	//onglet2
	int nbCouleurs2=4;
	
	//onglet3
	JButton validCouleur=new JButton("✓");
	JButton suppCouleur=new JButton("✖");
	JPanel panelCouleurs=new JPanel();
	JButton validSet=new JButton("✓   Valider set");
	int couleurSelectionnee;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<Color> listeCouleurs=new ArrayList<>();
					listeCouleurs.add(new Color(255,255,255));
					listeCouleurs.add(new Color(153,153,255));
					listeCouleurs.add(new Color(255,51,102));
					listeCouleurs.add(new Color(204,153,0));
					listeCouleurs.add(new Color(255,255,102));
					listeCouleurs.add(new Color(153,255,153));
					listeCouleurs.add(new Color(0,153,102));
					listeCouleurs.add(new Color(102,0,102));
					new Accueil(listeCouleurs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accueil(ArrayList<Color> listeCouleurs) {
		//Création de la fenetre
		fenetre= new JFrame("COLOR SWITCHER");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(650,500));
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
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnValider1 = new JButton("✓");

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
				ArrayList<Color> setGenere=csc.genererSet(listeCouleurs.get(i), nbCouleurs1);
				for(int j=0; j<10/2-nbCouleurs1/2+nbCouleurs1; j++) {
					if(j<10/2-nbCouleurs1/2) {
						p.add(new JPanel());
					} else {
						couleur=new JPanel();
						couleur.setBackground(setGenere.get(c));
						set.add(couleur);
						c++;
					}
				}
				p.add(set);
				setsJPanel[i]=set;
				for (int j=10/2-nbCouleurs1/2+nbCouleurs1; j<10 ; j++){
					p.add(new JPanel());
				}
				panel3.add(p);
			}
			//ajout des listeners
			for(int i=0; i<nbSets; i++) {
				setsJPanel[i].addMouseListener(new SelectionSet(i, setsJPanel, btnValider1));
			}			
			panel3.add(new JPanel());
			
			//bas
			JPanel panel2=new JPanel();
			btnValider1.setFont(new Font("Dialog", Font.BOLD, 16));
			btnValider1.setEnabled(false);
			btnValider1.addActionListener(new ActionValider1(this));
			panel2.add(btnValider1);
			
			//haut
			JLabel labelNbCouleurs = new JLabel("Nombre de couleurs / set : ");
			panel1.add(labelNbCouleurs);
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
			comboBox.setSelectedIndex(1);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					nbCouleurs1=Integer.parseInt((String) comboBox.getSelectedItem());
					panel3.removeAll();
					btnValider1.setEnabled(false);
					selection.clear();
					for(int i=0; i<nbSets; i++) {
						panel3.add(new JPanel());
						
						JPanel p=new JPanel();
						p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
						
						JPanel couleur;
						JPanel set=new JPanel();
						set.setLayout(new BoxLayout(set, BoxLayout.Y_AXIS));
						int c=0;
						ArrayList<Color> setGenere=csc.genererSet(listeCouleurs.get(i), nbCouleurs1);
						for(int j=0; j<10/2-nbCouleurs1/2+nbCouleurs1; j++) {
							if(j<10/2-nbCouleurs1/2) {
								p.add(new JPanel());
							} else {
								couleur=new JPanel();
								couleur.setBackground(setGenere.get(c));
								set.add(couleur);
								c++;
							}
						}
						p.add(set);
						setsJPanel[i]=set;
						for (int j=10/2-nbCouleurs1/2+nbCouleurs1; j<10 ; j++){
							p.add(new JPanel());
						}
						panel3.add(p);
					}
					//ajout des listeners
					for(int i=0; i<nbSets; i++) {
						setsJPanel[i].addMouseListener(new SelectionSet(i, setsJPanel, btnValider1));
					}
					panel3.add(new JPanel());
					fenetre.pack();
				}
				
			});
			panel1.add(comboBox);
		
		predef.add(panel1, BorderLayout.NORTH);
		predef.add(panel2, BorderLayout.SOUTH);
		predef.add(panel3, BorderLayout.CENTER);
		onglets.addTab("Prédéfinis", predef);
			
		
		//Onglet2
		JPanel creer=new JPanel();
		creer.setLayout(new BorderLayout());
		onglets.addTab("Créer", creer);
		colorChooser = new JColorChooser();
		JPanel panel4=new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		JPanel panel5=new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel labelNbSet = new JLabel("Nombre de couleurs du set : ");
		labelNbSet.setFont(new Font("Dialog", Font.BOLD, 16));
		panel5.add(labelNbSet);
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox2.setSelectedIndex(1);
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				nbCouleurs2=Integer.parseInt((String) comboBox2.getSelectedItem());
			}
		});
		panel5.add(comboBox2);
		JPanel panel6=new JPanel();
		JButton btnValider2 = new JButton("✓");
		btnValider2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnValider2.addActionListener(new ActionValider2(this));
		panel6.add(btnValider2);
		JPanel panelRandom=new JPanel();
		panelRandom.setPreferredSize(new Dimension (20,20));
		panel4.add(panelRandom);
		panel4.add(panel5);
		panel4.add(panel6);
		creer.add(panel4, BorderLayout.SOUTH);
		creer.add(colorChooser);
		
		
		//Onglet3
		JPanel verifier=new JPanel();
		onglets.addTab("Vérifier", verifier);
		colorChooser2 = new JColorChooser();
		verifier.setLayout(new BorderLayout());
		verifier.add(colorChooser2);
		JPanel panel7=new JPanel();
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
		suppCouleur.setEnabled(false);
		suppCouleur.setFont(new Font("Dialog", Font.PLAIN, 16));
		validCouleur.setFont(new Font("Dialog", Font.BOLD, 16));
		JPanel panel8= new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel8.add(validCouleur);
		panel8.add(suppCouleur);
		panel7.add(panel8);
		
			//affichage des couleurs par défaut : aucune
			JPanel panel10=new JPanel();
			JPanel panelC=new JPanel();
			panelC.setPreferredSize(new Dimension(45,35));
			panel10.add(panelC);
			panelCouleurs.add(panel10);
			panel7.add(panelCouleurs);
		validCouleur.addActionListener(new ValiderCouleur(colorChooser2));
		suppCouleur.addActionListener(new SupprimerCouleur());
		validSet.setEnabled(false);
		validSet.addActionListener(new ActionValider3(this));
		validSet.setFont(new Font("Dialog", Font.PLAIN, 16));
		JPanel panel9=new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel9.add(validSet);
		panel7.add(panel9);
		verifier.add(panel7,BorderLayout.SOUTH);
		
		
		fenetre.setContentPane(onglets);
		fenetre.setVisible(true);
		fenetre.pack();
	}
	
	public JPanel affichageCouleursVerif() {
		if(couleursAVerif.size()==0){
			JPanel c=new JPanel();
			c.setPreferredSize(new Dimension (450,45));
			return c;
		} else {
			JPanel panelCouleurs=new JPanel();
			JPanel panelC;
			JPanel[] tabPanelC=new JPanel[couleursAVerif.size()];
			panelCouleurs.removeAll();
			for(int i=0; i<couleursAVerif.size(); i++) {
				panelC=new JPanel();
				panelC.setPreferredSize(new Dimension(45,35));
				panelC.setBackground(couleursAVerif.get(i));
				tabPanelC[i]=panelC;
				panelC.addMouseListener(new SelectionCouleur(i, tabPanelC));
				panelCouleurs.add(panelC);
			}
			return panelCouleurs;
		}
	}
	
	class ValiderCouleur implements ActionListener {
		JColorChooser colorChooser;
		
		public ValiderCouleur(JColorChooser colorChooser) {
			this.colorChooser=colorChooser;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(couleursAVerif.size()<10){
				couleursAVerif.add(colorChooser.getColor());
				panelCouleurs.removeAll();
				panelCouleurs.add(affichageCouleursVerif());
			}
			if(couleursAVerif.size()>=3) {
				validSet.setEnabled(true);
			}
			fenetre.pack();
		}
	}
	
	class SelectionSet extends MouseAdapter {
		int pointeur;
		JPanel[] sets;
		JButton v;
		
		public SelectionSet(int pointeur, JPanel[] sets, JButton v){
			this.pointeur=pointeur;
			this.sets=sets;
			this.v=v;
		}
		public void mouseClicked(MouseEvent arg0) {
			v.setEnabled(true);
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
	
	class SelectionCouleur extends MouseAdapter {
		int i;
		JPanel[] tabPanelC;
		
		public SelectionCouleur(int i, JPanel[] tabPanelC){
			this.i=i;
			this.tabPanelC=tabPanelC;
		}
		public void mouseClicked(MouseEvent arg0) {
			for(int n=0; n<tabPanelC.length; n++){
				tabPanelC[n].setBorder(BorderFactory.createEmptyBorder());
			}
			couleurSelectionnee=i;
			tabPanelC[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			suppCouleur.setEnabled(true);
			fenetre.pack();
		}
	}
	
	class SupprimerCouleur implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			couleursAVerif.remove(couleurSelectionnee);
			panelCouleurs.removeAll();
			JPanel affichageVide=new JPanel();
			affichageVide.setPreferredSize(new Dimension(450,35));
			panelCouleurs.add(affichageVide);
			fenetre.pack();
			panelCouleurs.removeAll();
			panelCouleurs.add(affichageCouleursVerif());
			suppCouleur.setEnabled(false);
			fenetre.pack();
		}
	}

	class ActionValider1 implements ActionListener {
		Accueil a;
		public ActionValider1 (Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			if(selection.size()!=0){
				new AffichageCouleurs(selection, a, x, y);
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
			a.fenetre.dispose();
			new AffichageCouleurs(csc.genererSet(colorChooser.getColor(), nbCouleurs2), a, x, y);
		}
	}
	
	class ActionValider3 implements ActionListener {
		Accueil a;
		String message = "";
		
		public ActionValider3(Accueil a) {
			this.a=a;
		}
		
		public void actionPerformed(ActionEvent e) {
			/*for (int i = 0; i < couleursAVerif.size(); i++) {
				for (int j = 0; j < couleursAVerif.size(); j++) {
					if (i != j && i < j) {
						 int gris1 = (int) (couleursAVerif.get(i).getRed() * 0.3 + couleursAVerif.get(i).getGreen() * 0.59 + couleursAVerif.get(i).getBlue() * 0.11);
						 int gris2 = (int) (couleursAVerif.get(j).getRed() * 0.3 + couleursAVerif.get(j).getGreen() * 0.59 + couleursAVerif.get(j).getBlue() * 0.11);
						 for (int k = 0; k < nbCouleurs; k ++) {
							 if (gris1 + k == gris2 || gris1 - k == gris2) {
								 message += "Les couleurs " + i + " et " + j + " ont un niveau de gris trop semblable. \n";
							 }
						 }
					}
				}
			}*/
			for (int i = 0; i < couleursAVerif.size()-1; i++) {
				for (int j = i+1; j < couleursAVerif.size(); j++) {
					int gris1 = (int) (couleursAVerif.get(i).getRed() * 0.3 + couleursAVerif.get(i).getGreen() * 0.59 + couleursAVerif.get(i).getBlue() * 0.11);
					int gris2 = (int) (couleursAVerif.get(j).getRed() * 0.3 + couleursAVerif.get(j).getGreen() * 0.59 + couleursAVerif.get(j).getBlue() * 0.11);
					//20 car 255/10=25.5
					//10=nbCouleurs max
					//20 car petite marge pour ne pas avoir qu'1 seul set de 10 couleurs possible.
					if(gris1<=gris2+20 && gris1>=gris2-20){
						message += "Les couleurs " + i + " et " + j + " ont un niveau de gris trop semblable. \n";
					}
				}
			}
			if (message.equals("")) {
				a.fenetre.dispose();
				new AffichageCouleurs(couleursAVerif, a, x, y);
			} else {
				message += "Vous pouvez créer un set à partir d'une des couleurs utilisées en la saisissant dans l'onglet \"Créer\".";
				JOptionPane.showMessageDialog(null, message);
			}
			message = "";
		}
	}
	
}
