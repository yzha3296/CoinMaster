/**
 * @author CS2212 Group 11
 * @version 0.9
 * @since   2022-03-25 
 * This is the file that verifies the 
 * entered values against the stored 
 * values in the userDB.
 */

package cryptoTrader.service.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class authenticate user's username and password, Proxy design pattern used
 */
public class UserService implements UserServiceInterFace {

    @Override
    /**
     * This is the authentication method that verifies credentials.
     * @param userName The user id string entered at the LogIn UI
     * @param password The password string entered at the LogIn UI
     */
    public boolean authenticate(String userName, String password) {
        String record = null;
        FileReader in = null;
        try {
            in = new FileReader("userDB.txt");
            BufferedReader br = new BufferedReader(in);

            while ((record = br.readLine()) != null) {
                // Split line by a whitespace character
                // split[0] <- username
                // split[1] <- password
                String[] split = record.split("\\s");

                if (userName.equals(split[0]) && password.equals(split[1])) {
                    return true;
                    // You found the user, exit the loop
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

}
