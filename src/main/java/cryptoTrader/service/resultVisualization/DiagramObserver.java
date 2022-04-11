/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that visualize the bar graph for trading transactions.
 */

package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.utils.DataVisualizationCreator;

import java.util.List;

/**
 * This class generate the bar chart
 */
public class DiagramObserver extends Observer{
    public DiagramObserver() {

    }
    /**
     * This class defines the local variable of transaction.
     * @param transaction trading transaction
     */
    public DiagramObserver(Subject transaction){
        this.transaction = transaction;
    }

    @Override
    /**
     * This method generates the diagram.
     */
    public void generate(String[][] data, List<ClientTradingRecord> list) {
        DataVisualizationCreator creator = new DataVisualizationCreator();
        creator.createBar(list);
    }
}
