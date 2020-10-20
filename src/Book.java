import java.util.*;

public class Book
{
    private final String name;
    private final Genre genre;
    private final Set<Writer> writers;
    private Set<Publisher> publishers;
    private int personWhoBorrow;
    private int numberOfPublish;
    private boolean isPublished;
    private final String explanation;
    private Map<String, Integer> reviews;
    public enum Genre
    {
        Poem, LoveStory, Play, Classic, History, Novel, Psychology, Sociology, TechnicalBook, Philosophy, ScienceFiction,
        Mystery, Realistic, Children, Western
    }

    public Book(String name, String explanation, Genre genre, Writer writer)
    {
        this.name = name;
        this.explanation = explanation;
        this.genre = genre;
        this.writers = new HashSet<>();
        this.writers.add(writer);
        isPublished = false;
        System.out.println("now your book is ready");
        System.out.println("send it to a publisher!");
    }
    public Book(String name,String explanation, Genre genre, Publisher publisher, int numberOfPublish, Writer... writers)
    {
        this(name, explanation, genre, writers[0]);
        for (Writer w: writers)
            addWriter(w);
        this.isPublished = true;
        this.numberOfPublish = numberOfPublish;
        this.publishers = new HashSet<>();
        this.publishers.add(publisher);

    }
    @Override
    public boolean equals(Object o)
    {
        return o instanceof Book && ((Book) o).name.equals(name);
    }
    public void addWriter(Writer writer)
    {
        writers.add(writer);
    }
    public void addPublisher(Publisher publisher, int numberOfPublish)
    {
        this.publishers.add(publisher);
        this.numberOfPublish += numberOfPublish;
    }
    public void addPersonToBorrow()
    {
        if(this.isAvailable())
        {
            this.personWhoBorrow += 1;
        }
        else
        {
            System.out.println("the book is not available now!");
        }
    }

    private boolean isAvailable()
    {
        return numberOfPublish >= personWhoBorrow;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean hasBestSellerWriter()
    {
        for (Writer w: writers)
            if(w.isBestSeller())
                return true;
            return false;
    }
}
