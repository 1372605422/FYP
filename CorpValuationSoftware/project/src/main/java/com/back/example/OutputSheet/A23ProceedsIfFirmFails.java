/**

This class calculates the proceeds if the firm fails and stores it in a double variable.
The proceeds if the firm fails are calculated based on the input parameters and the sum of present values of
cash flow over 10 years and the present value of the terminal value, which is obtained from A21SumOfPV class.
This class has the following public methods:
setProceedsIfFirmFails(String inputB49, double inputB11, double inputB12, double inputB50, A21SumOfPV sumOfPV)
This method takes in a string value which represents if the proceeds if the firm fails should be based on
liquidation value or present value, a double value which represents the book value of debt,
a double value which represents the book value of equity, a double value which represents the probability of failure,
and an object of A21SumOfPV class which contains the sum of present values of cash flow over 10 years and
the present value of the terminal value. The method then calculates the proceeds if the firm fails and stores it
in a double variable.
getProceedsIfFirmFails()
This method returns the proceeds if the firm fails calculated by setProceedsIfFirmFails() method.
*/
package com.back.example.OutputSheet;

import com.back.StaticData.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A23ProceedsIfFirmFails {

    public double getProceedsIfFirmFails() {
        return proceedsIfFirmFails;
    }

    public void setProceedsIfFirmFails(String inputB49, double inputB11, double inputB12, double inputB50,A21SumOfPV sumOfPV ) {
        //System.out.println(sumOfPV.getSumOfPV());

        BigDecimal big_11=new BigDecimal(Double.toString(inputB11));
        BigDecimal big_12=new BigDecimal(Double.toString(inputB12));
        BigDecimal big_50=new BigDecimal(Double.toString(inputB50));
        BigDecimal big_21=new BigDecimal(Double.toString(sumOfPV.getSumOfPV()));


        if (inputB49.equals("B")) {
            BigDecimal ans1=big_11.add(big_12);
            BigDecimal ans2=ans1.multiply(big_50);
            double temp= ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.proceedsIfFirmFails=temp;
            //this.proceedsIfFirmFails = (inputB11 + inputB12) * inputB50;
        } else {
            BigDecimal ans1=big_21.multiply(big_50);
            double temp2= ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.proceedsIfFirmFails=temp2;
           // this.proceedsIfFirmFails = inputB21* inputB50;
        }

    }

    double proceedsIfFirmFails;

}

