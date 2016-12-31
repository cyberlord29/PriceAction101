/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup; 
import org.jsoup.nodes.Element;
import org.json.JSONObject;
import org.json.JSONArray;
import PriceAction101.Attributes;
import org.json.JSONException;

/**
 * Extracting and transforming stock data on NSE and YFin.
 * @author Man Eesh
 */
public class GetMaster {
    
    
   //.................................Return all values.
    
    /**
     * Gets Live Quote from NSE getQuote URI.
     * @param Symbol
     */
        
    
  public static void getQuote(String Symbol){    
        
   try{
               
               JSONObject json = getJSON(Symbol);
               JSONArray  data = json.getJSONArray("data");
               for(  Attributes a : Attributes.values() ){
                   
                               
                 System.out.println(a.name()+ " : " 
                                
                       + data.getJSONObject(0).getString(a.getTag()));  
               }
               
                
      }  
 
      catch(Exception e){System.out.print(e);}
    
 }
  
    /**
     * Gets JSONObject of Stock and quote data.
     * @param Symbol
     * @return responseDiv
     */
    public static JSONObject getJSON(String Symbol) {
        
      try{
       
          
         Document doc = Jsoup.connect(Util.BASE_GETQUOTE + Symbol).timeout(0).get(); 
         Element box = doc.getElementById("responseDiv");
           
         String raw = box.text();
         //System.out.println(doc.text());
         JSONObject json = new JSONObject(raw); 
         return json;
     
      }
    
      catch(Exception e)
      {
          System.out.println("getJSON : "+ e + " ");
          return null;                 
      }
    }
    
    /**
     * Gets Latest Intraday data.
     * @param Symbol
     * @param days
     * @return Intraday Object
     * @throws Exception
     */
    public static Intraday getQuoteIntraday(String Symbol,int days)throws Exception{
   
       JSONObject json = getJSON(Symbol,days);
       
       JSONArray series = json.getJSONArray("series");
       long max   = json.getJSONObject("Timestamp").getLong("max");
       
       Intraday newday =  new Intraday(series,max);
       
      // System.out.println(newday.getMins().toString());
       
      return newday;
   }
   
   
   
   private static JSONObject getJSON(String Symbol,int days){
       
       ///////..............GET json...........DEFINE STRUCTURE IN API  ........ GETMETHODS FOR ALL DATA .....
       
     try{
         Document doc = Jsoup.connect( Util.getQuoteIntraURL(Symbol,1)).timeout(0).get(); 
         String   raw = doc.text();
        
         raw  = raw.replaceFirst("finance_charts_json_callback","");
         raw  = raw.replace(")","");
         raw  = raw.replace("(","");
         //System.out.printf(raw);
         JSONObject json = new JSONObject(raw); 
         return json;
     }
     
     catch(Exception e){
         System.out.print(e);
         return null;
     }
   
   }
   
    /**
     * Indicator to Detect Volume spike based on VWAP algorithm.
     * (presently running simple average)
     * @param Symbol
     * @throws Exception
     */
    public static void getSpike(String Symbol) throws Exception{
       
       Intraday newday = getQuoteIntraday(Symbol,1);
       
       int av = newday.getav("m");
       int recentVolume = newday.getRecentVolume();
       
       
       //System.out.println( Integer.toString(av) +"  " + Integer.toString(recent));
       
       //System.out.println("Symbol  :  "+Symbol +"\nRecent Volume : "+ Integer.toString(recentVolume) + "  , Average Volume : "+Integer.toString(av) );
      
       if(recentVolume > 1.5*av){
           
           
           System.out.println("-------------------------\n\n        SPIKE AT : "+ Symbol 
                               +  Util.getTimeReadable(newday.getMins().get(newday.recent).getTimestamp() ) +"\n\n-------------------------"  );
           
       }
       
       
   
   }
   
    /**
     * Gets Basic Quote information to STD_OUTPUT for testing.
     * @param Symbol
     */
    public static void getBasic(String Symbol){
       try{
               
               JSONObject json = getJSON(Symbol);
               JSONArray  data = json.getJSONArray("data");
               //for(  Attributes a : Attributes.values() ){
                   
                               
                 System.out.println("\nCompany : " 
                                
                       + data.getJSONObject(0).getString("companyName") 
                         
                          + "\nPrice : " + data.getJSONObject(0).getString("lastPrice")
                              
                              +"  Traded Volume : "+data.getJSONObject(0).getString("totalTradedVolume"));  
               //}
               
                
      }  
 
      catch(Exception e){System.out.print("Get Basic:"+e);}
   }
   
 }
    
    