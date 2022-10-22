package linked_list;
import java.util.*;
import java.lang.String;

public class LinkedList1 {

    private int size;
    LinkedList1(){this.size=0;}
    
    public static Node head=null;
	public Node current;

    class Node{
        int data;
        Node next;

        Node(int  data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    //add-first
    public void addFirst(int data){
        Node newnode=new Node(data);
        if(head == null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    //add-last
    public void addLast(int data){
        Node newnode=new Node(data);
        if(head == null){
            head=newnode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){currNode=currNode.next;}
        currNode.next=newnode;
    }
    //add at any position
    public void addpos(int data,int pos){
        Node temp=new Node(data);
        if(pos==1){
        temp.next=head;
        System.out.println("\nNew data added in the first position "+data);
        
        }
        current=head;
        for(int i=1;i<=pos-2 &&current!=null;i++){current=current.next;}
        if(current == null){System.out.println("\nInvalid Position");}
        temp.next=current.next;
        current.next=temp;
        
        System.out.println("\nElement inserted at pos "+pos);
    }
    //delete first node
    public  void deleteFirst(){
        if(head==null){System.out.println("List is empty");return;}
        
        size--;
        head=head.next;//deletefirst
    }
    //delete last node
    public void deleteLast(){
        if(head==null){System.out.println("List is empty");return;}
        size--;
        if(head.next==null){head=null;return;}
        Node secondLast=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }
    //delete the particular node at particular position
    public void deletepos(int pos){
        if (head == null) { 
            System.out.println("List is Empty");
            return; 
        }
 
        if (pos == 1){ 
            Node temp=head;
            head=head.next;
            temp.next=null;    
        } 
        current = head;
        for (int i=0; current!=null && i<pos-2; i++) 
            current = current.next; 
        if (current == null || current.next == null) 
            return; 
        int data= current.next.data;
        System.out.println("\nDeleting "+data);
        current.next = current.next.next; 
        System.out.println(data+" deleted successfully from position "+pos);
        size-=1;
    } 
    

    public int getSize(){return size;}//size of the linked list
    //print the linked list
    public  void printList(){
        if(head==null){System.out.println("List is empty");return;}
        Node currNode = head;
        while(currNode !=null){System.out.print(currNode.data+"->");currNode=currNode.next;}
        System.out.println("Null");
    }
    //reverse
    public void reverseIterate(){
        if(head == null || head.next ==null){return;}
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode!=null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
    //sort via bubble sort
    public  void sortList(){
        Node current=head;
        Node index=null;
        int temp;
        if(head == null){System.out.println("\nLinked list is empty\n");}
        else{
            while(current!=null){
                index=current.next;
                while(index!=null){
                    if(current.data > index.data){
                        temp=current.data;
                        current.data=index.data;
                        index.data=temp;
                    }
                    index=index.next;
                }
                current=current.next;
            }
        }
        
    }
    //middle element
    public void getMiddle(){
        if(head == null){System.out.println("\nLinked list is empty\n");}
        Node slow=head,fast=head;
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("\nMiddle element of the linked list is: "+slow.data);
    }
    public static int searchll(int x){
        int pos=1;
        Node curr=head;
        while(curr!=null){
            if(curr.data == x){return pos;}
            else{
                pos++;
                curr=curr.next;
            }
            
        }
        return -1;
        
    }

}