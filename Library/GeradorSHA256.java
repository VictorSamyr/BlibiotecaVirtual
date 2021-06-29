import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorSHA256 {
    public static String getSHA256(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA256");
        byte[] inputByte = input.getBytes(StandardCharsets.UTF_8);
        byte[] shaByte = md.digest(inputByte); 
        BigInteger number = new BigInteger(1, shaByte);
        String hexString = number.toString(16);
        return hexString;
    }
}
