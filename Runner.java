/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import java.util.Iterator;

/**
 * Temporary class for spawning and testing threads.
 * The run() method contains testing code snippets.
 * 
 * @author Man Eesh
 */
public class Runner  extends Thread{
    
    private Symbol s;

    /**
     * Initializes Symbol Object of Class Runner.
     * @param s
     */
    public Runner(Symbol s){
     
        
        this.s = s;
        
    }

   
   
    
    @Override
    public void run() {
        
        // Loop for ten iterations.
        
        while(true) {
           
          
           //  for (Iterator<Symbol> it = this.s.getSymbolList().iterator(); it.hasNext();) {
             //   Symbol a = it.next();
                try{ 
                    
                    //GetMaster.getSpike(s.toString());
                      GetMaster.getBasic(s.toString());
                     Thread.sleep(0xc350);
               
                }
                
                catch(InterruptedException e){break;}
                         
                catch(Exception f){this.interrupt();}
        }
            
           
            /*
                try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }*/
            
            
  }

}

    

