



/**
 * This is the Round Robin Scheduler
 * Its prime implementation is basically a circular queue that stops a process if it does not complete within a 
 * specified time and delete it from the queue if it has
 * @author Kyle D. Williams
 */
public class RoundRobin extends Scheduler {
        private int cSwitch;
        private long quantum;         
        private long waitTimes;
        private float timeFinished;
        

        public RoundRobin(long timeSlice) {
            super();
            quantum = timeSlice;    
            cSwitch = 0;
            waitTimes=0;    
            timeFinished=0;
        } 
        
        @Override
        public void run() {
            long currentTime = 0;
            Process tempJob = null;
            while (!jobsQueued.isEmpty()) {
                
                Process job = jobsQueued.poll();                
                
                long elapsed = cpu.process(job, quantum);
                job.subtractFromRemainingTime(elapsed);
                currentTime += elapsed;
                if(job.getStartTime()==-1)job.setStartTime(currentTime);
                waitTimes+=currentTime;
                
                if (job.getRemainingTime() <= 0) {
                    job.setFinishedTime(currentTime);
                    jobsFinished.add(job);
                } else{                        
                    jobsQueued.add(job);
                }
                
                if(!job.equals(tempJob))cSwitch++;
                tempJob=job;
            } 
            timeFinished = currentTime;
        }
        
        /**
         * sets the timeSlice also known as the quantum
         * @param timeSlice 
         */
        public void setTimeSlice(long timeSlice){
            quantum = timeSlice;
        }
        
        /**
         * Time interval from the submission of the job until its completion
         * @return Average Turn Around Time
         */
        public long getAverageTurnAroundTime(){
            long tA=0;
            for(Process job:jobsFinished)
                tA+=job.getFinishedTime();
            return tA/jobsFinished.size();
        }
        
        /** 
         * sum of periods each job spent waiting in readyQueue
         * @return Average Waiting Time
         */
        public long getAverageWaitTime(){
            return waitTimes==0? -1 : waitTimes/jobsFinished.size();
        }
        
        /**
         * Number of jobs completed per unit time
         * @return calculated throughput
         */
        public float getThroughput(){
            return timeFinished==0? -1 : (float) (jobsFinished.size()/(timeFinished*cSwitch-1));
        }
        
        /**
         * Number of jobs completed per unit time
         * @return calculated throughput
         */
        public int getUtilization(){
            float cpuUtilization = timeFinished==0? -1 : (timeFinished/(timeFinished*cSwitch-1))*100;
            return (int) cpuUtilization;
        }
       
        @Override
        public String getStatistics(){
            StringBuilder sb = new StringBuilder();
            sb.append("***********Robin MEASUREMENTS*********\n");
            sb.append("** Ratio of Processing                : "+quantum+":"+(jobsFinished.size()-1)*quantum+" milliseconds\n");
            sb.append("** Context Switches                   : "+cSwitch+" switches \n");            
            sb.append("** Average Waiting Time               : "+getAverageWaitTime()+" ns \n");
            sb.append("** Average Turnaround Time            : "+getAverageTurnAroundTime()+" ns \n");
            sb.append("** CPU Throughput                     : "+getThroughput()+" ns \n");
            sb.append("** Estimated CPU Utilization          ~ "+getUtilization()+" % \n");
            sb.append(cpu.getStatistics());
            return sb.toString();
        }
}
