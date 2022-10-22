package stack;

import stack.StackClass;

public class StackClass_Main {

	public static void main(String[] args) {
		 StackClass st=new StackClass();
         System.out.println("\n___________________________________________________________________________");
         System.out.println("\nStack Operations");
         System.out.println("\nPushing the numbers into the stack");
         st.push(1);
         st.push(2);
         st.push(3);
         st.push(4);
         st.push(5);
 
         System.out.println("\nGetting size of the stack");
         st.getSize();
 
         System.out.println("\nPopping out the elements from the stack");
         st.pop();
         st.pop();
 
         System.out.println("\nPeeking the front element of the stack");
         st.peek();
 
         st.center();
         st.contains(2);
 
         st.reverse();
         st.sort();
         st.display();
         System.out.println("\n________________________________________________________________________");
 

	}

}
