import exceptionsPass.InvalidDigitException;
import exceptionsPass.InvalidLowerCaseException;
import exceptionsPass.InvalidPasswordLengthException;
import exceptionsPass.InvalidUpperCaseException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PasswordVerifierTest {

    @Test
    public void testPasswordLengthIsGreaterThanEightCharacters() throws InvalidPasswordLengthException {
        PasswordVerifier passVerify = new PasswordVerifier();
        assertTrue(passVerify.isLengthValid("abcdefghij"));
    }

    @Test
    public void testPasswordHasAtLeastOneUpperCase() throws InvalidUpperCaseException {
        PasswordVerifier passVerify = new PasswordVerifier();
        assertTrue(passVerify.hasUpperCase("Abcdefghij"));
    }

    @Test
    public void testPasswordHasAtLeastOneLowerCase() throws InvalidLowerCaseException {
        PasswordVerifier passVerify = new PasswordVerifier();
        assertTrue(passVerify.hasLowerCase("Abc"));
    }

    @Test
    public void testPasswordHasAtLeastOneDigit() throws InvalidDigitException {
        PasswordVerifier passVerify = new PasswordVerifier();
        assertTrue(passVerify.hasADigit("abc123"));
    }

    @Test
    public void testPasswordIsValid() throws InvalidDigitException, InvalidUpperCaseException, InvalidLowerCaseException, InvalidPasswordLengthException {
        PasswordVerifier passVerify = new PasswordVerifier();
        assertTrue(passVerify.verify("Abcd12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPasswordIsInvalid() throws InvalidDigitException, InvalidUpperCaseException, InvalidLowerCaseException, InvalidPasswordLengthException {
        PasswordVerifier passVerify = new PasswordVerifier();
        passVerify.verify(null);
    }

    @Test(expected = InvalidUpperCaseException.class)
    public void testUpperCaseException() throws InvalidUpperCaseException {
        PasswordVerifier passVerify = new PasswordVerifier();
        passVerify.hasUpperCase("abcdefghij");
    }

    @Test(expected = InvalidLowerCaseException.class)
    public void testLowerCaseException() throws InvalidLowerCaseException {
        PasswordVerifier passVerify = new PasswordVerifier();
        passVerify.hasLowerCase("ABC");
    }

    @Test(expected = InvalidDigitException.class)
    public void testDigitException() throws InvalidDigitException {
        PasswordVerifier passVerify = new PasswordVerifier();
        assertFalse(passVerify.hasADigit("ABC"));
    }

    @Test(expected = InvalidPasswordLengthException.class)
    public void testInvalidPasswordLengthException() throws InvalidPasswordLengthException {
        PasswordVerifier passVerify = new PasswordVerifier();
        passVerify.isLengthValid("abc");
    }

}