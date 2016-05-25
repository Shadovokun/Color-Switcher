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

public class SetPredef extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPredef frame = new SetPredef();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SetPredef() {
		setTitle("COLOR SWITCHER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JLabel label_9 = new JLabel("1");
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("2");
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("3");
		panel_4.add(label_11);
		
		JLabel label_12 = new JLabel("4");
		panel_4.add(label_12);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JLabel label_1 = new JLabel("1");
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("2");
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("3");
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("4");
		panel_3.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JLabel label_5 = new JLabel("1");
		panel_7.add(label_5);
		
		JLabel label_6 = new JLabel("2");
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("3");
		panel_7.add(label_7);
		
		JLabel label_8 = new JLabel("4");
		panel_7.add(label_8);
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JLabel label_13 = new JLabel("1");
		panel_8.add(label_13);
		
		JLabel label_14 = new JLabel("2");
		panel_8.add(label_14);
		
		JLabel label_15 = new JLabel("3");
		panel_8.add(label_15);
		
		JLabel label_16 = new JLabel("4");
		panel_8.add(label_16);
		
		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));
		
		JLabel label_17 = new JLabel("1");
		panel_12.add(label_17);
		
		JLabel label_18 = new JLabel("2");
		panel_12.add(label_18);
		
		JLabel label_19 = new JLabel("3");
		panel_12.add(label_19);
		
		JLabel label_20 = new JLabel("4");
		panel_12.add(label_20);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
	}
	
	private class ActionPrecedent implements MouseListener {
		SetPredef a;
		public ActionPrecedent(SetPredef a){
			this.a=a;
		}
		public void mouseClicked(MouseEvent e) {
			Accueil accueil=new Accueil();
			a.dispose();
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}

}
