import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Usuario on 09/06/2016.
 */
public class PasswordVerifierTest {

    @Test
    public void testPasswordLengthIsGreaterThanEightCharacters(){
        PasswordVerifier passVerify = new PasswordVerifier();
        assertTrue(passVerify.verify("abcdefghij"));
    }

    @Test
    public void testPasswordLengthIsLessThanEightCharacters(){
        PasswordVerifier passVerify = new PasswordVerifier();
        assertFalse(passVerify.verify("abc"));
    }




}