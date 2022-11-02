import java.util.ArrayList;
import java.util.Iterator;

public class SocialNetwork {
    private ArrayList<Person> people;

    public SocialNetwork() {
        people=new ArrayList<Person>();
    }
    public void addPerson(String name, String email, String status) throws Exception{
        Person person = new Person(name, email, status);

        for(Person element : people) {
            if (element.getName().equals(name.trim())) {
                throw new Exception("Person already exists.");
            }
        }

        people.add(person);
    }

    public Person getPersonByName(String name){
        for(Person element : people) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public void isPersonRegistered(String name) throws Exception{
        Person Person = getPersonByName(name);
        if (Person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            throw new Exception("Person is already registered.");
        }
    }

    public Iterator<Person> getRegisteredPeople() throws Exception{
        if(people.size()==0){
            throw new Exception ("Social network empty.");
        }
        return people.iterator();
    }

    public String checkStatus(String name) throws Exception{
        Person Person = getPersonByName(name);
        if (Person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            return Person.getStatus();
        }
    }

    public void updateStatus(String name, String newStatus) throws Exception {
        Person Person = getPersonByName(name);
        if (Person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            Person.setStatus(newStatus);
        }
    }

    /*public Iterator<Person> getpeople() throws Exception{
        if(people.size()==0){
            throw new Exception ("Person book empty.");
        }
        return people.iterator();
    }

    public void removePerson(String name) throws Exception{
        Person Person = getPersonByName(name);
        if (Person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            people.remove(Person);
            throw new Exception("Person removed.");
        }
    }

    public int getPhone(String name) throws Exception{
        Person Person = getPersonByName(name);
        if (Person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            return Person.getPhoneNumber();
        }
    }


    public String lookNameByPhone(int phoneNumber) throws Exception{
        for(Person element : people) {
            if (element.getPhoneNumber()==phoneNumber) {
                return element.getName();
            }
        }
        throw new Exception("Phone number does not exist.");
    }


    public void updateEmail(String name, String newEmail) throws Exception{
        Person Person = getPersonByName(name);
        if (Person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            Person.updateEmail(newEmail);
        }
    }

    public boolean equalPhoneNumbers() throws Exception{
        for (int i = 0; i < people.size(); i++) {
            for (int j = i + 1 ; j < people.size(); j++) {
                if (people.get(i).getPhoneNumber() == people.get(j).getPhoneNumber()) {
                    return true;
                }
            }
        }
        return false;
    }*/
    
}
