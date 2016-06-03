package Fail;

import java.io.PrintWriter;

public class testNiveauGris {
	int rouge, vert, bleu, nbColor;
	int[] valeurs = new int[10], valeursRouge = new int[10], valeursVert = new int[10], valeursBleu = new int[10];
	double fin;
	PrintWriter text;
	
	testNiveauGris() {
		nbColor = 10;
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
				System.out.println("R : " + valeursRouge[i] + " V : " + valeursVert[i] + " B : " + valeursBleu[i] + " Gris : " + valeurs[i]);
		}
		//text.close();
	}
	
	testNiveauGris(int r, int v, int b){
		
	}
	
	public static void main(String args[]) {
		testNiveauGris test = new testNiveauGris();
	}
}