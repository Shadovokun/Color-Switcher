package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AffichageDunSet extends fenetre {

	JPanel contentPane;
	JFrame fenetre;
	Sets s;

	/**
	 * Create the frame.
	 */
	public AffichageDunSet(ArrayList<Color> set, Sets s) {
		this.s=s;
		fenetre=new JFrame(super.title);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		fenetre.setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" ←");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.addMouseListener(new ActionPrecedent(this));
		panel_2.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_9.add(verticalGlue_2);
		
		JPanel panel_14 = new JPanel();
		panel_9.add(panel_14);
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);
		
		JLabel label_1 = new JLabel("1");
		panel_10.add(label_1);
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11);
		
		JLabel label_2 = new JLabel("2");
		panel_11.add(label_2);
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12);
		
		JLabel label_3 = new JLabel("3");
		panel_12.add(label_3);
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13);
		
		JLabel label_4 = new JLabel("4");
		panel_13.add(label_4);
		
		JPanel panel_15 = new JPanel();
		panel_9.add(panel_15);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_9.add(verticalGlue_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		JMenuBar menuBar=new JMenuBar();
		JMenu m1=new JMenu("RVB");
		JMenu m2=new JMenu("Hexa");
		JMenu m3=new JMenu("TSV");
		menuBar.add(m1);
		menuBar.add(m2);
		menuBar.add(m3);
		panel_1.add(menuBar, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_3.add(horizontalGlue);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel_3.add(horizontalGlue_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel_3.add(horizontalGlue_3);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_3.add(horizontalGlue_1);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_4.add(verticalGlue);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JLabel lblRougeVertBleu = new JLabel("Rouge        Vert        Bleu");
		panel_5.add(lblRougeVertBleu);
		lblRougeVertBleu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JLabel label = new JLabel("    0               0              0  ");
		panel_6.add(label);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JButton btnCopier = new JButton("Copier");
		panel_7.add(btnCopier);
		
		JButton btnCopier_1 = new JButton("Copier");
		panel_7.add(btnCopier_1);
		
		JButton btnCopier_2 = new JButton("Copier");
		panel_7.add(btnCopier_2);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_4.add(verticalGlue_1);
		
	}
	
	private class ActionPrecedent implements MouseListener {
		AffichageDunSet a;
		public ActionPrecedent(AffichageDunSet a){
			this.a=a;
		}
		public void mouseClicked(MouseEvent e) {
			a.s.fenetre.pack();  //rouvrir la fenetre ?
			s.fenetre.dispose();
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}

}
