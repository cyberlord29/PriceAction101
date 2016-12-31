/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Man Eesh
 */

package PriceAction101;

import java.text.DateFormatSymbols;
import java.util.Date;

/**
 * Class containing Utility Methods.
 * @author Man Eesh
 */
public class Util {
    
    /**
     *
     */
    public static final String BASE_GETQUOTE       = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol=";

    /**
     *
     */
    public static final String BASE_GETQUOTEHIST   = "http://chartapi.finance.yahoo.com/instrument/1.0/" + "/chartdata;type=quote;range=1y/csv";

    /**
     *
     */
    public static final String BASE_GETCMDAILY     = "https://www.nseindia.com/content/historical/EQUITIES/2016/DEC/cm28DEC2016bhav.csv.zip";
  // public static final String 
    
    /**
     * 
     * @param Symbol
     * @return String url
     */
    public static String getQuoteURL(String Symbol){
  
      return  "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol=" + Symbol;
    }
    
    /**
     *Gets Download link of Catch Market Data
     * @return String url
     */
    public static String getCMURL(){
    
       long epoch = System.currentTimeMillis()/1000;
        String date = getDateReadable(epoch);
        String month =getMonthCaps(epoch);
        
        return "https://www.nseindia.com/content/historical/EQUITIES/2016/" + month + "/cm" + date + "bhav.csv.zip";
    
    
    }
    
    /**
     *
     * @param epoch
     * @return String url
     */
    public static String getCMURL(long epoch){
        
        String date = getDateReadable(epoch);
        String month =getMonthCaps(epoch);
       return "https://www.nseindia.com/content/historical/EQUITIES/2016/" + month + "/cm" + date + "bhav.csv.zip";
        
        
    }
      
    /**
     *
     * @param Symbol
     * @param days
     * @return String url
     */
    public static String getQuoteIntraURL(String Symbol,int days){
         
         
         String d ="d"; 
         String y ="y";
         String m ="m";
         String ID;
   
      return   "http://chartapi.finance.yahoo.com/instrument/1.0/" + Symbol + "/chartdata;type=quote;range=" + Integer.toString(days) + "d/json";
    }
    
    /**
     *
     * @param epoch
     * @return
     */
    public static String getTimeReadable(long epoch){
     
     String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch*1000));
     
     return date;
     }
     
    /**
     * Gets date in the format ddMMMyyyy with month letters in CAPSLOCK.
     * @param epoch
     * @return Date
     */
    public static String getDateReadable(long epoch){
     
     String date = new java.text.SimpleDateFormat("ddMMMyyyy").format(new java.util.Date (epoch*1000));
     
     date = date.toUpperCase();
     
     
     return date;
     }
     
    /**
     * Gets three lettered month in CAPSLOCK
     * @param epoch
     * @return MON
     */
    public static String getMonthCaps(long epoch){
     
     String date = new java.text.SimpleDateFormat("MMM").format(new java.util.Date (epoch*1000));
     
     date = date.toUpperCase();
     
     
     return date;
     }
     
     
}
