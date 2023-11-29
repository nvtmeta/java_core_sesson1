package fa.training.services;

import fa.training.entities.Book;
import fa.training.utils.Validator;

import java.util.*;
import java.util.stream.Collectors;

import static fa.training.main.LibraryManagement.publications;

public class BookFunction {

//    Functional Requirements
//1. The program must have a function to add a new book.

    public static void addBook(Scanner scanner) {
        System.out.println("\nAdding a new book");

        System.out.println("Enter the publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the publisher: ");
        String publisher = scanner.nextLine();
//        System.out.println("Enter the publication date: ");
//        String publicationDate = scanner.nextLine();

        String isbn;
        // Validate the ISBN using the isValidISBN() method
        while (true) {
            System.out.println("Enter the ISBN: ");
            isbn = scanner.nextLine();
            if (Validator.isValidISBN(isbn)) {
                break;
            } else {
                System.out.println("Invalid ISBN. Please enter a valid ISBN with 10-17 digits.");
            }
        }

        System.out.println("Enter the publication place: ");
        String publicationPlace = scanner.nextLine();

        System.out.println("Enter the author(s) (comma-separated): ");
        String authorsInput = scanner.nextLine();

        Set<String> authors = Arrays.stream(authorsInput.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());

        Book book = new Book(isbn, authors, publicationPlace, publicationYear, publisher, new Date());

        publications.add(book);
        System.out.println("Book added successfully.");

    }

    public static void addAuthorToBook(Scanner scanner) {
//4. The program must have a function to add an author to a specific book, if the author existed, the
//program should print a message “Author existed”, otherwise print “Add successfully”.

        System.out.println("Enter the ISBN of the book: ");
        String isbn = scanner.nextLine();
        System.out.println("Enter the author's name: ");
        String authorName = scanner.nextLine();

        Optional<Book> optionalBook = publications.stream()
                .filter(publication -> publication instanceof Book)
                .map(publication -> (Book) publication)
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.getAuthor().contains(authorName)) {
                System.out.println("Author existed.");
            } else {
                book.getAuthor().add(authorName);
                System.out.println("Author added successfully to the book.");
            }
        } else {
            System.out.println("Book with the given ISBN not found.");
        }

    }


    public static void searchBooks(Scanner scanner) {
        //6. The program must provide functions to:
        //- search book by isbn
        //- search book by author
        //- search book by publisher
        //Search results should be sorted by isbn, publication date.

        System.out.println("Search book by (isbn, author, publisher): ");
        String searchBy = scanner.nextLine();

        List<Book> searchedBooks;
        if (searchBy.equalsIgnoreCase("isbn")) {
            System.out.println("Enter the ISBN: ");
            String isbn = scanner.nextLine();
            searchedBooks = publications.stream()
                    .filter(publication -> publication instanceof Book)
                    .map(publication -> (Book) publication)
                    .filter(book -> book.getIsbn().equals(isbn))
                    .collect(Collectors.toList());
        } else if (searchBy.equalsIgnoreCase("author")) {
            System.out.println("Enter the author's name: ");
            String authorName = scanner.nextLine();
            searchedBooks = publications.stream()
                    .filter(publication -> publication instanceof Book)
                    .map(publication -> (Book) publication)
                    .filter(book -> book.getAuthor().contains(authorName))
                    .collect(Collectors.toList());
        } else if (searchBy.equalsIgnoreCase("publisher")) {
            System.out.println("Enter the publisher: ");
            String publisher = scanner.nextLine();
            searchedBooks = publications.stream()
                    .filter(publication -> publication instanceof Book)
                    .map(publication -> (Book) publication)
                    .filter(book -> book.getPublisher().equals(publisher))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Invalid search criteria. Please try again.");
            return;
        }

        searchedBooks.sort(Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate));

        System.out.println("Search results:");
        searchedBooks.forEach(Book::display);
    }
}
