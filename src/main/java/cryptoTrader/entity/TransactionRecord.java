/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This file that includes methods 
 * regarding processing the transaction 
 * records.
 */

package cryptoTrader.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This is the main class of the file.
 */
public class TransactionRecord {
    private static TransactionRecord instance = null;
    private static List<List<String>> transactionRecords = null;
    private static List<ClientTradingRecord> clientRecordList = null;

    private TransactionRecord() {
    }

    /**
     * This class gets TransactionRecord. If instance 
     * is null, then we create a new CurrentClientsInfo. 
     * This is singleton design pattern.
     * @return instance 
     */
    public static TransactionRecord getInstance() {
        if (instance == null) {
            instance = new TransactionRecord();
        }
        return instance;
    }

    /**
     * This method reads the transactions stored in the database.
     */
    private static void readTransaction() {
        String record = null;
        FileReader in = null;
        try {
            transactionRecords = new ArrayList<>();
            in = new FileReader("transactionDB.txt");
            BufferedReader br = new BufferedReader(in);
            int count = 0;
            while ((record = br.readLine()) != null) {
                // Split line by ","
                String[] split = record.split(",");
                List<String> list = new ArrayList<>();
                for (String word : split) {
                    list.add(word.trim());
                }
                transactionRecords.add(list);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * This method returns the transactions after reading the database.
     * @return arr is the stored transactions
     */
    public static String[][] returnTransactionRecord() {
        readTransaction();
        String[][] arr = new String[transactionRecords.size()][];
        int i = 0;
        for (List<String> list: transactionRecords) {
            arr[i++] = list.toArray(new String[list.size()]);
        }
        return arr;
    }

    /**
     * This method process the transactions read in from the database.
     * @param info Transaction records
     * @return return a list of transaction counts
     */
    // each info[i] contains: {Trading-Broker-1,Strategy-A,BTC,Buy,100,56902.81,01-April-2022}
    private static List<ClientTradingRecord> processTransactionArr(String[][] info) {
        Set<String> clientNamesUsed = new HashSet<>();
        Map<String, ClientTradingRecord> clientMap = new HashMap<>();
        List<ClientTradingRecord>  list = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            // if we haven't created the clientRecord obj
            if (!clientMap.keySet().contains(info[i][0])) {
                ClientTradingRecord newClient = new ClientTradingRecord(info[i][0]);
                clientMap.put(info[i][0], newClient);
                list.add(newClient);
            }
            ClientTradingRecord client = clientMap.get(info[i][0]);
            String Action = info[i][3];
            // if action is valid, then increase corresponding strategy counter by 1
            if (Action.equals("Buy") || Action.equals("Sell")) {
                client.increaseCountByOne(info[i][1]);
            }
        }
        return list;
    }

    /**
     * This methods return a list of trading records associate with particular clients.
     * @return clientRecordList
     */
    public static List<ClientTradingRecord> returnClientRecordList() {
        String[][] clients = returnTransactionRecord();
        clientRecordList = processTransactionArr(clients);
        return clientRecordList;
    }

// FOR TEST PURPOSE
//    public static void main(String[] args) {
//        String[][] arr = returnTransactionRecord();
//        List<ClientTradingRecord> list = returnClientRecordList();
//        for (ClientTradingRecord client : list) {
//            System.out.println(client.getClientName() + " " + client.getStrategyACount() + " " + client.getStrategyBCount()
//                   /* + " " + client.getStrategyCCount() + " " + client.getStrategyDCount() + " " + client.getStrategyECount()*/);
//        }
//    }
}
