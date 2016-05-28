package Fail;

import java.awt.EventQueue;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
//: c13:CutAndPaste.java
//Utilisation du presse-papier.


public class CutAndPaste extends JFrame  {
	JMenuBar mb = new JMenuBar();
	JMenu edit = new JMenu("Edit");
	JMenuItem
	cut = new JMenuItem("Cut"),
	copy = new JMenuItem("Copy"),
	paste = new JMenuItem("Paste");
	JTextArea text = new JTextArea(20, 20);
	Clipboard clipbd =
	getToolkit().getSystemClipboard();
	
	
	public CutAndPaste()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cut.addActionListener(new CutL());
		copy.addActionListener(new CopyL());
		paste.addActionListener(new PasteL());
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		mb.add(edit);
		setJMenuBar(mb);
		getContentPane().add(text);
}
	class CopyL implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String selection = text.getSelectedText();
				if(selection == null)
					return;
				StringSelection clipString =       new StringSelection(selection);
				clipbd.setContents(clipString,clipString);
			}
	}
	class CutL implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String selection = text.getSelectedText();
				if(selection == null)
					return;
				StringSelection clipString =       new StringSelection(selection);
				clipbd.setContents(clipString, clipString);
				text.replaceRange("",	text.getSelectionStart(),	text.getSelectionEnd());
			}
	}
	class PasteL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Transferable clipData =	clipbd.getContents(CutAndPaste.this);
			try{
				String clipString =	(String)clipData.getTransferData(DataFlavor.stringFlavor);
				text.replaceRange(clipString,	text.getSelectionStart(),	text.getSelectionEnd());
			} catch(Exception ex) {
				System.err.println("Not String flavor");
			}
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CutAndPaste frame = new CutAndPaste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
} ///:~