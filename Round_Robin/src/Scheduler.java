



import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
/**
 * The base class for all Scheduling algorithms
 * @author Kyle D. Williams
 */
public abstract class Scheduler {
        protected final CPU cpu;   
        protected final Queue<Process> jobsQueued;
        protected final LinkedList<Process> jobsFinished;
       
        
        public Scheduler(){            
                jobsQueued = new LinkedList<Process>();
                jobsFinished = new LinkedList<Process>();
                cpu = new CPU();
        }
        /**
         * The main call in a Scheduler this call differentiates each 
         * scheduler and defines how they work
         */
        public abstract void run();

        /** 
         * Adds a Job to the Scheduler
         */
        public void addJob(Process job, long arrivalTime) {
            jobsQueued.add(job);
        }
        /** 
         * Adds a Job to the Scheduler
         */
        public void addJobs(Process... Jobs){
            for(int i=jobsQueued.size(); i<Jobs.length;i++){
                addJob(Jobs[i],i);
            }
        }
        /** 
         * Adds a Job to the Scheduler
         */
        public void addJobs(List<Process> jobs){
            long burstTime = jobs.size();
            for(Process job:jobs){
                burstTime++;
                addJob(job,burstTime);
            }
        }
        
        /**
         * Returns the jobs completed
         * @return jobsFinished
         */
         public LinkedList<Process> getResult() {
                return jobsFinished;
        }        
        
         /**
          * returns the finish time of a specific job
          * @param job
          * @return 
          */
        public long getFinishTime(String job){
            for(Process jb: jobsFinished){
                if(jb.getName().equals(job)){
                    return jb.getFinishedTime();                    
                }
            }
            return -1;
        }
        
        /**
         * Returns the CPU
         * @return 
         */
        public CPU getCPU(){
            return cpu;
        }
        
        /**
         * @see CPU#getStatistics() 
         * @return 
         */
        public String getStatistics(){
            return cpu.getStatistics();
        }
                
        public void printStatistics(){
            System.out.println(getStatistics());
        }
}
