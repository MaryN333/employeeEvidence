import java.util.ArrayList;
import java.util.List;

public class TimeClocksWorker {
    private List<Person> persons = new ArrayList<>();

    public TimeClocksWorker() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addOnePerson(Person person){
        persons.add(person);
    }

    public void addPersonsList(List<Person> someList){
        persons.addAll(someList);
    }
    public int countPersons(){
        return getPersons().size();
    }

    public double avgTicketsNumber(){
        if(persons.isEmpty()){
            return 0;
        }
        int totalTickets = 0;
        for(Person person : persons){
            totalTickets += person.getTickets();
        }
//        return (double) totalTickets / persons.size();
        return totalTickets / persons.size();
    }

    //Připrav metodu, která najde první osobu s počtem ticketů vyšším než zadaný parametr.
    public Person findFirstPersonGreaterTicketsThan(int tickets){
        for(Person person : persons){
            if(person.getTickets()> tickets){
                return person;
            }
        }
        System.out.println("There is no any person, which has more than " + tickets + " tickets");
        return null;
    }

    // Připrav metodu, která spočítá počet hostů v seznamu (zaměstnance nepočítá)
    public int countGuests(){
        int totalGuests = 0;
        for(Person person : persons){
            if(person.getPersonType().equals(PersonType.GUEST)){
                totalGuests += 1;
            }
        }
        return totalGuests;
    }



}
