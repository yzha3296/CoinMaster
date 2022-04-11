/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that visualize the trading transactions records in a table. 
 */
package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.utils.DataVisualizationCreator;

import java.util.List;

/**
 * The class generate the user transaction history
 */
public class TableObserver extends Observer{
    public TableObserver() {

    }

    /**
     * This class defines the local variable of transaction.
     * @param transaction trading transaction
     */
    public TableObserver(Subject transaction){
        this.transaction = transaction;
    }

    @Override
    /**
     * This method generates transactions tables.
     */
    public void generate(String[][] data, List<ClientTradingRecord> list) {
        DataVisualizationCreator creator = new DataVisualizationCreator();
        creator.createTableOutput(data);
//        creator.createBar();
    }
}
