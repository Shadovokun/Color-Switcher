package ihm;

import java.awt.Color;
import java.util.ArrayList;

public class ColorSetCreator {
	private int nbColor;
	private int[] valeurs = new int[10], valeursRouge = new int[10], valeursVert = new int[10], valeursBleu = new int[10];
	private ArrayList<Color> selectionCouleurs=new ArrayList<>();
	
	ColorSetCreator(Color color, int nb) {
		nbColor = nb;
		valeursRouge[0] = color.getRed();
		valeursVert[0] = color.getGreen();
		valeursBleu[0] = color.getBlue();
		valeurs[0] = (int) (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);
		selectionCouleurs.add(new Color(valeursRouge[0], valeursVert[0], valeursBleu[0]));
		
		for (int i = 1; i < 10; i++) {
			if (valeurs[0] + ( ( ( (255/nbColor) *i) *100) /100) <255 || valeurs [0] - ( ( ( (255/nbColor) *i) *100) /100) > 0) {
				if (valeursRouge[0] + ( ( ( (255/nbColor) *i) *100) /100) < 255) {
					valeursRouge[i] = valeursRouge[0] + ( ( ( (255/nbColor) *i) *100) /100);
				} else if (valeursRouge[0] + ( ( ( (255/nbColor) *i) *100) /100) > 0) {
					valeursRouge[i] = valeursRouge[0] - ( ( ( (255/nbColor) *i) *100) /100);
				} else if (valeursRouge[0] + ( ( ( (255/nbColor) *i) *100) /100) > 255) {
					valeursRouge[i] = 255;
				} else {
					valeursRouge[i] = 0;
				}
				
				if (valeursVert[0] + ( ( ( (255/nbColor) *i) *100) /100) < 255) {
					valeursVert[i] = valeursVert[0] + ( ( ( (255/nbColor) *i) *100) /100);
				} else if (valeursVert[0] + ( ( ( (255/nbColor) *i) *100) /100) > 0) {
					valeursVert[i] = valeursVert[0] - ( ( ( (255/nbColor) *i) *100) /100);
				} else if (valeursVert[0] + ( ( ( (255/nbColor) *i) *100) /100) > 255) {
					valeursVert[i] = 255;
				} else {
					valeursVert[i] = 0;
				}
				
				if (valeursBleu[0] + ( ( ( (255/nbColor) *i) *100) /100) < 255) {
					valeursBleu[i] = valeursBleu[0] + ( ( ( (255/nbColor) *i) *100) /100);
				} else if (valeursBleu[0] + ( ( ( (255/nbColor) *i) *100) /100) > 0) {
					valeursBleu[i] = valeursBleu[0] - ( ( ( (255/nbColor) *i) *100) /100);
				} else if (valeursBleu[0] + ( ( ( (255/nbColor) *i) *100) /100) > 255) {
					valeursBleu[i] = 255;
				} else {
					valeursBleu[i] = 0;
				}
				
				valeurs[i] = (int) (valeursRouge[i] * 0.3 + valeursVert[i] * 0.59 + valeursBleu[i] * 0.11);
			} else if (valeurs[0] - ( ( ( (255/nbColor) *i) *100) /100) < 0) {
				valeurs[i] = 0;
				valeursRouge[i] = 0;
				valeursVert[i] = 0;
				valeursBleu[i] = 0;
			} else {
				valeurs[i] = 255;
				valeursRouge[i] = 255;
				valeursVert[i] = 255;
				valeursBleu[i] = 255;
			}
			if (i < nbColor) {
				selectionCouleurs.add(new Color(valeursRouge[i], valeursVert[i], valeursBleu[i]));
			}
		}
	}
	
	public ArrayList<Color> getSelectionCouleurs() {
		return selectionCouleurs;
		
	}
}
