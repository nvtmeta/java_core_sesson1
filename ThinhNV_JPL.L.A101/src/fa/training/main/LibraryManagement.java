package fa.training.main;

import fa.training.entities.Publication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static fa.training.services.BookFunction.*;
import static fa.training.services.MagazineFunction.addMagazine;
import static fa.training.services.MagazineFunction.displayTopMagazinesByVolume;
import static fa.training.services.PublicationFunction.displayPublication;

public class LibraryManagement {
    public static List<Publication> publications = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.print("Please choose function you'd like to do: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addMagazine(scanner);
                    break;
                case 3:
                    displayPublication(scanner);
                    break;
                case 4:
                    addAuthorToBook(scanner);
                    break;
                case 5:
                    displayTopMagazinesByVolume();
                    break;
                case 6:
                    searchBooks(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
