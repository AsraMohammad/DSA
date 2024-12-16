public class TransformOfSumTree {
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

    public static int transform(Node root) {
        if(root == null) {
            return 0 ;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
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

        transform(root);
        preorder(root);
    }
}
