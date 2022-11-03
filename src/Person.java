import java.util.ArrayList;
import java.util.Iterator;

public class Person {
    private String name;
    private String email;
    private String status;
    private ArrayList<Person> friends;

    private ArrayList<Post> posts;
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
    public void addFriend(Person friend) {
        friends.add(friend);
    }

    public Iterator<Person> getFriends() throws Exception{
        if(friends.size()==0){
            throw new Exception ("Social network empty.");
        }
        return friends.iterator();
    }

    public boolean isFriendsWith(Person person){
        return friends.contains(person);
    }

    public void addPost(Post text) {
        posts.add(text);
    }

    public Iterator<Post> getPosts() {
        return posts.iterator();
    }

}
