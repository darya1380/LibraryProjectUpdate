import java.util.HashSet;
import java.util.Set;

public class Book
{
    private static long firstId = 1000;

    private String name;
    private Set<Author> authors;
    private Set<Publisher> publishers;
    private double score;
    private Genre genre;
    private int availableNumber;
    private long id;

    public Book(String name, Genre genre, int publisherScore, int availableNumber)
    {
        this.name = name;
        this.genre = genre;
        this.authors = new HashSet<>();
        this.publishers = new HashSet<>();
        this.score = publisherScore;
        this.availableNumber = availableNumber;
        this.id = firstId++;
    }

    public boolean isAvailable()
    {
        return this.availableNumber > 0;
    }
    public void lowerAvailableNumbers()
    {
        this.availableNumber -= 1;
    }
    public void addAvailableNumbers()
    {
        this.availableNumber += 1;
    }
}
