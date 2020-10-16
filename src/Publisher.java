import java.util.*;

public class Publisher extends SpecialPerson
{
    public static Set<Book> writersThatSentBooks = new HashSet<>();
    private static final Map<Book, Boolean> acceptedOrRejectedBooks = new HashMap<>();

    public Publisher(String name, String lastName, long id, String username, String password) {
        super(name, lastName, id, username, password);
    }
    public void judge()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("which book do you want to judge");
        String name = scanner.nextLine();
        for (Book b: writersThatSentBooks)
        {
            if(b.getName().equals(name))
            {
                System.out.println("do you think it's 1)good or 2)bad 3) not sure");
                int judge = scanner.nextInt();
                if(judge == 1 || judge == 2)
                {
                    writersThatSentBooks.remove(b);
                    acceptedOrRejectedBooks.put(b, judge == 1);
                }
                else
                {
                    System.out.println("pay more attention!");
                }
            }
        }
    }
    public static void optimizeBookList()
    {
        acceptedOrRejectedBooks.forEach((book, aBoolean) ->
        {
            if(!aBoolean)
            {
                acceptedOrRejectedBooks.remove(book, aBoolean);
            }
        });
    }
    public void onlyGetBestSellers()
    {
        writersThatSentBooks.removeIf(b -> !b.hasBestSellerWriter());
    }
}
