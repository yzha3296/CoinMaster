/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file states the conditions of strategy E.
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

public class StrategyE implements Strategy{

    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-D";
    String choice;

    /**
     * This methods states the coins to be included in the strategy and the trading actoin.
     */

    public StrategyE() {
        choice = "Sell";
        coinsCanBePerformed.add("SOL");
        coinsCanBePerformed.add("XRP");
        coinsCanBePerformed.add("ADA");
        coinsCanBePerformed.add("LUNA");
        coinsCanBePerformed.add("AVAX");
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
                if (coinName.equals("SOL")) {
                    System.out.println(coinPrice.get(coinName) );
                    if (coinPrice.get(coinName) > 125) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 200, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("XRP")) {
                    if (coinPrice.get(coinName) > 0.8) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 250, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("ADA")) {
                    if (coinPrice.get(coinName) > 1.2) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 500, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("LUNA")) {
                    if (coinPrice.get(coinName) > 105) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 400, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("AVAX")) {
                    if (coinPrice.get(coinName) > 98) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 5000, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                }

            }
        }
    }
}
