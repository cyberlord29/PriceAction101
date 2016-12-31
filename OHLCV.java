/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

/**
 * Object to store basic OpenHighLowCloseVolume Data.
 * @author Man Eesh
 */
public class OHLCV {
    
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final int    volume;
    private final long timestamp;
   
    /**
     * Initializes OHLCV with values.
     * @param open
     * @param high
     * @param low
     * @param close
     * @param volume
     * @param timestamp
     */
    public OHLCV(double open, double high, double low, double close, int volume, long timestamp) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     */
    public double getOpen() {
        return open;
    }

    /**
     *
     * @return
     */
    public double getHigh() {
        return high;
    }

    /**
     *
     * @return
     */
    public double getLow() {
        return low;
    }

    /**
     *
     * @return
     */
    public double getClose() {
        return close;
    }

    /**
     *
     * @return
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns time in epoch.
     * @return epoch
     */
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "OHLCV{" + "open=" + open + ", high=" + high +
                ", low=" + low + ", close=" + close + ", volume=" 
                + volume + ", timestamp=" + Util.getTimeReadable(timestamp) + '}' +"\n";
    }
   

   
}