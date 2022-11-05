import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SocialNetwork network= new SocialNetwork();

        while(true) {
            String command = scanner.nextLine();

            if(command.equals("Logout")) {
                System.out.println("Goodbye!");
                scanner.close();
                return;
            } else if (command.equals("Register")) {
                String name = scanner.nextLine();
                String email = scanner.nextLine();
                String status = scanner.nextLine();
                try{
                    network.addPerson(name, email, status);
                    System.out.println("Added a person successfully.");}
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equals("Check person")) {
                String name = scanner.nextLine();
                try {
                    network.isPersonRegistered(name);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if (command.equals("People")) {
                try {
                    Iterator<Person> iterator = network.getRegisteredPeople();
                    while (iterator.hasNext()) {
                        Person current = iterator.next();
                        System.out.println(current.getName() + ";" + current.getEmail());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("Check status")){
                String name = scanner.nextLine();
                try {
                    System.out.println(network.checkStatus(name));
                } catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("Update status")){
                String name = scanner.nextLine();
                String newStatus = scanner.nextLine();
                try {
                    network.updateStatus(name, newStatus);
                    System.out.print("Status Updated.");}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("Make friends")){
                String nameOne = scanner.nextLine();
                String nameTwo = scanner.nextLine();
                try {
                    if(network.makeFriendship(nameOne, nameTwo)==true){
                    System.out.println("Friendship established.");}}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            } else if(command.equals("User friends")){
                String name = scanner.nextLine();
                try {
                    Iterator<Person> iterator = network.getUserFriends(name);
                    System.out.println("List of friends: ");
                    while (iterator.hasNext()) {
                        Person current = iterator.next();
                        System.out.println( current.getName());
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("Check friendship")){
                String nameOne = scanner.nextLine();
                String nameTwo = scanner.nextLine();
                try {
                    network.doesFriendshipExist(nameOne, nameTwo);}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            } else if(command.equals("Add post")){
                String nameOne = scanner.nextLine();
                String post = scanner.nextLine();
                try {
                    network.addPostToTheWall(nameOne, post);}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }  else if(command.equals("Post friends")){
                String nameOne = scanner.nextLine();
                String post = scanner.nextLine();
                String friendName = scanner.nextLine();
                try {
                    network.addPostToFriendsWall(nameOne, post, friendName);}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }   else if(command.equals("Friends wall")){
                String nameOne = scanner.nextLine();
                String friendName = scanner.nextLine();
                try {
                    Iterator<Post> iterator = network.getFriendsPosts(nameOne, friendName);
                    System.out.println(friendName + "'s wall:");
                    while (iterator.hasNext()) {
                        Post current = iterator.next();
                        System.out.println(current.getAuthor() + ": " +current.getText());
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }
        }
    }
}