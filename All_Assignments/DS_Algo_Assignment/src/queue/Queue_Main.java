package queue;

import queue.MyQueue;

public class Queue_Main {

	public static void main(String[] args) {
		 MyQueue q= new MyQueue();
         System.out.println("\n_____________________________________________________________________________");
         System.out.println("\nQueue Operations\n");
         System.out.println("\nEntering elements in the queue");
         q.enqueue(50);
         q.enqueue(4);
         q.enqueue(30);
         q.enqueue(2);
         q.enqueue(10);
         System.out.println("\nRemoving the elements of the queue");
         q.dequeue();
         System.out.println("\nGetting size of the queue");
         q.getSize();
         System.out.println("\nGetting the centre element of the queue");
         q.center();
         q.iterator();
         q.contains(2);
         q.peek();
         q.reverse();
         q.sort();
         System.out.println("\n_____________________________________________________________________");
     }

	}


