package chap10;

public class GraphNode<V , E> {
    private V vertice;
    private GraphNode verticeLink;
    private E edgeLink;
    private boolean marked;
    
    public GraphNode() {
        vertice = null;
        verticeLink = null;
        edgeLink = null;
        marked=false;
    }
    
    public GraphNode(V a, GraphNode b) {
        vertice = a;
        verticeLink = b;
        edgeLink = null;
        marked = false;
    }
    
    public void setVertice(V a) {vertice = a;}
    public V getVertice() {return vertice;}
    public void setMarked(boolean a) {marked = a;}
    public boolean getMarked() {return marked;}    
    public void setVerticeLink(GraphNode a) { verticeLink = a;}
    public GraphNode getVerticeLink() { return verticeLink; }    
    public void setEdgeLink(E a) { edgeLink = a;}
    public E getEdgeLink() { return edgeLink; }    
    public String toString() { return vertice + " --> " ; }     
}

