public class CountOfNodes {
    static class Node {
        int data; // Stores the data of the node
        Node left, right; // References to left and right child nodes

        // Constructor to initialize the node with data
        public Node(int data) {
            this.data = data; // Assign the data to the node
            this.left = null; // Initially, no left child
            this.right = null; // Initially, no right child
        }
    }
    public static int count(Node root) {
        if(root == null) {
            return 0;
        }
        
        int leftCount  = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }
    public static void main(String[] args) {
        // Constructing the binary tree manually
        Node root = new Node(1); // Create the root node with data 1
        root.left = new Node(2); // Left child of node 1
        root.right = new Node(3); // Right child of node 1
        root.left.left = new Node(4); // Left child of node 2
        root.left.right = new Node(5); // Right child of node 2
        root.right.left = new Node(6); // Left child of node 3
        root.right.right = new Node(7); // Right child of node 3

        // Calling the height method to calculate the height of the tree and printing it
        System.out.println(count(root)); // Output will be 3, as the height of the tree is 3
    }
}
