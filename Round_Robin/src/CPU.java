



import java.util.logging.*;
import org.hyperic.sigar.*;

/** 
 * CPU this is the mock CPU class this is where the code is implemented
 * Due to Java's inability to access native system information other than in a strenuous 
 * roundabout way, the Sigar API was added in order to get past this
 * 
 * @author Kyle D. Williams
 */
public class CPU {
        private Sigar sigar = new Sigar();
    
        /** 
         * Concept Execute a Process for a specified time.
         * @param Process the process to simulate
         * @param sec the amount of time the job is allowed to be ran
         * @return the amount of time the process has left
         */
        public long process(Process job) {
            process(); 
            return job.getRemainingTime();
        } 

        /** 
         * Concept Execute a Process for a specified time, or its completion. This should be used for precision
         * @param Process the process to simulate
         * @param sec the amount of time the job is allowed to be ran
         * @return the amount of time the process has left
         */
        public long process(Process job, long sec) {
            process();
            return Math.min(sec, job.getRemainingTime());
        }
        
        /**
         * Process must be run every cpu cycle in order to get accurate CPU readings
         */
        private void process(){
        try {
            long pid = sigar.getPid();
                ProcCpu procCPU = sigar.getProcCpu(pid);
                procCPU.getPercent();
        } catch (SigarException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        /**
         * Returns the current HardwareTime in seconds
         * @return 
         */
        public float getCurrentTime(){
            try {
                long pid = sigar.getPid();
                return sigar.getProcTime(pid).getTotal();
            } catch (SigarException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        }
        
        /**
         * @return Required HardWare Statistical Data
         */
        public String getStatistics(){
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("***********HARDWARE MEASUREMENTS*********\n");
                //GETS CPU STATISTICS
                long pid = sigar.getPid();
                ProcCpu procCPU = sigar.getProcCpu(pid);                
                ProcTime procTime = sigar.getProcTime(pid);

                String cpuPercentage = CpuPerc.format(procCPU.getPercent());
                float totalProcessTime = procTime.getTotal();
                
                sb.append("** Total CPU Usage                    : " + cpuPercentage+"\n");
                sb.append("** Total Process Time                 : " + totalProcessTime+" ns \n"); 
                //DONE
		sb.append("**************************************");
                
                return sb.toString();
            } catch (SigarException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        /**
         * @return Full HardWare Statistical Data
         */
        public String getTotalStatistics(){
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("***********HARDWARE MEASUREMENTS*********\n");
                //GETS CPU STATISTICS
                long pid = sigar.getPid();
                ProcCpu procCPU = sigar.getProcCpu(pid);                
                ProcTime procTime = sigar.getProcTime(pid);

                String cpuPercentage = CpuPerc.format(procCPU.getPercent());
                float totalProcessTime = procTime.getTotal();
                
                sb.append("** Total CPU count                    : " + sigar.getCpuInfoList().length+"\n");
                sb.append("** Total CPU Usage                    : " + cpuPercentage+"\n");
                sb.append("** Total Process Time                 : " + totalProcessTime+" ns \n"); 
                //GETS MEMORY STATISTICS
                Mem mem = sigar.getMem();
		sb.append("** Actual total free system memory    : "+ mem.getActualFree() / 1024 + " KB\n");
		sb.append("** Actual total used system memory    : "+ mem.getActualUsed() / 1024 + " KB\n");
		sb.append("** Total free system memory           : " + mem.getFree()/ 1024 + " KB\n");
		sb.append("** System Random Access Memory        : " + mem.getRam()+ " MB\n");
		sb.append("** Total system memory                : " + mem.getTotal()/ 1024 + " KB\n");
		sb.append("** Total used system memory           : " + mem.getUsed()/ 1024 + " KB\n");
                //DONE
		sb.append("**************************************");
                
                return sb.toString();
            } catch (SigarException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
}
