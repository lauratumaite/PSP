package com.company.main.model;

public class CountryPhoneRules
{
    private String country;
    private int length;
    private String prefix;

    public CountryPhoneRules(String country, int length, String prefix) {
        this.country = country;
        this.length = length;
        this.prefix = prefix;
    }

    public String getCountry() {
        return this.country;
    }

    public int getLengthOfPhoneNumber() {
        return this.length;
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof CountryPhoneRules)
        {
            return country.equals(((CountryPhoneRules) obj).getCountry())
                    && length == ((CountryPhoneRules) obj).getLengthOfPhoneNumber()
                    && prefix.equals(((CountryPhoneRules) obj).getPrefix());
        }
        return super.equals(obj);
    }
}