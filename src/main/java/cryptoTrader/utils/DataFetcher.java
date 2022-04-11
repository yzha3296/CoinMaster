package cryptoTrader.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * This class is used to fetch data from the cryptoCoin web site
 * @author CS2212 Group11
 * @since   2022-03-25 
 */
public class DataFetcher {

	/**
	 * create a private get method to fetch the data from the given website
	 * @param id Giving cryptoCoins id
	 * @param date Giving real date to be further stored into the database
	 * @return return the stored data. Throw the exception when data cannot be fetched from the website
	 */
	private JsonObject getDataForCrypto(String id, String date) {

		/**
		 * The out source webbsite that provides the data
		 */
		String urlString = String.format(
				"https://api.coingecko.com/api/v3/coins/%s/history?date=%s", id, date);
		
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
				JsonObject jsonObject = new JsonParser().parse(inline).getAsJsonObject();
				return jsonObject;
			}

		} catch (IOException e) {
			System.out.println("Something went wrong with the API call.");
		}
		return null;
	}
	
	/**
	 * This method is used to get the price for cryptoCoins
	 * @param id Give the cryptoCoin id to locate 
	 * @param date Give the real date 
	 * @return return the price obtained from the web site
	 */
	public double getPriceForCoin(String id, String date) {
		double price = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("current_price").getAsJsonObject();
			price = currentPrice.get("cad").getAsDouble();
		}
		
		return price;
	}
	
	/**
	 * This method is used to get the market capitalization
	 * @param id Give the cryptoCoin id to locate 
	 * @param date Give the real time date
	 * @return return the market capitalization for the 'cad' value
	 */
	public double getMarketCapForCoin(String id, String date) {
		double marketCap = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("market_cap").getAsJsonObject();
			marketCap = currentPrice.get("cad").getAsDouble();
		}
		
		return marketCap;
	}
	
	
	/**
	 * This method is used to get the volume of the cryptoCoins
	 * @param id Give the cryptoCoin id to locate 
	 * @param date Give the date
	 * @return return the cryptoCoin volumes in cad
	 */
	public double getVolumeForCoin(String id, String date) {
		double volume = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("total_volume").getAsJsonObject();
			volume = currentPrice.get("cad").getAsDouble();
		}
		
		return volume;
	}
	
	/**
	 * Main method to call the data fetcher method given several cryptoCoin id and date
	 * @param args
	 * return the price, market capitalization and volume for requested cryptoCoin
	 */
	public static void main(String[] args) {
		DataFetcher fetcher = new DataFetcher();
		double price = fetcher.getPriceForCoin("bitcoin", "08-09-2021");
		double marketCap = fetcher.getMarketCapForCoin("bitcoin", "08-09-2021");
		double volume = fetcher.getVolumeForCoin("bitcoin", "08-09-2021");
		
		System.out.println("Bitcoin=>\tPrice: " + price + 
								"\n\t\tMarket Cap: " + marketCap + 
								"\n\t\tVolume: "+volume);
		
	}
}
