package stack;



public class StackClass {

    public class Node {
        public int data;
        public Node next;
        
        
        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
	
	
	
	public Node top;
	public int size=0;
	public Node current;
	
	
	public void getSize() {
		System.out.println("\nThe size of the stack is:"+size);
	}
	
	
	public void push(int data) {
		Node n=new Node(data);
		System.out.println("\nPushing "+data);
		
		if (top==null) {
			top=n;
			size+=1;
			System.out.println(data+" pushed successfully");
			
			display();
		}
		else {
			n.next=top;
			top=n;
			size+=1;
			System.out.println(data+" pushed successfully\n");
			
			display();
		}
	}
	public void pop() {
		if (top==null) {
			System.out.println("\nPopping");
			System.out.println("Can't Pop...Stack is Empty");
			return;
		}
		else {
			
			int data=top.data;
			System.out.println("\nPopping "+data);
			top=top.next;
			System.out.println(data+" popped successfully");
			size-=1;
			display();
		}
	}
	
	public void peek() {
		try {
			System.out.println("\nPeek Function called-------------");
			System.out.println(top.data+" is the data on the top\n");
		} catch (NullPointerException e) {
			System.out.println("Can't Peek....Stack is Empty");
		}
	}
	
	public void center() {
		try {
			int mid;
			if(size%2==0)
				 mid=size/2;
			else
				mid=(size-1)/2+1;
			
			current=top;
			for(int i=1;i<mid;i++) {
				current=current.next;
			}
			System.out.println("\nThe center of the stack is:"+current.data);
			display();
		} catch (NullPointerException e) {
			System.out.println("\nCan't Find Center....Stack is Empty");
		}
	}
	
	public void contains(int data) {

		if(top==null) {
			System.out.println("Stack is Empty");
			return ;
		}
		else {

			current=top;
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
		current=top;
		System.out.println("\nPrinting data Using Iterator");
		while(CheckNext(current)) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.print(current.data+" ");
		System.out.println("\n--------------------------");
	}
	
	public void sort() {
		current=top;
		if(size==0) {
			System.out.println("Stack is Empty");
			return;
		}
		if(size==1) {
			System.out.println("Stack has one node..can't Sort");
		}
		if (size==2) {
			if(current.data>current.next.data) {
				swap(current,current.next);
			}
		}
		else if (size > 1) {
			for (int i = 0; i < size; i++ ) {
				current = top;
				Node next = top.next;
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
	
	
	
	public void reverse() {
		Node temp = null;
	    current = top;
		while (current != null) {
		    Node next = current.next;
		    current.next = temp;
		    temp = current;
		    current = next;
		}
		top = temp;
		System.out.println("\n------------Stack reversed------------");
		display();
	}
	
	
	public void display() {
		if (top==null) {
			System.out.println("Stack is Empty");
			return;
		}
		else {
			current=top;
			System.out.print("\nStack Now:");
			
			System.out.println("\n------------------------------");
			System.out.print("Top->");
			while(current!=null) {
				System.out.print(current.data+"->");
				current=current.next;
			}
			System.out.print("Bottom");
			System.out.println("\n------------------------------");
			
				
			}
		}
}

