/**

 The A3Revenues class calculates the revenues for each year based on the revenue growth rates and the initial revenue value.
 It also stores the list of revenues over the years.
 This class contains the following public methods:
 setA3RevenuesList: calculates and sets the revenues list based on the input values.
 getRevenuesList: retrieves the revenues list.
 getTerminalRevenues: retrieves the terminal revenues.
 The following instance variables are used in this class:
 revenuesList: an ArrayList of doubles that stores the revenues.
 Note: The revenue for each year is calculated using the formula: (1 + revenue growth rate) * (previous year's revenue).
 * @author [KeYi LIU]
 * @version [V1.1]
 */
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A3Revenues {

    public ArrayList<Double> revenuesList = new ArrayList<>();

    public void setA3RevenuesList(double A8, A2RevenueGrowthRate revenueGrowthRate,int yearOfList) {
        revenuesList.add(A8);
        for (int i = 1; i <= yearOfList+1; i++) {


            double temp1=revenueGrowthRate.getRevenueGrowthRateList().get(i)+1;
            BigDecimal ans1= new BigDecimal(Double.toString(temp1));
            BigDecimal big_getrevenue=new BigDecimal(Double.toString(revenuesList.get(i-1)));

            BigDecimal ans2=ans1.multiply(big_getrevenue);

            double ans = ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double ans = (1 + revenueGrowthRate.getRevenueGrowthRateList().get(i)) * (revenuesList.get(i - 1));
            revenuesList.add(ans);
        }
    }

    public ArrayList<Double> getRevenuesList() {
        return revenuesList;
    }

    public double getTerminalRevenues() {
        return revenuesList.get(revenuesList.size()-1);
    }


}
