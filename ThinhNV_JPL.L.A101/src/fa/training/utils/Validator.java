package fa.training.utils;

public class Validator {
    public static boolean isValidISBN(String isbn) {
        // Remove all non-digit characters from the ISBN
        String digitsOnly = isbn.replaceAll("[^\\d]", "");

        // Check if the length of the digitsOnly string is between 10 and 17
        if (digitsOnly.length() >= 10 && digitsOnly.length() <= 17) {
            return true;
        } else {
            return false;
        }
    }
}
