import com.company.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class ValidationTest
{
    Validator validator;

    @BeforeEach
    void beforeTest()
    {
        validator = new Validator();
    }

    //passwordChecker Tests
    @Test
    void passwordCheckerIsNull()
    {
        assertTrue(validator.passwordChecker(null));
    }

    @Test
    void passwordCheckerEmptyString()
    {
        assertTrue(validator.passwordChecker(""));
    }

    @Test
    void passwordCheckerLongerThan12()
    {
        assertFalse(validator.passwordChecker("sedecfh"));
    }

    @Test
    void passwordCheckerUppercaseExists()
    {
        assertTrue(validator.passwordChecker("Guckdfrdf"));
    }

    @Test
    void passwordCheckerLowercaseExists()
    {
        assertFalse(validator.passwordChecker("BJUDCB"));
    }

    @Test
    void passwordCheckerIllegalSymbols()
    {
        assertTrue(validator.passwordChecker("gfųg±įbčšgjb"));
    }

    @Test
    void passwordCheckerSpecialSymbol()
    {
        assertFalse(validator.passwordChecker("psebchkk"));
    }

    @Test
    void passwordCheckerNumberExists()
    {
        assertTrue(validator.passwordChecker("dbg5nFH4"));
    }

    //phoneNumberValidator
    @Test
    void phoneNumberValidatorIsNull()
    {
        assertFalse(validator.phoneNumberValidator("7344"));
    }

    @Test
    void phoneNumberValidatorEmptyString()
    {
        assertTrue(validator.phoneNumberValidator(""));
    }

    @Test
    void phoneNumberValidatorStartsWith370()
    {
        assertTrue(validator.phoneNumberValidator("37064523765"));
    }

    @Test
    void phoneNumberValidatorIllegalSymbols()
    {
        assertTrue(validator.phoneNumberValidator("!456#886"));
    }

    @Test
    void phoneNumberValidatorCountrySpain()
    {
        assertFalse(validator.phoneNumberValidator("3578645676"));
    }

    @Test
    void phoneNumberValidatorCountryItaly()
    {
        assertTrue(validator.phoneNumberValidator("397364485643"));
    }

    @Test
    void phoneNumberValidatorCountryFrance()
    {
        assertFalse(validator.phoneNumberValidator("379983759"));
    }

    //emailValidator Tests

    @Test
    void emailValidatorIsNull()
    {
        assertFalse(validator.emailValidator("fcesdfvdefs@gmail.com"));
    }

    @Test
    void emailValidatorEmptyString()
    {
        assertFalse(validator.emailValidator("fvdef@gmail.com"));
    }

    @Test
    void emailValidatorHasAddressSign()
    {
        assertTrue(validator.emailValidator("dvjg@gvhc.lt"));
    }

    @Test
    void emailValidatorIllegalSymbols()
    {
        assertTrue(validator.emailValidator("1!sfd@#dfgv.shh"));
    }

    @Test
    void emailValidatorLegalDomain()
    {
        assertTrue(validator.emailValidator("laura.tumaite@mif.stud.vu.lt"));
    }

    @Test
    void emailValidatorTLD()
    {
        assertTrue(validator.emailValidator("laura.tumaite@gmail.com"));
    }
}
