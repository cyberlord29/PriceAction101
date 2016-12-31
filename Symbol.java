/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

/**
 * Class to store Equity entity and its properties.
 * @author Man Eesh
 */
public class Symbol {
    
    private String symbol;
   //private String companyName;
  //  private String series;
    private final String suffix =".NS";

    /**
     *
     * @param symbol
     */
    public Symbol(String symbol) {
        this.symbol = symbol;
        //this.companyName = companyName;
    }

    /**
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

  /*  public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    */

    /**
     * Symbol representation without .NS suffix.
     * @return
     */
    public String toStringNSE() {
        return symbol ;
    }
    
    /**
     * Symbol representation with .NS suffix
     * @return
     */
    public String toStringYahoo(){
        return symbol+suffix;
    }
    
   
    
    
    
    
}
