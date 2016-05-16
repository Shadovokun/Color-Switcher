package ihm;

public class testNvGris {
	int rouge, vert, bleu;
	int[] valeurs = new int[10];
	double fin;
	
	testNvGris() {
		for (int i = 1; i < 11; i++) {
			double temp = ( ( (255*0.1*i) *100) /100);
			valeurs[i-1] = (int) temp;
		}
		for (rouge = 0; rouge < 256; rouge++){
			for (vert = 0; vert < 256; vert++) {
				for (int bleu = 0; bleu < 255; bleu++) {
					fin = rouge*0.3 + vert*0.59 + bleu * 0.11;
					for (int i = 0; i < 10; i++) {
						if (fin == valeurs[i]) {
							System.out.println(rouge + " - " + vert + " - " + bleu + " - "+fin);
						}
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		testNvGris test = new testNvGris();
	}
}
