import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Writer extends SpecialPerson {
    private final int score;
    private int salary;
    private final boolean isBestSeller;
    private final Set<Book> finishedBooks;
    private final Set<Book> publisherSentBooks;
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
    private void writeBookContextInFile(String name, Scanner scanner) throws IOException {
        FileWriter bookFile = new FileWriter(name + " .txt");
        System.out.println("enter your book dates from PDF!");
        StringBuilder context = new StringBuilder();
        while (scanner.hasNextLine())
            context.append(scanner.nextLine());
        bookFile.write(context.toString());

    }

    private boolean isEligible() {
        return this.score >= 200;
    }
    public void writeBooks() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please write your book name");
        String name = scanner.nextLine();
        System.out.println("good, now please select your book genre");
        String genreIn = scanner.next();
        Genre genre = Genre.valueOf(genreIn);
        /* we will be able to save the book into file */
        writeBookContextInFile(name, scanner);

        System.out.println("great, now please introduce your book");
        String explain = scanner.nextLine();
        Book book = new Book(name, explain, genre, this);
        finishedBooks.add(book);
        System.out.println("great, now you can send your book to publisher at any time");
    }
    public void sendToPublisher()
    {
        System.out.println("we will send all of your books to publisher");
        publisherSentBooks.addAll(finishedBooks);
        Publisher.writersThatSentBooks.addAll(finishedBooks);
    }

    public boolean isBestSeller()
    {
        return this.isBestSeller;
    }

    @Override
    public void start() {

    }
}
