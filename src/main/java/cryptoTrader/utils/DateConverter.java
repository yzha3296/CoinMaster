package cryptoTrader.utils;
import java.text.DateFormatSymbols;
	
	/**
	 * This class is used to convert the date format to 'dd-mm-yy'.
	 * 
	 * 
	 */

public class DateConverter {

	public DateConverter() {
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * convert the given date information to corrected 'dd-mm-yyyy' format
	 * @param date input date information
	 * @return return the new corrected 'dd-mm-yyyy' format
	 */
	public static String convertDate(String date)
	{
		String date2 = null;
		String[] arrOfStr = date.split("-", 3);
		
		String month = getMonth(Integer.parseInt(arrOfStr[1]));
	
		arrOfStr[1] = month;
		date2 = arrOfStr[0] + "-" +  arrOfStr[1] +"-"+ arrOfStr[2];
		return date2;
		
	}
	
	/**
	 * This method uses in-built get month method to fetch month
	 * @param month input month information with type 'integer'
	 * @return return a new month pattern
	 */
	public static String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}

}
