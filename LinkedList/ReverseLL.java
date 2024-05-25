public class ReverseLL {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;


    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void print(){
        Node temp = head;
        if(temp == null) {
            System.out.println("LL is empty");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if(temp != null) {
                System.out.print("->");
            }
        }
        System.out.println("->null");
    }
    
    public static void main(String[] args) {
        ReverseLL ll = new ReverseLL();
        ll.print();
        ll.addLast(2);
        ll.addLast(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.print();
        ll.reverse();
        
    }
}
