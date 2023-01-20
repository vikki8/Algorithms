
package chap7;

public class BSTNode<T extends Comparable<T>> {
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;

    public BSTNode() {
        data = null;
        leftLink = null;
        rightLink = null;
    }
    
    public BSTNode(T a, BSTNode b, BSTNode c) {
        data = a;
        leftLink = b;
        rightLink = c;
    }
    public void setData(T a) {data = a;}
    public T getData() {return data;}    
    public void setLeft(BSTNode a) {leftLink = a;}
    public BSTNode getLeft() {return leftLink;}
    public void setRight(BSTNode a) {rightLink = a;}
    public BSTNode getRight() {return rightLink;}    
}
