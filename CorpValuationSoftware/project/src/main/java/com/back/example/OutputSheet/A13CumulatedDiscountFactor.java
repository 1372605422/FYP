/**

This class represents a cumulative discount factor list generator.
It provides methods to set and get the list of cumulated discount factors.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A13CumulatedDiscountFactor {
    public ArrayList<Double> cumulatedDFList = new ArrayList<>();


    public void setCumulatedDFListList(A12CostOfCapital costOfCapital,int yearOfList) {
        BigDecimal big_1 = new BigDecimal("1");
        BigDecimal getCostOfCapitalList1 = new BigDecimal(Double.toString(costOfCapital.getCostOfCapitalList().get(1)));
        BigDecimal ans1 = big_1.add(getCostOfCapitalList1);
        BigDecimal ans2 = big_1.divide(ans1, 20, RoundingMode.HALF_UP);
        Double ans = ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();

        cumulatedDFList.add((double) 0);
        cumulatedDFList.add(ans);
        //cumulatedDFList.add( 1/(1+costOfCapital.getCostOfCapitalList().get(1))  );
        for (int i = 2; i <= yearOfList; i++) {
            BigDecimal cumulatedDFListi1 = new BigDecimal(Double.toString(cumulatedDFList.get(i - 1)));
            BigDecimal getCostOfCapitalListi = new BigDecimal(Double.toString(costOfCapital.getCostOfCapitalList().get(i)));
            BigDecimal ans3 = big_1.add(getCostOfCapitalListi);
            BigDecimal ans4 = big_1.divide(ans3, 20, RoundingMode.HALF_UP);
            BigDecimal ans5= cumulatedDFListi1.multiply(ans4);

            double temp=ans5.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double temp = cumulatedDFList.get(i - 1) * (1 / (1 + costOfCapital.getCostOfCapitalList().get(i)));
            cumulatedDFList.add(temp);
        }

    }

    public ArrayList<Double> getCumulatedDFList() {
        return cumulatedDFList;
    }

}
