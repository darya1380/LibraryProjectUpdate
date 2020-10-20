import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Library
{
    static Set<Book> books = new HashSet<>();
    static Set<Publisher> publishers = new HashSet<>();
    static Set<User> users = new HashSet<>();
    static Set<Writer> writers = new HashSet<>();
    static final Librarian librarian = new Librarian("darya", "taghva", 24598471,
            "librarian", "1234");

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
            case "publisher": {
                person = new Publisher(command[1], command[2], Long.parseLong(command[3]), command[4], command[5]);
            }
            res = true;
                break;
            case "Librarian":
            {
                Librarian l = new Librarian(command[1], command[2], Long.parseLong(command[3]), command[4], command[5]);
                if(l.equals(librarian))
                {
                    System.out.println("please enter the data of the person you want to add");
                    Scanner scanner = new Scanner(System.in);
                    while (scanner.hasNextLine())
                    {
                        String[] commands = scanner.nextLine().split(" ");
                        switch (commands[0])
                        {
                            case "writer":
                            {
                                writers.add(new Writer(commands[1], commands[2], Long.parseLong(commands[3]
                                ), commands[4], commands[5]));
                            }
                            break;
                            case "publisher":
                            {
                                publishers.add(new Publisher(commands[1], commands[2], Long.parseLong(commands[3]),
                                        commands[4], commands[5]));

                            }
                            break;
                            default: {
                                System.out.println("enter a valid command");
                                askInput();
                            }
                            break;
                        }
                    }
                }
            }
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

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            switchCommand(command);
        }
    }
}
