/**

 The A5EBITIncome class calculates the EBIT income for each year based on the revenues and EBIT margins.
 It also stores the list of EBIT income over the years and the operating income growth rate.
 This class contains the following public methods:
 setEBITIncomeList: calculates and sets the EBIT income list based on the input values.
 getEBITIncomeList: retrieves the EBIT income list.
 getOperatingIncomeGrew: retrieves the operating income growth rate.
 The following instance variables are used in this class:
 ebitIncomeList: an ArrayList of doubles that stores the EBIT income.
 operatingIncomeGrew: a double that stores the operating income growth rate.
 Note: The EBIT income for each year is calculated using the formula: EBIT income = revenue * EBIT margin.
 The operating income growth rate is calculated as the difference between the terminal EBIT income and the initial EBIT income.
 @author [KeYi LIU]
 @version [V1.1]
 */
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A5EBITIncome {

    ArrayList<Double> ebitIncomeList = new ArrayList<>();
    public double operatingIncomeGrew = 0;


    public void setEBITIncomeList(A3Revenues revenues, A4EBITMargin ebitMargin,int yearOfList) {
        ebitIncomeList.add(ebitMargin.getBaseIncome());

        for (int i = 1; i <= 1+yearOfList; i++) {
            BigDecimal big_get_reven = new BigDecimal(Double.toString(revenues.getRevenuesList().get(i)));
            BigDecimal big_get_ebitMargin = new BigDecimal(Double.toString(ebitMargin.getEBITMarginList().get(i)));
            BigDecimal ans1 = big_get_reven.multiply(big_get_ebitMargin);


            double ans = ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double ans = revenues.getRevenuesList().get(i) * ebitMargin.getEBITMarginList().get(i);
            ebitIncomeList.add(ans);
        }


        BigDecimal ebitIncomeList11 = new BigDecimal(Double.toString(ebitIncomeList.get(yearOfList+1)));
        BigDecimal ebitIncomeListget0 = new BigDecimal(Double.toString(ebitIncomeList.get(0)));

        operatingIncomeGrew = ebitIncomeList11.subtract(ebitIncomeListget0).setScale(4, RoundingMode.HALF_UP).doubleValue();
        //operatingIncomeGrew=ebitIncomeList.get(11) - ebitIncomeList.get(0);
        ebitIncomeList.add(operatingIncomeGrew);
    }

    public ArrayList<Double> getEBITIncomeList() {
        return ebitIncomeList;
    }

    public double getOperatingIncomeGrew() {
        return operatingIncomeGrew;
    }

}

