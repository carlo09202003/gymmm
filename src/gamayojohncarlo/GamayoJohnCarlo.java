/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gamayojohncarlo;

/**
 *
 * @author PC
 */

import java.util.Scanner;
public class GamayoJohnCarlo {
// Define arrays to store user information
    static String[] usernames = new String[100];
    static String[] passwords = new String[100];
    static String[] userTypes = new String[100];
    static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Welcome to the Gym Management System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    loginMenu(scanner);
                    break;
                case 2:
                    registerUser(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public static void loginMenu(Scanner scanner) {
        System.out.println("Login as:");
        System.out.println("1. Guest");
        System.out.println("2. Subscriber");
        System.out.println("3. Admin");
        System.out.print("Choose an option: ");
        
        int loginChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (loginChoice) {
            case 1:
                login("guest", scanner);
                break;
            case 2:
                login("subscriber", scanner);
                break;
            case 3:
                login("admin", scanner);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void login(String userType, Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password) && userTypes[i].equals(userType)) {
                System.out.println("Login successful as " + userType);
                return;
            }
        }
        System.out.println("Login failed. Please check your credentials.");
    }

    public static void registerUser(Scanner scanner) {
    System.out.print("Register as:\n1. Guest\n2. Subscriber\n3. Admin\nChoose an option (1/2/3): ");
    int userTypeChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    String userType;

    switch (userTypeChoice) {
        case 1:
            userType = "guest";
            break;
        case 2:
            userType = "subscriber";
            break;
        case 3:
            userType = "admin";
            break;
        default:
            System.out.println("Invalid user type choice. Registration failed.");
            return;
    }

    System.out.print("Enter your username: ");
    String username = scanner.nextLine();
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();

    usernames[userCount] = username;
    passwords[userCount] = password;
    userTypes[userCount] = userType;
    userCount++;

    System.out.println("Registration successful.");
}

}
