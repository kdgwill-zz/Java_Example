package depreciated.OperatingSystemsProject.test.etc;  
   
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  

   
public class RoundRobinTest {  
    public static void main(String[] args){
        RoundRobinTest test = new RoundRobinTest();
        System.out.println("This is Test 1");
        test.testOne();
        System.out.println("This is Test 2");
        test.testTwo();
        System.out.println("This is Test 3");
        test.testThree();
    }
    
    
    List<Robin> items = new ArrayList<Robin>();  
    RoundRobin round;  

    public void testOne() {  
    items.add(new Robin(1));  
    round = new RoundRobin(items);  
    System.out.println("should be 1: "+ round.next());  
    System.out.println("should be 1: "+round.next());  
    }  

    public void testTwo() {  
    items.add(new Robin(1));  
    items.add(new Robin(2));  
    round = new RoundRobin(items);  
    System.out.println("should be 1:, "+round.next());  
    System.out.println("should be 2: "+round.next());  
    System.out.println("should be 1: "+round.next());  
    System.out.println("should be 2: "+round.next());  
    }  

    public void testThree() {  
    items.add(new Robin(1));  
    items.add(new Robin(2));  
    items.add(new Robin(3));  
    round = new RoundRobin(items);  
    System.out.println("should be 1: "+ round.next());  
    System.out.println("should be 2: "+round.next());  
    System.out.println("should be 3: "+round.next());  
    System.out.println("should be 1: "+round.next());  
    System.out.println("should be 2: "+round.next());  
    System.out.println("should be 3: "+round.next());  
    } 
    class Robin {  
        private int i;  

        public Robin(int i) {  
        this.i = i;  
        }  

        public int call() {  
        return i;  
        }  
        }  

        class RoundRobin {  
        private Iterator<Robin> it;  
        private List<Robin> list;  

        public RoundRobin(List<Robin> list) {  
        this.list = list;  
        it = list.iterator();  
        }  

        public int next() {  
        // if we get to the end, start again  
        if (!it.hasNext()) {  
        it = list.iterator();  
        }  
        Robin robin = it.next();  

        return robin.call();  
        }  
    }
}  