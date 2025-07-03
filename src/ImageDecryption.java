import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
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
import javax.imageio.ImageIO;

public class ImageDecryption {
	
	// this class takes a two file names and a  cipher key as input 
	// fileName should be a text file where the encrypted byte values of the original
	// image is stored.
	// finalRest is the exact path we want the decrypted image to be stored in.
	// for finalRest, the user has to provide the image format that the original image 
	// was or else the decryption will not work properly
	public static void mainMethod(String fileName, String userKey, String finalRest) throws Exception {

		// we get the path of the file using the path provided by the user
    	Path path = Paths.get(fileName);
    	
    	// create a key using the KeyGenerator object
    	SecretKey key = KeyGenerator.createKey(userKey);
    	
    	// extract the bytes of the file provided and store them in a byte array
    	byte[] data = Files.readAllBytes(path);
    	
    	// calls the decryptImage method to decrypt the byte values stored in the 
    	// text file and return the final results
    	byte[] decryptedArray = decryptImage(data, key);
    	
    	/* the following lines of code creates a new image file using the encrypted byte
    	 * values, the file will be stored in the location specified by the user in 
    	 * finalRest. the code will take the final 3 characters of finalRest and generate
    	 * the final image using the format specified in those 3 characters
    	*/ 
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(decryptedArray);
        BufferedImage newImage = ImageIO.read(inStreambj);
		ImageIO.write(newImage, finalRest.substring(finalRest.length()-3),
				new File(finalRest));
		System.out.printf("Image successfully decrypted.");
		
		Files.delete(path);
		
   
	}
	
	// for an explanation of who this works, open DecryptText
	public static byte[] decryptImage(byte[] cipherText, SecretKey key)
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


