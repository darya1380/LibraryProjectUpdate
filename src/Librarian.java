import java.util.Scanner;
import java.util.Set;

public class Librarian extends SpecialPerson
{
    private Set<Book> books;
    private  Set<Publisher> publishers;
    private  Set<User> users;
    private  Set<Writer> writers;

    public Librarian(String name, String lastName, long id, String username, String password) {
        super(name, lastName, id, username, password);
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) add writer");
        System.out.println("2) add user");
        System.out.println("3) add publisher");
        int input = scanner.nextInt();
        switch (input)
        {
            case 1:addWriter();
            break;
            case 2: addUser();
            break;
            case 3: addPublisher();
            break;
        }
    }

    private void addPublisher() {
        System.out.println("enter the publisher info");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String[] infoCommand = info.split(" ");
        Publisher publisher = new Publisher(infoCommand[0], infoCommand[1], Long.parseLong(infoCommand[2]), infoCommand[3], infoCommand[4]);
        publishers.add(publisher);
        Library.publishers.add(publisher);
    }

    private void addUser() {
        System.out.println("enter the user info");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String[] infoCommand = info.split(" ");
        User user = new User(infoCommand[0], infoCommand[1], Long.parseLong(infoCommand[2]));
        this.users.add(user);
        Library.users.add(user);
    }

    private void addWriter()
    {
        System.out.println("enter the writer info");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String[] infoCommand = info.split(" ");
        Writer writer = new Writer(infoCommand[0], infoCommand[1], Long.parseLong(infoCommand[2]), infoCommand[3], infoCommand[4]);
        writers.add(writer);
        Library.writers.add(writer);
    }
}
