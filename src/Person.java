import java.math.BigDecimal;
import java.time.LocalDate;

public class Person {
    private static int nextId = 1;
    private int id;
    private String name;
    private String surname;
    private BigDecimal account;
    private PersonType personType;
    private int tickets;
    private LocalDate lastArrival;
    private double bodyTemperature;

    // Constructor for Employee
    public Person(String name, String surname, int tickets ){
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.tickets = tickets;
        this.account = new BigDecimal("0.00");
        this.personType = PersonType.EMPLOYEE;
        this.lastArrival = LocalDate.now();
        this.bodyTemperature = -300;
    }


    //Constructor for another type of persons (not Employee)
    public Person(String name, String surname, PersonType personType){
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.tickets = 0;
        this.account = new BigDecimal("0.00");
        this.personType = personType;
        this.lastArrival = LocalDate.now();
        this.bodyTemperature = -300;
    }

    //Constructor for another type of persons (not Employee)
    public Person(String name, String surname, PersonType personType, BigDecimal account){
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.tickets = 0;
        this.account = account;
        this.personType = personType;
        this.lastArrival = LocalDate.now();
        this.bodyTemperature = -300;
    }
    // Getters
    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public int getTickets() {
        return tickets;
    }

    public LocalDate getLastArrival() {
        return lastArrival;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", account=" + account +
                ", personType=" + personType +
                ", tickets=" + tickets +
                ", lastArrival=" + lastArrival +
                ", bodyTemperature=" + bodyTemperature +
                '}';
    }
}
