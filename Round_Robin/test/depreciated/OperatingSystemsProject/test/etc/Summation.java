/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package depreciated.OperatingSystemsProject.test.etc;

/**
 *
 * @author Kyle Williams
 */
public class Summation implements Runnable{
        private int upper;
        private Sum sumValue;
        
        public Summation(int upper, Sum sumValue){
            this.upper = upper;
            this.sumValue = sumValue;
        }
        
        public void run(){
            int sum =0;
            for(int i=0; i<=upper; i++){
                sum+=i;
                sumValue.setSum(sum);
            }
        }
}
