/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package depreciated.OperatingSystemsProject.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Kyle Williams
 */
public class ProcessTest {
    public static void main(String[] args) throws IOException{
        ProcessBuilder pb = new ProcessBuilder("notepad.exe", "service.log");
         Map<String, String> env = pb.environment();
         env.put("VAR1", "myValue");
         env.remove("OTHERVAR");
         env.put("VAR2", env.get("VAR1") + "suffix");
         pb.directory(new File("C:/"));
         Process p = pb.start();     
         
    }
}
