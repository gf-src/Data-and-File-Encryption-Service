import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/*
 * this class works very similarly to DecryptText, but the text is decrypted from a
 * text file one line at a time as opposed to all at once. once the line of text is 
 * decrypted, it is returned to the original text file before moving on the the next 
 * line.
 */

public class TextFileDecryption {

	public static void mainMethod(String fileName, String userKey) throws InvalidKeyException, 
	NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, 
	IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, 
	IOException {


		
		try {
			
		readFile(fileName, userKey);
		
		} catch (AEADBadTagException e) {
			System.out.print("wrong passkey or encrytped File used.\nPlease try again");
		}
		System.out.print("File successfully decrypted.");
		
	}
	
	public static void readFile(String fileName, String userKey) throws IOException, 
	NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, 
	NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, 
	InvalidAlgorithmParameterException {
		
		try {
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		StringBuffer inputBuffer = new StringBuffer();
		
		String line;
		
		SecretKey key = KeyGenerator.createKey(userKey);

		while ((line = file.readLine()) != null) {
			//System.out.println(line); // TEMP LINE TO CHECK IF PROGRAM CAN READ EACH LINE
			line = lineDecryption(line, key); 
			inputBuffer.append(line);
			inputBuffer.append('\n');
		}
		file.close();

		// write the new string with the replaced line OVER the same file
		FileOutputStream fileOut = new FileOutputStream(fileName);
		fileOut.write(inputBuffer.toString().getBytes());
		fileOut.close();
		} catch (FileNotFoundException e) {
		      System.out.println("File could not be found.");
		      System.exit(0);
		    }
	}
	
	public static String lineDecryption(String cipherText, SecretKey key)
			throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException 
	{
		
	    byte[] decodedCipherText = Base64.getDecoder().decode(cipherText);
	    byte[] iv = new byte[12];

	    System.arraycopy(decodedCipherText, 0, iv, 0, iv.length);
	    
	    byte[] encryptedText = new byte[decodedCipherText.length - 12];
	    System.arraycopy(decodedCipherText, 12, encryptedText, 0, encryptedText.length);
		
	    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
	    cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);

		byte[] plainText = cipher.doFinal(encryptedText);


		return new String(plainText, StandardCharsets.UTF_8);
		
	}

}
