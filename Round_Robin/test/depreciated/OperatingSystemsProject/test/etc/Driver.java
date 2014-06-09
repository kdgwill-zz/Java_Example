/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package depreciated.OperatingSystemsProject.test.etc;


/**
 *
 * @author Kyle Williams
 */
public class Driver {
    
    public static void main(String[] arg){
        String[] args = {"12"};
        if(args.length>0){
            if(Integer.parseInt(args[0])<0){
                System.err.println(args[0] + "must be >= 0.");
            } else {
                //create the object to be shared
                Sum sumObject = new Sum();
                int upper = Integer.parseInt(args[0]);
                Thread thrd = new Thread(new Summation(upper, sumObject));
                thrd.start();
                try{
                    thrd.join();
                    System.out.println("The sum of "+upper+" is "+sumObject.getSum());
                }catch(InterruptedException ie){}
            }
        }else{
            System.err.println("Ussage: summation <intger value>");
        }
    }
    
    
    
    
    
}
