public class LLRemoveNthNode {
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
    
    public void deleteNthFrom(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n==sz) {
            head = head.next;
            return;
        }
        int i=1;
        int iToFind=sz-n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public static void main(String[] args) {
        LLRemoveNthNode ll = new LLRemoveNthNode();
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addLast(2);
        ll.addLast(4);
        ll.deleteNthFrom(3);
        ll.print();
    }
}
