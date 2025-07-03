import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

//this class is called VideoDecryption, but it works on multiple different file formats,
//not just videos(.mp4)

public class VideoDecryption {

	/*
	 * this class will get the path stored in fileName, extract its byte values,
	 * decrypt the byte values found, and create a new file of the specified format
	 * using the decrypted bytes in the location specified by finalRest. 
	 * the class will also delete the file found in fileName
	 */
	public static void mainMethod(String fileName, String userKey, String finalRest) throws Exception {

    	Path path = Paths.get(fileName);

    	SecretKey key = KeyGenerator.createKey(userKey);
    	
    	byte[] data = Files.readAllBytes(path);
    	
    	byte[] decryptedArray = videoDecryption(data, key);
		
		FileOutputStream fos = new FileOutputStream(finalRest);
		fos.write(decryptedArray);
		fos.close();
		System.out.printf("Video decryption successful.\n"
				+ "Encrypted video informaiton found at %s", 
				fos.toString());
		
		Files.delete(path);
		
	}
	
	public static byte[] videoDecryption(byte[] cipherText, SecretKey key)
			throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException 
	{
		
	    byte[] decodedCipherText = cipherText;
	    byte[] iv = new byte[12];

	    System.arraycopy(decodedCipherText, 0, iv, 0, iv.length);
	    
	    byte[] encryptedText = new byte[decodedCipherText.length - 12];
	    System.arraycopy(decodedCipherText, 12, encryptedText, 0, encryptedText.length);
		
	    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
	    cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);

		byte[] plainText = cipher.doFinal(encryptedText);


		return plainText;
		
	}

}
