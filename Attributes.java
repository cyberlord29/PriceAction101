/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import java.lang.Character;
import java.lang.String;

/**
 * List of attributes and tags as in NSE's getQuote URI.
 * @author Man Eesh
 */
public enum Attributes {
    
 /*otherSeries("otherSeries"),
 lastUpdateTime("lastUpdateTime"),
 tradedDate("tradedDate"),
  */

    /**
     *
     */
    
 extremeLossMargin("extremeLossMargin"),  

    /**
     *
     */
    cm_ffm("cm_ffm"),

    /**
     *
     */
    bcStartDate("bcStartDate"),
 
    /**
     *
     */
    change("change"), 
 
    /**
     *
     */
    buyQuantity3("buyQuantity3"), 

    /**
     *
     */
    sellPrice1("sellPrice1"),
 
    /**
     *
     */
    buyQuantity4("buyQuantity4"), 
  
    /**
     *
     */
    sellPrice2("sellPrice2"),  

    /**
     *
     */
    priceBand("priceBand"),

    /**
     *
     */
    buyQuantity1("buyQuantity1"),

    /**
     *
     */
    deliveryQuantity("deliveryQuantity"),

    /**
     *
     */
    buyQuantity2("buyQuantity2"),
 
    /**
     *
     */
    sellPrice5("sellPrice5"), 

    /**
     *
     */
    quantityTraded("quantityTraded"),

    /**
     *
     */
    buyQuantity5("buyQuantity5"),

    /**
     *
     */
    sellPrice3("sellPrice3"),

    /**
     *
     */
    sellPrice4("sellPrice4"),
 
    /**
     *
     */
    open("open"), 
 
    /**
     *
     */
    low52("low52"), 

    /**
     *
     */
    securityVar("securityVar"),
 
    /**
     *
     */
    marketType("marketType"), 
 
    /**
     *
     */
    pricebandupper("pricebandupper"), 

    /**
     *
     */
    totalTradedValue("totalTradedValue"),

    /**
     *
     */
    faceValue("faceValue"),
 
    /**
     *
     */
    ndStartDate("ndStartDate"), 
 
    /**
     *
     */
    previousClose("previousClose"), 

    /**
     *
     */
    symbol("symbol"),
 
    /**
     *
     */
    varMargin("varMargin"), 
 
    /**
     *
     */
    lastPrice("lastPrice"), 
 
    /**
     *
     */
    pChange("pChange"), 
 
    /**
     *
     */
    adhocMargin("adhocMargin"), 
 
    /**
     *
     */
    companyName("companyName"), 
 
    /**
     *
     */
    averagePrice("averagePrice"), 
 
    /**
     *
     */
    secDate("secDate"), 

    /**
     *
     */
    series("series"),
 
    /**
     *
     */
    isinCode("isinCode"), 
 
    /**
     *
     */
    indexVar("indexVar"), 
 
    /**
     *
     */
    pricebandlower("pricebandlower"), 

    /**
     *
     */
    totalBuyQuantity("totalBuyQuantity"),

    /**
     *
     */
    high52("high52"),
 
    /**
     *
     */
    purpose("purpose"), 
 
    /**
     *
     */
    cm_adj_low_dt("cm_adj_low_dt"), 
 
    /**
     *
     */
    closePrice("closePrice"), 
 //isExDateFlag("isExDateFlag"),

    /**
     *
     */
     recordDate("recordDate"),
 
    /**
     *
     */
    cm_adj_high_dt("cm_adj_high_dt"), 
 
    /**
     *
     */
    totalSellQuantity("totalSellQuantity"), 

    /**
     *
     */
    dayHigh("dayHigh"),
 
    /**
     *
     */
    exDate("exDate"), 
 
    /**
     *
     */
    sellQuantity5("sellQuantity5"), 
 
    /**
     *
     */
    bcEndDate("bcEndDate"), 
 
    /**
     *
     */
    css_status_desc("css_status_desc"), 

    /**
     *
     */
    ndEndDate("ndEndDate"),
 
    /**
     *
     */
    sellQuantity2("sellQuantity2"), 
 
    /**
     *
     */
    sellQuantity1("sellQuantity1"), 
 
    /**
     *
     */
    buyPrice1("buyPrice1"), 
 
    /**
     *
     */
    sellQuantity4("sellQuantity4"), 

    /**
     *
     */
    buyPrice2("buyPrice2"),
 
    /**
     *
     */
    sellQuantity3("sellQuantity3"), 
 
    /**
     *
     */
    applicableMargin("applicableMargin"), 

    /**
     *
     */
    buyPrice4("buyPrice4"),
 
    /**
     *
     */
    buyPrice3("buyPrice3"), 
 
    /**
     *
     */
    buyPrice5("buyPrice5"), 
 
    /**
     *
     */
    dayLow("dayLow"), 

    /**
     *
     */
    deliveryToTradedQuantity("deliveryToTradedQuantity"),

    /**
     *
     */
    totalTradedVolume("totalTradedVolume");
 
    /**
     *
     */
    public String tag;
 
 
 Attributes(String tag){
 
     this.tag = tag;
 
 }

    /**
     * Gets the tag associated with a property which is used to retrieve the 
     * properties value from NSE's getQuote URI.
     * @return
     */
    public String getTag() {
        return this.tag;
    }
 

}