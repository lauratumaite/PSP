package com.company.main.service.implementation;

import com.company.main.service.Validator;

public class EmailValidator implements Validator
{
    private int AddressSignPlace;
    private final String[] usedDomains = {"gmail.com", "awesome.vu.lt"};
    public static String AllowedCharacters = ".";

    @Override
    public boolean isValid(String email)
    {
        return email != null && !email.isBlank() && hasAddressSign(email) && checkLocal(email)
                && checkTLDandDomain(email);
    }

    private boolean hasAddressSign(String email)
    {
        AddressSignPlace = email.indexOf("@");
        return AddressSignPlace != -1;
    }

    private boolean checkLocal(String email)
    {
        String localPart = email.substring(0, AddressSignPlace);
        for (char symbol : localPart.toCharArray())
        {
            if (!(Character.isLetterOrDigit(symbol) || AllowedCharacters.contains("" + symbol)))
            {
                return false;
            }
        }
        return true;
    }
    private boolean checkTLDandDomain (String email)
    {
        for (String domain:usedDomains)
        {
            if (email.endsWith("@" + domain))
            {
                return true;
            }
        }
        return false;
    }
}
