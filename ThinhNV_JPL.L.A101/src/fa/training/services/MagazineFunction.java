package fa.training.services;

import fa.training.entities.Magazine;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static fa.training.main.LibraryManagement.publications;

public class MagazineFunction {
    public static void  addMagazine(Scanner scanner) {
        System.out.println("\nAdding a new magazine");

        System.out.print("Enter the publication year: ");
        int publicationYear = scanner.nextInt();

        System.out.print("Enter the publisher: ");
        String publisher = scanner.next();


        System.out.print("Enter the author name: ");
        String author = scanner.next();

        System.out.print("Enter the volume: ");
        int volume = scanner.nextInt();

        System.out.print("Enter the edition: ");
        int edition = scanner.nextInt();

        // Create a new magazine object
        Magazine magazine = new Magazine(author, volume, edition,
                publicationYear, publisher, new Date());

        publications.add(magazine);

        System.out.println("New magazine added successfully!");
    }


    public static void displayTopMagazinesByVolume() {
//        5. The program must have a function to display the list of
//        top 10 magazines which have the largest
//        volume.
        System.out.println("Top 10 magazines by volume:");
        List<Magazine> magazines = publications.stream()
                .filter(publication -> publication instanceof Magazine)
                .map(publication -> (Magazine) publication)
                .sorted(Comparator.comparingInt(Magazine::getVolume).reversed())
                .limit(10)
                .toList();

        System.out.println("Top 10 magazines by volume:");
        magazines.forEach(Magazine::display);
    }
}
