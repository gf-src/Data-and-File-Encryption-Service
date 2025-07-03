import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// the main page for the service, will provide the user the option to either encrypt
// or decrypt their data.


public class MainPage implements ActionListener{
	
	JFrame mainPage; // the main frame that this page is held in
	JButton encrypt; // a button for entering the EncryptionSelectionPage
	JButton decrypt; // a button for entering the DecryptionSelectionPage
	
	MainPage() {
		
		// creates the page frame with the provided title
		mainPage = new JFrame("Data Encryption Service Home Page");

		// several settings that dictate the size, look, and behavior of the page when 
		// closing
		mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPage.getContentPane().setBackground(Color.black);		
		mainPage.setSize(500, 400);
		mainPage.setLocationRelativeTo(null);
		
		// the setLayout method allows us to choose how the layout of the page will look 
		// and how we can arrange it.
		// GridBagLayout gives us the most amount of freedom out of most layout options.
		// most pages created in this program will follow this format.
		mainPage.setLayout(new GridBagLayout());
		Container c = mainPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// we create a label that contains the title of our page.
		JLabel title = new JLabel("Data Encryption Service");

		// the following code is used to determine how the title will look and where it
		// be placed on our grid.
		title.setFont(title.getFont().deriveFont((float) 30));
		title.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		// the following line blocks of code is used to determine how the encrypt and 
		// decrypt button will look and how it will be placed in our page.
		// the addActionListener method is used to connect certain actions to their  
		// respective buttons
		encrypt = new JButton("<html><font color = white size = 40>Encrypt<font><html>");
		encrypt.setFocusable(false);
		encrypt.setBackground(Color.black);
		encrypt.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL; // makes the button stretch to the sides of the screem
		gbc.weightx = .5; // the size of the spacing between components
		gbc.gridx = 0; // the x position of the element in the grid
		gbc.gridy = 1; // the y position of the element in the grid
		gbc.ipady = 60; // determines the height of the button
		c.add(encrypt,gbc); // adds the element(button) to the page
		
		decrypt = new JButton("<html><font color = white size = 10>Decrypt<font><html>");
		decrypt.setFocusable(false);
		decrypt.setBackground(Color.black);
		decrypt.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = .5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipady = 60;
		c.add(decrypt,gbc);

		mainPage.setVisible(true); // this line of code is what allows the page to be visible

	}

	// the actionPerformed method is inherited from ACtionListener and is used to 
	// determine how the page reacts to certain events, like button presses.
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * when the encrypt button is pressed, the page will close and the 
		 * EncryptionSelectionPage page will open
		 */
		if(e.getSource() == encrypt) {
			mainPage.dispose();
			EncryptionSelectionPage encrypt = new EncryptionSelectionPage();
		}
		/*
		 * when the decrypt button is pressed, the page will close and the 
		 * DecryptionSelectionPage page will open
		 */
		if(e.getSource() == decrypt) {
			mainPage.dispose();
			DecryptionSelectionPage decrypt = new DecryptionSelectionPage();
		}
		
	}
	
}
