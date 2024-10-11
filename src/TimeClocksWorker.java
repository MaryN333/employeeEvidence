import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
    public Person getFirstPersonGreaterTicketsThan(int tickets){
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

    // Připrav metodu, která vrátí osoby s počtem ticketů v zadaném rozmezí, které jsou dnes v práci
    public List<Person> getPersonsWithRangeTickets(int min, int max){
        List <Person> newList = new ArrayList<>();
        for(Person person : persons){
            if(person.getTickets()>= min &&
                    person.getTickets() <= max &&
                    person.getLastArrival().equals(LocalDate.now())){
                newList.add(person);
            }
        }
        return newList;
    }

    // Připrav metodu pro výpis osob, které přišly do firmy naposledy minulý měsíc.
    public List<Person> getPersonsLastMonth(){
        List <Person> newList = new ArrayList<>();
        LocalDate nowDate = LocalDate.now();
        int lastMonth = nowDate.getMonthValue() - 1;
        int year = nowDate.getYear();
        if(lastMonth == 0){
            lastMonth = 12;
            year -=1;
        }

        for(Person person : persons){
            if(person.getLastArrival().getMonthValue() == lastMonth && person.getLastArrival().getYear() == year){
                newList.add(person);
            }
        }
        return newList;
    }

    // Připrav metodu, která vrátí seznam všech osob, které mají zadané křestní jméno
    public List<Person> getAllWithName(String name){
        List<Person> newList = new ArrayList<>();
        for(Person person : persons){
            if(person.getName().trim().equalsIgnoreCase(name)){
                newList.add(person);
            }
        }
        return newList;
    }

    public void printNamesWithTickets(){
        for(Person person :persons){
            int tickets = person.getTickets();
            if(tickets > 30){
                System.out.println(person.getName() + " " + person.getSurname() + " (zkušený zlepšovatel)");
            } else if(tickets == 12) {
                System.out.println(person.getName() + " " + person.getSurname() + " (první tucet ticketů)");
            } else if(tickets == 1) {
            System.out.println(person.getName() + " " + person.getSurname() + " (první ticket)");
            } else if(tickets == 0) {
                System.out.println(person.getName() + " " + person.getSurname() + " (bez ticketů)");
            } else {
                System.out.println(person.getName() + " " + person.getSurname() + " " + tickets + " ticketů");
            }
        }
    }
    // Připrav metodu, která vrátí zadaný počet osob s největším počtem ticketů.
    // Jako parametr dostane počet osob, které má vrátit.
    public List<Person> getPersonsWithMoreTickets(int persons){
        List<Person> sortedPersons = new ArrayList<>(getPersons());
        sortedPersons.sort(Comparator.comparingInt(Person::getTickets).reversed());
        return sortedPersons.subList(0, Math.min(persons, sortedPersons.size()));
    }

}
