package chap4;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // Example 1
        /*
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Linked List : Insert 3 nodes at the back");
        list.addNode("One");
        list.addNode("Two");
        list.addNode("Three");
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        
        Scanner s= new Scanner(System.in);
        System.out.print("\nEnter a String to search : "); 
        String str = s.nextLine();
        if (list.contains(str)) {
            System.out.println(str + " was found");             
        }
        else {
            System.out.println(str + " was not found");             
        }
        System.out.println("Linked List: Delete 2 nodes at the back"); 
        list.deleteNode();
        list.deleteNode();
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println("\nLinked List: Clear ALL"); 
        list.clear();
        System.out.println("Linked List has " + list.length() + " nodes");
        */
        // Example 2
        /*
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Linked List : Insert 3 front nodes");
        list.addFrontNode("One");
        list.addFrontNode("Two");
        list.addFrontNode("Three");
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println("\nLinked List: Delete 2 front nodes"); 
        list.deleteFrontNode();
        list.deleteFrontNode();
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println();
        */
        // Example 3
        /*
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Linked List : Insert 3 nodes at the back");
        list.addNode("One");
        list.addNode("Two");
        list.addNode("Three");
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        int position=1;
        System.out.println("\nLinked List Position start at 0");
        System.out.println("Insert a node at position : " + position);
        list.addNodeByPosition("Four", position);
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();        
        position=2;
        System.out.println("\nDelete a node from position : " + position);
        list.deleteNodeByPosition(position);
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println();
        */        
        // Example 4
        /*
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Linked List : Insert 4 nodes at the back");
        list.addNode("One");
        list.addNode("Two");
        list.addNode("Three");
        list.addNode("Four");
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println("\nLinked List Position start at 0");
        String newValue = "Five";
        int position = 2;
        System.out.println("Change value at position " + position + " to " +newValue);
        list.set(newValue, position);        
        System.out.println("Linked List has " + list.length() + " nodes");
        list.showList();
        position = 1;
        System.out.println("\nThe value at position " + position + " is " + list.get(position));
        */
        // Example 5
        /*
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        System.out.println("Double Linked List : Insert 3 nodes at right site");
        list.addRightNode("One");
        list.addRightNode("Two");
        list.addRightNode("Three");        
        System.out.println("Double Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println("\nDelete two nodes from right site");
        list.deleteRightNode();
        list.deleteRightNode();
        System.out.println("Double Linked List has " + list.length() + " nodes");
        list.showList();
        */
        // Example 6
        /*
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        System.out.println("Double Linked List : Insert 3 nodes at right site");
        list.addRightNode("One");
        list.addRightNode("Two");
        list.addRightNode("Three");        
        System.out.println("Double Linked List has " + list.length() + " nodes");
        list.showList();
        int position=1;
        System.out.println("\nDouble Linked List Position start at 0");
        System.out.println("Insert a node at position : " + position);
        list.addNodeByPosition("Four", position);
        System.out.println("Double Linked List has " + list.length() + " nodes");
        list.showList();
        position=2;
        System.out.println("\nDelete a node from position : " + position);
        list.deleteNodeByPosition(position);
        System.out.println("Double Linked List has " + list.length() + " nodes");
        list.showList();
        System.out.println();
        */
    }
    

    
}
