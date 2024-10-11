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

    public Person(String name, String surname, int tickets, BigDecimal account, PersonType personType, LocalDate lastArrival) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.tickets = tickets;
        this.account = account;
        this.personType = personType;
        this.lastArrival = lastArrival;
        this.bodyTemperature = -300;
    }

    public Person(String name, String surname, int tickets, BigDecimal account, PersonType personType) {
        this(name, surname, tickets, account, personType, LocalDate.now());
    }

    /**
    * Constructor creates a Person object with the specified first name, last name, and number of tickets.
     * The remaining parameters are automatically initialized: <br>
     * <ul>
     *     <li><b>account:</b> 0.00</li>
     *     <li><b>personType:</b> EMPLOYEE</li>
     *     <li><b>lastArrival:</b> current date</li>
     *     <li><b>bodyTemperature:</b> -300 (not installed)</li>
     * </ul>
     * @param name
     * @param surname
     * @param tickets number of tickets
     */
    public Person(String name, String surname, int tickets ){
        this(name, surname, tickets, new BigDecimal("0.00"), PersonType.EMPLOYEE);
    }

    //Constructor for another type of persons (not Employee)
    public Person(String name, String surname, PersonType personType){
        this(name, surname, 0, new BigDecimal("0.00"), personType);
    }

    //Constructor with account
    public Person(String name, String surname,BigDecimal account, PersonType personType){
        this(name, surname, 0, account, personType);
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
        if(personType.equals(PersonType.EMPLOYEE)) {
            return name + " " + surname + " (ID:" + id + ")";
        } else if(personType.equals(PersonType.OUTSIDE_EMPLOYEE)){
            return name + " " + surname + "(ID:" + id + ") " + personType;
        } else{
            return "Návštěva: " + name + " " + surname;
        }
    }
}
