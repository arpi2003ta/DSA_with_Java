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

    // In-order traversal (Left, Root, Right)
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Binary Search Tree Operations:");

        while (true) {
            System.out.println("\n1. Insert a node");
            System.out.println("2. In-order traversal");
            System.out.println("3. Pre-order traversal");
            System.out.println("4. Post-order traversal");
            System.out.println("5. Exit");
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
                    System.out.println("In-order traversal of BST:");
                    bst.inOrderTraversal(bst.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Pre-order traversal of BST:");
                    bst.preOrderTraversal(bst.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Post-order traversal of BST:");
                    bst.postOrderTraversal(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
