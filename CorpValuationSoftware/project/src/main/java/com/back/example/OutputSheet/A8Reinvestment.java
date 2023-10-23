/**

 This class calculates the reinvestment for each year and the terminal reinvestment
 based on the input values from the user.
 @author [KeYi LIU]
 @version [V1.1]
 */
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A8Reinvestment {
    public ArrayList<Double> reinvestmentList = new ArrayList<>();
    double sum=0;

    public void setReinvestmentList(A3Revenues revenues,double inputB28,A2RevenueGrowthRate revenueGrowthRate,
                                    A40ROIC roic,A7EBIT1t ebit1t,int yearOfList) {
        reinvestmentList.add((double) 0);

        for (int i = 1; i <= 10; i++) {
            BigDecimal RevenuesListgeti=new BigDecimal(Double.toString(revenues.getRevenuesList().get(i)));
            BigDecimal RevenuesListget1=new BigDecimal(Double.toString(revenues.getRevenuesList().get(i-1)));
            BigDecimal big_B28=new BigDecimal(Double.toString(inputB28));

            BigDecimal ans1=RevenuesListgeti.subtract(RevenuesListget1);
            BigDecimal ans2=ans1.divide(big_B28,4, RoundingMode.HALF_UP);

            double temp=ans2.doubleValue();
            //double temp = (revenues.getRevenuesList().get(i)-revenues.getRevenuesList().get(i-1))/inputB28;
            reinvestmentList.add(temp);
        }
       if(revenueGrowthRate.getTerminalRevenueGrowthRate()>0){
           BigDecimal getTerminalRevenueGrowthRate=new BigDecimal(Double.toString(revenueGrowthRate.getTerminalRevenueGrowthRate()));
           BigDecimal getTerminaLROIC=new BigDecimal(Double.toString(roic.getTerminaLROIC()));
           BigDecimal getTerminalEBIT1t=new BigDecimal(Double.toString(ebit1t.getTerminalEBIT1t()));

           BigDecimal ans1=getTerminalRevenueGrowthRate.divide(getTerminaLROIC,20,RoundingMode.HALF_UP);
           BigDecimal ans2=ans1.multiply(getTerminalEBIT1t);

           double temp=ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();
           //double temp=(revenueGrowthRate.getTerminalRevenueGrowthRate()/roic.getTerminaLROIC())*ebit1t.getTerminalEBIT1t();
            reinvestmentList.add(temp);
       }

        for (int i = 1; i <=yearOfList+1 ; i++) {
            BigDecimal big_i=new BigDecimal(Double.toString(reinvestmentList.get(i)));
            BigDecimal big_sum=new BigDecimal(Double.toString(sum));
            BigDecimal ans=big_i.add(big_sum);

            sum=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //sum+=reinvestmentList.get(i);
        }
        reinvestmentList.add(sum);
    }

    public ArrayList<Double> getReinvestmentList (){
        return reinvestmentList;
    }

    public double getTerminalreinvestment(){
        return reinvestmentList.get(reinvestmentList.size()-2);
    }

    public double getSum() {
        return sum;
    }
}
