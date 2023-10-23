/**

 The A4EBITMargin class calculates the EBIT margin for each year based on the base income and input values.
 It also stores the list of EBIT margins over the years.
 This class contains the following public methods:
 setBaseIncome: calculates and sets the base income based on the input values.
 getBaseIncome: retrieves the base income.
 setEBITMarginList: calculates and sets the EBIT margin list based on the input values.
 getEBITMarginList: retrieves the EBIT margin list.
 getTerminalEBITMargin: retrieves the terminal EBIT margin.
 The following instance variables are used in this class:
 ebitMarginList: an ArrayList of doubles that stores the EBIT margins.
 baseIncome: a double that stores the base income.
 Note: The EBIT margin for each year is calculated using the formula: EBIT margin = (income / revenue) * 100.
 * @author [KeYi LIU]
 * @version [V1.1]
 */
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A4EBITMargin {

    public ArrayList<Double> ebitMarginList = new ArrayList<>();


    public double baseIncome;  //firstly bulid  baseIncome

    public double getBaseIncome() {
        return baseIncome;
    }

    public void setBaseIncome(boolean inputB14, boolean inputB13, double olcF32, double rdcD39, double inputB9) {
        BigDecimal big_olcF32 = new BigDecimal(Double.toString(olcF32));
        BigDecimal big_rdcD39 = new BigDecimal(Double.toString(rdcD39));
        BigDecimal big_inputB9 = new BigDecimal(Double.toString(inputB9));

        if (inputB14) {
            if (inputB13) {
                BigDecimal ans1 = big_inputB9.add(big_olcF32);
                BigDecimal ans=ans1.add(big_rdcD39);
                baseIncome = ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            } else {
                BigDecimal ans = big_inputB9.add(big_olcF32);
                baseIncome = ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
            }
        } else {
            if (inputB13) {
                BigDecimal ans = big_inputB9.add(big_rdcD39);
                baseIncome = ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

                //baseIncome = inputB9 + rdcD39;
            } else {
                baseIncome = big_inputB9.setScale(4, RoundingMode.HALF_UP).doubleValue();
                //baseIncome = inputB9;
            }
        }
    }

    public void setEBITMarginList(double inputB8, double inputB24, double inputB26, double inputB27,int yearOfList) {


        BigDecimal big_income=new BigDecimal(Double.toString(baseIncome));
        BigDecimal big_B8=new BigDecimal((Double.toString(inputB8)));
        BigDecimal num=big_income.divide(big_B8,4, RoundingMode.HALF_UP);
        ebitMarginList.add(num.doubleValue());
        //ebitMarginList.add(baseIncome / inputB8);
        ebitMarginList.add(inputB24);
        for (int i = 2; i <= yearOfList; i++) {
            if (i > inputB27) {
                ebitMarginList.add(inputB26);
            } else {

                BigDecimal big_B26 = new BigDecimal(Double.toString(inputB26));
                BigDecimal big_B27 = new BigDecimal(Double.toString(inputB27));
                BigDecimal big_get1 = new BigDecimal(Double.toString(ebitMarginList.get(1)));
                BigDecimal big_i = new BigDecimal(Double.toString(i));


                BigDecimal ans1 = big_B27.subtract(big_i);
                BigDecimal ans2= big_B26.subtract(big_get1);
                BigDecimal ans3=ans2.divide(big_B27,20,RoundingMode.HALF_UP);
                BigDecimal ans4=ans3.multiply(ans1);
                BigDecimal ans5= big_B26.subtract(ans4);
                double ans = ans5.setScale(4, RoundingMode.HALF_UP).doubleValue();
                //double ans = inputB26 - ( (inputB26 - ebitMarginList.get(1)) / inputB27 * (inputB27 - i) );
                ebitMarginList.add(ans);
            }
        }
        ebitMarginList.add(ebitMarginList.get(yearOfList));
    }


    public ArrayList<Double> getEBITMarginList() {
        return ebitMarginList;
    }

    public double getTerminalEBITMargin() {
        return ebitMarginList.get(ebitMarginList.size()-1);
    }

}
