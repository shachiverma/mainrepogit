package priorityqueue;

import priorityqueue.PriorityQueue;

public class PriorityQueue_Main {

	public static void main(String[] args) {
		PriorityQueue pq=new PriorityQueue();
        System.out.println("\n__________________________________________________________________________");
        System.out.println("\nPriority Queue Operations\n");
        System.out.println("\nInserting the elements in the priority queue\n");
        pq.enqueue(12);
        pq.enqueue(7);
        pq.enqueue(10);
        pq.enqueue(1);
        pq.enqueue(8);

        pq.printPriorityQueue();

        System.out.println("\n");
        System.out.println("\nThe element that is removed is: "+pq.dequeue());
        pq.printPriorityQueue();

        System.out.println();
        System.out.println("\nThe element that is removed is: "+pq.dequeue());
        pq.printPriorityQueue();

        System.out.println();
        System.out.println("\nThe priority queue size is : "+pq.getsize());

        System.out.println("\nPeek element is: "+pq.getpeek());

        pq.getmiddle();

        System.out.println("\nReverse prioity queue is: ");
        pq.reverse();
        System.out.println("\nIs 20 there in the priority queue or not ?");
        pq.contains(20);
        System.out.println("\n________________________________________________________________________");
        

	}

}
