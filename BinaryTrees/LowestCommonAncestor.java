import java.util.ArrayList;

public class LowestCommonAncestor {
    // Class to represent a Node in the Binary Tree
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
     * Finds the path from the root node to the given node (n) and stores it in the path list.
     * 
     * @param root The current root node being explored.
     * @param n The value of the node we're looking for.
     * @param path The list that stores the path from the root to the target node.
     * @return True if the target node is found, false otherwise.
     */
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) { // If the current node is null, return false
            return false;
        }

        // Add the current node to the path
        path.add(root);

        // Check if the current node is the target node
        if (root.data == n) {
            return true;
        }

        // Recursively search for the target node in the left or right subtree
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // If the target node is found in either subtree, return true
        if (foundLeft || foundRight) {
            return true;
        }

        // If the target node is not found, remove the current node from the path
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a binary tree.
     * 
     * @param root The root of the binary tree.
     * @param n1 The value of the first node.
     * @param n2 The value of the second node.
     * @return The LCA node.
     */
    public static Node lca(Node root, int n1, int n2) {
        // Lists to store the paths to n1 and n2
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Find the paths to n1 and n2 from the root
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Compare the paths to find the last common node
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) { // Paths diverge here
                break;
            }
        }

        // Return the last common node in the paths
        Node lca = path1.get(i - 1);
        return lca;
    }

    
// Approch 2
    public static Node lca2(Node root, int n1, int n2) {

        // Base case: If the current node is null, or matches either n1 or n2, return it.
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
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        // If neither subtree contains n1 or n2, return null.
        return root;
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

        // Nodes for which we want to find the LCA
        int n1 = 4, n2 = 7;

        // Find and print the LCA of n1 and n2
        System.out.println("The LCA of " + n1 + " and " + n2 + " is: " + lca2(root, n1, n2).data);
    }
}
