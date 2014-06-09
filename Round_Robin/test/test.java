import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.ProcCpu;
import org.hyperic.sigar.ProcState;
import org.hyperic.sigar.ProcTime;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.SigarProxyCache;
import org.hyperic.sigar.cmd.Shell;

public class test {
 
	private static Sigar sigar = new Sigar();

	public static void main(String[] args) {
		getInformationsAboutCPU();                
		getInformationsAboutMemory();
		getInformationsAboutFileSystem();
                getInformationAboutCPUusage(sigar.getPid());
                
	}
       
	/* Method to get Informations about the CPU(s): */
	public static void getInformationsAboutCPU() {
                System.out.println("************************************");
                System.out.println("*** Informations about the CPUs: ***");
                System.out.println("************************************\n");

                CpuInfo[] cpuinfo = null;
                try {
                        cpuinfo = sigar.getCpuInfoList();
                } catch (SigarException se) {
                        se.printStackTrace();
                }

                System.out.println("---------------------");
                System.out.println("Sigar found " + cpuinfo.length + " CPU(s)!");
                System.out.println("---------------------");

                for (int i = 0; i < cpuinfo.length; i++) {
                        Map map = cpuinfo[i].toMap();
                        System.out.println("CPU " + i + ": " + map);
                }

                System.out.println("\n************************************\n");
	}

        
        private static void getInformationAboutCPUusage(long pid) {
        try {
            ProcCpu procCPU = sigar.getProcCpu(pid); //-> Main Change
            ProcState procState = sigar.getProcState(pid);
            ProcTime procTime = sigar.getProcTime(pid);

            String processName = procState.getName();
            String cpuPercentage = CpuPerc.format(procCPU.getPercent());
            float totalProcessTime = procTime.getTotal();

            System.out.println(pid + "\t\t" + processName + "\t\t" + cpuPercentage + "\t\t" + totalProcessTime);
        } catch (SigarException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
	/* Method to get Informations about the Memory: */
	public static void getInformationsAboutMemory() {
		System.out.println("**************************************");
		System.out.println("*** Informations about the Memory: ***");
		System.out.println("**************************************\n");

		Mem mem = null;
		try {
			mem = sigar.getMem();
		} catch (SigarException se) {
			se.printStackTrace();
		}

		Map map = mem.toMap();
		System.out.println(map);

		System.out.println("\nPretty printed:");
		System.out.println("---------------");
		System.out.println("Actual total free system memory: "
				+ mem.getActualFree() / 1024 + " KB");
		System.out.println("Actual total used system memory: "
				+ mem.getActualUsed() / 1024 + " KB");
		System.out.println("Total free system memory ......: " + mem.getFree()
				/ 1024 + " KB");
		System.out.println("System Random Access Memory....: " + mem.getRam()
				+ " MB");
		System.out.println("Total system memory............: " + mem.getTotal()
				/ 1024 + " KB");
		System.out.println("Total used system memory.......: " + mem.getUsed()
				/ 1024 + " KB");

		System.out.println("\n**************************************\n");
	}

	/* Method to get Informations about the FileSystem: */
	public static void getInformationsAboutFileSystem() {
		System.out.println("******************************************");
		System.out.println("*** Informations about the FileSystem: ***");
		System.out.println("******************************************\n");

		FileSystem[] filesystem = null;
		try {
			filesystem = sigar.getFileSystemList();
		} catch (SigarException se) {
			se.printStackTrace();
		}

		System.out.println("---------------------");
		System.out.println("Sigar found " + filesystem.length + " drives!");
		System.out.println("---------------------");

		for (int i = 0; i < filesystem.length; i++) {
			Map map = filesystem[i].toMap();
			System.out.println("drive " + i + ": " + map);
		}

		System.out.println("\n******************************************");
	}

    

}