/**

This class calculates the value of operating assets and stores it in a double variable.
The value of operating assets is calculated based on the sum of present values of cash flow over 10 years,
the present value of the terminal value, the proceeds if the firm fails, and the probability of failure.
This class has the following public methods:
setValueOfOperatingAssets(A21SumOfPV sumOfPV, A23ProceedsIfFirmFails proceedsIfFirmFails, A22ProbabilityOfFailure probailityOfFailure)
This method takes in an object of A21SumOfPV class which contains the sum of present values of cash flow over 10 years
and the present value of the terminal value, an object of A23ProceedsIfFirmFails class which contains the proceeds if the firm fails,
and an object of A22ProbabilityOfFailure class which contains the probability of failure.
The method then calculates the value of operating assets and stores it in a double variable.
getValueOfOperatingAssets()
This method returns the value of operating assets calculated by setValueOfOperatingAssets() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A24ValueOfOperatingAssets {
    public double getValueOfOperatingAssets() {
        return valueOfOperatingAssets;
    }

    public void setValueOfOperatingAssets(A21SumOfPV sumOfPV, A23ProceedsIfFirmFails proceedsIfFirmFails, A22ProbabilityOfFailure probailityOfFailure) {
        BigDecimal big_1=new BigDecimal("1");
        BigDecimal getSumOfPV=new BigDecimal(Double.toString(sumOfPV.getSumOfPV()));
        BigDecimal getProbability_failur=new BigDecimal(Double.toString(probailityOfFailure.getProbability_failure()));
        BigDecimal getProceedsIfFirmFails =new BigDecimal(Double.toString(proceedsIfFirmFails.getProceedsIfFirmFails()));
        BigDecimal ans1=big_1.subtract(getProbability_failur);
        BigDecimal ans2=getSumOfPV.multiply(ans1);
        BigDecimal ans3=getProbability_failur.multiply(getProceedsIfFirmFails);
        BigDecimal an4= ans2.add(ans3);
        double temp= an4.setScale(4, RoundingMode.HALF_UP).doubleValue();

        valueOfOperatingAssets=temp;
        //valueOfOperatingAssets = (sumOfPV.getSumOfPV() * (1 - probailityOfFailure.getProbability_failure())) + probailityOfFailure.getProbability_failure() * proceedsIfFirmFails.getProceedsIfFirmFails();
    }

    double valueOfOperatingAssets;
}
