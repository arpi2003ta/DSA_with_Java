import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head = null;

    // Method to insert an element at the specified position
    public void insert(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) { // Insert at the front
            newNode.next = head;
            head = newNode;
        } else if (position == -1) { // Insert at the end
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        } else { // Insert at an intermediate position
            Node temp = head;
            int currentPos = 0;
            while (temp != null && currentPos < position - 1) {
                temp = temp.next;
                currentPos++;
            }
            if (temp == null) {
                System.out.println("Position is out of bounds.");
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    // Method to delete an element at the specified position
    public void delete(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position == 0) { // Delete from the front
            head = head.next;
        } else {
            Node temp = head;
            int currentPos = 0;
            while (temp.next != null && currentPos < position - 1) {
                temp = temp.next;
                currentPos++;
            }
            if (temp.next == null) {
                System.out.println("Position is out of bounds.");
            } else {
                temp.next = temp.next.next; // Remove the node at the specified position
            }
        }
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;

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
                    System.out.print("Enter the element to insert: ");
                    int data = scanner.nextInt();
                    list.insert(data, -1); // Insert at the end for list creation
                    System.out.println("List created with element: " + data);
                    break;

                case 2:
                    System.out.print("Enter the element to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position (0 for front, -1 for end, any other for intermediate): ");
                    int position = scanner.nextInt();
                    list.insert(data, position);
                    break;

                case 3:
                    System.out.print("Enter the position to delete (0 for front, -1 for end, any other for intermediate): ");
                    position = scanner.nextInt();
                    if (position == -1) { // Delete from the end
                        position = list.getLength() - 1;
                    }
                    list.delete(position);
                    break;

                case 4:
                    list.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method to get the length of the linked list
    public int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
