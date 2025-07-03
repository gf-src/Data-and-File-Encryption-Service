import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class EncryptText {
	
	// no traditional main method.
	// when the class is called, it will take the plain text and 
	// a cipher key as input	
	public static String mainMethod(String message, String userKey) 
			throws Exception 
	{
		
		// creates a key using the KeyGenerator class
		SecretKey key = KeyGenerator.createKey(userKey);
		
		// calls the encryptMessage method with the plain text and cipher key and 
		// returns they cipher text as output
		String encryptedMessage = encryptMessage(message, key);
		System.out.println("Encrypted message: " + encryptedMessage);
		return encryptedMessage;
		
	}

	public static String encryptMessage(String plainText, SecretKey key) 
			throws Exception
	{
		
		// a byte array with random byte values is created, used as the basis for the IV
	    byte[] iv = new byte[12];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(iv);

	    // a cipher object is created and initialized to encrypt mode using the key and
	    // iv
	    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
	    cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);
	    
	    // the plain text gets converted to its byte value, encrypted using the cipher 
	    // object,and stored in a new byte array
	    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
	    /*
	     * the following lines of code combine the encrypted bytes array and the iv array
	     * this is done so that we can extract the IV from the cipher text later on, 
	     * allowing us to perform the decryption successfully.
	     */
	    byte[] combinedIvAndCipherText = new byte[iv.length + encryptedBytes.length];
	    System.arraycopy(iv, 0, combinedIvAndCipherText, 0, iv.length);
	    System.arraycopy(encryptedBytes, 0, combinedIvAndCipherText, iv.length,
	    		encryptedBytes.length);
	    
	    // return the encrypted byte array as a string
	    return Base64.getEncoder().encodeToString(combinedIvAndCipherText);
		
	}
	
	
}
