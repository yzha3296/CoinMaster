
package cryptoTrader.utils.strategyOperations;

/**
 * Create an interface named 'StrategyOperation' where 
 * the 'writeTransactionDB' and 'handleInvalidBroker' methods
 * are grouped with empty bodies
 * strategy design pattern used
 * @author CS2212 Group 11
 */
public interface StrategyOperation {
	/**
	 * Make an abstract 'writeTransactionDB' method
	 * @param trader Trader name
	 * @param strategy Applied strategy
	 * @param quantity Trading quantity
	 * @param coin Trading cryptoCoin
	 * @param price cryptoCoin price
	 */
    public void writeTransactionDB(String trader, String strategy, int quantity, String coin, double price);
    
    /**
     * Make an abstract 'handleInvalidBroker' method
     * @param trader Trader name
     * @param strategy Applied strategy
     * @param coin cryptoCoin 
     */
    public void handleInvalidBroker(String trader, String strategy, String coin);
}