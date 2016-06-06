package ihm;

import java.awt.Color;
import java.util.ArrayList;

public class ColorSetCreator {
	//private int nbColor;
	//private int[] valeurs = new int[10], valeursRouge = new int[10], valeursVert = new int[10], valeursBleu = new int[10];
	private ArrayList<Color> setCouleurs=new ArrayList<>();
	
	ColorSetCreator(Color color, int nb) {
		final int ROUGE=color.getRed();
		final int VERT=color.getGreen();
		final int BLEU=color.getBlue();
		
		ArrayList<Integer> nvGrisTab=new ArrayList<>();
		nvGrisTab.add((int)(ROUGE*0.3+VERT*0.59+BLEU*0.11));
		setCouleurs.add(color);
		
		int r=ROUGE;
		int v=VERT;
		int b=BLEU;
		
		//r,v,b
		while (r + 40 <= 255) {
			r += 40;
			while (v + 40 <= 255) {
				v += 40;
				while (b + 40 <= 255) {
					b += 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
			}
			v = VERT;
			while (v - 40 >= 0) {
				v -= 40;
				while (b + 40 <= 255) {
					b += 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
			}
		}
		r = ROUGE;
		while (r - 40 >= 0) {
			r -= 40;
			while (v + 40 <= 255) {
				v += 40;
				while (b + 40 <= 255) {
					b += 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
			}
			v = VERT;
			while (v - 40 >= 0) {
				v -= 40;
				while (b + 40 <= 255) {
					b += 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab);
				}
			}
		}
		
		/*
		while (v + 40 <= 255) {
			v += 40;
			ajouterCouleurSiValide(r, v, b, nvGrisTab);
		}
		v = VERT;
		while (v - 40 >= 0) {
			v -= 40;
			ajouterCouleurSiValide(r, v, b, nvGrisTab);
		}
		
		
		while (b + 40 <= 255) {
			b += 40;
			ajouterCouleurSiValide(r, v, b, nvGrisTab);
		}
		b = BLEU;
		while (b - 40 >= 0) {
			b -= 40;
			ajouterCouleurSiValide(r, v, b, nvGrisTab);
		}*/
		
		
		
		
		/*nbColor = nb;
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
		}*/
	}
	
	public boolean nvGrisValide(Color c, ArrayList<Integer> nvGrisTab){
		int nvGris=(int)(c.getRed()*0.3+c.getGreen()*0.59+c.getBlue()*0.11);
		for(int i=0; i<nvGrisTab.size(); i++) {
			if(nvGris<=nvGrisTab.get(i)+20 && nvGris>=nvGrisTab.get(i)-20){
				return false;
			}
		}
		return true;
	}
	
	public void ajouterCouleurSiValide(int r, int v, int b, ArrayList<Integer> nvGrisTab){
		if(nvGrisValide(new Color(r,v,b), nvGrisTab)){
			nvGrisTab.add((int)(r*0.3+v*0.59+b*0.11));
			setCouleurs.add(new Color(r,v,b));
		}
	}
	
	public ArrayList<Color> getSelectionCouleurs() {
		return setCouleurs;
	}
}
