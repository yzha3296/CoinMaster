package cryptoTrader.entity;

/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that contains 
 * methods regarding the operation 
 * of client trading records .
 */

import java.util.*;

/**
 * This is the main class of the file.
 */

public class ClientTradingRecord {
    private String clientName;
    private Map<String, Integer> countMap = new HashMap<>();

    private List<Integer> count1 = new ArrayList<>();
    
    /**
     * This method initiate the countMap.(strategy)
     * @param name client's name
     */

    public ClientTradingRecord(String name) {
        this.clientName = name;
        // initialize the countMap
        countMap.put("Strategy-A", 0);
        countMap.put("Strategy-B", 0);
        countMap.put("Strategy-C", 0);
        countMap.put("Strategy-D", 0);
        countMap.put("Strategy-E", 0);
    }

    /**
     * This method set the client's name.
     * @param name client's name
     */

    public void setClientName(String name) {
        this.clientName = name;
    }

    /**
     * This method get the client's name.
     * @return return client's name
     */

    public String getClientName() {
        return clientName;
    }
    
    /**
     * This method update count of strategy that has been applied.
     * @param strategy Indication of which strategy been practiced
     * @param count Update the count
     */

    public void updateCount(String strategy, int count) {
        countMap.put(strategy, count);
    }
    
    

    /**
     * This method increase the count of the strategy by one
     * @param strategy Indication of which strategy's count to be updated
     */

    public void increaseCountByOne(String strategy) {
        int count = countMap.get(strategy) + 1;
        countMap.put(strategy, count);
    }

    /**
     * This method get the number of times that strategy A has been practiced. 
     * @return return the number of times that strategy A has been practiced
     */

    public int getStrategyACount() {
        return countMap.get("Strategy-A");
    }

    /**
     * This method get the number of times that strategy B has been practiced. 
     * @return return the number of times that strategy B has been practiced
     */

    public int getStrategyBCount() {
        return countMap.get("Strategy-B");
    }
    
    /**
     * This method get the number of times that strategy C has been practiced. 
     * @return return the number of times that strategy C has been practiced
     */

    public int getStrategyCCount() {
        return countMap.get("Strategy-C");
    }


   

    /**
     * This method get the number of times that strategy D has been practiced. 
     * @return return the number of times that strategy D has been practiced
     */
    public int getStrategyDCount() {
        return countMap.get("Strategy-D");
    }

    /**
     * This method get the number of times that strategy E has been practiced. 
     * @return return the number of times that strategy E has been practiced
     */
    public int getStrategyECount() {
        return countMap.get("Strategy-E");
    }
}
