import java.util.HashSet;
import java.util.Set;

public class Book
{
    private String name;
    private Set<Author> authors;
    private Set<Publisher> publishers;
    private double score;
    private Genre genre;
    private int availableNumber;

    public Book(String name, Genre genre, int publisherScore, int availableNumber)
    {
        this.name = name;
        this.genre = genre;
        this.authors = new HashSet<>();
        this.publishers = new HashSet<>();
        this.score = publisherScore;
        this.availableNumber = availableNumber;
    }
}
