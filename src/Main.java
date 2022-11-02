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
            }/*else if(command.equals("Check friendship")){
                String nameRemoved = scanner.nextLine();
                try {
                    network.removeContact(nameRemoved);}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("Friends")){
                String name = scanner.nextLine();
                try {
                    System.out.print(network.getPhone((name)));}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("Check friends")){
                String name = scanner.nextLine();
                try {
                    System.out.print(network.getMail((name)));}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }*/
        }
    }
}