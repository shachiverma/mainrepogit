package queue;


public class MyQueue {
	public Node front=null;
	public Node rear=null;
	public int size=0;
	public Node current;


     class Node {
        public int data;
        public Node next;
        
         Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
	
	public void getSize() {
		System.out.println("The size of the queue is:"+size);
	}
	
	
	
	public void enqueue(int data) {
		Node n=new Node(data);
		System.out.println("\nInserting "+data);
		if (front==null) {
			front=n;
			rear=n;
			size+=1;
			n.next=null;
			System.out.println(data+" inserted successfully");
		}
		else {
			current=front;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=n;
			size+=1;
			System.out.println(data+" inserted successfully");
		}
	}
	
	
	public void dequeue() {
		if (front==null) {
			System.out.println("Queue is Empty");
			return;
		}
		else {
			int data=front.data;
			System.out.println("\nDeleting "+data);
			front=front.next;
			System.out.println(data+" dequeued successfully\n");
			size-=1;
			display();
		}
	}
	
	public void peek() {
		System.out.println("\nPeek Function called");
		System.out.println(front.data+" is the data on the front\n");
	}
	
	public void reverse() {
		Node temp = null;
	    current = front;
		while (current != null) {
		    Node next = current.next;
		    current.next = temp;
		    temp = current;
		    current = next;
		}
		front = temp;
		System.out.println("\n------------Queue reversed------------");
		display();
	}
	
	
	public void center() {
		int mid;
		if(size%2==0)
			 mid=size/2;
		else
			mid=(size-1)/2+1;
		
		current=front;
		for(int i=1;i<mid;i++) {
			current=current.next;
		}
		System.out.println("The center of the Queue is:"+current.data);
		display();
		
	}
	
	public void contains(int data) {

		if(front==null) {
			System.out.println("Queue is Empty");
			return ;
		}
		else {

			current=front;
			for(int i=0;i<size;i++) {
				if (current.data==data) {
					System.out.println("Element "+data+" found on index"+Integer.valueOf(i+1));
					current=current.next;
					System.out.println("\n");
				}
			}

		}
	}
	
	public boolean CheckNext(Node n) {
		boolean hasNext=false;
		if(n.next!=null) {
			hasNext=true;
		}
		return hasNext;
	}
	
	
	public void iterator() {
		System.out.println("\nPrinting data Using Iterator");
		current=front;
		while(CheckNext(current)) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.print(current.data+" ");
		System.out.println("\n--------------------------");
	}
	
	//remaining
	public void sort() {
		current=front;
		if(front==null) {
			System.out.println("Queue is Empty");
			return;
		}
		if(size==1) {
			System.out.println("Queue has one node..can't Sort");
		}
		if (size==2) {
			System.out.println("\n------------Queue sorted------------");
			if(current.data>current.next.data) {
				swap(current,current.next);
			}
		}
		else if (size > 1) {
			System.out.println("\n------------Queue sorted------------");
			for (int i = 0; i < size; i++ ) {
				current = front;
				Node next = front.next;
				for (int j = 0; j < size - 1; j++) {
					if (current.data > next.data) {
						
						swap(current,next);
						
					} 
					current = next;
					next = next.next;                   
				} 
			}
		}
		
		display();
	}
	
	
	public void swap(Node n1,Node n2) {
		int temp;
		temp = n1.data;
		n1.data = n2.data;
		n2.data= temp;
	}
	
	public void display() {
		current=front;
		if(current==null) {
			System.out.println("Queue Empty");
		}
		
		System.out.print("\nQueue Now:");
	
		System.out.println("\n------------------------------");
		System.out.print("Front->");
		while(current!=null) {
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.print("Rear");
		System.out.println("\n------------------------------");
		
	}

	


}
