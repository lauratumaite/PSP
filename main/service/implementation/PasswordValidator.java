package com.company.main.service.implementation;

import com.company.main.service.Validator;

public class PasswordValidator implements Validator
{
    String specialSymbols="@#-_*";

    @Override
    public boolean isValid(String password)
    {
        return password != null && !password.isBlank() && correctLength(password) && checkUppercase(password)
                && checkSpecialSymbols(password);
    }

    private boolean correctLength(String password)
    {
        return password.length() >= 8;
    }

    private boolean checkUppercase(String password)
    {
        for (int i = 0; i < password.length(); i++)
        {
            if (Character.isUpperCase(password.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    private boolean checkSpecialSymbols(String password)
    {
        for (int i = 0; i < specialSymbols.length(); i++)
        {
            for (int j = 0; j < password.length(); j++)
            {
                if (password.charAt(j) == specialSymbols.charAt(i))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
