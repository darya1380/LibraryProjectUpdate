import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User extends Person {
    private final Set<BorrowedBook> borrowedBooks;
    public User(String name, String lastName, long id) {
        super(name, lastName, id);
        borrowedBooks = new HashSet<>();
    }
    private class BorrowedBook
    {
        Book book;

        public Book getBook() {
            return book;
        }

        public Date getReturnDate() {
            return returnDate;
        }

        Date returnDate;

        public BorrowedBook(Book book)
        {
            this.book = book;
            this.returnDate = generateDate();
        }

        private Date generateDate()
        {
            Date date = new Date();
            /**
             * current time by second from 1970!
             */
            long currentTime = date.getTime();
            long returnLong = currentTime + (2 * 7 * 24 * 3600);
            Date returnTime = new Date(returnLong);
            return returnTime;
        }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the name of the book that you want");
        String name = scanner.nextLine();
        for (Book b: Library.books)
            if(b.getName().equals(name))
            {
                if(this.isEligible())
                {
                    borrowedBooks.add(new BorrowedBook(b));
                    System.out.println("you have successfully borrowed this book");
                    System.out.println("remember to return it");
                    break;
                }
            }
    }

    private boolean isEligible() {
        return borrowedBooks.size() < 5;
    }

    public void returnBook()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the name of book you want to return");
        String name = scanner.nextLine();
        for (BorrowedBook b: borrowedBooks)
            if(b.getBook().getName().equals(name))
            {
                borrowedBooks.remove(b);
                if(b.getReturnDate().before(new Date()))
                {
                    System.out.println("thanks for giving back the book on time!");
                }
                else
                {
                    System.out.println("please return it sooner!");
                }
            }
    }
}
