package fa.training.entities;

import java.util.Date;

public class Magazine extends Publication {

    private String author;
    private int volume;
    private int edition;

    public Magazine(String author, int volume, int edition,
                    int publicationYear, String publisher, Date publicationDate) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "author='" + author + '\'' +
                ", volume=" + volume +
                ", edition=" + edition +
                '}';
    }

    @Override
    public void display() {
        System.out.println("Magazine{" +
                "author='" + author + '\'' +
                ", volume=" + volume +
                ", edition=" + edition +
                '}');
    }
}
