import java.math.BigDecimal;
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
        Person p1 = new Person("Jana", "Nováková", 0);
        Person p2 = new Person("Jan", "Novák", PersonType.GUEST);
        Person p3 = new Person("Petr", "Svoboda", PersonType.OUTSIDE_EMPLOYEE, new BigDecimal("100.00"));

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
//        System.out.println(persons);

        for(int i = 1; i<21; i++){
            Person person = new Person(String.valueOf(i), "guest", PersonType.GUEST, new BigDecimal("300.00"));
            persons.add(person);
        }

//        System.out.println(persons);
        System.out.println("The are "+ persons.size() + " persons in the list.");
        printAllNames(persons);
        System.out.println("-*".repeat(20));

        printEmployeesNames(persons);
        System.out.println("-*".repeat(20));
        printNoEmployeesType(persons);
    }
}
