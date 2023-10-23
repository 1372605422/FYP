/**

This class calculates the present value of free cash flow to firm (FCFF)
and stores them in an ArrayList.
The present value is calculated as the product of the corresponding FCFF
and the cumulated discount factor at each year, which is obtained from
the A13CumulatedDiscountFactor class.
This class has the following public methods:
setPvFcffList(A9FCFF fcff, A13CumulatedDiscountFactor cumulatedDiscountFactor,int yearOfList)
This method takes in an object of A9FCFF class which contains the FCFF list,
an object of A13CumulatedDiscountFactor class which contains the cumulated discount factor list,
and the number of years for which the present value needs to be calculated.
The method then calculates the present value of FCFF for each year and stores it in an ArrayList.
getPvFcffList()
This method returns the ArrayList of present values of FCFF calculated by setPvFcffList() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A14PVFCFF {

    public ArrayList<Double> pvFcffList =new ArrayList<>();

    public void setPvFcffList(A9FCFF fcff, A13CumulatedDiscountFactor cumulatedDiscountFactor,int yearOfList) {
        pvFcffList.add((double) 0);
        for (int i = 1; i <= yearOfList; i++) {
            BigDecimal getFcffListi=new BigDecimal(Double.toString(fcff.getFcffList().get(i)));
            BigDecimal cumulatedDFListgeti=new BigDecimal(Double.toString(cumulatedDiscountFactor.cumulatedDFList.get(i)));
            BigDecimal ans=getFcffListi.multiply(cumulatedDFListgeti);
            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            pvFcffList.add(temp);
            //pvFcffList.add(fcff.getFcffList().get(i)*cumulatedDiscountFactor.cumulatedDFList.get(i));
        }
    }

    public ArrayList<Double> getPvFcffList() {
        return pvFcffList;
    }

}
