import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Writer extends SpecialPerson {
    private int score;
    private int salary;
    private boolean isBestSeller;
    private Set<Book> finishedBooks;
    private Set<Book> publisherSentBooks;
    public Writer(String name, String lastName, long id, String username, String password)
    {
        super(name, lastName, id, username, password);
        this.score = 0;
        this.salary = 0;
        this.isBestSeller = false;
        this.finishedBooks = new HashSet<>();
        this.publisherSentBooks = new HashSet<>();
    }
    public void makeBestSeller()
    {
        if(this.isEligible())
        {
            this.salary = 100;
        }
        else
        {
            System.out.println("you are not eligible");
            System.out.println("write more books!");
        }
    }

    private boolean isEligible() {
        return this.score >= 200;
    }
    public void writeBooks()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please write your book name");
        String name = scanner.nextLine();
        System.out.println("good, now please select your book genre");
        String genreIn = scanner.next();
        Genre genre = Genre.valueOf(genreIn);
        System.out.println("great, now please introduce your book");
        String explain = scanner.nextLine();
        Book book = new Book(name, explain, genre, this);
        finishedBooks.add(book);
        System.out.println("great, now you can send your book to publisher at any time");
    }
    public void sendToPublisher()
    {

    }
}
