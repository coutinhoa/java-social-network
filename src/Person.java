import java.util.ArrayList;

public class Person {
    private String name;
    private String email;
    private String status;

    private ArrayList<Person> friends;
    public Person(String name, String email, String status) {
        this.name = name;
        this.email= email;
        this.status = status;
        this.friends = new ArrayList<>();
    }
    public String getName() {return name;}
    public String getEmail() {
        return email;
    }
    public String getStatus() {return status;}

    public void setStatus(String status) {this.status= status;}
}
