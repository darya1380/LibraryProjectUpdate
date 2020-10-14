import java.util.HashSet;
import java.util.Set;

public class OrdinaryUser implements AbleToBorrow{
    private int score;
    private boolean isTrustWorthy;
    private Set<Book> borrowedBooks = new HashSet<>();

    public OrdinaryUser()
    {
        this.score = 0;
        this.isTrustWorthy = false;
    }

    @Override
    public void borrow(Book book)
    {
        if(book.isAvailable())
        {
            if(this.hasRightToBorrow())
            {
                book.lowerAvailableNumbers();
                borrowedBooks.add(book);
            }
        }

    }

    @Override
    public boolean hasRightToBorrow() {
        return borrowedBooks.size() < 5;
    }

    @Override
    public void returnBook(Book book)
    {
        borrowedBooks.remove(book);
        book.addAvailableNumbers();
    }
}
