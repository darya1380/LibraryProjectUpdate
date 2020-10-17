import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Library
{
    private static final Set<Book> books = new HashSet<>();
    static Set<Publisher> publishers = new HashSet<>();
    static Set<User> users = new HashSet<>();
    static Set<Writer> writers = new HashSet<>();
    static Librarian librarian;

    public static void main(String[] args) {
        askInput();
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
                else
                {
                    System.out.println("no user found with this name!");
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
        if(person != null && res)
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
