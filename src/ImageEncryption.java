import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.imageio.ImageIO;

public class ImageEncryption {

	// this class takes a two file names and a  cipher key as input 
	// fileName should be the path of the image we want to encrypt
	// byteLocation is the exact path we want the byte values of the encrypted image to be stored in.
	// for byteLocation, the user has to specify the file as a .txt file or else the
	// byte values wont be properly stored, leading to the original image becoming lost
	public static void mainMethod(String fileName, String userKey, String byteLocation)
			throws Exception {

		/*
		 * the following lines of code creates a file object for the image we want 
		 * encrypted and a BufferedImage object. this will allow us to extract the byte 
		 * value of the original image into a byte array
		 */
		File file = new File(fileName);
    	BufferedImage image = ImageIO.read(file);
    	ByteArrayOutputStream outStreamObj = new ByteArrayOutputStream();
    	
    	ImageIO.write(image, fileName.substring(fileName.length()-3), outStreamObj);


    	
    	byte[] imageBytes = outStreamObj.toByteArray();
    	SecretKey key = KeyGenerator.createKey(userKey);// creates a key for encryption
    	
    	// calls the encryptImage method to encrypt the image byte values
		byte[] encryptedArray = encryptImage(imageBytes, key);
		
		/* creates a new text file using the path provided by the user and stores the
		 * byte values in the text file
		 */
    	Path path = Paths.get(byteLocation);
    	Files.write(path, encryptedArray);
    	
    	// for added secrecy, the program will delete the original file that was
    	// encrypted. This may however cause issues if you specify the wrong format
    	// for byteLocation or if you forgot the password used for encryption, leading to
    	// you losing the original forever.
    	file.delete();
    	
    	System.out.printf("Image encrypted.\nEncrypted Data Found at %s", path);
		
	}
	
	
	// to understand how this method works, check out the EncryptText class
	public static byte[] encryptImage(byte[] plainText, SecretKey key) 
			throws Exception
	{
		
	    byte[] iv = new byte[12];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(iv);


	    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	    GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
	    cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

	    byte[] encryptedBytes = cipher.doFinal(plainText);

	    byte[] finalCipher = new byte[iv.length + encryptedBytes.length];
	    System.arraycopy(iv, 0, finalCipher, 0, iv.length);
	    System.arraycopy(encryptedBytes, 0, finalCipher, iv.length, encryptedBytes.length);

	    return finalCipher;
		
	}
	

}
