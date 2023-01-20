package chap2;


public class Main {

    public static void main(String[] args) {
        // Example 1
        /*
        Test<Integer> a = new Test<>(100);
        Test<Double> b = new Test<>(20.16);
        Test<String> c = new Test<>("Introduction to Generic");
        Test<?> d = new Test<>('A');
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        */
        // Example 2
        /*
        String[] str = {"one", "two", "three"};
        TwoType<Integer, String> a = new TwoType<>(100, str);
        System.out.println(a.toString());
        */
        // Example 3
        /*
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "orange");
        if (Util.compare(p1, p2)) {
            System.out.println("The pairs are equals");
        }
        else {
            System.out.println("The pairs are not equals");
        }
        */
        // Example 4
        /*
        ArrayLog<Integer> a = new ArrayLog<>(10);
        a.insert(20);
        a.insert(15);
        a.insert(13);
        System.out.println("Log Size " + a.size());
        System.out.println(a.toString());
        
        int num =12;
        if (a.search(num))
            System.out.println("Log contains " + num);
        else
            System.out.println("Log does not contains " + num);           
        */
        // Example 5
        /*
        String name = "Siti";
        ArrayLog<String> b = new ArrayLog<>(5);
        b.insert("James");
        b.insert("Ahmad");
        b.insert("Siti");
        b.insert("Ramesh");
        b.insert("John");;
        b.insert("Abdullah");
        System.out.println(b.toString());
        if (b.search(name))
            System.out.println("Log contains " + name);
        else
           System.out.println("Log does not contains " + name);
        b.clear();
        System.out.println("After clearing, log size is equal to " + b.size());
        */
        // Example 6
        /*
        ArrayListLog<Integer> a = new ArrayListLog<>(10);
        a.insert(20);
        a.insert(15);
        a.insert(13);
        System.out.println("Log Size " + a.size());
        System.out.println(a.toString());
        
        int num =12;
        if (a.search(num))
            System.out.println("Log contains " + num);
        else
            System.out.println("Log does not contains " + num);    
        */
        // Example 7
        /*
        String name = "Siti";
        ArrayListLog<String> b = new ArrayListLog<>(5);
        b.insert("James");
        b.insert("Ahmad");
        b.insert("Siti");
        b.insert("Ramesh");
        b.insert("John");;
        b.insert("Abdullah");
        System.out.println(b.toString());
        if (b.search(name))
            System.out.println("Log contains " + name);
        else
           System.out.println("Log does not contains " + name);
        b.clear();
        System.out.println("After clearing, log size is equal to " + b.size());
        */
        // Example 8
        /*
        LinkedListLog<Integer> a = new LinkedListLog<>(10);
        a.insert(20);
        a.insert(15);
        a.insert(13);
        System.out.println("Log Size " + a.size());
        System.out.println(a.toString());
        
        int num =12;
        if (a.search(num))
            System.out.println("Log contains " + num);
        else
            System.out.println("Log does not contains " + num);    
        */
        // Example 9
        /*
        String name = "Siti";
        LinkedListLog<String> b = new LinkedListLog<>(5);
        b.insert("James");
        b.insert("Ahmad");
        b.insert("Siti");
        b.insert("Ramesh");
        b.insert("John");;
        b.insert("Abdullah");
        System.out.println(b.toString());
        if (b.search(name))
            System.out.println("Log contains " + name);
        else
           System.out.println("Log does not contains " + name);
        b.clear();
        System.out.println("After clearing, log size is equal to " + b.size());
        */
    }
}
