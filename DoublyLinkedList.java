import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private Node head;

    // Method to create the list with the first node
    public void createList(int data) {
        head = new Node(data);
    }

    // Method to insert an element at a given position
    public void insert(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) { // Insert at the front
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }

        if (position == -1) { // Insert at the end
            Node current = head;
            if (current == null) {
                head = newNode;
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.prev = current;
            }
            return;
        }

        // Insert at an intermediate position
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position is out of bounds.");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }

    // Method to delete an element at a given position
    public void delete(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position == 0) { // Delete from the front
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        if (position == -1) { // Delete from the end
            Node current = head;
            if (current.next == null) { // If there's only one element
                head = null;
                return;
            }
            while (current.next != null) {
                current = current.next;
            }
            current.prev.next = null;
            return;
        }

        // Delete from an intermediate position
        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position is out of bounds.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create the list");
            System.out.println("2. Insert an element");
            System.out.println("3. Delete an element");
            System.out.println("4. Display the list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the first element: ");
                    data = scanner.nextInt();
                    list.createList(data);
                    System.out.println("List created with first element: " + data);
                    break;
                case 2:
                    System.out.print("Enter the element to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position (0 for front, -1 for end, any other for intermediate): ");
                    position = scanner.nextInt();
                    list.insert(data, position);
                    break;
                case 3:
                    System.out.print("Enter the position to delete (0 for front, -1 for end, any other for intermediate): ");
                    position = scanner.nextInt();
                    list.delete(position);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
