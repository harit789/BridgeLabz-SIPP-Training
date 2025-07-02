// Superclass: Person
class Person {
    String name;
    int id;

    // Constructor
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking meals in the kitchen.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Chef");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at the tables.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Waiter");
    }
}

// Main class to test the system
public class RestaurantSystemTest {
    public static void main(String[] args) {
        Chef chef = new Chef("Raj", 101);
        Waiter waiter = new Waiter("Anita", 202);

        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
