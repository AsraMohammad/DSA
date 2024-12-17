import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree { // Main class to represent the Binary Tree
    // Static inner class representing a single node of the tree
    static class Node {
        int data; // Data stored in the node
        Node left; // Reference to the left child node
        Node right; // Reference to the right child node
        
        // Constructor to initialize a node with a value
        Node(int data) {
            this.data = data; // Assign the data to the node
            this.left = null; // Initially, no left child
            this.right = null; // Initially, no right child
        }
    }

    // Static inner class that provides functionality to build and manipulate the binary tree
    static class Binarytree {
        static int idx = -1; // Index to track the position in the input array

        // Method to build the binary tree from an array of integers
        public static Node buildTree(int nodes[]) {
            idx++; // Move to the next index in the array
            // Base case: if the value at the current index is -1, it represents a null node
            if (nodes[idx] == -1) {
                return null; // Return null to indicate no node here
            }

            // Create a new node with the current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build the left subtree
            newNode.left = buildTree(nodes);
            // Recursively build the right subtree
            newNode.right = buildTree(nodes);

            // Return the created node
            return newNode;
        }
        // Preorder traversal: root → left → right
        public static void preorder(Node root) {
            if (root == null) { // Base case: if the current node is null
                return;
            }
            System.out.println(root.data + " "); // Print the value of the current node
            preorder(root.left); // Recursively traverse the left subtree
            preorder(root.right); // Recursively traverse the right subtree
        }
        public static void inorder(Node root) {
            if (root == null) { // Base case: if the current node is null
                return;         // Stop recursion and return to the previous call
            }
        
            inorder(root.left); // Recursively traverse the left subtree
            System.out.println(root.data + " "); // Print the value of the current node
            inorder(root.right); // Recursively traverse the right subtree
        }
        public static void postorder(Node root) {
            if (root == null) { // Base case: if the current node is null, return (no action needed)
                return;
            }
            postorder(root.left); // Recursively traverse the left subtree
            postorder(root.right); // Recursively traverse the right subtree
            System.out.println(root.data + " "); // Print the data of the current node after traversing both subtrees
        }
        //Level Order Traversal----> BFS 
        public static void levelOrder(Node root) {
            if (root == null) { // If the tree is empty, return immediately
                return;
            }
            
            Queue<Node> q = new LinkedList<>(); // Create a queue to help with level order traversal
            q.add(root); // Add the root node to the queue
            q.add(null); // Add a null marker to indicate the end of the current level
        
            while (!q.isEmpty()) { // Continue until the queue is empty
                Node currNode = q.remove(); // Remove a node from the queue
                
                if (currNode == null) { // Check if we've reached the end of a level
                    System.out.println(); // Print a newline to move to the next level
                    
                    if (q.isEmpty()) { // If the queue is empty, all levels are processed
                        break;
                    } else {
                        q.add(null); // Add a new null marker for the next level
                    }
                } else {
                    System.out.print(currNode.data + " "); // Print the current node's data
                    
                    if (currNode.left != null) { // If there's a left child, add it to the queue
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) { // If there's a right child, add it to the queue
                        q.add(currNode.right);
                    }
                }
            }
        }
        
    }
    

    // Main method: Entry point of the program
    public static void main(String[] args) {
        // Input array representing the tree structure in preorder traversal
        // {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Binarytree.idx = -1;
        //Binarytree tree = new Binarytree(); // Create an instance of the BinaryTree class
        Node root = Binarytree.buildTree(nodes); // Build the binary tree and get its root node
        // Perform preorder traversal and print the result
        System.out.println("Preorder traversal of the tree:");
        Binarytree.preorder(root); //output 124536
        System.out.println("Inorder traversal of the tree:");
        Binarytree.inorder(root); // Call the inorder method to print the traversal
        // Perform postorder traversal and print the result
        System.out.println("\nPostorder traversal of the tree:");
        Binarytree.postorder(root); // Output: 4 5 2 6 3 1
        // Perform level order traversal and print the result
        System.out.println("Level order traversal of the tree:");
        Binarytree.levelOrder(root); // Output: 1 2 3 4 5 6
        //System.out.println(root.data); //  
    } //output = 1
}
