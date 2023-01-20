package chap2;

public class ArrayLog<T extends Comparable<T>> implements SimpleLog<T> {

    private T[] log;
    private int index, maxsize;

    public ArrayLog(int a) {
        index = -1;
        maxsize = a;
        log = (T[]) new Comparable[10];
    }
    public void insert(T t) {
        if (!isFull()) {
            index++;
            log[index] = t;           
        }
        else {
           System.out.println("The log is full");
        }
    }    
    public boolean isFull() { return maxsize==(index+1); }
    public int size() { return index+1; }
    
    public boolean search(T t) {
        for(int i=0; i<=index; i++) { 
            if(log[i].compareTo(t)==0) {
                return true;
            }
        }                 
        return false;
    }
    
    public void clear() {
        for(int i=0; i<=index; i++) 
            log[i]=(T) null;
        index=-1;
    }
    
    public String toString() {
        String str="";
        for(int i=0; i<=index; i++) 
            str += log[i] + " ";
        return str;
    }
}



