import exceptionsPass.InvalidDigitException;
import exceptionsPass.InvalidLowerCaseException;
import exceptionsPass.InvalidPasswordLengthException;
import exceptionsPass.InvalidUpperCaseException;

/**
 * Created by Usuario on 09/06/2016.
 */

public class PasswordVerifier {

    public boolean verify(String password) throws InvalidUpperCaseException, InvalidLowerCaseException, InvalidDigitException, InvalidPasswordLengthException {
        if (password == null) {
            throw new IllegalArgumentException("The password not must be null");
        }
        isLengthValid(password);
        hasLowerCase(password);
        hasUpperCase(password);
        hasADigit(password);

        return true;
    }

    public boolean isLengthValid(String password) throws InvalidPasswordLengthException {

        if(password.length() > 8){
            return true;
        }
        throw new InvalidPasswordLengthException("The minimum password lenght whould be 8 characters");
    }

    public boolean hasUpperCase(String password) throws InvalidUpperCaseException {
        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        throw new InvalidUpperCaseException("The password MUST have minimum an upper case");
    }

    public boolean hasLowerCase(String password) throws InvalidLowerCaseException {
        for (char character : password.toCharArray()) {
            if (Character.isLowerCase(character)) {
                return true;
            }
        }
        throw new InvalidLowerCaseException("The password MUST have minimum an lower case");
    }

    public boolean hasADigit(String password) throws InvalidDigitException {
        for (char character : password.toCharArray()) {
            if (Character.isDigit(character)) {
                return true;
            }
        }
        throw new InvalidDigitException("The password MUST have minimum a digit case");
    }
}
