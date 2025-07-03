import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// page used for decrypting a file

public class FileDecryptionPage implements ActionListener {
	
	JFrame fileDecryptionPage;
	JLabel title;
	JButton fileChooser; // a button that will open a file explorer
	JLabel passwordLabel;
	JTextField fileName;
	JTextField password;
	JButton submit;
	JButton back;
	JButton rest; // a button that will open the file explorer
	JTextField finalLocation; // a field for where the decrypted file will be stored
	
	FileDecryptionPage(){
		
		fileDecryptionPage = new JFrame("File Decryption Page");

		fileDecryptionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileDecryptionPage.getContentPane().setBackground(Color.black);		
		fileDecryptionPage.setSize(620, 400);
		fileDecryptionPage.setLocationRelativeTo(null);
		
		fileDecryptionPage.setLayout(new GridBagLayout());
		Container c = fileDecryptionPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new  Insets(5, 5, 5, 5);

		
		title = new JLabel("<html>Enter info file, password, <br/>and "
				+ "encrypted file location</html>");
		
		title.setFont(title.getFont().deriveFont((float) 30));
		title.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		fileChooser = new JButton("<html><font color = white>Encrypted "
				+ "Byte File<font><html>");
		fileChooser.setFocusable(false);
		fileChooser.setBackground(Color.black);
		fileChooser.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		c.add(fileChooser,gbc);  
		
		fileName = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(fileName,gbc);
		
		
		
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
		
		rest = new JButton("<html><font color = white>Final Location<font><html>");
		rest.setFocusable(false);
		rest.setBackground(Color.black);
		rest.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		c.add(rest,gbc);
		
		finalLocation = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 3;
		c.add(finalLocation,gbc);
		

		submit = new JButton("<html><font color = white>submit<font><html>");
		submit.setFocusable(false);
		submit.setBackground(Color.black);
		submit.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 4;
		c.add(submit,gbc);
		
		back = new JButton("<html><font color = white>return<font><html>");
		back.setFocusable(false);
		back.setBackground(Color.black);
		back.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 4;
		c.add(back,gbc);
		
		fileDecryptionPage.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// closes current page and returns to the previous page
		if(e.getSource() == back) {
			fileDecryptionPage.dispose();
			DecryptionSelectionPage decrypt = new DecryptionSelectionPage();
		}	
		
		/* 
		 * when this button is pressed, it will open a file explorer that will allow
		 * the user to select a file from the directory.
		 * when a file is selected, the path to the file will automatically be 
		 * copied to the fileName field
		*/
		if(e.getSource() == fileChooser) {
			
			JFileChooser chooser = new JFileChooser();
			int response = chooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION){
				String filePath = chooser.getSelectedFile().getAbsolutePath();
				fileName.setText(filePath);
			}
			
		}
		
		/* 
		 * when this button is pressed, it will open a file explorer that will allow
		 * the user to select where to create a new file from the directory.
		 * when the location is selected and file named, the path to the file will 
		 * automatically be copied to the finalLocation field
		*/
		if(e.getSource() == rest) {
			
			JFileChooser chooser = new JFileChooser();
			int response = chooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION){
				String filePath = chooser.getSelectedFile().getAbsolutePath();
				finalLocation.setText(filePath);
			}
			
		}
		
		/*
		 * will close the current page and open the decryption success page and take the 
		 * path of both the original file and decrypted file as input.
		 * it will call the VideoDecryption class to perform the decryption.
		 * it will take the paths and strings found in the fileName, password, and 
		 * finalRest fields as input
		 */
		if(e.getSource() == submit) {
			try {
				fileDecryptionPage.dispose();
				VideoDecryption.mainMethod(fileName.getText(), password.getText(),
						finalLocation.getText());
				DecryptionSuccess display = new DecryptionSuccess(fileName.getText(),
						finalLocation.getText());
				//DisplayFinalMessage finalResult =
				//		new DisplayFinalMessage(EncryptText.mainMethod(plainText.getText(), password.getText()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

