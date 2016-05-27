package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class Accueil extends fenetre {

	JPanel contentPane;
	JFrame fenetre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accueil() {
		fenetre= new JFrame(super.title);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);  
		fenetre.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		fenetre.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnUtiliserUnSet = new JButton("Sets prédéfinis");
		panel.add(btnUtiliserUnSet);
		btnUtiliserUnSet.addActionListener(new ActionSetPredef(this));
		
		JButton btnCalculerUnSet = new JButton("Générer un set");
		panel.add(btnCalculerUnSet);
		btnCalculerUnSet.addActionListener(new ActionGenererSet(this));
		
		JLabel label = new JLabel("↔ ");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label, BorderLayout.NORTH);
	}

	private class ActionSetPredef implements ActionListener {
		Accueil a;
		public ActionSetPredef(Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			Sets setPredef=new Sets(true);
			a.fenetre.dispose();
		}
	}
	
	private class ActionGenererSet implements ActionListener {
		Accueil a;
		public ActionGenererSet(Accueil a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			ChoisirCouleur choisirCouleur=new ChoisirCouleur();
			a.fenetre.dispose();
		}
	}
}
