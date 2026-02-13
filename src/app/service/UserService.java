// pacchetto per le classi di servizio
package app.service;

// import delle classi necessarie
import app.model.User;
import app.util.HashUtil;
import java.io.*;

// classe di servizio per la gestione degli utenti, con registrazione e login
// Service Layer (Logica Business)
public class UserService {
  // data members - attributi della classe
  private static final String FILE_NAME = "users.txt";

  // metodi - funzioni della classe.
  // metodo per registrare un nuovo utente, restituisce true
  // se la registrazione è avvenuta con successo, false se l'utente esiste già
  public boolean register(String username, String password) {

    if (userExists(username)) {
    return false;
    }

    String hashed = HashUtil.hashPassword(password);
    User user = new User(username, hashed);

    try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
      fw.write(user.toString() + "\n");
      return true;
    } catch (IOException e) {
      throw new RuntimeException("Errore scrittura file");
    }
  }

  // metodo per effettuare il login, restituisce true 
  // se le credenziali sono corrette, false altrimenti
  public boolean login(String username, String password) {

    String hashed = HashUtil.hashPassword(password);

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");

        if (parts[0].equals(username) && parts[1].equals(hashed)) {
          return true;
        }
      }

    } catch (IOException e) {
      return false;
    }

    return false;
  }

  // metodo privato per verificare se un utente esiste già, 
  // restituisce true se esiste, false altrimenti
  private boolean userExists(String username) {

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts[0].equals(username)) {
          return true;
        }
      }

    } catch (IOException e) {
      return false;
    }

    return false;
  }
}
