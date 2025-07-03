import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//this class will be displayed if encryption is successful, providing the 
//location of the final encrypted file

public class EncryptionSuccess implements ActionListener {
	
	JFrame textDisplayPage;
	JLabel label;
	JTextArea text;
	JPanel panel;
	JButton back;
	
	EncryptionSuccess(String message, String finalResult){
		
		textDisplayPage = new JFrame("Final Message Page");
		textDisplayPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textDisplayPage.getContentPane().setBackground(Color.white);		
		textDisplayPage.setSize(600, 400);
		textDisplayPage.setLocationRelativeTo(null);
		
		text = new JTextArea(10,1);
		text.setForeground(Color.white);
		text.setBackground(Color.black);
		text.setText("File: " + message + " was successfully encrypted.");
		if(finalResult != null) {
			text.setText("\nlocation of decrypted file: " + finalResult);
		}
		text.setEditable(false);
		text.setLineWrap(true);
		
		panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(text);
		
		back = new JButton("<html><font color = white>return to main page<font><html>");
		back.setFocusable(false);
		back.setBackground(Color.black);
		back.addActionListener(this);
		
		panel.add(back);
		
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		textDisplayPage.add(panel);
		textDisplayPage.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			textDisplayPage.dispose();
			MainPage decrypt = new MainPage();
		}
		
		
	}
	
}
