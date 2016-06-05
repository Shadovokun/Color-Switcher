package Fail;

import java.awt.Color;
import java.awt.Dimension;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class testNiveauGris {
	int rouge, vert, bleu, nbColor;
	int[] valeurs = new int[10], valeursRouge = new int[10], valeursVert = new int[10], valeursBleu = new int[10];
	double fin;
	PrintWriter text;
	JFrame fenetre = new JFrame("testNiveauGris");
	JLabel title = new JLabel("Set de couleurs : ");
	JPanel conteneurCouleurs = new JPanel();
	JButton[] boutonsColores = new JButton[10];
	ArrayList<Color> selection=new ArrayList<>();
	
	testNiveauGris() {
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(650,500));
		fenetre.setLocation(400,200);
		conteneurCouleurs.setLayout(new BoxLayout(conteneurCouleurs, BoxLayout.X_AXIS));
		nbColor = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez un nombre entre 3 et 10"));
		try{
		//text = new PrintWriter("/home/infoetu/provof/git/ColorSwitcher/IHMProject/ColorGrayScale"+nbColor+".csv");
		} catch(Exception e) {
			
		}
 		for (int i = 1; i < 11; i++) {
			double temp = ( ( ((255/nbColor)*i) *100) /100);
			valeurs[i-1] = (int) temp;
			valeursRouge[i-1] = 0;
			valeursVert[i-1] = 0;
			valeursBleu[i-1] = 0;
		}
		for (rouge = 0; rouge < 256; rouge++){
			for (vert = 0; vert < 256; vert++) {
				for (bleu = 0; bleu < 256; bleu++) {
					fin = rouge*0.3 + vert*0.59 + bleu * 0.11;
					for (int i = 0; i < nbColor; i++) {
						if (fin == valeurs[i]) {
							if (valeursRouge[i] == 0 && valeursVert[i] == 0 && valeursBleu[i] == 0) {
								valeursRouge[i] = rouge;
								valeursVert[i] = vert;
								valeursBleu[i] = bleu;
								
							}
							//text.println(rouge + " , " + vert + " , " + bleu + " , "+fin);
							//System.out.println(rouge + " , " + vert + " , " + bleu + " , "+fin);
						}
					}
				}
			}
		}
		System.out.println("");
		System.out.println("");
		for (int i = 0; i < 10; i++) {
			if (valeurs[i] <= 255) {
				System.out.println("R : " + valeursRouge[i] + " V : " + valeursVert[i] + " B : " + valeursBleu[i] + " Gris : " + valeurs[i]);
				//selection.add(new Color(valeursRouge[i], valeursVert[i], valeursBleu[i]));
				boutonsColores[i] = new JButton();
				boutonsColores[i].setBackground(new Color(valeursRouge[i], valeursVert[i], valeursBleu[i]));
				conteneurCouleurs.add(boutonsColores[i]);
			}
			fenetre.getContentPane().add(conteneurCouleurs);
			fenetre.setVisible(true);
			fenetre.pack();
		}
		//text.close();
	}
	
	testNiveauGris(int r, int v, int b){
		
	}
	
	public static void main(String args[]) {
		testNiveauGris test = new testNiveauGris();
	}
	
}