package depreciated;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/** 
 *
 * @author Kyle Williams
 */
public class Robin{
    private int i;  
    private String name;
    public Robin(String name, int i) {  
        this.i = i;  
        this.name=name;
    }  

    public int perform(int tS) { 
        i -= tS;
        return i;  
    }

    public boolean isCompleted() {
        return i<=0;
    }
    
    public int remaingTime(){return i;}
    
    @Override
    public String toString(){
        return name +" with "+i+" remaning";
    }
    
    public String getName(){return name;}
            
}
