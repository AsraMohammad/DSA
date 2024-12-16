public class KthAncestorOfNode {

    // Class to represent a node in the binary tree
    static class Node {
        int data; // Value stored in the node
        Node left, right; // Pointers to left and right children

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Function to find the Kth ancestor of a given node.
     *
     * @param root The root of the binary tree.
     * @param n The target node's value.
     * @param k The ancestor level to find (Kth ancestor).
     * @return The distance of the target node from the root, or -1 if the node isn't found.
     */
    public static int KAncestor(Node root, int n, int k) {
        // Base case: If the root is null, return -1 (node not found).
        if (root == null) {
            return -1;
        }

        // If the current node matches the target node, return 0 (found at current level).
        if (root.data == n) {
            return 0;
        }

        // Recursively search for the node in the left and right subtrees.
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        // If the node is not found in either subtree, return -1.
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // Find the distance from the current node.
        int max = Math.max(leftDist, rightDist);

        // If the distance matches the ancestor level (k), print the ancestor.
        if (max + 1 == k) {
            System.out.println("The " + k + "th ancestor of node " + n + " is: " + root.data);
        }

        // Return the updated distance to the parent.
        return max + 1;
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

        // Target node and ancestor level to find
        int n = 5; // Target node
        int k = 2; // Kth ancestor level

        // Find the Kth ancestor of the given node
        KAncestor(root, n, k);
    }
}
