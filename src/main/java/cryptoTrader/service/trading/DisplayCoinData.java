/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that display the coin data.
 */

package cryptoTrader.service.trading;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.entity.TransactionRecord;
import cryptoTrader.service.resultVisualization.*;

import java.util.List;

/**
 * This class helping show the transaction data
 */
public class DisplayCoinData {
	/**
	 * This method generate the visualization.
	 */
    public void visualizationGenerator() {
        String[][] recordArr = TransactionRecord.returnTransactionRecord();
        List<ClientTradingRecord> list = TransactionRecord.returnClientRecordList();

        Subject transaction = new Subject();
        Observer table = new TableObserver();
        transaction.add(table);
        Observer diagram = new DiagramObserver();
        transaction.add(diagram);
        transaction.notifyObserver(recordArr, list);
    }
}
