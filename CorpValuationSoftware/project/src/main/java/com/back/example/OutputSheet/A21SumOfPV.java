/**

This class calculates the sum of the present values of cash flow over 10 years and the present value of the terminal value
and stores it in a double variable.
This class has the following public methods:
setSumOfPV(A20PVCFOver10Year pvcfOver10Year, A19PVTerminalValue pvTerminalValue)
This method takes in an object of A20PVCFOver10Year class which contains the present value of cash flow over 10 years,
and an object of A19PVTerminalValue class which contains the present value of the terminal value.
The method then calculates the sum of the present values of cash flow over 10 years and the present value of the terminal value
and stores it in a double variable.
getSumOfPV()
This method returns the sum of the present values of cash flow over 10 years and the present value of the terminal value
calculated by setSumOfPV() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A21SumOfPV {

    public double getSumOfPV() {
        return sumOfPV;
    }

    public void setSumOfPV(A20PVCFOver10Year pvcfOver10Year, A19PVTerminalValue pvTerminalValue) {
        BigDecimal getpVCFOver10Year=new BigDecimal(Double.toString(pvcfOver10Year.getpVCFOver10Year()));
        BigDecimal getpVTerminalValue=new BigDecimal(Double.toString(pvTerminalValue.getpVTerminalValue()));
        BigDecimal ans=getpVCFOver10Year.add(getpVTerminalValue);

        sumOfPV= ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
        //sumOfPV = pvcfOver10Year.getpVCFOver10Year() + pvTerminalValue.getpVTerminalValue();
    }

    double sumOfPV;



}
