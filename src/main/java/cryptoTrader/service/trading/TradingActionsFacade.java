package cryptoTrader.service.trading;
/**
 * This class is used to execute the previously defined 'displayCoinData',
 * 'NotifyBroker', and 'PerformStrategyAnalysis' method
 * @author CS2212 Group 11
 * @version 0.9
 * @since 2022-03-25
 *
 */
public class TradingActionsFacade {
	/**
	 * private the new DisplayCoinData type variable for further use
	 */
    private DisplayCoinData displayCoinData;
    /**
	 * private the new NotifyBroker type variable for further use
	 */
    private NotifyBroker notifyBroker;
    
    /**
	 * private the new PerformStrategyAnalysis type variable for further use
	 */
    private PerformStrategyAnalysis performStrategyAnalysis;


    /**
     * This method is to create new objects 
     */
    public TradingActionsFacade () {
        displayCoinData = new DisplayCoinData();
        notifyBroker = new NotifyBroker();
        performStrategyAnalysis = new PerformStrategyAnalysis();
    }

    /**
     * Perform the trade and do the requested job
     */
    public void performTradingActions() {
        // step1&2: initiate the retieval of the current cryptocoin prices
        // Notify the different trading brokers by passing the appropriate prices to the right trading broker.
        notifyBroker.updateBrokerCoinPrice();
        // step3: perform strategy computations
        performStrategyAnalysis.AnalyzeStrategy();
        displayCoinData.visualizationGenerator();
    }
}
