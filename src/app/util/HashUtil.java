
// pacchetto per le classi di utilità
package app.util;

// framework per l'hashing delle password, utilizza SHA-256
import java.security.MessageDigest;

// Classe di utilità per l'hashing delle password
// Utility per Hash Password (SHA-256)
public class HashUtil {

  public static String hashPassword(String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] hashedBytes = md.digest(password.getBytes());

      StringBuilder sb = new StringBuilder();
      for (byte b : hashedBytes) {
        sb.append(String.format("%02x", b));
      }

      return sb.toString();

    } catch (Exception e) {
      throw new RuntimeException("Errore hashing password");
    }
  }
}
