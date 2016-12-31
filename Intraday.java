/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import static javafx.application.Platform.exit;
import org.json.JSONException;

/**
 * Class to store Intraday Data and Interval based Data.
 * @author Man Eesh
 */
public class Intraday {
    
 
   private ArrayList<OHLCV> mins = new ArrayList<>();
                int  avm  = 0;
                int avh = 0;
                long start;
                int recent;
                long eod;
                int volumeHigh=0;
   
    /**
     * Makes OHLCV Array of 1min Intraday data from YFinance.
     * @param series
     * @param max
     */
    public Intraday(JSONArray series , long max){
       
       OHLCV min;
       int i=0;
       long t= 0;
     //CHECK MAX i FROM TIME RANGE
     try{  
      while(t <= max-80) {       
           t = series.getJSONObject(i).getLong("Timestamp");
               min = new OHLCV( series.getJSONObject(i).getDouble("open"),
                              series.getJSONObject(i).getDouble("high"),
                              series.getJSONObject(i).getDouble("low"),
                              series.getJSONObject(i).getDouble("close"),
                              series.getJSONObject(i).getInt("volume"),
                              t 
                            );
         
         
         
          mins.add(min);
          
          i++;
        }
      }catch(JSONException e){//System.out.println(e);
                                  this.recent = i-1;
                                  return;
                                }   
      
       this.recent = i-1;
       
   }

    /**
     * Returns ArrayList of OHLCV.
     * @return ArrayList
     */
    public ArrayList<OHLCV> getMins() {
        return mins;
    }
   
    /**
     * Returns Average Volume of the day based on Interval.
     * @param interval
     * @return int
     */
    public int  getav(String interval){
      
       int j=0;
       int av = 0;
        // System.out.println(this.recent);
       for(j=0 ; j <= recent ; j++)  
          av += this.mins.get(j).getVolume();
           
       if(null != interval)switch (interval) {
           case "h":
               av/=6.3;
               break;
           case "m":
               if(this.recent==0)return 0;
               av/= this.recent;
               break;               //GET PROPER DIVISOR FROM MoST RECENT 
           case "15m":
               av/=26;
               break;
           case "5m":
               av/=26*3;
               break;
       }  
   
   return av;
   
   }
   
    /**
     * Returns most recent quotes 1min volume. 
     * @return int 
     */
    public int getRecentVolume(){
      //string interval param
       int l;
        
       try{l = this.getMins().get(this.recent-1).getVolume();
       }catch(Exception e){l = 0;}
       
       return l;
       
   }
   //make more getters
}
