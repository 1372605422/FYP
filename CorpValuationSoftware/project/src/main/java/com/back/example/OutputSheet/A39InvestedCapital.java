/**

The A39InvestedCapital class represents the invested capital for a company over a period of time.

It accepts multiple input parameters such as Boolean values, doubles, and an object of A8Reinvestment class, to calculate

the invested capital for each year over a specified period of time. The class provides a setter method to calculate the invested

capital for each year and store it in an ArrayList, and a getter method to retrieve the ArrayList of invested capital values.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A39InvestedCapital {

    public ArrayList<Double> investedCapitalList = new ArrayList<>();


    public void setInvestedCapitalList(Boolean inputB14, Boolean inputB13, double inputB12, double inputB15, double inputB11,
                                       double olcF33, double rdcD35, A8Reinvestment reinvestment,int yearOfList) {
        double temp;
        BigDecimal big_b11 = new BigDecimal(Double.toString(inputB11));
        BigDecimal big_b12 = new BigDecimal(Double.toString(inputB12));
        BigDecimal big_b15 = new BigDecimal(Double.toString(inputB15));
        BigDecimal big_olcF33 = new BigDecimal(Double.toString(olcF33));
        BigDecimal big_rdcD35=new BigDecimal(Double.toString(rdcD35));
        BigDecimal ans=big_b11.add(big_b12).subtract(big_b15);

        if (inputB14) {
            if (inputB13) {
                BigDecimal ans1=ans.add(big_olcF33).add(big_rdcD35);
                temp = ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();;
                //temp = inputB11 + inputB12 - inputB15 + olcF33 + rdcD35;
            } else {

                BigDecimal ans1=ans.add(big_olcF33);
                temp = ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();;
                //temp = inputB11 + inputB12 - inputB15 + olcF33;
            }
        } else {
            if (inputB13) {
                BigDecimal ans1=ans.add(big_rdcD35);
                temp = ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();;
                //temp = inputB11 + inputB12 - inputB15 + rdcD35;
            } else {

                temp = ans.setScale(4, RoundingMode.HALF_UP).doubleValue();;
                //temp = inputB11 + inputB12 - inputB15;
            }
        }
        investedCapitalList.add(temp);

        for (int i = 1; i < 1+yearOfList; i++) {
            BigDecimal investedCapitalListi1=new BigDecimal(Double.toString(investedCapitalList.get(i - 1)));
            BigDecimal getReinvestmentListi =new BigDecimal(Double.toString(reinvestment.getReinvestmentList().get(i)));
            BigDecimal ans_0=investedCapitalListi1.add(getReinvestmentListi);

            double temp_1= ans_0.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double temp_1 = investedCapitalList.get(i - 1) + reinvestment.getReinvestmentList().get(i);
            investedCapitalList.add(temp_1);
        }
    }


    public ArrayList<Double> getInvestedCapitalList() {
        return investedCapitalList;
    }
}

