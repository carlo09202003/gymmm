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

    public static void displayGuestUsernames() {
    System.out.println("List of Guest Usernames:");
    for (int i = 0; i < userCount; i++) {
        if (userTypes[i].equals("guest")) {
            System.out.println(usernames[i]);
        }
    }
}

public static void displaySubscriberUsernames() {
    System.out.println("List of Subscriber Usernames:");
    for (int i = 0; i < userCount; i++) {
        if (userTypes[i].equals("subscriber")) {
            System.out.println(usernames[i]);
        }
    }
}

// Modify the login function to allow admin to view guest and subscriber usernames

public static void login(String userType, Scanner scanner) {
    System.out.print("Enter your username: ");
    String username = scanner.nextLine();
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();
    
    if (userType.equals("admin") && username.equals("admin") && password.equals("admin")) {
        System.out.println("Login successful as " + userType);
        System.out.println("1. View Guest Usernames");
        System.out.println("2. View Subscriber Usernames");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                displayGuestUsernames();
                break;
            case 2:
                displaySubscriberUsernames();
                break;
            default:
                System.out.println("Invalid option.");
        }
    } else {
        System.out.println("Login failed. Please check your credentials.");
    }
}


    public static void registerUser(Scanner scanner) {
    System.out.print("Register as:\n1. Guest\n2. Subscriber\nChoose an option (1/2): ");
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
        default:
            System.out.println("Invalid user type choice. Registration failed.");
            return;
    }

    System.out.print("Enter your username: ");
    String username = scanner.nextLine();
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();
    
    
    // used for checking exisiting account
    for (int i=0; i<100; i++)
    {
    if (username.equals(usernames[i]))
    {
        System.out.println("This Username is Existing as " + userTypes[i]);
        System.out.println("Please try again");
        break;
        
    }
    else
        {
    usernames[userCount] = username;
    passwords[userCount] = password;
    userTypes[userCount] = userType;
    userCount++;
    
    System.out.println("Registration successful.");
    break;
        }
    } // for
} // registerUser

}
