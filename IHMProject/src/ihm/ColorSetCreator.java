package ihm;

import java.awt.Color;
import java.util.ArrayList;

public class ColorSetCreator {
	ArrayList<Color> setCouleurs=new ArrayList<>();
	
	public ArrayList<Color> genererSet (Color color, int nb) {
		setCouleurs=new ArrayList<>();
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
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
			}
			v = VERT;
			while (v - 40 >= 0) {
				v -= 40;
				while (b + 40 <= 255) {
					b += 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
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
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
			}
			v = VERT;
			while (v - 40 >= 0) {
				v -= 40;
				while (b + 40 <= 255) {
					b += 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
				b = BLEU;
				while (b - 40 >= 0) {
					b -= 40;
					ajouterCouleurSiValide(r, v, b, nvGrisTab, nb);
				}
			}
		}		
		return setCouleurs;
	}
	
	public boolean nvGrisValide(Color c, ArrayList<Integer> nvGrisTab, int nbCouleurs){
		if(nvGrisTab.size()>=nbCouleurs){
			return false;
		}
		int nvGris=(int)(c.getRed()*0.3+c.getGreen()*0.59+c.getBlue()*0.11);
		int pas;
		if(nbCouleurs<=4) {
			pas=50;
		} else if(nbCouleurs<=6){
			pas=30;
		} else if(nbCouleurs<=9){
			pas=20;
		} else {
			pas=15;
		}
		for(int i=0; i<nvGrisTab.size(); i++) {
			if(nvGris<=nvGrisTab.get(i)+pas && nvGris>=nvGrisTab.get(i)-pas){
				return false;
			}
		}
		return true;
	}
	
	public void ajouterCouleurSiValide(int r, int v, int b, ArrayList<Integer> nvGrisTab, int nbCouleurs){
		if(nvGrisValide(new Color(r,v,b), nvGrisTab, nbCouleurs)){
			nvGrisTab.add((int)(r*0.3+v*0.59+b*0.11));
			setCouleurs.add(new Color(r,v,b));
		}
	}
}
