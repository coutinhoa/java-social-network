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
        Person person = getPersonByName(name);
        if (person == null) {
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
        Person person = getPersonByName(name);
        if (person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            return person.getStatus();
        }
    }

    public void updateStatus(String name, String newStatus) throws Exception {
        Person person = getPersonByName(name);
        if (person == null) {
            throw new Exception("Person doesn't exist.");
        } else {
            person.setStatus(newStatus);
        }
    }


    public boolean makeFriendship(String nameOne, String nameTwo) throws Exception {
        Person personOne = getPersonByName(nameOne);
        Person personTwo = getPersonByName(nameTwo);
        if(nameOne==null || nameTwo==null){
            throw new Exception("Person doesn't exist.");
        } else if(nameOne==nameTwo){
            throw new Exception("Invalid Friendship.");
        } else if(personOne.isFriendsWith(personTwo) || personTwo.isFriendsWith(personOne)){
            throw new Exception("Friendship already exists.");
        }else {
            personOne.addFriend(personTwo);
            personTwo.addFriend(personOne);
            return true;}
    }

    public Iterator<Person> getUserFriends(String name) throws Exception {
        Person person = getPersonByName(name);
        if (person == null) {
            throw new Exception("Person doesn't exist.");
        } else if (!person.getFriends().hasNext()){
            throw new Exception("Person doesn't have friends yet.");
        }
        return person.getFriends();
    }


    public void doesFriendshipExist(String nameOne, String nameTwo) throws Exception {
        Person personOne = getPersonByName(nameOne);
        Person personTwo = getPersonByName(nameTwo);
        if (personOne.isFriendsWith(personTwo) || personTwo.isFriendsWith(personOne)) {
            throw new Exception("Users are friends.");
        } else {
            throw new Exception("Friendship doesn't exist.");
        }
    }
}
