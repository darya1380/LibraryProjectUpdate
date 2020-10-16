public abstract class SpecialPerson extends Person
{
    private final String username;
    private final String password;
    public SpecialPerson(String name, String lastName, long id, String username, String password) {
        super(name, lastName, id);
        this.username = username;
        this.password = password;
    }
}
