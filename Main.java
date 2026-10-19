import com.mycompany.chatapp.Login;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Chat App Registration ===");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        Login login = new Login(firstName, lastName);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African cellphone number: ");
        String cellphoneNumber = scanner.nextLine();

        String registrationMessage =
                login.registerUser(username, password, cellphoneNumber);

        System.out.println(registrationMessage);
    }System.out.println("\n=== Login ===");

System.out.print("Enter your username: ");
String loginUsername = scanner.nextLine();

System.out.print("Enter your password: ");
String loginPassword = scanner.nextLine();

boolean loginSuccessful =
        login.loginUser(loginUsername, loginPassword);

System.out.println(login.returnLoginStatus(loginSuccessful));

scanner.close();
}/*
 * 
}
