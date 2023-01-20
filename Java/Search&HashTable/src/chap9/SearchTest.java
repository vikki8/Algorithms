package chap9;

import java.util.Random;

public class SearchTest<T extends Comparable<T>> { 
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    private final int MAX=20;
    private final int MAXCHAR=26;
    private T[] value;    
    private int orderType, size, line;
    private Random r;
    
    public SearchTest(T b, int size) {            
        this.size = size;       
        line =10;
        value = (T[]) new Comparable[size];
        r = new Random();
        char c;
        for(int i=0; i<size; i++) {
            if (b instanceof Integer) 
                value[i] = (T) ((Integer) r.nextInt(MAX));                
            else if (b instanceof Double)
                value[i] = (T) ((Double) (0.01*r.nextInt(MAX)));
            else if (b instanceof Character) {
                c = (char)('A'+r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            }
            else {
                c = (char)('A'+r.nextInt(MAXCHAR));
                value[i] = (T) (c+"");        
            }
        }
    }
        
    public SearchTest(int sortType, T b, int size) {    
        orderType = sortType;
        this.size = size;        
        line =10;
        value = (T[]) new Comparable[size];
        r = new Random();
        char c;
        for(int i=0; i<size; i++) {
            if (b instanceof Integer) 
                value[i] = (T) ((Integer) r.nextInt(MAX));                
            else if (b instanceof Double)
                value[i] = (T) ((Double) (0.01*r.nextInt(MAX)));
            else if (b instanceof Character) {
                c = (char)('A'+r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            }
            else {
                c = (char)('A'+r.nextInt(MAXCHAR));
                value[i] = (T) (c+"");        
            }
        }
    }
    
    public void showValue() {
        for(int i=0; i<value.length; i++) {
            System.out.print(value[i] + " ");
            if ((i+1)%line==0)
                System.out.println();
        }    
    }    
    
    public T getElement(int index) {
        return value[index];
    }

    public int linearSearchCount(T t) {
        int count=0;
        for(int i=0; i<value.length; i++) {
            if(value[i].compareTo(t)==0)
                count++;
        }
        return count;
    }
    
        public int binarySearchCount(T t) {
        int count=0;
        int index=binarySearchCount(0, value.length, t);
        if (index!=-1) {
            for(int i=index; i>=0 && t.compareTo(value[i])==0; i--)
                count++;
            for(int i=index+1; i<value.length && t.compareTo(value[i])==0; i++)
                count++;
        }
        return count;
    }
    public int binarySearchCount(int start, int end, T t) {
        int middle = (start + end) / 2;
        if(end < start) {
            return -1;
        } 
        if(value[middle].compareTo(t)==0)
            return middle;
        else if ( (value[middle].compareTo(t)>0 && orderType==ASCENDING) ||
                  (value[middle].compareTo(t)<0 && orderType==DESCENDING) )
            return binarySearchCount(start, middle - 1, t);
        else
            return binarySearchCount(middle+1, end, t);
    }
    
    public void selectionSort(int a) {
        orderType = a;
        for(int i=0; i<value.length-1; i++ )
            swap(i, getMinIndex(i));
    }
    
    public void swap(int index1, int index2) {
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }
    public int getMinIndex(int start) {
        T temp = value[start];
        int index = start;
        for(int i=start+1; i<value.length; i++) {
            if (temp.compareTo(value[i])>0 && orderType==ASCENDING) {
                index = i;
                temp = value[i];
            }
            else if (temp.compareTo(value[i])<0 && orderType==DESCENDING) {
                index = i;
                temp = value[i];
            }    
        }
        return index;
    }
    
}