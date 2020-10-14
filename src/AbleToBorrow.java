public interface AbleToBorrow
{
    void borrow(Book book);
    boolean hasRightToBorrow();
    void returnBook(Book book);
}
