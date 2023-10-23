/**

 The A6TaxRate class sets and retrieves the tax rate for each year.
 This class contains the following public methods:
 setTaxRateList: sets the tax rate list based on the input values.
 getTaxRateList: retrieves the tax rate list.
 getTerminalTaxRate: retrieves the terminal tax rate.
 The following instance variables are used in this class:
 taxRateList: an ArrayList of doubles that stores the tax rates.
 Note: The tax rate for each year is the same and is set based on the input value.
 @author [KeYi LIU]
 @version [V1.1]
 */
package com.back.example.OutputSheet;

import java.util.ArrayList;

public class A6TaxRate {
    public ArrayList<Double> taxRateList = new ArrayList<>();

    public void setTaxRateList(double inputB20,int yearOfList) {
        for (int i = 0; i <=1+yearOfList; i++) {
        taxRateList.add(inputB20);
        }
    }

    public ArrayList<Double> getTaxRateList() {
        return taxRateList;
    }

    public Double getTerminalTaxRate() {
        return taxRateList.get(taxRateList.size()-1);
    }
}

