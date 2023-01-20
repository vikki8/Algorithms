package chap2;

// define a generic class containing elements of type T
public class Test<T> {
    private T t;    
    public Test(T t) { this.t = t; }
    public T getT() { return t; }
    public void setT(T t) { this.t = t; }
    public String toString() { return  t + ""; }    
}
