package Fail;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccueilFail extends fenetre {

	JPanel contentPane;
	JFrame fenetre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilFail frame = new AccueilFail();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AccueilFail() {
		fenetre= new JFrame(super.title);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setBounds(0, 0, super.width, super.height);
		fenetre.setLocationRelativeTo(null);
		super.setPosX(fenetre.getX());
		super.setPosY(fenetre.getY());
		fenetre.setVisible(true);
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
		AccueilFail a;
		public ActionSetPredef(AccueilFail a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			Sets setPredef=new Sets(true);
			a.fenetre.dispose();
		}
	}
	
	private class ActionGenererSet implements ActionListener {
		AccueilFail a;
		public ActionGenererSet(AccueilFail a){
			this.a=a;
		}
		public void actionPerformed(ActionEvent e) {
			ChoisirCouleur choisirCouleur=new ChoisirCouleur();
			a.fenetre.dispose();
		}
	}
}
