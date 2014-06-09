/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package depreciated.OperatingSystemsProject.test;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import javax.management.MBeanServerConnection;

/**
 *
 * @author Kyle Williams
 */
public class MemoryUsage {
    public static void main(String[] args) throws InterruptedException, IOException{
          
                
                Runtime runtime = Runtime.getRuntime();

                NumberFormat format = NumberFormat.getInstance();

                StringBuilder sb = new StringBuilder();
                long maxMemory = runtime.maxMemory();
                long allocatedMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                sb.append("free memory: " + format.format(freeMemory / 1024) + "\n");
                sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "\n");
                sb.append("max memory: " + format.format(maxMemory / 1024) + "\n");
                sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "\n");
                sb.append("cpuload  " + format.format(allocatedMemory-freeMemory));

                System.out.println(sb);
                
              
                
          }
        
}
