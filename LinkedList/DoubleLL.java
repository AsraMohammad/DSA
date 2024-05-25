public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public DoubleLL() {
        DoubleLL.size = 0;
    }

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (DoubleLL.head == null) {
            DoubleLL.head = DoubleLL.tail = newNode;
        } else {
            newNode.next = DoubleLL.head;
            DoubleLL.head.prev = newNode;
            DoubleLL.head = newNode;
        }
        DoubleLL.size++;
    }

    // Print the list
    public void print() {
        Node temp = DoubleLL.head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove the first node
    public int removeFirst() {
        if (DoubleLL.head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        int val = DoubleLL.head.data;
        if (DoubleLL.size == 1) {
            DoubleLL.head = DoubleLL.tail = null;
        } else {
            DoubleLL.head = DoubleLL.head.next;
            DoubleLL.head.prev = null;
        }
        DoubleLL.size--;
        return val;
    }
    //reverse the DLL
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.print();
        dll.reverse();
        dll.print();
       // System.out.println("Size: " + DoubleLL.size);  // Print size
        //dll.removeFirst();
        //dll.print();
        //System.out.println("Size: " + DoubleLL.size);  // Print size after removal
    }
}
