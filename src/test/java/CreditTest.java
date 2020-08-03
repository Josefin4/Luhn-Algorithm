import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditTest {
    @Test
    void isNumeric() {
        assertTrue(Credit.checkNumeric("2983445745342216"));
    }

    @Test
    void notNumeric() {
        assertFalse(Credit.checkNumeric("HejLsoosweerti23"));
    }

    @Test
    void isPositiveNumber() {
        assertTrue(Credit.positiveNumber("1234567823444447"));
        assertTrue(Credit.positiveNumber("4242424242424242"));
    }

    @Test
    void notPositiveNumber() {
        assertFalse(Credit.positiveNumber("-1235537678998798"));
    }

    @Test
    void validLength() {
        int length = 16;
        assertTrue(Credit.isValidLength("4242424242424242", length));
    }

    @Test
    void invalidLength() {
        int length = 16;
        assertFalse(Credit.isValidLength("424242424242424", length));
    }


}