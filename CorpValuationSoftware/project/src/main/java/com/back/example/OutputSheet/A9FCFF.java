/**

 This package contains classes related to generating output sheet for a discounted cash flow (DCF) analysis.
 The output sheet includes various financial metrics and cash flows for the analysis, such as revenues, EBIT, EBITDA, free cash flows, etc.
 The classes in this package are used to calculate these metrics and cash flows based on the input data provided by the user.
 @author KeYi LIU
 @version V1.1
 */
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A9FCFF {

    public ArrayList<Double> fcffList = new ArrayList<>();


    public void setFcffList(A7EBIT1t ebit1t, A8Reinvestment reinvestment,int yearOfList) {
        fcffList.add((double) 0);
        for (int i = 1; i <= 1+yearOfList; i++) {
            BigDecimal getEBIT1tListi=new BigDecimal(Double.toString(ebit1t.getEBIT1tList().get(i)));
            BigDecimal getReinvestmentListi=new BigDecimal((Double.toString(reinvestment.getReinvestmentList().get(i))));
            BigDecimal ans=getEBIT1tListi.subtract(getReinvestmentListi);


            double temp= ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double temp = ebit1t.getEBIT1tList().get(i) - reinvestment.getReinvestmentList().get(i);
            fcffList.add(temp);
        }
    }

    public ArrayList<Double> getFcffList() {
        return fcffList;
    }

    public double getTerminalFcff() {
        return fcffList.get(fcffList.size()-1);
    }


}
