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

// this page will display the final result of the encryption/decryption process used 
// in the TextEncryptionPage/TextDecryptionPage

public class DisplayFinalMessage implements ActionListener {
	
	JFrame textDisplayPage;
	JLabel label;
	JTextArea text;
	JPanel panel;
	JButton back;
	
	DisplayFinalMessage(String message){
		
		textDisplayPage = new JFrame("Final Message Page");
		textDisplayPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textDisplayPage.getContentPane().setBackground(Color.white);		
		textDisplayPage.setSize(600, 400);
		textDisplayPage.setLocationRelativeTo(null);
		
		
		label = new JLabel("Final Result:");
		label.setForeground(Color.white);

		
		
		text = new JTextArea(10,10);
		text.setForeground(Color.white);
		text.setBackground(Color.black);
		text.append(message);
		text.setEditable(false);
		text.setLineWrap(true);
		
		panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(label);
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
