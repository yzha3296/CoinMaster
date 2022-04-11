/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that defines the observer.
 */

package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.entity.CurrentClientsInfo;

import java.util.List;

/**
 * observer design pattern used
 */
public abstract class Observer {
    protected Subject transaction;
    /**
     * This class defines the parameters of the generate method.
     */
    public abstract void generate(String[][] data, List<ClientTradingRecord> list);
}
