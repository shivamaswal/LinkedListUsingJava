//Created By Shivam Aswal | Thanks for reading 
class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}
public class linkedList {
    public static void main(String[] args) {
        //Method-1 (for creating Linked List in Java)
        // Node head = new Node(10);
        // Node temp1 = new Node(20);
        // Node temp2 = new Node(30);
        // head.next = temp1;
        // temp1.next = temp2;

        //Method-2 (for creating Linked List in Java)
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);
        // // printLL(head);
        // // System.out.println(search(head, 20));
        head = insertAtBegin(head, 10);
        head = insertAtEnd(head, 50);
        head = insertAtEnd(head, 60);
        printLL(head);
        // head = deleteFromBegin(head);
        // head = deleteFromEnd(head);
        // head = insertSorted(head, 1);
        // printLL(head);
        printMiddleNode(head);
    }

    public static void printLL(Node head){  //function to Print Linked List
        Node curr = head ; 
        while(curr!=null){
            System.out.print(curr.data+" -> ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static int search(Node head , int x){    //function to Search for given data in LinkedList
        if(head == null) return -1;

        if(head.data == x) return 1;

        else{
            int res = search(head.next,x);
            if(res == -1) return -1;
            else{
                return(res+1);
            }
        }

    }

    public static Node insertAtEnd(Node head, int x){   //function to Insert given data at the end of LinkedList
        Node temp = new Node(x);
        if(head == null) return temp;
        Node curr = head;
        while(curr.next != null){
            curr=curr.next;
        }
        curr.next=temp;
        return head;

    }

    public static Node insertAtBegin(Node head, int x){ //function to Insert given data at the start of LinkedList
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    public static Node deleteFromBegin(Node head){  //function to delete node from the start of LinkedList
        if(head == null )return null;
        else{
            return head.next;
        }
        
    }

    public static Node deleteFromEnd(Node head){    //function to delete node from the start of LinkedList
        if(head == null )return null;
        if(head.next == null)return null;

        Node curr = head;
        while(curr.next.next != null) curr = curr.next;
        curr.next=null;
        return head;
        
    }

    public static Node insertAtPos(Node head ,int pos,int x){   //function to Insert node at the given position of LinkedList
        Node temp = new Node(x);
        if(head==null){
            if(pos==1){
                return temp;
            }else return head;
        }

        if(pos==1){
            temp.next = head;
            return temp;
        }

        Node curr = head;

        for(int i=1;i<pos-1;i++){
            curr = curr.next;
        }

        if(curr==null){
            return head;
        }

        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static Node insertSorted(Node head,int x){   //function to Insert node in Sorted Order of LinkedList
        Node temp = new Node(x);
        if(head==null){
            return temp;
        }

        if(head.next == null){
            if(head.data>x){
                temp.next = head;
                return temp;
            }else{
                head.next = temp;
                return head;
            }
        }

        Node curr = head;

        while(curr.next.data<x){
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;
        return head;

    }

    public static void printMiddleNode(Node head){  //function to print the element at the middle position of LinkedList
        if(head == null) return;
        Node slow = head;   //reference that iterate one step at a time
        Node fast = head;   //reference that iterate two step at a time

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }


}
