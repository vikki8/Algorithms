package chap2;

public class TwoType<T,U> {
    private T t;
    private U[] u;
    
    public TwoType(T t, U[] u) { this.t = t; this.u = u; }    
    public T getT() { return t; }
    public void setT(T t) { this.t = t; }
    public U[] getU() { return u; }
    public void setU(U[] u) { this.u = u; }
    public String toString() { 
        String str = "";
        str = "T is " + t + "\n";
        for(U value : u)
           str += value + " ";
        str += "\n";
        return str;        
    }    
}
