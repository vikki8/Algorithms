package chap2;

public interface SimpleLog<T> {
   // insert item to the log
   void insert(T t);
   // check whether the log is full
   boolean isFull();
   // get the size of the log
   int size();
   // check whether the item exists in the log
   boolean search(T t);
   // delete the log
   void clear();
   // display all items in the log. 
   String toString();
}
