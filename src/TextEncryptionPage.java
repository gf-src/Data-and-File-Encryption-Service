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

// the class used to create the plain text encryption page

public class TextEncryptionPage implements ActionListener{
	
	JFrame textEncryptionPage;
	JLabel title;
	JLabel text;
	JLabel passwordLabel;
	JTextArea plainText; // the text area where users will place their plain message
	JTextField password; // a field where users will be able to place their password
	JButton submit;
	JButton back;
	
	// the following method is used to determine how the page will look and is arranged
	// look at MainPage for more explanation for certain elements
	TextEncryptionPage(){
		
		textEncryptionPage = new JFrame("PlainText Encryption Page");

		textEncryptionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textEncryptionPage.getContentPane().setBackground(Color.black);		
		textEncryptionPage.setSize(600, 400);
		textEncryptionPage.setLocationRelativeTo(null);
		
		textEncryptionPage.setLayout(new GridBagLayout());
		Container c = textEncryptionPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new  Insets(5, 5, 5, 5);

		
		title = new JLabel("Enter plain text and password");
		
		title.setFont(title.getFont().deriveFont((float) 30));

		title.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		text = new JLabel("Plain Text:");
		text.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
		c.add(text,gbc);
		
		// the following code will initialize and change the text area where users will
		// place their message
		plainText = new JTextArea(5,20); // determines the initial size of the text area
		gbc.fill = GridBagConstraints.HORIZONTAL;
		// when the text placed in the area reaches the end of the provided area,
		// the following line of code will make the text wrap around to the next line
		// in the area as opposed to stretching the text area itself.
		plainText.setLineWrap(true);
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(plainText,gbc);
		

		
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
		c.add(passwordLabel,gbc);
		
		// the following lines of code initializes and changes how the text field where
		// the cipher key will be placed in will look
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
		
		textEncryptionPage.setVisible(true);
		
	}

	// the method that is called to determine how the program will act when certain 
	// buttons are pressed. for all buttons, the current page will close when pressed.
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the back button is pressed, return to the main page
		if(e.getSource() == back) {
			textEncryptionPage.dispose();
			EncryptionSelectionPage encrypt = new EncryptionSelectionPage();
		}	
		
		/*
		 * if the submit button is pressed, then the page call the EncryptText class and
		 * take the input found in both the plainText and password fields and use them 
		 * as input. it will then call the DisplayFinalMessage page and place the 
		 * result of the previous class call as input
		 */
		if(e.getSource() == submit) {
			try {
				textEncryptionPage.dispose();
				DisplayFinalMessage finalResult =
						new DisplayFinalMessage(EncryptText.mainMethod(plainText.getText(), password.getText()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
