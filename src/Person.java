public abstract class Person
{
    private final String name;
    private final String lastName;
    private final long id;
    protected int testId;//todo

    public Person(String name, String lastName, long id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.testId = -1;//todo
    }



    public abstract void start();
}
