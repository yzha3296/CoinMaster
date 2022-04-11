package cryptoTrader.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * 
 * @author CS2212 Group 11
 * @since   2022-03-25 
 */
public class AvailableCryptoList {
	/**
	 * Initialize an empty cryptoCoin List
	 */
	private static AvailableCryptoList instance = null;
	
	/**
	 * Initialize an empty HashMap for further storage
	 */
	private Map<String, String> availableCryptosMap = new HashMap<>();
	
	/**
	 * Initialize a new string list to store the available cryptoCoins
	 */
	private List<String> availableCryptosList = new ArrayList<>();
	
	/**
	 * This method is used to get the instance,
	 * if instance is empty, create a new one and return
	 * @return return either the existing or new created cryptocCoin list.
	 */
	public static AvailableCryptoList getInstance() {
		if (instance == null)
			instance = new AvailableCryptoList();
		
		return instance;
	}
	
	/**
	 * This private method is used to invoke the finder method
	 */
	private AvailableCryptoList() {
		findAvailableCryptos();
	}
	
	/**
	 * THis method is used to first open the cryptoCoin web site and then read in the 
	 * interested coin information. Finally print out the coin information 
	 */
	public void call() {
		String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=VNEY4VV2AWF1EB51";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				System.out.println(inline);
//				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
//				int size = jsonArray.size();
//				
//				String name, id;
//				for (int i = 0; i < size; i++) {
//					JsonObject object = jsonArray.get(i).getAsJsonObject();
//					name = object.get("name").getAsString();
//					id = object.get("id").getAsString();
//					
//					availableCryptosMap.put(name, id);
//					availableCryptosList.add(name);
//				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	
	/**
	 * A void method to update the interested cryptoCoin information(including name and id) 
	 * to the cryptoCoin list and cryptoCoin HashMap.
	 */
	private void findAvailableCryptos() {

		String urlString = 
				"https://api.coingecko.com/api/v3/coins/markets" + 
						"?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false";
//		ALPHAVANTAGE API KEY = VNEY4VV2AWF1EB51
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
				
				String name, id;
				for (int i = 0; i < size; i++) {
					JsonObject object = jsonArray.get(i).getAsJsonObject();
					name = object.get("name").getAsString();
					id = object.get("id").getAsString();
					
					availableCryptosMap.put(name, id);
					availableCryptosList.add(name);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	
	/**
	 * Get available cryptoCoins and store them in the string array that is newly defined.
	 * @return return the availableCryptosList 
	 */
	public String[] getAvailableCryptos() {
		return availableCryptosList.toArray(new String[availableCryptosList.size()]);
	}
	
	/**
	 *Get the crypto Id given the crypto name.
	 * @param cryptoName Input cryptoName parameter
	 * @return return the cryptoName in the availableCryptoMap
	 */
	public String getCryptoID(String cryptoName) {
		return availableCryptosMap.get(cryptoName);
	}

	/**
	 * Main method to execute cryptoCoin list storage
	 * @param args
	 */
	public static void main(String[] args) {
		AvailableCryptoList avai = new AvailableCryptoList();
		String[] newList = avai.getAvailableCryptos();
		System.out.println(newList.length);
		for (String item : newList) {
			System.out.println(item);
		}
		System.out.println(avai.getCryptoID("bitcoin"));

	}
}
