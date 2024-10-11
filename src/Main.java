import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // křestní jména všech osob,
    private  static void printAllNames(List<Person> persons){
        for( int i = 0; i < persons.size(); i++){
            System.out.printf("%d. %s %n", i+1, persons.get(i).getName());
        }
    }

    // křestní jména všech zaměstnanců (nikoli hostů),
    private  static void printEmployeesNames(List<Person> persons){
        int counter = 1;
        System.out.println("Employees names list");
        for(Person person : persons){
            if(person.getPersonType().equals(PersonType.EMPLOYEE)){
                System.out.printf("%d. %s %n", counter, person.getName());
            }
            counter++;
        }
    }
    // u křestního jména vypíše "host" nebo "zaměstnanec",
    private static void printNoEmployeesType(List <Person> persons){
        for(Person person : persons){
            if(!person.getPersonType().equals(PersonType.EMPLOYEE)) {
                System.out.printf("%-20s  %s%n", person.getName(), person.getPersonType());
            } else {
                System.out.printf("%s %n", person.getName());
            }
        }
    }


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("Jana", "Nováková", 36);
        Person p2 = new Person("Jan", "Novák", PersonType.GUEST);
        Person p3 = new Person("Petr", "Svoboda",new BigDecimal("100.00"), PersonType.OUTSIDE_EMPLOYEE);

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
//        System.out.println(persons);

        for(int i = 1; i<21; i++){
            Person person = new Person(String.valueOf(i), "guest", new BigDecimal("300.00"), PersonType.GUEST);
            persons.add(person);
        }

//        System.out.println(persons);
        System.out.println("The are "+ persons.size() + " persons in the list.");
        printAllNames(persons);
        System.out.println("-*".repeat(20));

        printEmployeesNames(persons);
        System.out.println("-*".repeat(20));
        printNoEmployeesType(persons);

        TimeClocksWorker timeClocksWorker = new TimeClocksWorker();
        timeClocksWorker.addPersonsList(persons);
        System.out.println("-*".repeat(20));

        timeClocksWorker.addOnePerson(new Person("John", "Johnson", 50));
        printAllNames(timeClocksWorker.getPersons());

        int count = timeClocksWorker.countPersons();
        System.out.println("There are " + count + " persons.");

        System.out.println("Průměrný počet tiketů: " + timeClocksWorker.avgTicketsNumber());

        System.out.println("-*".repeat(20));
        System.out.println(timeClocksWorker.getFirstPersonGreaterTicketsThan(40));
        System.out.println(timeClocksWorker.getFirstPersonGreaterTicketsThan(50));

        System.out.println("Počet hostů v seznamu: " + timeClocksWorker.countGuests()); // 21

        System.out.println("-*".repeat(20));
        System.out.println(p1);             // Jana Nováková (ID:1)
        System.out.println(p2);             // Návštěva: Jan Novák
        System.out.println(p3);             // Petr Svoboda(ID:3) OUTSIDE_EMPLOYEE

        System.out.println("-*".repeat(20));
        timeClocksWorker.addOnePerson(new Person("Honza", "Fantyš", 10));
        System.out.println(timeClocksWorker.getPersonsWithRangeTickets(9, 40));

        System.out.println("-*".repeat(20));
        timeClocksWorker.addOnePerson(new Person("Jana", "Mrackova", 2, new BigDecimal("200.00"), PersonType.EMPLOYEE, LocalDate.of(2024, 9,15)));;
        System.out.println(timeClocksWorker.getPersonsLastMonth());

        System.out.println("-*".repeat(20));
        System.out.println(timeClocksWorker.getAllWithName("Jana"));

        System.out.println("-*".repeat(20));
        timeClocksWorker.printNamesWithTickets();

        System.out.println("-*".repeat(20));
        System.out.println(timeClocksWorker.getPersonsWithMoreTickets(7));
        System.out.println("-*".repeat(20));
        timeClocksWorker.printNamesWithTickets();   // just for control, that original List hasn`t been changed (sorted)
    }
}
