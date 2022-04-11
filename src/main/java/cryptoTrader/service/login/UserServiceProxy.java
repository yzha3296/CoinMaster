/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This file is a proxy to implement 
 * UserService authentication method.
 */
package cryptoTrader.service.login;

/**
 * This is the class for the Log In user interface
 */
import cryptoTrader.service.login.UserServiceInterFace;
import cryptoTrader.service.login.UserService;

public class UserServiceProxy implements UserServiceInterFace {

    @Override
    /**
     * This method implements the authentication process.
     * @return authen.authenticate(userName, password) boolean variable if the verification is successful
     */
    public boolean authenticate(String userName, String password) {

        UserService authen = new UserService();
        return authen.authenticate(userName, password);
    }

}
