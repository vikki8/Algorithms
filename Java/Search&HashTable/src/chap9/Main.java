package chap9;

import java.util.Scanner;

public class Main {
  
    public static void main(String[] args) {
        //Example 1
        /*
        int key, count;
        SearchTest<Integer> a = new SearchTest<>(1, 10);     
        System.out.println("The Integer data set : ");
        a.showValue();        
        Scanner s = new Scanner(System.in);        
        System.out.println("Linear Search");
        System.out.print("Enter a number to search: ");
        key = s.nextInt();
          count = a.linearSearchCount(key);
        if (count!=0) {
            System.out.println("The number of " + key + " in the data set is " + count);
        }
        else {
            System.out.println(key + " is not found");
        }
        */
        // Example 2
        /*
        int key, count;
        SearchTest<Integer> a = new SearchTest<>(1, 10);     
        System.out.println("The Integer data set : ");
        a.selectionSort(a.ASCENDING);
        a.showValue();        
        Scanner s = new Scanner(System.in);        
        System.out.println("Binary Search");
        System.out.print("Enter a number to search: ");
        key = s.nextInt();        
        count = a.binarySearchCount(key);
        if (count!=0) {
            System.out.println("The number of " + key + " in the data set is " + count);
        }
        else {
            System.out.println(key + " is not found");
        }
        */
        // Example 3
        /*
        HashTable<String, String> HT = new HashTable<>();
        System.out.println("Insert Three Key-Value Pairs into the Hash Table");
        HT.put("A", "Apple");
        HT.put("B", "Boy");
        HT.put("C", "Cat");
        System.out.println("The number of elements in the Hash Table " + HT.getSize());
        HT.showHashTable();        
        System.out.println("\nThe value for Key B is " + HT.get("B"));
        System.out.println("Modify the value for Key B");
        HT.put("B", "Bird");
        System.out.println("The number of elements in the Hash Table " + HT.getSize());
        HT.showHashTable();  
        System.out.println("Remove Key A");
        HT.remove("A");
        System.out.println("The number of elements in the Hash Table " + HT.getSize());
        HT.showHashTable();  
        System.out.println();
        */
    }
    
}
