import java.security.MessageDigest;
import java.util.Scanner;  

public class sha256 {
    public static void main(String[] args) {          
        Scanner reading = new Scanner(System.in); 
        System.out.printf("Enter a string to be hashed: ");   
        String str = reading.next(); 
        System.out.printf("\nString ..: %s\n", str);  
        System.out.println("Sha256 ..: " + getSha256(str));
    }
    public static String getSha256(String value) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(value.getBytes());
	        return bytesToHex(md.digest());
	    } catch(Exception ex) {
	        throw new RuntimeException(ex);
	    }
 	}
    private static String bytesToHex(byte[] bytes) {
	    StringBuffer result = new StringBuffer();
	    for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	    return result.toString();
 	}
}