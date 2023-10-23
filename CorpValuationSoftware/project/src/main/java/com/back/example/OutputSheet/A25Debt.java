/**

This class stores the amount of debt and provides methods to set and get the value of debt.
This class has the following public methods:
setDebt(boolean inputB14, double olcC28, double inputB12)
This method takes in a boolean value which represents if the debt should include the book value of equity,
a double value which represents the book value of debt, and a double value which represents the book value of equity.
If the debt should include the book value of equity, the method adds the inputB12 and olcC28 values and
sets the result as the value of debt. Otherwise, the method sets the inputB12 as the value of debt.
getDebt()
This method returns the value of debt stored in the debt variable.
*/




package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A25Debt {
    double debt;

    public double getDebt() {
        return debt;
    }

    public void setDebt(boolean inputB14, double olcC28, double inputB12) {
        if(inputB14){
            BigDecimal big_B12=new BigDecimal(Double.toString(inputB12));
            BigDecimal big_olcC28=new BigDecimal(Double.toString(olcC28));
            BigDecimal ans=big_B12.add(big_olcC28);
            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.debt=temp;
            //this.debt = inputB12 + olcC28;
        }else {
            this.debt = inputB12;
        }

    }

}
