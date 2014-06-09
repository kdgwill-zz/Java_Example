



/**
 * This is a test class for the RoundRobin Algorithm it will be used to thoroughly test tha main functionality of Round Robin
 * @author Kyle Williams
 */
public class TestRoundRobin {
    
        public static void main(String[] args){
            TestRoundRobin trr = new TestRoundRobin();
            trr.TestRoundRobinBasic();
        }
         
        public void TestRoundRobinBasic(){             
            
            ///////////First RUN///////////
            System.out.println("Run 1\n");
            Scheduler schd = new RoundRobin(100);
            schd.addJobs(new Process("Job1", 50),
                            new Process("Job2", 900),
                            new Process("Job3", 80));      
            schd.run(); 
            schd.printStatistics();
            ///////////Second RUN///////////
            System.out.println("\nRun 2\n");
            runSet(4,24,3,3);
            ///////////Third RUN///////////
            System.out.println("\nRun 3\n");
            runSet(1,6,8,7,3);
            ///////////Fourth RUN///////////
            System.out.println("\nRun 4\n");
            runSet(1,165,453,4531);
            
            
            System.out.println("\n FINAL MEASUREMENTS");
            System.out.println("\n"+schd.getCPU().getTotalStatistics());
        }
        
        public void runSet(int quantomSlice, long... cpubursts){
            Scheduler schd = new RoundRobin(quantomSlice);
            
            for(int i=0;i<cpubursts.length;i++){
                schd.addJob(new Process("Job"+(i+1),cpubursts[i]), i);
            }    
            
            schd.run(); 
            schd.printStatistics();
        }
        
}
