
package chap7;

import java.util.Random;


public class Main {


    public static void main(String[] args) {
        // Example 1
        /*
        final int MAX = 20, SIZE=10;
        int[] num = new int[SIZE];
        Random r = new Random();
        BST<Integer> tree = new BST<>();        
        System.out.println("Insert " + SIZE + " random numbers within 0 - " + 
                            MAX + " into the Binary Search Tree");
        System.out.print("The random numbers are : ");
        for(int i=0;i<num.length; i++) {
            num[i] = r.nextInt(MAX+1);
            tree.addNode(num[i]);
            System.out.print(num[i] + "  ");
        }                
        System.out.println("\nThe number of elements in the tree : " + tree.getSize());        
        System.out.print("The tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();        
        System.out.print("\nThe tree elements - PREORDER : ");
        tree.setOrder(BST.PREORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
        System.out.println();
        */
        //Example 2
        /*
        final int MAX = 20, SIZE=10;
        int[] num = new int[SIZE];
        Random r = new Random();
        BST<Integer> tree = new BST<>();        
        System.out.println("Insert " + SIZE + " random numbers within 0 - " + 
                            MAX + " into the Binary Search Tree");
        System.out.print("The random numbers are : ");
        for(int i=0;i<num.length; i++) {
            num[i] = r.nextInt(MAX+1);
            tree.addNode(num[i]);
            System.out.print(num[i] + "  ");
        }                
        System.out.println("\nThe number of elements in the tree : " + tree.getSize());        
        System.out.println("Create Balance Tree");
        tree.balance();
        System.out.print("The tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();        
        System.out.print("\nThe tree elements - PREORDER : ");
        tree.setOrder(BST.PREORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
        System.out.println();
        */
        
    }
    
}
