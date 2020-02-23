package menu;

import dataStructure.MyLinkedList;
import node.Node;
import person.Person;

import java.util.Scanner;

public class Menu {
    private MyLinkedList<Person> linkedList;
    private Scanner scan;

    public Menu() {
        scan = new Scanner(System.in);
        linkedList = new MyLinkedList<>();
    }

    public int showChoice() {
        System.out.println("Welcome to Shashank's Contact List App\n" +
                "Press 1 to add a new contact\n" +
                "Press 2 to view all contacts\n" +
                "Press 3 to search for a contact\n" +
                "Press 4 to delete a contact\n" +
                "Press 5 to exit program");
        return scan.nextInt();
    }

    public void addChoice() {
        Person person = new Person();
        String name;
        System.out.println("You have chosen to add a new contact: \n" +
                "Please enter the name of the Person\n");
        scan.nextLine();

        System.out.print("First Name: ");
        name = scan.nextLine().trim();
        person.setFirstName(name);

        System.out.print("Last Name: ");
        name = scan.nextLine().trim();
        person.setLastName(name);

        String number;
        System.out.print("Contact Number: ");
        number = scan.nextLine().trim();
        person.setPhoneNumber(number);

        char c;
        System.out.print("Would you like to add another contact number? (y/n): ");
        c = scan.nextLine().trim().charAt(0);
        while (c == 'y') {
            System.out.print("Contact Number: ");
            number = scan.nextLine().trim();
            person.setPhoneNumber(number);
            System.out.print("Would you like to add another contact number? (y/n): ");
            c = scan.nextLine().trim().charAt(0);
        }

        String email = null;
        System.out.print("Would you like to add email address? (y/n): ");
        c = scan.nextLine().trim().charAt(0);
        if (c == 'y') {
            System.out.print("Email Address: ");
            email = scan.nextLine().trim();
            person.setEmailID(email);
        } else {
            person.setEmailID("");
        }

        Node<Person> node = new Node<Person>();
        node.setData(person);
        linkedList.insert(node);
    }

    private void sortList(MyLinkedList<Person> linkedList) {
        linkedList.sort();
    }

    public void viewChoice() {
        sortList(linkedList);
        while (true) {
            Node<Person> node = linkedList.getObject();
            if (node == null)
                break;
            System.out.println(node.getData());
        }
    }

    public void searchChoice() {
        int counter = 0;
        System.out.print("You could search for a contact from their first names: ");
        scan.nextLine();
        String name = scan.nextLine().trim();

        while (true) {
            Node<Person> node = linkedList.getObject();
            if (node == null)
                break;
            if (node.getData().getFirstName().compareTo(name) == 0)
                counter++;
        }

        System.out.println(counter + " match found!");
        while (true) {
            Node<Person> node = linkedList.getObject();
            if (node == null)
                break;
            if (node.getData().getFirstName().compareTo(name) == 0)
                System.out.println(node.getData());
        }
    }

    public void deleteChoice() {
        System.out.println("Here are all your contacts: ");
        int i = 1;
        while (true) {
            Node<Person> node = linkedList.getObject();
            if (node == null)
                break;
            System.out.println(i + ". " + node.getData().getFirstName() + " " + node.getData().getLastName());
            i++;
        }
        System.out.print("Press the number against the contact to delete it: ");
        int position = scan.nextInt();
        Person person = linkedList.delete(position).getData();

        System.out.println(person.getFirstName() + " " + person.getLastName() + "'s contact deleted from list!");
    }

    public void exitChange() {
        System.out.println("Exiting.");
    }
}