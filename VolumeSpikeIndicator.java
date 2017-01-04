/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import java.net.ConnectException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Temporary class for spawning and testing threads.
 * The run() method contains testing code snippets.
 * 
 * @author Man Eesh
 */
public class VolumeSpikeIndicator  extends Thread{
    
    private Symbol s;
    private Intraday newday;
    private int intervalMins;
    
    /**
     * Initializes Symbol Object of Class Runner.
     * @param s
     */
    public VolumeSpikeIndicator(Symbol s){
       // newday = new Intraday(s.toStringYahoo());
        this.s = s;
        
    }

   
   
       
 
    
    @Override
    public void run() {
       
        if(newday==null){
            try{ 
         
           newday = new Intraday(s.toStringYahoo());
       
       }catch(Exception g){System.out.println(" REMOVED : "+s.toStringNSE());
                                    return;}
   
        }
       
       
        Thread.currentThread().setName(s.toStringNSE());
        
      //   System.out.println(s.toStringNSE());
        
        while(true) {
           
          
           //  for (Iterator<Symbol> it = this.s.getSymbolList().iterator(); it.hasNext();) {
             //   Symbol a = it.next();
        try{ 
                    
                   // GetMaster.getSpike(s.toStringYahoo());
                     // GetMaster.getBasic(s.toString());
             int av = newday.getAV();
             int recentVolume = newday.getRecentVolume();
                      
                 
            System.out.println(s.toStringNSE());
               if(recentVolume > 1.5*av){
           
                         
                    System.out.println("-------------------------\n\n SPIKE AT : "
                                           +  s.toStringYahoo() 
                                    +  Util.getTimeReadable(newday.getMins()
                                            .get(newday.recent).getTimestamp() ) 
                               +"\n\n-------------------------"  );
           
                }

            Thread.sleep(0xc350);
                     
            }
                
                catch(InterruptedException e){break;}
                         
                catch(Exception f){System.out.println(" REMOVED B : " +
                                                                s.toStringNSE());
                                     return;
                }
        }
            
           
            /*
                try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }*/
            
            
  }

}

    

