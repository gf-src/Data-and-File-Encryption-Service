import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class KeyGenerator {

	/*
	 * this class creates a key used for encryption or decryption using a user provided
	 * phrase.
	 */
	public static SecretKey createKey(String password) 
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		/* a salt is a value that is combined with the cipher key to create more 
		 * randomness, think of it like a second password needed to create the final 
		 * cipher key. for user simplicity, the salt value will always be the same.
		*/ 
		String salt = "12345678";
		
		// creates an object of the SecretjeyFactory class that will be used to create the 
		// cipher key. the "PBKDF2WithHmacSHA256" input allows us to provide our own key.
		SecretKeyFactory generator = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		
		// the following lines of code generates the key using the user provided password 
		// and program provided salt value.
		// it then return the final key object
		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		
		SecretKey key = new SecretKeySpec(generator.generateSecret(keySpec).getEncoded(), "AES");
		
		return key;
		
	}


		
	
}
