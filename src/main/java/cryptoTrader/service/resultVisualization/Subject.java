/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that contains methods regarding observer.
 */

package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;

import java.util.*;

/**
 * observer design pattern used
 */
public class Subject {
    protected  List<Observer> observerList = new ArrayList<Observer>();

    /**
     * This method add an observer
     * @param observer observer to be added
     */
    public void add(Observer observer) {
        observerList.add(observer);
    }

    /**
     * This method add an observer
     * @param observer observer to be removed
     */
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * This method notifies the observer.
     * @param data data to be observed
     * @param list list to be observed
     */
    public void notifyObserver(String[][] data, List<ClientTradingRecord> list) {
        for (Observer observer : observerList) {
            ((Observer)observer).generate(data, list);
        }
    }

}
