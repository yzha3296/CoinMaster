/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that deals with trades' 
 * information, including adding brokers and 
 * checking if entries of brokers are duplicated.
 */

package cryptoTrader.entity;

import java.util.*;

/**
 * This is the primary class of this file.
 */

public class CurrentClientsInfo {
    private static CurrentClientsInfo instance = null;
    private static List<TradingBroker> tradingBrokerList = new ArrayList<>();
    private static List<String> clientNames = new ArrayList<>();
    private static List<String> interestedCoinList = new ArrayList<>();

    private CurrentClientsInfo() {

    }

    /**
     * This class gets client info. If instance 
     * is null, then we create a new CurrentClientsInfo. 
     * This is singleton design pattern.
     * @return instance 
     */

    public static CurrentClientsInfo getInstance() {
        if (instance == null) {
            instance = new CurrentClientsInfo();
        }
        return instance;
    }

    /**
     * This class adds a new trading broker into the list.
     * @param newBroker a new broker
     */

    public static void addTradingBroker(TradingBroker newBroker) {
        tradingBrokerList.add(newBroker);
    }

    /**
	 * Initiate an array list for trading broker
	 * @return tradingBrokerList
	 */

    public static List<TradingBroker> returnBrokerList() {
        return tradingBrokerList;
    }

    /**
     * This class adds trading broker's name to the corresponding broker.
     * @param newName new client name
     */

    public static void addTradingName(String newName) {
        clientNames.add(newName);
    }

    /**
     * This class checks if the entered broker's name has already enlisted.
     * @param newName new client name
     * @return return a boolean variable indicating if the name is duplicated
     */

    public static boolean ifBrokerNameDuplicated(String newName) {
        for (String name : clientNames) {
            if (newName.equals(name)) {
                return true;
            }
        }
        return false;
    }
    

    /**
     * This class clears the current tradingBrokerList list and clientNames list.
     */

    public static void clearLists() {
        tradingBrokerList = new ArrayList<>();
        clientNames = new ArrayList<>();
    }

    /**
     * This class return a list of interested coins' tickers.
     * @return interested list
     */

    public static List<String> returnInterstedCoins() {
        Set<String> tradingSet = new HashSet<>();
        for (TradingBroker broker : tradingBrokerList) {
            List<String> coins = Arrays.asList(broker.getCoinList());
            for (String item : coins) {
                tradingSet.add(item);
            }
        }
        return new ArrayList<>(tradingSet);
    }
}
