/**

 * The A2RevenueGrowthRate class calculates the revenue growth rate and terminal revenue for a given input set of values.
 * It also stores the list of revenue growth rates over the years.
 * This class contains the following public methods:
 * setTerminalRevenue: sets the terminal revenue based on the input values.
 * getTerminalRevenue: retrieves the terminal revenue.
 * setRevenueGrowthRateList: calculates and sets the revenue growth rate list based on the input values.
 * getRevenueGrowthRateList: retrieves the revenue growth rate list.
 * getTerminalRevenueGrowthRate: retrieves the terminal revenue growth rate.
 * The following instance variables are used in this class:
 * revenueGrowthRateList: an ArrayList of doubles that stores the revenue growth rates.
 * terminalRevenue: a double that stores the terminal revenue.
 * Note: The revenue growth rate is calculated using the formula: (current revenue - terminal revenue) / (terminal year - current year + 1).
 * @author [KeYi LIU]
 * @version [V1.1]
 */
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A2RevenueGrowthRate {

    public ArrayList<Double> revenueGrowthRateList = new ArrayList<>();
    public double terminalRevenue;

    public void setTerminalRevenue(boolean inputA60, double inputA61, boolean inputA57, double inputA58, double inputA30) {
        if (inputA60) {
            terminalRevenue = inputA61;
        } else {
            if (inputA57) {
                terminalRevenue = inputA58;
            } else {
                terminalRevenue = inputA30;
            }
        }
    }

    public double getTerminalRevenue() {
        return terminalRevenue;
    }

    public void setRevenueGrowthRateList(double inputA23, double inputA25, double terminalRevenue,int yearOfList,int year2_x) {
        revenueGrowthRateList.add((double) 0);
        revenueGrowthRateList.add(inputA23);
        for (int i = 1; i <= year2_x-1; i++) {
            revenueGrowthRateList.add(inputA25);
        }

        for (int i = year2_x; i < yearOfList; i++) {


            BigDecimal big_get2 = new BigDecimal(Double.toString(revenueGrowthRateList.get(2)));
            BigDecimal big_terminalvalue=new BigDecimal(Double.toString(terminalRevenue));
            BigDecimal big_int5=new BigDecimal(Double.toString(year2_x));
            BigDecimal big_temp=new BigDecimal(Double.toString(i - year2_x+1));

            BigDecimal ans1=big_get2.subtract(big_terminalvalue);
            BigDecimal ans2=ans1.divide(big_int5,20, RoundingMode.HALF_UP);
            BigDecimal ans3=ans2.multiply(big_temp);
            BigDecimal ans4=big_get2.subtract(ans3);


            double ans=ans4.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double ans = revenueGrowthRateList.get(2) - (revenueGrowthRateList.get(2) - terminalRevenue) / 5 * (i - 4);


            revenueGrowthRateList.add(ans);
        }
        revenueGrowthRateList.add(terminalRevenue);
    }

    public ArrayList<Double> getRevenueGrowthRateList() {
        return revenueGrowthRateList;
    }

    public double getTerminalRevenueGrowthRate() {
        return revenueGrowthRateList.get(revenueGrowthRateList.size()-1);
    }
}





