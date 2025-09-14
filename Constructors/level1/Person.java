public class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "";
        this.age = 0;
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getters and Setters (optional)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // To string for easy display
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
