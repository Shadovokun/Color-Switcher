package ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fail.Accueil;
import Fail.ChoisirCouleur;
import Fail.Sets;

public class SetPredef_Accueil {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPredef_Accueil frame = new SetPredef_Accueil();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SetPredef_Accueil() {
		//Création de la fenetre
		JFrame fenetre= new JFrame("COLOR SWITCHER");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setBounds(0, 0, 450, 300);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setVisible(true);
		
		//Création du JPanel principal
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		fenetre.setContentPane(contentPane);
		
		//Contenu de la fenetre
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JLabel lblNombreDeCouleurs = new JLabel("Nombre de couleurs / set : ");
		panel.add(lblNombreDeCouleurs);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setSelectedIndex(1);
		comboBox.setMaximumRowCount(4);
		panel.add(comboBox);
		
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
		panel_2.add(new JPanel());
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
		SetPredef_Accueil a;
		public ActionValider (SetPredef_Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			//ChoisirCouleur choisirCouleur=new ChoisirCouleur();
			//a.dispose();
		}
	}
	
}
