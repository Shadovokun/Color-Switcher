package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Accueil {

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
		JFrame fenetre= new JFrame("COLOR SWITCHER");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setBounds(0, 0, 450, 300);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		
		//Création du JPanel principal
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setLayout(new BorderLayout(0, 0));
		
		//Création onglets
		JTabbedPane onglets=new JTabbedPane(JTabbedPane.TOP);
		
		//Onglet1
		JPanel predef=new JPanel();
		JLabel titrePredef=new JLabel("Prédéfinis");
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		
			//haut
			JLabel labelNbCouleurs = new JLabel("Nombre de couleurs / set : ");
			panel3.add(labelNbCouleurs);
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
			comboBox.setSelectedIndex(0);
			panel3.add(comboBox);
			
			//bas
			JPanel panel4=new JPanel();
			
			//milieu
		
		panel2.add(panel3, BorderLayout.NORTH);
		panel2.add(panel4, BorderLayout.SOUTH);
		predef.add(panel2);
		onglets.addTab("Prédéfinis", predef);
			
		//Onglet2
		JPanel creer=new JPanel();
		JLabel titreCreer=new JLabel("ZBLAH !");
		creer.add(titreCreer);
		onglets.addTab("Créer", creer);
		
		
		panel1.add(onglets);
		fenetre.setContentPane(panel1);
		fenetre.setVisible(true);

		
		
		//Contenu de la fenetre
		/*JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnValider = new JButton("✓");
		btnValider.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnValider);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		int nbSets=5;
		JPanel[] setsJPanel=new JPanel[nbSets];
		
		for(int i=0; i<nbSets; i++) {
			panel_2.add(new JPanel());
			setsJPanel[i]=getSetJPanel(4);
			panel_2.add(setsJPanel[i]);
		}
		panel_2.add(new JPanel());*/
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
	
	private class ActionValider implements ActionListener {
		Accueil a;
		public ActionValider (Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			//ChoisirCouleur choisirCouleur=new ChoisirCouleur();
			//a.dispose();
		}
	}
	
}
