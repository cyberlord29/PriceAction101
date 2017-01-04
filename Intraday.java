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
public class Intraday  {
    
    
   public ArrayList<OHLCV> mins = new ArrayList<>();
                
                long min;
                int  recent = 0;
                long max;
                int  totalVolume=0;
     private String symbol ;
   
     public Intraday(String symbol)throws Exception{
         
         this.symbol = symbol;
         this.getIntraday();
         
         
     }    
     
     
     
    /**
     * Makes OHLCV Array of 1min Intraday data from YFinance.
     * @param series
     * @param max
     * @param range
     */
    public void makeIntraday(JSONArray series , long max , long min){
       
       OHLCV minute;
       int i=this.recent;  // enables implicit updation w/o new OHLCV object
       long t= 0;
     //CHECK MAX i FROM TIME RANGE
       this.max = max;
       this.min = min;
      
       
       try{  
      while(t <= max-80) {       
           t = series.getJSONObject(i).getLong("Timestamp");
              
           minute = new OHLCV( series.getJSONObject(i).getDouble("open"),
                              series.getJSONObject(i).getDouble("high"),
                              series.getJSONObject(i).getDouble("low"),
                              series.getJSONObject(i).getDouble("close"),
                              series.getJSONObject(i).getInt("volume"),
                              t 
                              );
               
               
          this.mins.add(minute);
          i++;
        }
      }catch(JSONException e){
           //System.out.println(e);
           //System.out.println(e);
                                  
                                }   
      finally{
           int j;
          for(j=this.recent ; j <= i-1 ; j++)  
          this.totalVolume += this.mins.get(j).getVolume();     
       this.recent = i-1;
      // System.out.println( i-1);
       }
       
   }
    
    
     public void getIntraday() throws Exception{
   
        
       JSONObject json = GetMaster.getJSON(this.symbol,1);
       
       JSONArray series = json.getJSONArray("series");
       long max   = json.getJSONObject("Timestamp").getLong("max");
       long min   = json.getJSONObject("Timestamp").getLong("min");
       //  System.out.println("masdf: ");
     
      
      this.makeIntraday(series,max,min);
    //  }catch(Exception e){System.out.println("getIntraday() : "+symbol + e);}  
      // System.out.println(newday.getMins().toString());
       
      
    }

    /**
     * Returns ArrayList of OHLCV.
     * @return ArrayList
     */
    public ArrayList<OHLCV> getMins() {
        return mins;
    }
   
    
    public int getAV(int mins){
     
        int av = this.totalVolume/(this.recent+1);
        return av*mins;
    
    }
    
     public int getAV(){
     
        int av = this.totalVolume/(this.recent+1);
        return av;
    
    }
    
    
   
    /**
     * Returns most recent quotes 1min volume. 
     * @return int 
     */
    public int getRecentVolume(){
      //string interval param
       int rv;
        
       try{rv = this.getMins().get(this.recent-1).getVolume();
      }catch(Exception e){rv = 0;}
       
       return rv;
       
   }
    
    
    
     public int getRecentVolume(int mins){
      //string interval param
       int rv;
        
       try{rv = this.getMins().get(this.recent-1-mins).getVolume();
       }catch(Exception e){rv = 0;}
       
       return rv;
       
   }
    
}
