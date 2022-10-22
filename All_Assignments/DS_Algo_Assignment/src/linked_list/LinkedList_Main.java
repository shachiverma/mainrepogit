package linked_list;

import linked_list.LinkedList1;

public class LinkedList_Main {

	public static void main(String[] args) {
		 LinkedList1 list=new LinkedList1();
         System.out.println("______________________________________________________________________");
         System.out.println("\nLinked List Operations");
         System.out.println("\nInsertion at first and last positions of the linked list\n");
         list.addFirst(5);
         list.addFirst(4);
         list.addFirst(3);
         list.printList();
 
         list.addLast(9);
         list.printList();
 
         System.out.println("\nInsertion at particular position of the linked list\n");
         list.addpos(10,4);
         list.printList();
 
         System.out.println("\nReverse of the linked list is :\n");
         list.reverseIterate();
         list.printList();
 
         System.out.println("\nSorted linked list is\n");
         list.sortList();
         list.printList();
 
         System.out.println("\nPrinting Middle element :\n");
         list.getMiddle();
 
         System.out.println("\nSearching the element: \n");
         System.out.println("Position of element in Linked List: "+list.searchll(10));
 
         System.out.println("\nDeleting from a particular position ");
         list.deletepos(4);
         list.printList();
 
         System.out.println("\nSize of the linked list is: "+list.getSize());
         System.out.println("_________________________________________________________________________");
     }

	}


