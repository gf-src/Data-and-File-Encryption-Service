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

//the page where text file decryption takes place.
//works very similarly to the VideoDecryptionPage, so view the comments in that
//page to have a better understanding to the code.
//this page does not need a second file location to place the decrypted text since
//the decrypted text will be stored in the original text file

public class TextFileDecryptionPage implements ActionListener {
	
	JFrame textDecryptionPage;
	JLabel title;
	JButton text;
	JLabel passwordLabel;
	JTextField textFile;
	JTextField password;
	JButton submit;
	JButton back;
	
	TextFileDecryptionPage(){
		
		textDecryptionPage = new JFrame("Text File Decryption Page");

		textDecryptionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textDecryptionPage.getContentPane().setBackground(Color.black);		
		textDecryptionPage.setSize(600, 400);
		textDecryptionPage.setLocationRelativeTo(null);
		
		textDecryptionPage.setLayout(new GridBagLayout());
		Container c = textDecryptionPage.getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new  Insets(5, 5, 5, 5);

		
		title = new JLabel("Enter text file and password");
		
		title.setFont(title.getFont().deriveFont((float) 30));
		//title.setHorizontalAlignment(JLabel.CENTER);
		//title.setVerticalAlignment(JLabel.TOP);
		title.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 0;
		c.add(title,gbc);
		
		text = new JButton("<html><font color = white>Text File<font><html>");
		text.setFocusable(false);
		text.setBackground(Color.black);
		text.addActionListener(this);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		c.add(text,gbc);
		
		textFile = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(textFile,gbc);
		

		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			textDecryptionPage.dispose();
			DecryptionSelectionPage decrypt = new DecryptionSelectionPage();
		}	
		if(e.getSource() == text) {
			
			JFileChooser chooser = new JFileChooser();
			int response = chooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION){
				String filePath = chooser.getSelectedFile().getAbsolutePath();
				textFile.setText(filePath);
			}
			
		}
		
		if(e.getSource() == submit) {
			try {
				textDecryptionPage.dispose();
				TextFileDecryption.mainMethod(textFile.getText(), password.getText());
				DecryptionSuccess display = new DecryptionSuccess(textFile.getText(), null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

