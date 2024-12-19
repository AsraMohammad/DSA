public class PrintInRange {
    static class Node {
        int data; // Value of the node
        Node left; // Pointer to the left subtree
        Node right; // Pointer to the right subtree

        // Constructor to initialize a node with a given value
        Node(int data) {
            this.data = data;
        }
    }

    // Method to insert a value into the BST
    public static Node insert(Node root, int val) {
        if (root == null) { // If the tree is empty, create a new node
            root = new Node(val);
            return root;
        }
        if (root.data > val) { // If the value is smaller, go to the left subtree
            root.left = insert(root.left, val);
        } else { // If the value is larger, go to the right subtree
            root.right = insert(root.right, val);
        }
        return root; // Return the updated root
    }

    // Method to perform inorder traversal (Left, Root, Right)
    public static void inorder(Node root) {
        if (root == null) { // Base case: if the node is null, return
            return;
        }
        inorder(root.left); // Traverse the left subtree
        System.out.print(root.data + " "); // Visit the root
        inorder(root.right); // Traverse the right subtree
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14}; // Array of values to insert
        Node root = null; // Initialize the tree as empty

        // Insert each value into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        // if(search(root, 1)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }


        // Perform an inorder traversal to display the sorted values
        inorder(root);
        System.out.println(); // Print a newline after traversal
        
        printInRange(root, 5, 12);
    }
}
