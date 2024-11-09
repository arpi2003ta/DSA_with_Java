import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Insert a new key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the unchanged root pointer
        return root;
    }

    // Function to search for a given key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search a key in BST
    boolean searchRec(Node root, int key) {
        // Base cases: root is null or key is present at root
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        // Key is greater than root's key
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // Key is smaller than root's key
        return searchRec(root.right, key);
    }

    // Function to perform in-order traversal
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Binary Search Tree Operations:");
        
        while (true) {
            System.out.println("\n1. Insert a node");
            System.out.println("2. Search for a node");
            System.out.println("3. Display in-order traversal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    bst.insert(valueToInsert);
                    System.out.println("Inserted " + valueToInsert + " into the BST.");
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    int valueToSearch = scanner.nextInt();
                    boolean found = bst.search(valueToSearch);
                    if (found) {
                        System.out.println(valueToSearch + " is present in the BST.");
                    } else {
                        System.out.println(valueToSearch + " is not present in the BST.");
                    }
                    break;
                case 3:
                    System.out.println("In-order traversal of BST:");
                    bst.inOrderTraversal(bst.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
