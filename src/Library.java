import java.util.Scanner;
import java.util.Set;

public class Library
{
    private static Set<Book> books;
    private static Set<Publisher> publishers;
    private static Set<User> users;
    private static Set<Writer> writers;
    private static Librarian librarian;

    public static void main(String[] args) {

    }
    public static void switchCommand(String[] command)
    {
        boolean res = false;
        Person person = null;

        switch (command[0]) {
            case "writer":
                person = new Writer(command[1], command[2], Long.parseLong(command[3]), command[4], command[5]);
                if (writers.contains(person)) {
                    res = true;
                }
                break;
            case "user":
                person = new User(command[1], command[2], Long.parseLong(command[3]));
                if (users.contains(person)) {
                    res = true;
                }

                break;
            case "publisher":
                person = new Publisher(command[1], command[2], Long.parseLong(command[3]), command[4], command[5]);
                res = true;
                break;
            default:
                System.out.println("command not found");
                askInput();
                break;
        }
        if(person != null)
            person.start();
    }

    private static void askInput()
    {
        Librarian librarian = new Librarian("darya", "taghva", 24598471,
                "librarian", "1234");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] command = input.split(" ");
        switchCommand(command);
    }
}
