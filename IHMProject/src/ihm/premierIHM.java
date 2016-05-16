package ihm;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class premierIHM {
	/*
	 * Les "new JButton" ne sont là que pour construire, ils seront remplacés par une structure à même d'être colorés.
	 * Voir image.
	 */
	premierIHM() {
		JFrame fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int valeurRouge, valeurVert, valeurBleu;
		valeurRouge = 0;
		valeurVert = 0;
		valeurBleu = 0;
		JPanel panel, panel1, panel1_1, panel1_2, panel2, panel2_1, panel2_2;
		JLabel labelRouge, labelVert, labelBleu;
		JButton copierRouge, copierVert, copierBleu;
		panel = new JPanel(); 
		panel1 = new JPanel();
		panel1_1 = new JPanel();
		panel1_2 = new JPanel();
		panel2 = new JPanel(); 
		panel2_1 = new JPanel();
		panel2_2 = new JPanel();
		copierRouge = new JButton("Copier");
		copierVert = new JButton("Copier");
		copierBleu = new JButton("Copier");
		labelRouge = new JLabel("Rouge : " + valeurRouge);
		labelVert = new JLabel("Vert : " + valeurVert);
		labelBleu = new JLabel("Bleu : " + valeurBleu);
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1_1.setLayout(new BoxLayout(panel1_1, BoxLayout.X_AXIS));
		panel1_2.setLayout(new BoxLayout(panel1_2, BoxLayout.X_AXIS));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2_1.setLayout(new BoxLayout(panel2_1, BoxLayout.X_AXIS));
		panel2_2.setLayout(new BoxLayout(panel2_2, BoxLayout.X_AXIS));
		
		panel1_1.add(new JButton("Bouton 1"));
		panel1_1.add(Box.createHorizontalGlue());
		panel1_1.add(new JButton("Bouton 2"));
		panel1_1.add(Box.createHorizontalGlue());
		panel1_1.add(new JButton("Bouton 3"));
		panel1_1.add(Box.createHorizontalGlue());
		panel1_1.add(new JButton("Bouton 4"));
		panel1_1.add(Box.createHorizontalGlue());
		panel1_1.add(new JButton("Bouton 5"));
		
		panel1_2.add(new JButton("Bouton 6"));
		panel1_2.add(Box.createHorizontalGlue());
		panel1_2.add(new JButton("Bouton 7"));
		panel1_2.add(Box.createHorizontalGlue());
		panel1_2.add(new JButton("Bouton 8"));
		panel1_2.add(Box.createHorizontalGlue());
		panel1_2.add(new JButton("Bouton 9"));
		panel1_2.add(Box.createHorizontalGlue());
		panel1_2.add(new JButton("Bouton 10"));
		
		panel1.add(Box.createVerticalGlue());
		panel1.add(panel1_1);
		panel1.add(Box.createVerticalGlue());
		panel1.add(panel1_2);
		panel1.add(Box.createVerticalGlue());
		
		panel2_1.add(Box.createHorizontalGlue());
		panel2_1.add(labelRouge);
		panel2_1.add(Box.createHorizontalGlue());
		panel2_1.add(labelVert);
		panel2_1.add(Box.createHorizontalGlue());
		panel2_1.add(labelBleu);
		panel2_1.add(Box.createHorizontalGlue());
		
		panel2_2.add(Box.createHorizontalGlue());
		panel2_2.add(copierRouge);
		panel2_2.add(Box.createHorizontalGlue());
		panel2_2.add(copierVert);
		panel2_2.add(Box.createHorizontalGlue());
		panel2_2.add(copierBleu);
		panel2_2.add(Box.createHorizontalGlue());
		
		panel2.add(Box.createVerticalGlue());
		panel2.add(panel2_1);
		panel2.add(Box.createVerticalGlue());
		panel2.add(panel2_2);
		panel2.add(Box.createVerticalGlue());
		
		
		
		panel.add(panel1);
		panel.add(panel2);
		
		
		fenetre.getContentPane().add(panel);
		
		
		fenetre.setPreferredSize(new Dimension(1000,600));
		fenetre.pack();
		fenetre.setVisible(true);
	}
	
	public static void main(String[] args) {
	      //Schedule a job for the event-dispatching thread:
	      //creating and showing this application’s GUI.
	      javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new premierIHM();
	        }
	    });
	  }
}
