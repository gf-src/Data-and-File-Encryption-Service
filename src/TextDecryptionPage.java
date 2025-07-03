import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//the class used to create the plain text decryption page


public class TextDecryptionPage implements ActionListener{
	
	JFrame textDecryptionPage;
	JLabel title;
	JLabel text;
	JLabel passwordLabel;
	JTextArea cipherText; // the text area where users will place their cipher text
	JTextField password; // a field where users will be able to place their password
	JButton submit;
	JButton back;
	
	// the following method is used to determine how the page will look and is arranged
	// look at MainPage for more explanation for certain elements
	TextDecryptionPage(){
		
		textDecryptionPage = new JFrame("PlainText Decryption Page");

		textDecryptionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textDecryptionPage.getContentPane().setBackground(Color.black);		
		textDecryptionPage.setSize(600, 400);
		textDecryptionPage.setLocationRelativeTo(null);
		
		textDecryptionPage.setLayout(new GridBagLayout());
		Container c = textDecryptionPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new  Insets(5, 5, 5, 5);

		
		title = new JLabel("Enter cipher text and password");
		
		title.setFont(title.getFont().deriveFont((float) 30));

		title.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		text = new JLabel("Cipher Text:");
		text.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
		c.add(text,gbc);
		
		// the following code will initialize and change the text area where users will
		// place their message
		cipherText = new JTextArea(5,20);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		// when the text placed in the area reaches the end of the provided area,
		// the following line of code will make the text wrap around to the next line
		// in the area as opposed to stretching the text area itself.
		cipherText.setLineWrap(true);
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(cipherText,gbc);
		

		
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
		c.add(passwordLabel,gbc);
		
		password = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		c.add(password,gbc);
		

		submit = new JButton("<html><font color = white>submit<font><html>");
		submit.setFocusable(false);
		submit.setBackground(Color.black);
		submit.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		c.add(submit,gbc);
		
		back = new JButton("<html><font color = white>return<font><html>");
		back.setFocusable(false);
		back.setBackground(Color.black);
		back.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		c.add(back,gbc);

		textDecryptionPage.setVisible(true);
		
	}

	// the method that is called to determine how the program will act when certain 
	// buttons are pressed. for all buttons, the current page will close when pressed.
	@Override
	public void actionPerformed(ActionEvent e) {
		// if the back button is pressed, return to the main page
		if(e.getSource() == back) {
			textDecryptionPage.dispose();
			DecryptionSelectionPage decrypt = new DecryptionSelectionPage();
		}
		
		/*
		 * if the submit button is pressed, then the page call the EncryptText class and
		 * take the input found in both the plainText and password fields and use them 
		 * as input. it will then call the DisplayFinalMessage page and place the 
		 * result of the previous class call as input
		 */
		if(e.getSource() == submit) {
			try {
				textDecryptionPage.dispose();
				DisplayFinalMessage finalResult =
						new DisplayFinalMessage(DecryptText.mainMethod(cipherText.getText(), password.getText()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
