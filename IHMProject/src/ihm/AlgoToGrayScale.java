package ihm;

import java.awt.Color;

public class AlgoToGrayScale {
	 Color depart;
	 int rouge, vert, bleu;
	 double nvGris;
	 Color[] set;
	
	public AlgoToGrayScale(int r, int g, int b) {
		depart = new Color(r, g, b);
		rouge = r;
		vert = g;
		bleu = b;
		nvGris = rouge *0.3 + vert *0.59 + bleu *0.11;
	}
	
	public AlgoToGrayScale(Color c) {
		depart = c;
	}
	
	public Color[] creerSet() {
		return null;
	}
	
	public String toString() {
		return "Rouge : " + rouge + " Vert : " + vert + " Bleu : " + bleu + " Nv Gris : " + nvGris;
	}

	public static void main(String[] args) {
	AlgoToGrayScale test = new AlgoToGrayScale(255,255,0);
	
	System.out.println(test.toString());
	}
}