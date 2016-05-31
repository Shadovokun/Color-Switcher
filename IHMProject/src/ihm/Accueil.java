package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JFrame fenetre;
	ArrayList<Color> selection=new ArrayList<>();

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
		fenetre.setPreferredSize(new Dimension(600,450));
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
			int nbSets=8;
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
			comboBox.setSelectedIndex(2);
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
			JButton btnValider1 = new JButton("✓");
			btnValider1.setFont(new Font("Dialog", Font.BOLD, 16));
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
		panel5.add(new JLabel("Nombre de couleurs du set : "));
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
		panel6.add(btnValider2);
		
		panel4.add(panel5);
		panel4.add(panel6);
		
		creer.add(panel4, BorderLayout.SOUTH);
		creer.add(colorChooser);
		
		
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
		ArrayList <Color> couleurs=new ArrayList<>();
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
		JPanel couleur;
		JPanel set=new JPanel();
		set.setLayout(new BoxLayout(set, BoxLayout.Y_AXIS));
		int c=0;
		for(int i=0; i<10/2-nbCouleurs/2+nbCouleurs; i++) {
			if(i<10/2-nbCouleurs/2) {
				p.add(new JPanel());
			} else {
				couleur=new JPanel();
				couleur.setBackground(couleurs.get(c));
				set.add(couleur);
				c++;
			}
		}
		set.addMouseListener(new SelectionSet(set));
		p.add(set);
		for (int i=10/2-nbCouleurs/2+nbCouleurs; i<10 ; i++){
			p.add(new JPanel());
		}
		return p;
	}
	
	class SelectionSet extends MouseAdapter {
		JPanel set;
		
		public SelectionSet(JPanel set){
			this.set=set;
		}
		public void mouseClicked(MouseEvent arg0) {
			set.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			selection.clear();
			for(int i=0; i<set.getComponentCount(); i++) {
				selection.add(set.getComponent(i).getBackground());
				System.out.println(set.getComponent(i).getBackground().toString());
			}
		}
		
	}
	
	class ActionValider implements ActionListener {
		Accueil a;
		public ActionValider (Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			if(selection.size()!=0){
				AffichageCouleurs AffichageCouleurs=new AffichageCouleurs();
				a.fenetre.dispose();
			}
		}
	}
	
}
