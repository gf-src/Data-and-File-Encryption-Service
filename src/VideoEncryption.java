import java.io.File;
import java.io.FileInputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

// this class is called VideoEncryption, but it works on multiple different file formats,
// not just videos(.mp4)

public class VideoEncryption {

	/*
	 * this class will get the path stored in fileName, extract the byte values of the
	 * file using the FileInputStream,
	 * encrypt the byte values found, and create a new text file to store the encrypted 
	 * bytes in the location specified by finalRest. 
	 * the class will also delete the file found in fileName
	 */
	
	public static void mainMethod(String fileName, String userKey, String finalRest) throws Exception {

		File file = new File(fileName);
		
		byte[] fileBytes = new byte[(int) file.length()];
		
    	SecretKey key = KeyGenerator.createKey(userKey);

		
		FileInputStream fis = new FileInputStream(file);
		fis.read(fileBytes);
		fis.close();
		
		byte[] encryptedFileBytes = fileEncryption(fileBytes, key);
		
    	Path path = Paths.get(finalRest);
    	Files.write(path, encryptedFileBytes);

		System.out.printf("file  encryption successful.\n"
				+ "Encrypted file informaiton found at %s", 
				path);
		
		file.delete();
		
	}
	
	public static byte[] fileEncryption(byte[] plainText, SecretKey key) 
			throws Exception
	{
		
	    byte[] iv = new byte[12];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(iv);


	    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
	    cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

	    byte[] encryptedBytes = cipher.doFinal(plainText);

	    byte[] combinedIvAndCipherText = new byte[iv.length + encryptedBytes.length];
	    System.arraycopy(iv, 0, combinedIvAndCipherText, 0, iv.length);
	    System.arraycopy(encryptedBytes, 0, combinedIvAndCipherText, iv.length, encryptedBytes.length);

	    return combinedIvAndCipherText;
		
	}

}
