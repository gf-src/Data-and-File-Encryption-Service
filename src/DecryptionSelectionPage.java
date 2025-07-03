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

//this is the class used to create the decryption selection page

public class DecryptionSelectionPage implements ActionListener {
	
	JFrame decryptionSelectionPage;
	JLabel title;
	JButton plainText;
	JButton textFile;
	JButton imageFile;
	JButton otherFiles;
	JButton back;
	
	// the following method is used to determine how the page will look and is arranged
	// look at MainPage for more explanation for certain elements
	DecryptionSelectionPage()  {
		

		decryptionSelectionPage = new JFrame("Decryption Selection Page");
		
		decryptionSelectionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		decryptionSelectionPage.getContentPane().setBackground(Color.black);		
		decryptionSelectionPage.setSize(600, 650);
		decryptionSelectionPage.setLocationRelativeTo(null);
		
		decryptionSelectionPage.setLayout(new GridBagLayout());
		Container c = decryptionSelectionPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new  Insets(5, 5, 5, 5);

		
		title = new JLabel("Select format you want decrypted");

		title.setFont(title.getFont().deriveFont((float) 30));

		title.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		plainText = new JButton("<html><font color = white size = 40>Plain Text<font><html>");
		plainText.setFocusable(false);
		plainText.setBackground(Color.black);
		plainText.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = .5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipady = 60;
		c.add(plainText,gbc);
		
		textFile = new JButton("<html><font color = white size = 10>Text File<font><html>");
		textFile.setFocusable(false);
		textFile.setBackground(Color.black);
		textFile.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = .5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipady = 60;
		c.add(textFile,gbc);
		
		imageFile = new JButton("<html><font color = white size = 10>Image File<font><html>");
		imageFile.setFocusable(false);
		imageFile.setBackground(Color.black);
		imageFile.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = .5;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipady = 60;
		c.add(imageFile,gbc);
		
		otherFiles = new JButton("<html><font color = white size = 10>Other File"
				+ " Types<font><html>");
		otherFiles.setFocusable(false);
		otherFiles.setBackground(Color.black);
		otherFiles.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = .5;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.ipady = 60;
		c.add(otherFiles,gbc);
		
		back = new JButton("<html><font color = white>return<font><html>");
		back.setFocusable(false);
		back.setBackground(Color.black);
		back.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.ipady = 0;
		c.add(back,gbc);

		decryptionSelectionPage.setVisible(true);
	}
	
	// the method that is called to determine how the program will act when certain 
	// buttons are pressed. for all buttons, the current page will close when pressed.
	public void actionPerformed(ActionEvent e) {
		
		// if the back button is pressed, return to the main page
		if(e.getSource() == back) {
			decryptionSelectionPage.dispose();
			MainPage mainPage = new MainPage();
		}
		// if plainText is pressed, move on to the TextDecryptionPage
		if(e.getSource() == plainText) {
			decryptionSelectionPage.dispose();
			TextDecryptionPage plainTextDecryption = new TextDecryptionPage();
		}
		// if the textFile button is pressed, move on to the TextFileDecryptionPage
		if(e.getSource() == textFile) {
			decryptionSelectionPage.dispose();
			TextFileDecryptionPage textFileDecryption = new TextFileDecryptionPage();
		}
		// if the imageFile button is pressed, move on to the ImageDecryptionPage
		if(e.getSource() == imageFile) {
			decryptionSelectionPage.dispose();
			ImageDecryptionPage imageFileDecryption = new ImageDecryptionPage();
		}
		// if the otherFiles button is pressed, move on to the FileDecryptionPage
		if(e.getSource() == otherFiles) {
			decryptionSelectionPage.dispose();
			FileDecryptionPage fileDecryption = new FileDecryptionPage();
		}

		
	}

}
