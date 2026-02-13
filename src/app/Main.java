// pacchetto principale dell'applicazione, contiene il punto di ingresso
package app;

// import delle classi necessarie
import app.service.UserService;
import java.util.Scanner;


// classe principale dell'applicazione, 
// contiene il metodo main che avvia il programma,
// Main (View + Controller)
public class Main {

  // metodo main, punto di ingresso dell'applicazione
  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
      UserService service = new UserService();

      while (true) {

        System.out.println("\n=== LOGIN SYSTEM ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Scelta: ");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {

          case 1:
            System.out.print("Username: ");
            String user = scanner.nextLine();

            System.out.print("Password: ");
            String pass = scanner.nextLine();

            if (service.register(user, pass))
              System.out.println("Registrazione OK");
            else
              System.out.println("Utente già esistente");

            break;

          case 2:
            System.out.print("Username: ");
            user = scanner.nextLine();

            System.out.print("Password: ");
            pass = scanner.nextLine();

            if (service.login(user, pass))
              System.out.println("Login riuscito");
            else
              System.out.println("Credenziali errate");

            break;

          case 3:
            System.out.println("Chiusura...");
            return;

          default:
            System.out.println("Scelta non valida");
        }
      }
    }
  } // fine main
} // fine classe Main
