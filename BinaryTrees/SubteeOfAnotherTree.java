//import org.w3c.dom.Node;

public class SubteeOfAnotherTree {// Node class represents a single node in the binary tree
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
    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
            
        } else if(node == null || subRoot == null   || node.data != subRoot.data) {
            return false;
        }
    
    if(!isIdentical(node.left, subRoot.left)) {
        return false;
    }
    if(!isIdentical(node.right, subRoot.right)) {
        return false;
    }
    return true;
}
    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }
        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);

        return leftAns || rightAns;
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

        Node subRoot = new Node(2); // Create the root node with data 1
        subRoot.left = new Node(4); // Left child of node 1
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
        // Calling the height method to calculate the height of the tree and printing it
        //System.out.println(diameter(root).diam); // Output will be 3, as the height of the tree is 3
    }
}
