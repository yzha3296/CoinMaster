/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This file includes the set and get 
 * methods regarding traders' name, 
 * their interested coin tickers, and 
 * strategies.
 */

package cryptoTrader.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the primary class of this file.
 */
public class TradingBroker {
	
	/**
	 * Initiate the variables of clientName, coinList, strategy, coinPrice and validity
	 */
    private String clientName;
    private String[] coinList;
    private String strategy;
    private Map<String,Double> coinPrice;
    private boolean isValid;
    
    /**
     * This method set clientName, coinList and strategy as parameters of TradingBroker method.
     * @param clientName trader's name
     * @param coinList trader's interested coin list
     * @param strategy trader's strategy
     */
    public TradingBroker(String clientName, String[] coinList, String strategy) {
        this.clientName = clientName;
        this.coinList = coinList;
        this.strategy = strategy;
        this.coinPrice = new HashMap<>();
    }
    
    /**
     * This method get client name.
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }
    
    /**
     * This method set client name.
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * This method get CoinList.
     * @return Interested coin List
     */
    public String[] getCoinList() {
        return coinList;
    }

    /**
     * This method set CoinList.
     * @param coinList 
     */
    public void setCoinList(String[] coinList) {
        this.coinList = coinList;
    }
    
    /**
     * This method get Strategy.
     * @return strategy
     */
    public String getStrategy() {
        return strategy;
    }
    
    /**
     * This method get broker's status.
     * @return duplication validity 
     */
    public boolean getBrokerStatus() {
        return this.isValid;
    }
    
    /**
     * This method set Strategy.
     * @param strategy
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    /**
     * This method update interested coin prices.
     * @param coin coin's ticker
     * @param price coin's price
     */
    public void updateCoinPrice(String coin, double price) {
        coinPrice.put(coin, price);
    }
    /**
     * This method get coins' prices.
     * @return coins' prices
     */
    public Map<String, Double> getCoinPriceMap() {
        return this.coinPrice;
    }
    
    /**
     * This method update broker's duplication status
     * @param status boolean variable indicating duplication status
     */
    public void updateBrokerStatus(boolean status) {
        this.isValid = status;
    }

}
