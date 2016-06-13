package exceptionsPass;

/**
 * Created by Usuario on 12/06/2016.
 */
public class InvalidPasswordLengthException extends Throwable {
    public InvalidPasswordLengthException(String msg) {
        super(msg);
    }
}
