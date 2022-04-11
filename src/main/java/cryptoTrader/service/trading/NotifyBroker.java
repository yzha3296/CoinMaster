package cryptoTrader.service.trading;

import cryptoTrader.entity.CurrentClientsInfo;
import cryptoTrader.entity.TradingBroker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/**
 * This class is used to notify the broker by updating the coin price stored in broker list
 * @author CS2212 Group 11
 *
 */
public class NotifyBroker {

	/**
	 * Update the coin information and notify it to the broker
	 */
    public void updateBrokerCoinPrice() {
        // get all the prices of coins in the list of interested coins
        Map<String, Double> coinPriceMap =  FetchCoinData.getCoinPrice();
        // pass the appropriate prices to the right trading broker
        List<TradingBroker> tradingBrokerList = CurrentClientsInfo.returnBrokerList();
        for (TradingBroker broker : tradingBrokerList) {
            List<String> coins = Arrays.asList(broker.getCoinList()); // stores interested coin list for single broker
            // check if broker's interested list contains all the valid coins
            // update coin price
            for (String coin : coins) {
                Double price = coinPriceMap.get(coin);
                if (price == null) {
                    // if can't find any coin price, set the price default invalid value -100
                    broker.updateCoinPrice(coin, -100);
                } else {
                    broker.updateCoinPrice(coin, price);
                }
            }
        }
    }
}
