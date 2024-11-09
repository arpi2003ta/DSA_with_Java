import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;

    // Method to create the list with the first node
    public void createList(int data) {
        Node newNode = new Node(data);
        head = newNode;
        newNode.next = head; // Point to itself to make it circular
    }

    // Method to insert at the front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Method to insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to insert at a specified position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtFront(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < position - 1 && current.next != head; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to delete from the front
    public void deleteFromFront() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
    }

    // Method to delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    // Method to delete from a specified position
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (position == 0) {
            deleteFromFront();
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }
        if (current.next == head) {
            System.out.println("Position out of bounds.");
        } else {
            current.next = current.next.next;
        }
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create the list");
            System.out.println("2. Insert at front");
            System.out.println("3. Insert at end");
            System.out.println("4. Insert at a given position");
            System.out.println("5. Delete from front");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete from a given position");
            System.out.println("8. Display the list");
            System.out.println("9. Exit");
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
                    System.out.print("Enter the element to insert at front: ");
                    data = scanner.nextInt();
                    list.insertAtFront(data);
                    break;
                case 3:
                    System.out.print("Enter the element to insert at end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 4:
                    System.out.print("Enter the element to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position to insert at (0 for front): ");
                    position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 5:
                    list.deleteFromFront();
                    System.out.println("Deleted element from front.");
                    break;
                case 6:
                    list.deleteFromEnd();
                    System.out.println("Deleted element from end.");
                    break;
                case 7:
                    System.out.print("Enter the position to delete from (0 for front): ");
                    position = scanner.nextInt();
                    list.deleteFromPosition(position);
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
