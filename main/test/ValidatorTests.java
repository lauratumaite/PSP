package com.company.main.test;
import com.company.main.service.implementation.PhoneNumberValidator;
import com.company.main.service.implementation.EmailValidator;
import com.company.main.service.implementation.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTests
{
    protected EmailValidator emailValidator;
    protected PasswordValidator passwordValidator;
    protected PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp()
    {
        emailValidator = new EmailValidator();
        phoneNumberValidator = new PhoneNumberValidator();
        passwordValidator = new PasswordValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Password#123", "9P@ssWordDd3", "P@ssw0rd"})
    void shouldCheckPasswordCorrect(String password)
    {
        Assertions.assertTrue(passwordValidator.isValid(password));
    }

    @Test
    void shouldCheckPasswordLength()
    {
        String password = "s";
        Assertions.assertFalse(passwordValidator.isValid(password));
    }

    @Test
    void shouldCheckPasswordUppercase()
    {
        String password = "nouppercase";
        Assertions.assertFalse(passwordValidator.isValid(password));
    }

    @Test
    void shouldCheckPasswordHasSpecialSymbols()
    {
        String password = "asdasDasdasdasd";
        Assertions.assertFalse(passwordValidator.isValid(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37061235067", "865959636"})
    void shouldCheckCorrectPhoneNumbers(String phoneNumber)
    {
        Assertions.assertTrue(phoneNumberValidator.isValid(phoneNumber));
    }

    @Test
    void shouldCheckPhoneNumberLength()
    {
        String phoneNumber = "0";
        Assertions.assertFalse(phoneNumberValidator.isValid(phoneNumber));
    }

    @Test
    void shouldCheckPhoneNumberContainsOnlyNum()
    {
        String phoneNumber = "86oo00o0o";
        Assertions.assertFalse(phoneNumberValidator.isValid(phoneNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37161235067", "+37265656565"})
    void shouldCheckForeignPhoneNumberRuleAdded(String phoneNumber)
    {
        Assertions.assertTrue(phoneNumberValidator.isValid(phoneNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"goodemail@gmail.com", "good.email@gmail.com", "reallygreat@awesome.vu.lt"})
    void shouldCheckCorrectEmails(String email)
    {
        Assertions.assertTrue(emailValidator.isValid(email));
    }

    @Test
    void shouldCheckEmailContainsAnnotation()
    {
        String email = "asd.email.com";
        Assertions.assertFalse(emailValidator.isValid(email));
    }

    @Test
    void shouldCheckIfEmailHasSpecialSymbols()
    {
        String email = "as~~d@~~email.com";
        Assertions.assertFalse(emailValidator.isValid(email));
    }

    @Test
    void shouldCheckEmailDomainCorrect()
    {
        String email = "asd@e mail.com";
        Assertions.assertFalse(emailValidator.isValid(email));
    }

    @Test
    void shouldCheckEmailTLDCorrect()
    {
        String email = "asd@email.1om";
        Assertions.assertFalse(emailValidator.isValid(email));
    }

    @Test
    void shouldCheckEmailUsernameCorrect()
    {
        String email = "ba  dusername@gmail.com";
        Assertions.assertFalse(emailValidator.isValid(email));
    }
}
