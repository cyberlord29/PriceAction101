/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import static PriceAction101.Symbols.getInstance;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup; 
import org.jsoup.nodes.Element;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;


/**
 *
 * @author Man Eesh
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //     TODO
     
     //   GetMaster.getQuoteIntraday("BHEL.NS",1);                                .... GET INTRADAY
   /*   while(true){
        GetMaster.getSpike("BHEL.NS");
       try{sleep(50000);}catch(Exception e){System.out.println(e);}                ..... VOLUMESPIKE INDICATOR
      }
    */
        
    /*   long epoch =  System.currentTimeMillis()/1000;                      
       int i = 0;                                                                 ...... AUTO DOWNLOAD
     
       while(i<=730){
        System.out.println("\n\n\nDownloading...");
         Download.downloadFileUnzip("CatchMarketData",Util.getCMURL(epoch - 86400*i));
        i++;
       }
        
        */
        
     /*
      Symbols s = getInstance();  
      
      System.out.println(s.toString());                                           ..... SYMBOLS LIST
     */
        
        
      
   /*   Symbols s = getInstance();
      ArrayList<Symbol> e  = s.getSymbolList();
     //System.out.println(e.get(1).toString());
     
        for (Symbol a : s.getSymbolList()) {
          
            GetMaster.getBasic(a.toStringNSE());
            
        }
    */
        
        Symbols s = getInstance();
     /*   
        while(true){
           
            for (Iterator<Symbol> it = s.getSymbolList().iterator(); it.hasNext();) {
                Symbol a = it.next();
                try{ GetMaster.getSpike(a.toStringYahoo());
                }catch(Exception e){it.remove();}
                        }   }
        
       
        */
        

        ArrayList<VolumeSpikeIndicator> threadpool = new ArrayList<>();
    
   
for (Iterator<Symbol> it = s.getSymbolList().iterator(); it.hasNext();){
        
           threadpool.add(new VolumeSpikeIndicator(it.next()));
            
        
      }
        
       
       System.out.println("GOING TO START");
       int a = threadpool.size();
       int i;
       for(i = 0 ; i<a ; i++){
      try{ Thread.sleep(15);
           threadpool.get(i).start();
        }catch(InterruptedException e){System.out.println("Main Thread :"+ e );}
       
       
        
    }
           
} 
}
        
  

    
    
    
 
 
