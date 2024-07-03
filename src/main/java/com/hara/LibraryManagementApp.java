package com.hara;

import java.util.Scanner;

public class LibraryManagementApp {
    private static LibraryService libraryService = new LibraryService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!AuthService.authenticate(username, password)) {
            System.out.println("Invalid credentials!");
            return;
        }

        String role = AuthService.getRole(username);

        while (true) {
            System.out.println("\nMenu:");
            if ("ADMIN".equals(role)) {
                System.out.println("1. Add Book");
                System.out.println("2. Update Book");
                System.out.println("3. Delete Book");
            }
            System.out.println("4. List Books");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (!"ADMIN".equals(role)) break;
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    libraryService.addBook(title, author);
                    break;
                case 2:
                    if (!"ADMIN".equals(role)) break;
                    System.out.print("Enter old book title: ");
                    String oldTitle = scanner.nextLine();
                    System.out.print("Enter new book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new book author: ");
                    String newAuthor = scanner.nextLine();
                    libraryService.updateBook(oldTitle, newTitle, newAuthor);
                    break;
                case 3:
                    if (!"ADMIN".equals(role)) break;
                    System.out.print("Enter book title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    libraryService.deleteBook(deleteTitle);
                    break;
                case 4:
                    libraryService.listBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
