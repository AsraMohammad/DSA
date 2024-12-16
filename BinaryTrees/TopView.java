import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Class to store a node along with its horizontal distance (hd)
    static class Info {
        Node node;
        int hd;

        // Constructor to initialize Info
        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Method to compute and print the top view of a binary tree
    public static void topView(Node root) {
        if (root == null) {
            return; // No tree to traverse
        }

        // Queue for level-order traversal
        Queue<Info> q = new LinkedList<>();
        // Map to store the first node encountered at each horizontal distance
        HashMap<Integer, Node> map = new HashMap<>();

        // Variables to track the minimum and maximum horizontal distances
        int min = 0, max = 0;

        // Start traversal with the root node at hd = 0
        q.add(new Info(root, 0));

        // Perform level-order traversal
        while (!q.isEmpty()) {
            Info curr = q.remove(); // Get the current node and its hd

            // If this hd is not already in the map, add it
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node); // Add the node to the top view
            }

            // Add the left child with hd - 1
            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1); // Update minimum hd
            }

            // Add the right child with hd + 1
            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1); // Update maximum hd
            }
        }

        // Print the top view nodes from min to max horizontal distance
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println(); // Print a newline after the output
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

        // Call the topView method to print the top view of the binary tree
        System.out.println("Top view of the binary tree:");
        topView(root);
    }
}
