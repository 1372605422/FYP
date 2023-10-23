/**

This class calculates the present value of cash flow over 10 years and stores it in a double variable.
The present value is calculated as the sum of the present values of free cash flow to firm (FCFF)
for the first 10 years, which is obtained from A14PVFCFF class.
This class has the following public methods:
setpVCFOver10Year(A14PVFCFF pv_FCFF)
This method takes in an object of A14PVFCFF class which contains the present values of FCFF for all years.
The method then calculates the present value of cash flow over 10 years and stores it in a double variable.
getpVCFOver10Year()
This method returns the present value of cash flow over 10 years calculated by setpVCFOver10Year() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A20PVCFOver10Year {



    public double getpVCFOver10Year() {
        return pVCFOver10Year;
    }

    public void setpVCFOver10Year(A14PVFCFF pv_FCFF) {
        for (int i = 1; i <= 10; i++) {
            BigDecimal big_pVCFOver10Year=new BigDecimal(Double.toString(pVCFOver10Year));
            BigDecimal getPvFcffListi=new BigDecimal(Double.toString(pv_FCFF.getPvFcffList().get(i)));
            BigDecimal ans=big_pVCFOver10Year.add(getPvFcffListi);
            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            pVCFOver10Year=temp;
            //pVCFOver10Year += pv_FCFF.getPvFcffList().get(i);
        }
    }

    double pVCFOver10Year;
}
