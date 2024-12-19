public class BinarySearchTree {
    // Definition of a Node in the Binary Search Tree
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

    // Method to search for a value in the BST
    public static boolean search(Node root, int key) {
        if(root == null) { // If the root is null, return false
            return false;
        }
        if(root.data == key) { // If the key is found, return true
            return true;
        }
        if(root.data > key) { // If the key is smaller, search in the left subtree
            return search(root.left, key);
        } else { // If the key is larger, search in the right subtree
            return search(root.right, key);
        }
    }

    // Method to delete a value from the BST
    public static Node delete(Node root, int val) {
        if(root.data < val ) { // If the value is greater, delete from the right subtree
            root.right = delete(root.right, val);
        } else if(root.data > val) { // If the value is smaller, delete from the left subtree
            root.left = delete(root.left, val);
        } else { // If the value is found
            // Case 1: Node has no children (leaf node)
            if(root.left == null && root.right == null) {
                return null; // Remove the node
            }
            // Case 2: Node has one child (either left or right)
            if(root.left == null) {
                return root.right; // Return the right child
            } else if(root.right == null) {
                return root.left; // Return the left child
            }
            // Case 3: Node has two children
            Node IS = findInorderSuccessor(root.right); // Find the inorder successor
            root.data = IS.data; // Replace node's data with the inorder successor's data
            root.right = delete(root.right, IS.data); // Delete the inorder successor
        }
        return root; // Return the updated root
    }

    // Method to find the inorder successor (leftmost node in the right subtree)
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) { // Traverse the left subtree until a null pointer is found
            root = root.left;
        }
        return root; // Return the leftmost node
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14}; // Array of values to insert
        Node root = null; // Initialize the tree as empty

        // Insert each value into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Uncomment to test the search function
        // if(search(root, 1)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }

        // Perform an inorder traversal to display the sorted values
        inorder(root);
        System.out.println(); // Print a newline after traversal
        
        // Delete a node (10 in this case) and print the updated inorder traversal
        root = delete(root , 10);
        System.out.println();

        inorder(root); // Perform inorder traversal after deletion
    }
}
