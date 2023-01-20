package chap6;

import java.util.Random;


public class Main {


    public static void main(String[] args) {
        // Example 1
        /*
        Queue<Integer> a = new Queue<>();
        System.out.println("Insert three nodes into the queue");
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.showQueue();
        System.out.println("\nThe queue size is " + a.getSize());
        System.out.println("Remove one node from the queue");
        a.dequeue();
        a.showQueue();
        System.out.println("\nThe queue size is " + a.getSize());
        System.out.println("The value of the front node is " + a.peek());
        System.out.println("The queue size is " + a.getSize());
        */
        // Example 2
        /*
        String[] name= {"Ahmad", "Ali", "Anuar", "James", "Ramesh"};
        final int serviceTime = 3;    
        int cnt1=0, cnt2=0; 
        Queue<String> Q = new Queue<>();
        System.out.println("Simulate Waiting Queue in the Bank");
        System.out.println("Time 0: All customers queue at the same time");
        int time=0;
        for(int i=0; i<name.length; i++)
            Q.enqueue(name[i]);
        System.out.println("The queue is ");
        Q.showQueue();
        System.out.println("");
        while (true) {
            time++;
            if (cnt1==0) {
                if (!Q.isEmpty()) {
                    System.out.println("Time " + time + 
                                       " Counter 1 serving " + Q.dequeue());
                    cnt1+=serviceTime-1;        
                } 
            }
            else
                cnt1--;
            if (cnt2==0) {
                if (!Q.isEmpty()) {
                    System.out.println("Time " + time + 
                                       " Counter 2 serving " + Q.dequeue());
                    cnt2+=serviceTime-1;        
                }
            }
            else
                cnt2--;
            if (Q.isEmpty())
                break;            
            System.out.println("Time " + time + " The queue is ");
            Q.showQueue();
            System.out.println();
        }
        */
        // Example 3
        /*
        String[] name = {"Ahmad", "Ali", "Anuar", "James", "Ramesh"};
        int[] arrive = {1, 2, 2, 4, 6};  
        int time =0, cnt1=0, cnt2=0, serviceTime = 3, N=0;
        Queue<String> Q = new Queue<>();
        System.out.println("Simulate Waiting Queue in the Bank");
        System.out.println("Customers arrive at different time");
        for(int i=0; i<name.length; i++) 
            System.out.print(name[i] + "(" + arrive[i] + ") ");
        System.out.println();
        while (true) {
            time++;
            while (N<arrive.length && arrive[N]==time) {
                Q.enqueue(name[N]);
                N++;
            }    
            if (cnt1==0) {
                if (!Q.isEmpty()) {
                    System.out.println("Time " + time + 
                                       " Counter 1 serving " + Q.dequeue());
                    cnt1+=serviceTime-1;
                } 
            }
            else
                cnt1--;
            
            if (cnt2==0) {
                if (!Q.isEmpty()) {
                    System.out.println("Time " + time + 
                                       " Counter 2 serving " + Q.dequeue());
                    cnt2+=serviceTime-1;
                }
            }
            else
                cnt2--;
            
            if (Q.isEmpty() && N==arrive.length)
                break;            
            System.out.println("Time " + time + " The queue is ");
            Q.showQueue();
            System.out.println();
        }
        */
        // Example 4
        /*
        Random r = new Random();
        Request request;
        int NRequest=10, numberOfQueue = 2;
        System.out.println("Calculate Waiting Time with " + numberOfQueue + " Service Counters");        
        Queue<Request>[]SQ = new Queue[numberOfQueue];
        Queue<Request>RQ = new Queue<>();
        
        for(int i=0; i<numberOfQueue; i++) 
            SQ[i] = new Queue<>();
        
        int currentTime=0;
        int minIAT = 1, maxIAT=10, minST = 5, maxST=15;
        
        int IAT, ST;
        for(int i=0; i<NRequest; i++) {
            IAT = minIAT + r.nextInt(maxIAT-minIAT-1);
            ST = minST + r.nextInt(maxST-minST-1);
            currentTime+=IAT;
            request = new Request(currentTime, ST);
            RQ.enqueue(request);
        }
        
        int []indexandFT = new int[2];
        int index;
        int WT=0, NProcess=0;
        currentTime=0;
        while (true) {
            // dequue all SQ if FT = currentTime
             for(int i=0; i<numberOfQueue; i++)
                if (!SQ[i].isEmpty()) {
                     if (SQ[i].peek().getFT()==currentTime)
                         SQ[i].dequeue();
                 }
            // process queue if AT=currentTime         
            while (!RQ.isEmpty() && RQ.peek().getAT()==currentTime) {
                request = RQ.dequeue();                
                // get the best queue and finish time
                getBestQueue(request.getAT(), request.getST(), SQ, indexandFT);
                request.setFT(indexandFT[1]);
                WT+=request.getWT();
                index= indexandFT[0];
                System.out.println("Request " + (NProcess+1) + " : AT = " + request.getAT() + 
                                   " ST = " +   request.getST() + " FT = " + request.getFT() + 
                                   " WT = " + request.getWT() + " Counter = " + index);
                SQ[index].enqueue(request);
                NProcess++;
            }        
            currentTime++;
            if(NProcess==NRequest)
                break;
        }
        System.out.println("The waiting time is : " + WT);
        System.out.println("The average waiting time is : " + WT/(NRequest*1.0));     
        */
    }
    
    public static void getBestQueue(int at, int st, Queue<Request>[] SQ, int[] indexandFT) {
        Queue<Request> hold = new Queue<>();        
        int temp, FT=0, index=0;        
        if (SQ[index].isEmpty())
            FT = at + st;
        else {
            while(SQ[index].getSize()!=1)
                hold.enqueue(SQ[index].dequeue());
            if (at<SQ[index].peek().getFT())
                FT = SQ[index].peek().getFT() + st;
            else
                FT = at + st;
            hold.enqueue(SQ[index].dequeue());
            
            while(!hold.isEmpty())
                SQ[index].enqueue(hold.dequeue());
         }          
        
         for(int i=1; i<SQ.length; i++) {
            if (SQ[i].isEmpty()) {
                temp = at + st;
                if (temp<FT) {
                    index =i;
                    FT=temp;
                }
            }   
            else {
                while(SQ[i].getSize()!=1)
                    hold.enqueue(SQ[i].dequeue());
                if (at<SQ[i].peek().getFT())
                    temp = SQ[i].peek().getFT() + st;
                else
                    temp = at + st;
                if (temp<FT) {
                    index =i;
                    FT=temp;
                }
                hold.enqueue(SQ[i].dequeue());
            
                while(!hold.isEmpty())
                    SQ[i].enqueue(hold.dequeue());   
            }
        } 
        indexandFT[0]=index;
        indexandFT[1]=FT;
    }
    
}
