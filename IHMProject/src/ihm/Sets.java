package ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

public class Sets extends fenetre {
	
	boolean fromAccueil;
	JPanel contentPane;
	JFrame fenetre;
	int nbSets=5;

	/**
	 * Create the frame.
	 */
	public Sets(boolean fromAccueil) {
		this.fromAccueil=fromAccueil;
		fenetre= new JFrame(super.title);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		fenetre.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel(" ←");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.addMouseListener(new ActionPrecedent(this));
		panel.add(label);
		
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
		
		JPanel[] setsJPanel=new JPanel[nbSets];
		
		for(int i=0; i<nbSets; i++) {
			panel_2.add(new JPanel());
			setsJPanel[i]=getSetJPanel(4);
			panel_2.add(setsJPanel[i]);
		}
		panel_2.add(new JPanel());
	}
	
	JPanel getSetJPanel(int nbCouleurs){
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		for(int i=0; i<nbCouleurs; i++) {
			p.add(new JLabel(""+i));
		}
		return p;
	}
	
	private class ActionPrecedent implements MouseListener {
		Sets a;
		public ActionPrecedent(Sets a){
			this.a=a;
		}
		public void mouseClicked(MouseEvent e) {
			if(a.fromAccueil){
				Accueil accueil=new Accueil();
			} else {
				ChoisirCouleur choice= new ChoisirCouleur();
			}
			a.fenetre.dispose();
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}

}
