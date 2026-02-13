// pacchetto per le classi del modello
package app.model;

// classe che rappresenta un utente, con username e password hashata
// Utility per Hash Password (SHA-256)
public class User {

  private String username;
  private String passwordHash;

  public User(String username, String passwordHash) {
    this.username = username;
    this.passwordHash = passwordHash;
  }

  public String getUsername() {
    return username;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  @Override
  public String toString() {
    return username + "," + passwordHash;
  }
}
