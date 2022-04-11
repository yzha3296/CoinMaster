package cryptoTrader.utils;
import java.util.*;
/**
 * This class defines all the possible cryptoCoins with its ID and names
 * @author CS2212 Group 11
 * @since   2022-03-25 
 */
public class CoinSimplify {

	/**
	 * Initialize an empty Hashtable to store cryptoCoins name and id
	 */
	static Hashtable<String, String> cryptoCoin = null;
	/**
	 * public a method to call the CoinSimolify method
	 */
	public CoinSimplify() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 *Store all the cryptoCoins into the Hashtable 
	 * @return return the new updated cryptoCoins Hashtable
	 */
	public static Hashtable<String, String> getCoinNameMap() {
		cryptoCoin = new Hashtable<String, String>();
		cryptoCoin.put("BTC","bitcoin");
		cryptoCoin.put("ETH","ethereum");
		cryptoCoin.put("USDT","tether");
		cryptoCoin.put("BNB","bnb");
		cryptoCoin.put("USDC","usd coin");
		cryptoCoin.put("XRP","xrp");
		cryptoCoin.put("ADA","cardano");
		cryptoCoin.put("SOL","solana");
		cryptoCoin.put("LUNA","terra");
		cryptoCoin.put("AVAX","avalanche");
		cryptoCoin.put("DOT","polkadot");
		cryptoCoin.put("DOGE","dogecoin");
		cryptoCoin.put("BUSD","binance usd");
		cryptoCoin.put("UST","terra usd");
		cryptoCoin.put("SHIB","shiba inu");
		cryptoCoin.put("MATIC","polygon");
		cryptoCoin.put("WBTC","wrapped bitcoin");
		cryptoCoin.put("CRO","cronos");
		cryptoCoin.put("DAI","dai");
		cryptoCoin.put("NEAR","near protocol");

		return cryptoCoin;
	}

	/**
	 * Test purpose
	 * @param coin
	 * @return
	 */
//	public static boolean check(List<String> coinList) {
//		// TODO Auto-generated method stub
//		List<String> coinList2 = new ArrayList<>();
//		List<String> coinAvaliable = new ArrayList<>();
//		coinList2 = coinList;
//		Map<String, String> coinMap = getCoinNameMap();
//		for (String key: coinMap.keySet()) {
//			coinAvaliable.add(key);
//		}
//		for (int i = 0; i < coinList2.size(); i ++) {
//			String crypto = coinList2.get(i);
//			if (!coinAvaliable.contains(crypto)) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	/**
	 * create a boolean type method to check whether the input coin
	 * has been stored in the coinAvailable list
	 * @param coin parameter to check 
	 * @return return false if the available coins list does not contain the input coin
	 * otherwise, return true
	 */
	public static boolean check(String coin) {
		// TODO Auto-generated method stub
		String coin2 = null;
		List<String> coinAvaliable = new ArrayList<>();
		coin2 = coin;
		Map<String, String> coinMap = getCoinNameMap();
		for (String key: coinMap.keySet()) {
			coinAvaliable.add(key);
		}
		if (!coinAvaliable.contains(coin)) {
			return false;
		}
		return true;
	}
}