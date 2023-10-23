/**

A12CostOfCapital represents the cost of capital used in the discounted cash flow (DCF) analysis.
This class includes methods to calculate the terminal cost of capital and the cost of capital for each year in the forecast period.
@author Back
@version 1.0
@since 2023-04-05
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


//todo
public class A12CostOfCapital {
    public ArrayList<Double> costOfCapitalList = new ArrayList<>();

    public double getTerminalostOfCapital() {
        return terminalostOfCapital;
    }

    public double terminalostOfCapital;


    public void setTerminalostOfCapital(boolean inputB41, double inputB42, boolean inputB57, double inputB58, double countryEquityRiskPremiumsB1, double inputB30) {
        BigDecimal big_B58 = new BigDecimal(Double.toString(inputB58));
        BigDecimal big_B30 = new BigDecimal(Double.toString(inputB30));
        BigDecimal big_08 = new BigDecimal("0.8");
        BigDecimal big_countryEquityRiskPremiumsB1 = new BigDecimal(Double.toString(countryEquityRiskPremiumsB1));
        BigDecimal ans1 = big_08.multiply(big_countryEquityRiskPremiumsB1);

        if (inputB41) {
            terminalostOfCapital = inputB42;
        } else {
            if (inputB57) {

                BigDecimal ans = big_B58.add(ans1);
                terminalostOfCapital = ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
                //terminalostOfCapital=  (inputB58+0.8*(countryEquityRiskPremiumsB1));
            } else {
                BigDecimal ans = big_B30.add(ans1);
                terminalostOfCapital = ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
                //terminalostOfCapital= (inputB30+0.8*(countryEquityRiskPremiumsB1));
            }
        }
    }


    public void setCostOfCapitalList(double B31,int yearOfList,int year2_x) {
        costOfCapitalList.add((double) 0);

        for (int i = 1; i <= year2_x; i++) {
            costOfCapitalList.add(B31);
        }
        for (int i = year2_x+1; i <= yearOfList; i++) {

            BigDecimal costOfCapitalList1=new BigDecimal(Double.toString(costOfCapitalList.get(i - 1)));
            BigDecimal costOfCapitalList5=new BigDecimal(Double.toString(costOfCapitalList.get(year2_x)));
            BigDecimal terminaCapital=new BigDecimal(Double.toString(terminalostOfCapital));
            BigDecimal big_5=new BigDecimal(Double.toString(year2_x));
            BigDecimal ans1=costOfCapitalList5.subtract(terminaCapital);
            BigDecimal ans2=ans1.divide(big_5,20,RoundingMode.HALF_UP);
            BigDecimal ans3=costOfCapitalList1.subtract(ans2);

            double temp=ans3.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double temp = costOfCapitalList.get(i - 1) - ((costOfCapitalList.get(5) - terminalostOfCapital) / 5);
            costOfCapitalList.add(temp);
        }
        costOfCapitalList.add(terminalostOfCapital);

    }

    public ArrayList<Double> getCostOfCapitalList() {
        return costOfCapitalList;
    }


}

