/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that implements 
 * the authenticate function on the 
 * strings: userName and password
 */

package cryptoTrader.service.login;

public interface UserServiceInterFace {

    boolean authenticate(String userName, String password);
 }