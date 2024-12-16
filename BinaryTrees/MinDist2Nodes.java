public class MinDist2Nodes {

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
     * Function to find the Lowest Common Ancestor (LCA) of two nodes.
     *
     * @param root The current root of the subtree.
     * @param n1 The first node's value.
     * @param n2 The second node's value.
     * @return The LCA node if found, otherwise null.
     */
    public static Node lca2(Node root, int n1, int n2) {

        // Base case: If the current node is null or matches either n1 or n2, return it.
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively search for n1 and n2 in the left and right subtrees.
        Node leftLca = lca2(root.left, n1, n2);  // LCA in the left subtree
        Node rightLca = lca2(root.right, n1, n2); // LCA in the right subtree

        // If n1 and n2 are found in different subtrees, the current node is their LCA.
        if (leftLca != null && rightLca != null) {
            return root;
        }

        // If only one subtree contains either n1 or n2, return that subtree's result.
        return (leftLca != null) ? leftLca : rightLca;
    }

    /**
     * Function to calculate the distance between the given root and a target node.
     *
     * @param root The current root of the subtree.
     * @param n The target node's value.
     * @return The distance from the root to the target node, or -1 if the node isn't found.
     */
    public static int lcaDist(Node root, int n) {

        // Base case: If the root is null, the node is not found.
        if (root == null) {
            return -1;
        }

        // If the current node matches the target, the distance is 0.
        if (root.data == n) {
            return 0;
        }

        // Recursively calculate the distance in the left and right subtrees.
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        // If the target is not found in both subtrees, return -1.
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // If the target is found in one subtree, return the distance incremented by 1.
        return (leftDist == -1) ? rightDist + 1 : leftDist + 1;
    }

    /**
     * Function to calculate the minimum distance between two nodes in the binary tree.
     *
     * @param root The root of the binary tree.
     * @param n1 The first node's value.
     * @param n2 The second node's value.
     * @return The minimum distance between n1 and n2.
     */
    public static int minDist(Node root, int n1, int n2) {

        // Step 1: Find the Lowest Common Ancestor (LCA) of n1 and n2.
        Node lca = lca2(root, n1, n2);

        // Step 2: Calculate the distance from the LCA to n1 and n2.
        int dist1 = lcaDist(lca, n1); // Distance from LCA to n1
        int dist2 = lcaDist(lca, n2); // Distance from LCA to n2

        // Step 3: Return the total distance (dist1 + dist2).
        return dist1 + dist2;
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

        // Nodes for which we want to find the minimum distance
        int n1 = 4, n2 = 5;

        // Find and print the minimum distance between n1 and n2
        System.out.println("The minimum distance of " + n1 + " and " + n2 + " is: " + minDist(root, n1, n2));
    }
}
