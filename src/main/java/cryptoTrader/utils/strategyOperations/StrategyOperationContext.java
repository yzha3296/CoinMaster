package cryptoTrader.utils.strategyOperations;

import cryptoTrader.entity.strategy.Strategy;
/**
 * This class is used to implement the transaction database update
 * @author CS2212 Group 11
 *
 */
public class StrategyOperationContext {
	
	/**
	 * private a operation for further use
	 */
    private StrategyOperation strategyOperation;
    
    /**
     * call the main method to invoke the implementation
     */
    public StrategyOperationContext() {
    }

    /**
     * Give a concrete strategy operation 
     * @param strategyOp A concrete strategy operation
     */
    public void setStrategyOp(StrategyOperation strategyOp) {
        this.strategyOperation = strategyOp;
    }


    /**
     * Perform the strategy operation and update the transaction database with
     * the input information as followings. Also handle the invalid situation where
     * the strategy could not be applied
     * 
     * @param isFail The indicator to show whether the operation is a fail one
     * @param trader The trader information
     * @param strategy The strategy information
     * @param quantity The cryptoCoin trading quantity
     * @param coin The trading cryptoCoins
     * @param price The price of the trading cryptoCoins
     */
    public void executeOperation(Boolean isFail, String trader, String strategy, int quantity, String coin, double price) {
        if (!isFail) {
            strategyOperation.writeTransactionDB(trader, strategy,quantity,coin,price);
        } else {
            strategyOperation.handleInvalidBroker(trader,strategy,coin);
        }
    }
}
