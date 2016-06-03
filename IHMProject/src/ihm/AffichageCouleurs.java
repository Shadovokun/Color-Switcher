package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AffichageCouleurs {

	Accueil accueil;
	JPanel contentPane;
	JPanel stats=new JPanel();
	JPanel panel=new JPanel();
	JFrame fenetre=new JFrame("COLOR SWITCHER");
	Clipboard clipbd =	fenetre.getToolkit().getSystemClipboard();
	int pointeur=0; //couleur affichée: la première du set
	int x, y;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList <Color> couleurs =new ArrayList<>();
					couleurs.add(Color.PINK);
					couleurs.add(Color.BLACK);
					couleurs.add(Color.BLUE);
					couleurs.add(Color.RED);
					couleurs.add(Color.GREEN);
					couleurs.add(Color.YELLOW);
					couleurs.add(Color.ORANGE);
					couleurs.add(Color.CYAN);
					couleurs.add(Color.MAGENTA);
					couleurs.add(Color.RED);
					AffichageCouleurs frame = new AffichageCouleurs(couleurs, null, 400, 200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AffichageCouleurs(ArrayList<Color> couleurs, Accueil accueil, int posX, int posY) {
		x=posX;
		y=posY;
		this.accueil=accueil;
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(600,450));
		fenetre.setLocation(x, y);
		fenetre.setResizable(false);
		fenetre.addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent arg0) {}
			public void componentMoved(ComponentEvent arg0) {
				x=(int)(fenetre.getLocation().getX());
				y=(int)(fenetre.getLocation().getY());
			}
			public void componentResized(ComponentEvent arg0) {}
			public void componentShown(ComponentEvent arg0) {}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		fenetre.setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		//affichage des couleurs
		JPanel panelC=new JPanel();
		JPanel[] panelsCouleurs=new JPanel[couleurs.size()];
			for(int i=0; i<couleurs.size(); i++) {
				panelC=new JPanel();
				panelC.setPreferredSize(new Dimension(45,35));
				panelC.setBackground(couleurs.get(i));
				if(i==0){
					panelC.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				}
				panelsCouleurs[i]=panelC;
				panel.add(panelC);
			}
			//ajout des listeners
			for(int i=0; i<panelsCouleurs.length; i++) {
				panelsCouleurs[i].addMouseListener(new SelectionCouleur(i, panelsCouleurs));
			}

		JPanel bouche_trou1=new JPanel();
		bouche_trou1.setPreferredSize(new Dimension(45,35));
		bouche_trou1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel retour=new JLabel(" ←");
		retour.setFont(new Font("Dialog", Font.BOLD, 22));
		retour.addMouseListener(new ActionRetour(this));
		bouche_trou1.add(retour);
		contentPane.add(bouche_trou1);
		contentPane.add(panel);
		JPanel bouche_trou2=new JPanel();
		bouche_trou2.setPreferredSize(new Dimension(45,35));
		contentPane.add(bouche_trou2);
		stats.setLayout(new BorderLayout());
		stats.add(StatsCouleur(panel));
		contentPane.add(stats);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	
	public JPanel StatsCouleur(JPanel couleurs){
		int r=couleurs.getComponent(pointeur).getBackground().getRed();
		int g=couleurs.getComponent(pointeur).getBackground().getGreen();
		int b=couleurs.getComponent(pointeur).getBackground().getBlue();
		
		float[] tsv=new float[3];
		Color.RGBtoHSB(r, g, b, tsv);
		int t=(int)(360*tsv[0]);
		int s=(int)(100*tsv[1]);
		int v=(int)(100*tsv[2]);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "RVB", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JLabel lblRouge = new JLabel("Rouge : ");
		panel_8.add(lblRouge);
		
		JLabel lblNbrouge = new JLabel(""+r);
		panel_8.add(lblNbrouge);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCopierRouge = new JButton("Copier");
		btnCopierRouge.addActionListener(new Copy(lblNbrouge));
		panel_9.add(btnCopierRouge);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JLabel lblVert = new JLabel("Vert : ");
		panel_10.add(lblVert);
		
		JLabel lblNbvert = new JLabel(""+g);
		panel_10.add(lblNbvert);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		JButton btnCopierVert = new JButton("Copier");
		btnCopierVert.addActionListener(new Copy(lblNbvert));
		panel_11.add(btnCopierVert);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JLabel lblBleu = new JLabel("Bleu : ");
		panel_12.add(lblBleu);
		
		JLabel lblNbbleu = new JLabel(""+b);
		panel_12.add(lblNbbleu);
		
		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);
		
		JButton btnCopierBleu = new JButton("Copier");
		btnCopierBleu.addActionListener(new Copy(lblNbbleu));
		panel_13.add(btnCopierBleu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Hexa", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_3.add(verticalGlue);
		
		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		
		JLabel lblNbhexa = new JLabel(""+String.format("#%02X%02X%02X", r, g, b));
		panel_14.add(lblNbhexa);
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		
		JButton btnCopierHexa = new JButton("Copier");
		btnCopierHexa.addActionListener(new Copy(lblNbhexa));
		panel_15.add(btnCopierHexa);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "TSV", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JPanel panel_16 = new JPanel();
		panel_4.add(panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.Y_AXIS));
		
		JPanel panel_19 = new JPanel();
		panel_16.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));
		
		
		//trouver comment modifer les valeurs TSV
		JLabel lblTeinte = new JLabel("Teinte : ");
		panel_19.add(lblTeinte);
		
		JLabel lblNbteinte = new JLabel(""+t);
		panel_19.add(lblNbteinte);
		
		JPanel panel_20 = new JPanel();
		panel_16.add(panel_20);
		
		JButton btnCopierTeinte = new JButton("Copier");
		btnCopierTeinte.addActionListener(new Copy(lblNbteinte));
		panel_20.add(btnCopierTeinte);
		
		JPanel panel_17 = new JPanel();
		panel_4.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.Y_AXIS));
		
		JPanel panel_21 = new JPanel();
		panel_17.add(panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.X_AXIS));
		
		JLabel lblSaturation = new JLabel("Saturation : ");
		panel_21.add(lblSaturation);
		
		JLabel lblNbsaturation = new JLabel(""+s);
		panel_21.add(lblNbsaturation);
		
		JPanel panel_22 = new JPanel();
		panel_17.add(panel_22);
		
		JButton btnCopierSaturation = new JButton("Copier");
		btnCopierSaturation.addActionListener(new Copy(lblNbsaturation));
		panel_22.add(btnCopierSaturation);
		
		JPanel panel_18 = new JPanel();
		panel_4.add(panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.Y_AXIS));
		
		JPanel panel_23 = new JPanel();
		panel_18.add(panel_23);
		panel_23.setLayout(new BoxLayout(panel_23, BoxLayout.X_AXIS));
		
		JLabel lblValeur = new JLabel("Valeur : ");
		panel_23.add(lblValeur);
		
		JLabel lblNbvaleur = new JLabel(""+v);
		panel_23.add(lblNbvaleur);
		
		JPanel panel_24 = new JPanel();
		panel_18.add(panel_24);
		
		JButton btnCopierValeur = new JButton("Copier");
		btnCopierValeur.addActionListener(new Copy(lblNbvaleur));
		panel_24.add(btnCopierValeur);
		
		return panel_1;
	}

	class Copy implements ActionListener {
		JLabel value;
		public Copy(JLabel v) {
			value = v;
		}
		public void actionPerformed(ActionEvent e) {
			String selection = value.getText();
			if(selection == null) {return;}
			StringSelection clipString = new StringSelection(selection);
			clipbd.setContents(clipString,clipString);
		}
	}
	
	class SelectionCouleur extends MouseAdapter {
		int i;
		JPanel[] couleurs;
		
		public SelectionCouleur(int i, JPanel[] couleurs){
			this.i=i;
			this.couleurs=couleurs;
		}
		public void mouseClicked(MouseEvent arg0) {
			pointeur=i;
			for(int n=0; n<couleurs.length; n++){
				couleurs[n].setBorder(BorderFactory.createEmptyBorder());
			}
			couleurs[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			stats.removeAll();
			stats.add(StatsCouleur(panel));
			fenetre.pack();
		}
	}
	
	private class ActionRetour implements MouseListener {
		AffichageCouleurs affichage;
		public ActionRetour(AffichageCouleurs affichage){
			this.affichage=affichage;
		}
		public void mouseClicked(MouseEvent e) {
			affichage.fenetre.dispose();
			accueil.fenetre.setLocation(x,y);
			accueil.fenetre.setVisible(true);
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}
}
