package com.company.main.service.implementation;

import com.company.main.model.CountryPhoneRules;
import com.company.main.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberValidator implements Validator
{
    @Override
    public boolean isValid(String phoneNumber)
    {
        return phoneNumber != null && !phoneNumber.isBlank() && validByCountryPhoneRules(phoneNumber)
                && checkSymbols(phoneNumber);
    }

    private boolean checkSymbols(String phoneNumber)
    {
        for (int i = 0; i < phoneNumber.length(); i++)
        {
            if (!Character.isDigit(phoneNumber.charAt(i)) && !phoneNumber.startsWith("+"))
            {
                return false;
            }
        }
        return true;
    }

    private boolean validByCountryPhoneRules(String phoneNumber)
    {
        if (phoneNumber.startsWith("8"))
        {
            phoneNumber = "+370" + phoneNumber.substring(1);
            return true;
        }

        List<CountryPhoneRules> rulesList = new ArrayList<>();
        rulesList.add(new CountryPhoneRules("Lithuania", 12, "+370"));
        rulesList.add(new CountryPhoneRules("Latvia", 12, "+371"));
        rulesList.add(new CountryPhoneRules("Estonia", 12, "+372"));


        for (CountryPhoneRules rules : rulesList)
        {
            if (phoneNumber.startsWith(rules.getPrefix()) && phoneNumber.length() == rules.getLengthOfPhoneNumber())
            {
                return true;
            }
        }
        return false;
    }
}
