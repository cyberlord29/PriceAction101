/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * SIngleton to store a reference of an all Symbols List.
 * @author Man Eesh
 */
public class Symbols {
     
    private static Symbols myObj;
    private  ArrayList<Symbol> symbolList = new ArrayList<>();
    /**
     * Gets all latest equity symbols traded on the NSE today.
     */
    private Symbols(){
   
        // PARSE CSV
        // ADD DOWNLOAD FEATURE
        String csvFile = "CatchMarketData/cm"+Util.getDateReadable(System.currentTimeMillis()/1000 - 100000)+"bhav.csv";
        String line="";
        String splitBy=",";
        
        
        try( BufferedReader  br = new BufferedReader(new FileReader(csvFile))){
           line=br.readLine();
            while( (line=br.readLine()) != null ){
                
                String[] prop = line.split(splitBy);
                
                Symbol p = new Symbol(prop[0]);
                //System.out.println("HERE AGAIN :");
                symbolList.add(p);
                
                
                //System.out.println("Symbol [symbol= " + prop[0] + " , name=" + prop[1] + "]");

            }
            
        }
        catch(IOException e){System.out.println(e);}
        
    }
    /**
     * static method to get instance.
     * @return 
     */
    public static Symbols getInstance(){
        if(myObj== null){
            myObj = new Symbols();
        }
        return myObj;
    }
     
    /**
     * Gets ArrayList of Class Symbol.
     * @return
     */
    public ArrayList<Symbol> getSymbolList(){
        
        return symbolList;
        
       
    }

    @Override
    public String toString() {
        return symbolList.toString();
    }
     
    
}
