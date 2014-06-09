/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package depreciated.OperatingSystemsProject.test.etc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * **RoundRobin is jst an iterator
 * **robin is just an int
 * @author Kyle Williams
 */
public class Main {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        Iterator i = ll.iterator();
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        i = al.iterator();
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        //Main app = new Main();
        //app.start();
    }
    
    public void start(){
        System.out.println("This is the First Test:");
        testOne();
        System.out.println("This is the Second Test:");
        testTwo();
        System.out.println("This is the Third Test:");
        testThree();
    }
    
    public java.util.ArrayList<Robin> items = new java.util.ArrayList<Robin>();
    public RoundRobin round; 

    public void testOne() { 
        items.clear();
        items.add(new Robin(1));  
        round = new RoundRobin(items);  
        System.out.print("should be 1: "+ round.next()+" ");  
        System.out.println("should be 1: "+round.next());  
    }  

    public void testTwo() {  
        items.clear();
        items.add(new Robin(1));  
        items.add(new Robin(2));  
        round = new RoundRobin(items);  
        System.out.print("should be 1: "+round.next()+" ");  
        System.out.print("should be 2: "+round.next()+" ");  
        System.out.print("should be 1: "+round.next()+" ");  
        System.out.println("should be 2: "+round.next()+" ");  
    }  

    public void testThree() { 
        items.clear();
        items.add(new Robin(1));  
        items.add(new Robin(2));  
        items.add(new Robin(3));  
        round = new RoundRobin(items);  
        System.out.print("should be 1: "+round.next()+" ");  
        System.out.print("should be 2: "+round.next()+" ");  
        System.out.print("should be 3: "+round.next()+" ");  
        System.out.print("should be 1: "+round.next()+" ");  
        System.out.print("should be 2: "+round.next()+" ");  
        System.out.println("should be 3: "+round.next());  
    } 
}
