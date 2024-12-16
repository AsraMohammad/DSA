public class KthLevel {
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
    public static void KLevel(Node root, int level, int K) {
        if(root == null) {
            return;
        }
        if(level == K) {
            System.out.println(root.data+" ");
            return;
        }
        KLevel(root.left, level+1, K);
        KLevel(root.right, level+1, K);
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
        int  K = 2;
        KLevel(root, 1, K);

    }
}
