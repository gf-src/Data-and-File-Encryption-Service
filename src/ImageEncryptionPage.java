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

//the page where image decryption takes place.
//view FileEncryptionPage to have a better understanding of how the page works

public class ImageEncryptionPage implements ActionListener {
	
	JFrame imageEncryptionPage;
	JLabel title;
	JButton text;
	JLabel passwordLabel;
	JTextField imageFile;
	JTextField password;
	JButton submit;
	JButton back;
	JButton rest;
	JTextField finalLocation;
	
	ImageEncryptionPage(){
		
		imageEncryptionPage = new JFrame("Image File Encryption Page");

		imageEncryptionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageEncryptionPage.getContentPane().setBackground(Color.black);		
		imageEncryptionPage.setSize(620, 400);
		imageEncryptionPage.setLocationRelativeTo(null);
		
		imageEncryptionPage.setLayout(new GridBagLayout());
		Container c = imageEncryptionPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new  Insets(5, 5, 5, 5);

		
		title = new JLabel("<html>Enter image file,<br/>password, and "
				+ "encrypted<br/> file location</html>");
		
		title.setFont(title.getFont().deriveFont((float) 30));
		//title.setHorizontalAlignment(JLabel.CENTER);
		//title.setVerticalAlignment(JLabel.TOP);
		title.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		text = new JButton("<html><font color = white>Image File<font><html>");
		text.setFocusable(false);
		text.setBackground(Color.black);
		text.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		c.add(text,gbc);
		
		imageFile = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(imageFile,gbc);
		

		
		
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
		
		rest = new JButton("<html><font color = white>Info Location<font><html>");
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
		
		imageEncryptionPage.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			imageEncryptionPage.dispose();
			EncryptionSelectionPage encrypt = new EncryptionSelectionPage();
		}	
		if(e.getSource() == text) {
			
			JFileChooser chooser = new JFileChooser();
			int response = chooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION){
				String filePath = chooser.getSelectedFile().getAbsolutePath();
				imageFile.setText(filePath);
			}
			
		}
		
		if(e.getSource() == rest) {
			
			JFileChooser chooser = new JFileChooser();
			int response = chooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION){
				String filePath = chooser.getSelectedFile().getAbsolutePath();
				finalLocation.setText(filePath);
			}
			
		}
		
		if(e.getSource() == submit) {
			try {
				imageEncryptionPage.dispose();
				ImageEncryption.mainMethod(imageFile.getText(), password.getText(),
						finalLocation.getText());
				EncryptionSuccess display = new EncryptionSuccess(imageFile.getText(),
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

