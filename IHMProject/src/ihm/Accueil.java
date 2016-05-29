package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Accueil {
	
	int nbCouleurs=3;
	JFrame fenetre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accueil() {
		//Création de la fenetre
		fenetre= new JFrame("COLOR SWITCHER");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(450,300));
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		
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
			int nbSets=5;
			JPanel[] setsJPanel=new JPanel[nbSets];
			for(int i=0; i<nbSets; i++) {
				panel3.add(new JPanel());
				setsJPanel[i]=getSetJPanel(nbCouleurs);
				panel3.add(setsJPanel[i]);
			}
			panel3.add(new JPanel());
		
			//haut
			JLabel labelNbCouleurs = new JLabel("Nombre de couleurs / set : ");
			panel1.add(labelNbCouleurs);
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
			comboBox.setSelectedIndex(0);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					nbCouleurs=Integer.parseInt((String) comboBox.getSelectedItem());
					panel3.removeAll();
					for(int i=0; i<nbSets; i++) {
						panel3.add(new JPanel());
						setsJPanel[i]=getSetJPanel(nbCouleurs);
						panel3.add(setsJPanel[i]);
					}
					panel3.add(new JPanel());
					fenetre.pack();
				}
				
			});
			panel1.add(comboBox);
			
			//bas
			JPanel panel2=new JPanel();
			JButton btnValider = new JButton("✓");
			btnValider.setFont(new Font("Dialog", Font.BOLD, 16));
			panel2.add(btnValider);
		
		predef.add(panel1, BorderLayout.NORTH);
		predef.add(panel2, BorderLayout.SOUTH);
		predef.add(panel3, BorderLayout.CENTER);
		onglets.addTab("Prédéfinis", predef);
			
		//Onglet2
		JPanel creer=new JPanel();
		JLabel titreCreer=new JLabel("ZBLAH !");
		creer.add(titreCreer);
		onglets.addTab("Créer", creer);
		
		
		fenetre.setContentPane(onglets);
		fenetre.setVisible(true);
		fenetre.pack();
	}
	
	/**
	 * Méthode permettant de générer un JPanel contenant un set de couleur.
	 * @param nbCouleurs
	 * @return un JPanel
	 */
	JPanel getSetJPanel(int nbCouleurs){
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		for(int i=0; i<nbCouleurs; i++) {
			p.add(new JLabel(""+(i+1)));
		}
		return p;
	}
	
	class ActionValider implements ActionListener {
		Accueil a;
		public ActionValider (Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			//AffichageCouleurs AffichageCouleurs=new AffichageCouleurs();
			//a.fenetre.dispose();
		}
	}
	
}
