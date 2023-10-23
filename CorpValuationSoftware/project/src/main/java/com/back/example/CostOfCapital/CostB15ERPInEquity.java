package com.back.example.CostOfCapital;

import com.back.example.CostOfCapital.InputForCapital;

import java.util.Objects;

/**
 * B13 in Cost of capital worksheet:
 * Equity Risk Premium used in cost of equity
 */
public class CostB15ERPInEquity {
    public static double getERPInEquity() {
        return ERPInEquity;
    }

    /**
     *
     * Different approaching types for data
     * 1. Direct Input
     * 2. Country of Incorporation
     * 3. Operating Countries
     * 4. Operating Regions
     */
    public static void setERPInEquity() {
        String type = InputForCapital.getB13ApproachForERP();
        if (Objects.equals(type, "Will input")) {
            ERPInEquity = InputForCapital.getB14DirectInputForERP();
        } else if (Objects.equals(type, "Country of Incorporation")) {
            ERPInEquity = InputForCapital.getCountryERP();
        } else if (Objects.equals(type, "Operating Countries")) {
            ERPInEquity = InputForCapital.getK18OperatingCountriesERP();
        } else if (Objects.equals(type, "Operating Regions")) {
            ERPInEquity = InputForCapital.getK32OperatingRegionERP();
        }
    }

    static double ERPInEquity;

}
