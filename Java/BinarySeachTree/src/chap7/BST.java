package chap7;

public class BST<T extends Comparable<T>>  {
    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;
    private BSTNode root;
    private boolean found;    
    private Queue<T> Q;        
    private int traverse;
    
    public BST() {
        root = null;
    }
    
    public boolean isEmpty() {
        return (root==null);
    }
    
    public int getSize() {
        return getSize(root);
    }
    
    public int getSize(BSTNode<T> a) {
        if (a==null)
            return 0;
        else
            return getSize(a.getLeft()) + getSize(a.getRight()) + 1; 
    }
    
    public boolean contains(T t) {
        return find(root, t);
    }
    
    public boolean find(BSTNode<T> a, T t) {
        if (a==null)
            return false;
        else if (t.compareTo(a.getData())<0 )
            return find(a.getLeft(), t);
        else if (t.compareTo(a.getData())>0 )
            return find(a.getRight(), t);
        else    
            return true;
    }
    
    public T getElement(T t) {
        return (T) getElement(root, t);
    }
    
    public T getElement(BSTNode<T> a, T t) {
        if (a==null)
            return null;
        else if (t.compareTo(a.getData())<0 )
            return (T) getElement(a.getLeft(), t);
        else if (t.compareTo(a.getData())>0 )
            return (T) getElement(a.getRight(), t);
        else    
            return a.getData();
    }   
    
    public void addNode(T t) {
        root = add(root, t);
    }
    
    public BSTNode<T> add(BSTNode<T> a, T t) {
        if (a==null)
            a = new BSTNode<T>(t, null, null);
        else if (t.compareTo(a.getData())<=0)
            a.setLeft(add(a.getLeft(), t));
        else
            a.setRight(add(a.getRight(), t));
        return a;
    }
    
    public boolean remove(T t) {
        root = remove(root, t);
        return found;
    }
    
    public BSTNode<T> remove(BSTNode<T> a, T t) {
       if (a==null)
           found = false;       
       else if (t.compareTo(a.getData())<0)
            a.setLeft(remove(a.getLeft(), t));
       else if (t.compareTo(a.getData())>0)
            a.setRight(remove(a.getRight(), t));
       else {
           a = removeNode(a);
           found = true;
       }
       return a;
    }
    
    public BSTNode<T> removeNode(BSTNode<T> a) {
        if (a.getLeft()==null)
            return a.getRight();
        else if (a.getRight()==null)
            return a.getLeft();
        else {
            T t = (T) getPredecessor(a.getLeft());
            a.setData(t);
            a.setLeft(remove(a.getLeft(), t));
            return a;
        }
    }
    
    public T getPredecessor(BSTNode<T> a) {
        while(a.getRight()!=null) {
            a = a.getRight();
        }
        return a.getData();
    }
    
    public void showTree() {
        Q.showQueue();        
    }
    
    public void setOrder(int a) {
        traverse = a;
        Q = new Queue<>();
        if (traverse==INORDER) {            
            inOrder(root);
        }
        else if (traverse==PREORDER) {            
            preOrder(root);
        }
        else {
            postOrder(root);
        }
    }
    
    public void inOrder(BSTNode<T> a) {
        if (a!=null) {
            inOrder(a.getLeft());
            Q.enqueue(a.getData());
            inOrder(a.getRight());
        }
    }
    
    public void preOrder(BSTNode<T> a) {
        if (a!=null) {
            Q.enqueue(a.getData());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }
    
    public void postOrder(BSTNode<T> a) {
        if (a!=null) {
            postOrder(a.getLeft());
            postOrder(a.getRight());
            Q.enqueue(a.getData());
        }
    }    
    
    public void balance() {
        int size = this.getSize();
        setOrder(INORDER);
        T[] data = (T[]) (new Comparable[size]); 
        for(int i=0; i<size; i++) 
            data[i] = Q.dequeue();
        root=null;
        insertBalanceTree(data, 0, size - 1);
    }
    
    public void insertBalanceTree(T[] t, int low, int high) {
        if (low==high)
            this.addNode(t[low]);
        else if ((low + 1) == high) {
            this.addNode(t[low]);
            this.addNode(t[high]);
        }
        else {
            int mid = (low+high)/2;
            this.addNode(t[mid]);
            insertBalanceTree(t, low, mid - 1);
            insertBalanceTree(t, mid+1, high);
        }   
    }
 
}