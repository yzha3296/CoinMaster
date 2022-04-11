package cryptoTrader.utils.strategyOperations;

import cryptoTrader.utils.DateConverter;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is designed to update the selling information into transaction database
 * including trader name, strategy being applied, coin quantity, coin name, and price of the coin
 * @author CS2212 Group 11
 *
 */
public class SellOperation implements StrategyOperation{
    public SellOperation() {

    }

    /**
     * Update the transaction database with 'Sell' status and update the corresponding information 
     * Pinpoint the exact line in which the method raised the exception.
     */
    public void writeTransactionDB(String trader, String strategy, int quantity, String coin, double price) {
        String action = "Sell";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactionDB.txt", true));
            String date = currDateGenerator();
            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + quantity + "," + price + "," + date);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get the time and transform the time into the 'dd-MM-yyyy' format
     * @return return the corrected time format
     */
    private String currDateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateStr = formatter.format(date);
        DateConverter dateConverter = new DateConverter();
        dateStr = dateConverter.convertDate(dateStr);
        return dateStr;
    }

    /**
     * Handle the situation where the trading strategy cannot be applied given trader, strategy and coin information.
     * Pinpoint the exact line in which the method raised the exception.
     */
    public void handleInvalidBroker(String trader, String strategy, String coin) {
        String message = "Cannot apply " + strategy + " with " + coin + " \nfor "+ trader;
        JOptionPane.showMessageDialog(null, message, "Strategy Can't Apply", JOptionPane.INFORMATION_MESSAGE);
        String action ="Fail (strategy not applied)";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactionDB.txt", true));
            String date = currDateGenerator();

            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + "Null" + "," + "Null" + "," + date);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
