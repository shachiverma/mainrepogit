package hashtable;

import hashtable.MyHashTable;

public class HashTable_Main {

	public static void main(String[] args) {
		 MyHashTable<String,String>ht=new MyHashTable<String,String>();
         System.out.println("\n____________________________________________________________________");
         System.out.println("\nHashTable Operations");
         ht.put("Fruit","Mango");
         ht.put("Car","Scorpio");
         ht.put("Mango","Yummy");
         ht.put("P","2");
         ht.put("1","G");
         ht.put("2","6");
         ht.put("3","2");
         ht.put("4","4");
         ht.put("1","H");
         
         System.out.println("\nElements in the hashtable");
         System.out.println(ht);
         System.out.println("\nGetting the value of the key Mango!");
         System.out.println(ht.get("Mango"));
         System.out.println("\nRemoving A which is not in the hashtable");
         System.out.println(ht.remove("A"));
         System.out.println("\nRemoving 1 which is there in the hashtable as updated value H");
         System.out.println(ht.remove("1"));
         System.out.println("\n");
         System.out.println(ht);
         System.out.println("\n______________________________________________________________________");
     }
     

	}


