package cryptoTrader.entity.strategy;
/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that include strategy in the UI.
 */

import cryptoTrader.entity.TradingBroker;

public interface Strategy {

    public void perform(TradingBroker broker);

}
