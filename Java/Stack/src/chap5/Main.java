
package chap5;

public class Main {

    public static void main(String[] args) {
        // Example 1
        /*
        Stack<String> stack = new Stack<>();
        System.out.println("Insert three nodes into the stack");
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        System.out.println("The number of elements in the stack is " + stack.getSize());
        stack.showStack();
        System.out.println("\nPop one node from the stack"); 
        stack.pop();
        System.out.println("The number of elements in the stack is " + stack.getSize());
        stack.showStack();        
        System.out.println("\nThe element on the top of the stack is " + stack.peek());
        stack.showStack();
        System.out.println();
        */
        // Example 2
        /*
        String[] infix = { "A+B", "A+B*C", "(A+B)*(C-D)", "(A*B+C)/D+E"};
        for(int i=0; i<infix.length; i++) {
            System.out.println("The infix expression : " + infix[i]);
            System.out.println("The postfix expression : " + infixToPostfix(infix[i]));
            System.out.println("The prefix expression : " + infixToPrefix(infix[i]));
        }
        */
        // Example 3
        /*        
        String[] infixValue = { "5+9", "4+3*2", "(3+2)*(7-4)", "(5*6+2)/4+7"};
        for(int i=0; i<infixValue.length; i++) {
            System.out.println("The infix expression : " + infixValue[i]);
            System.out.println("The postfix expression : " + infixToPostfix(infixValue[i]));
            System.out.println("The prefix expression : " + infixToPrefix(infixValue[i]));
            System.out.println("The result using postfix expression : " + postfixEvaluation(infixToPostfix(infixValue[i])));
            System.out.println("The result using prefix expression : " + prefixEvaluation(infixToPrefix(infixValue[i])));
        }
        */
    }
    
     public static String infixToPostfix(String a) {
        String str="";
        char c=' ';
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<a.length(); i++) {
            if (Character.isLetterOrDigit(a.charAt(i)))
                str += a.charAt(i);
            else if (a.charAt(i) == '(')
                stack.push(a.charAt(i));
            else if (a.charAt(i) == ')') {
                c = stack.pop();
                while (c!='('){ 
                    str+=c;
                    c = stack.pop();
                }
            }
            else {
                if (!stack.isEmpty()) {
                    if (stack.peek()=='(')
                        stack.push(a.charAt(i));
                    else {
                        c = stack.peek();
                        while(getPriority(a.charAt(i)) <= getPriority(c)) {
                            str+=stack.pop();
                            if (!stack.isEmpty()) {
                                c = stack.peek();
                                if (c=='(')
                                    break;
                            }
                            else
                                break;
                        }
                        stack.push(a.charAt(i));
                    }
                }
                else
                    stack.push(a.charAt(i));
            }
        }
        while (!stack.isEmpty())
            str+=stack.pop();
 
        return str;
    }
     
    public static String infixToPrefix(String a) {
        String rev="", str="";
        Stack<Character> stack = new Stack<>();
        for(int i=a.length()-1; i>=0; i--) {
            if (a.charAt(i)=='(')
                rev+= ')';
            else if (a.charAt(i)==')')
                rev+= '(';
            else
                rev+=a.charAt(i);
        }
        rev = infixToPostfix(rev);
        for(int i=rev.length()-1; i>=0; i--) 
            str+=rev.charAt(i);
        return str;
    }
     
    public static int getPriority(char a) {
        switch (a) {
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    
    public static int postfixEvaluation(String a){
        Stack<String> stack = new Stack<>();
        String temp;
        int num1=0, num2=0, result=0;  
        for(int i=0; i<a.length(); i++) {
            if (Character.isLetterOrDigit(a.charAt(i))) {
                temp = a.substring(i, i+1);
                stack.push(temp);
            }
            else {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                result = getResult(num1, num2, a.charAt(i));
                stack.push(result+"");
            }
        }
        result = Integer.parseInt(stack.pop());
        return result;
    }     
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false;      
        }
        return true;
    }
    
    public static int getResult(int a, int b, char c) {
        switch(c) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '%':
                return a*b;
        }
        return 0;
    }
    
    public static int prefixEvaluation(String a){
        Stack<String> stack = new Stack<>();
        String temp;
        int num1=0, num2=0, result=0;
        temp = a.substring(0, 1);
        stack.push(temp);
        if (!Character.isLetterOrDigit(a.charAt(0))) {
            stack.push("#");
        }
        for(int i=0; i<a.length(); i++) {
            if (Character.isLetterOrDigit(a.charAt(i))) {
                if (stack.peek().equals("#")) {
                    temp = a.substring(i, i+1);
                    stack.push(temp);
                }
                else {
                    boolean first =true;
                    while (isInteger(stack.peek()) && !stack.isEmpty()) {
                         num1 = Integer.parseInt(stack.pop());
                         if (first) {                                                     
                            num2 = Integer.parseInt(a.substring(i, i+1));
                         }
                         else {
                            num2=result;                            
                         }
                         stack.pop();
                         result = getResult(num1, num2,stack.pop().charAt(0));
                         first=false;
                    }
                    stack.push(result+"");
                }
            }    
            else {
                temp = a.substring(i, i+1);
                stack.push(temp);
                stack.push("#");
            }
         }
        result =  Integer.parseInt(stack.pop());
        return result;
    }
    
}
