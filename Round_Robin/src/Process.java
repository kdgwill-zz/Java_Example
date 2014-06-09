



/** 
 * Object representing a Job (Process) that Scheduler can process.
 * @author Kyle D. Williams
 */
public class Process { 
    private long timeLeft;
    private long startTime;    
    private long finishTime;
    private final String name;
    private final long burstTime;
    
    
    public Process(String name, long burstTime) {
            this.name = name;
            this.burstTime = burstTime;
            this.timeLeft = burstTime;
            startTime=-1;
            finishTime = -1;
    }

    public String getName() {
        return name;
    }
    
    public long getCpuBurst() {
        return burstTime;
    }

    public void setStartTime(long time) {
        startTime = time;
    }
        
    public long getStartTime() {
        return startTime;
    }
    
    public void setFinishedTime(long time){
        finishTime = time;
    }
    public long getFinishedTime(){
        return finishTime;
    }
    
    public void setRemainingTime(long time) {
        timeLeft = time;
    }
    
    public long getRemainingTime() {
        return timeLeft;
    }
    
    public void subtractFromRemainingTime(long elapsed){
        timeLeft-=elapsed;
    }
}
