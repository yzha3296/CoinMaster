/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file states the conditions of strategy B.
 */

package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.BuyOperation;
import cryptoTrader.utils.strategyOperations.SellOperation;
import cryptoTrader.utils.strategyOperations.StrategyOperationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is the main class of this file.
 */

public class StrategyB implements Strategy{
    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-B";
    String choice;

    /**
     * This methods states the coins to be included in the strategy and the trading action.
     */

    public StrategyB() {
        choice = "Buy";
        coinsCanBePerformed.add("ETH");
        coinsCanBePerformed.add("BTC");
        coinsCanBePerformed.add("SOL");
        coinsCanBePerformed.add("XRP");
        coinsCanBePerformed.add("ADA");
    }

    @Override
    /**
     * This methods states conditions of the strategy.
     */

    public void perform(TradingBroker broker) {
        StrategyOperationContext context = new StrategyOperationContext();
        // create strategy obj by the type of operations
        if (choice.equals("Buy")) {
            context.setStrategyOp(new BuyOperation());
        } else {
            context.setStrategyOp(new SellOperation());
        }

        // map for checking if broker is valid to perform
        Map<String, Double> coinPrice = broker.getCoinPriceMap();
        Boolean isFail = true;
        for (String coinName : coinPrice.keySet()) {
            if (coinPrice.get(coinName) == -100) {
                // if the provided coin name is not valid for data fetching
                isFail = true;
                context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
            } else if (!coinsCanBePerformed.contains(coinName)) {
                isFail = true;
                context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
            } else if (coinsCanBePerformed.contains(coinName)){
                // trading rule
                if (coinName.equals("BTC")) {
                    System.out.println(coinPrice.get(coinName) );
                    if (coinPrice.get(coinName) < 45600) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 100, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("ETH")) {
                    if (coinPrice.get(coinName) < 3200) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 300, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("SOL")) {
                    if (coinPrice.get(coinName) < 200) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 500, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("XRP")) {
                    if (coinPrice.get(coinName) < 0.8) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 30000, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("ADA")) {
                    if (coinPrice.get(coinName) < 1.15) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 20000, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                }

            }
        }
    }
}
