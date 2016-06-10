/**
 * Created by Usuario on 09/06/2016.
 */
public class PasswordVerifier {

    public boolean verify(String password) {

        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}
