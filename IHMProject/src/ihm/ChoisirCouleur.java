package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChoisirCouleur extends fenetre {

	JPanel contentPane;
	JFrame fenetre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoisirCouleur frame = new ChoisirCouleur();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChoisirCouleur() {
		fenetre=new JFrame(super.title);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		fenetre.setContentPane(contentPane);
		
		JColorChooser colorChooser = new JColorChooser();
		contentPane.add(colorChooser, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel(" ←");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.addMouseListener(new ActionPrecedent(this));
		panel.add(lblNewLabel);
	}
	
	private class ActionPrecedent implements MouseListener {
		ChoisirCouleur a;
		public ActionPrecedent(ChoisirCouleur a){
			this.a=a;
		}
		public void mouseClicked(MouseEvent e) {
			Accueil accueil=new Accueil();
			a.fenetre.dispose();
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}

}
