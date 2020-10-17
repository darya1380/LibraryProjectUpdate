import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User extends Person {
    private final Set<Book> borrowedBooks;
    public User(String name, String lastName, long id) {
        super(name, lastName, id);
        borrowedBooks = new HashSet<>();
    }

    @Override
    public void start() {
        System.out.println("1) borrow book");
        System.out.println("2) return book");
        System.out.println("3) read book");
        System.out.println("4) read borrowed books");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input)
        {
            case 1: borrowBook();
            break;
            case 2: returnBook();
            break;
            case 3: readBook();
            break;
            case 4: readBorrowedBook();
            break;
        }

    }

    private void readBorrowedBook()
    {
        //todo
    }

    private void readBook()
    {
        //todo FILE LOADING MANAGEMENT
    }

    public void borrowBook()
    {
        //todo
    }
    public void returnBook()
    {
        //todo
    }
}
