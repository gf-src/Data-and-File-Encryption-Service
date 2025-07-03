import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class DecryptText {

	// no traditional main method.
	// when the class is called, it will take the cipher text and 
	// a cipher key as input
	public static String mainMethod(String cipherText, String userKey) 
			throws Exception 
	{

		// creates a key using the KeyGenerator class
		SecretKey key = KeyGenerator.createKey(userKey); 
		
		// calls the decryptMessage method with the cipher text and cipher key and 
		// returns they cipher text as output
		String decryptedMessage = decryptMessage(cipherText, key);
		//System.out.println("Original message: " + decryptedMessage);
		return decryptedMessage;

	}

	public static String decryptMessage(String cipherText, SecretKey key)
			throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException 
	{
		
		// the cipher text gets broken down into its byte values and stored 
		// in a byte array
	    byte[] decodedCipherText = Base64.getDecoder().decode(cipherText);
	    byte[] iv = new byte[12]; // creates a byte array used to store the IV
	    
	    // this line of code will take the first 12 bytes in the byte array and 
	    // store it in the iv array
	    System.arraycopy(decodedCipherText, 0, iv, 0, iv.length);
	    
	    // creates a new array that stores the encrypted bytes in a separate byte array,
	    // removing the iv stored in the cipher text
	    byte[] encryptedText = new byte[decodedCipherText.length - 12];
	    System.arraycopy(decodedCipherText, 12, encryptedText, 0, encryptedText.length);
		
	    /* creates an instance of a cipher object and an IV using the values of the
	     *IV stored in the cipher text. the cipher then decrypts the cipher text using
	     *the key and iv generated
	    */
	    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
	    cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);

	    // the final plain text is stored in a byte array
		byte[] plainText = cipher.doFinal(encryptedText);

		// the method return the original plain text by creating a string using
		// the values stored in the byte array
		return new String(plainText, StandardCharsets.UTF_8);
		
	}
	
}
