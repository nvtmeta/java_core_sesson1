package fa.training.services;

import fa.training.entities.Publication;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static fa.training.main.LibraryManagement.publications;

public class PublicationFunction {

    public static void displayPublication(Scanner scanner) {
//        3. The program must have a function to display the list of all books and magazines that have the
//same publication year and publisher.

        System.out.println("Enter the publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the publisher: ");
        String publisher = scanner.nextLine();

        List<Publication> matchingPublications = publications.stream()
                .filter(publication -> publication.getPublicationYear() == publicationYear
                        &&
                        publication.getPublisher().equals(publisher))
                .toList();

        System.out.println("List of books and magazines with the same publication year and publisher:");
        matchingPublications.forEach(Publication::display);
    }


}
