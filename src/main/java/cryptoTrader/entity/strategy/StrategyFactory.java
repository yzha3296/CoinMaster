/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that can get 
 * the corresponding strategy.
 */

package cryptoTrader.entity.strategy;

public class StrategyFactory {

	/**
	 * This method get the selected strategy Name 
	 * @param strategyName selected strategy
	 * @return return the corresponding strategy
	 */

    public Strategy getStrategy(String strategyName) {
        if (strategyName.equals("Strategy-A")) {
            return new StrategyA();
        }else if (strategyName.equals("Strategy-B")) {
            return new StrategyB();
        } else if (strategyName.equals("Strategy-C")) {
            return new StrategyC();
        } else if (strategyName.equals("Strategy-D")) {
            return new StrategyD();
        } else {
            return new StrategyE();
        }
    }
}
